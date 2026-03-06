package com.healthcare.service.implementation;

import com.healthcare.exception.auth.EmailNotFoundException;
import com.healthcare.exception.auth.PasswordMismatchException;
import com.healthcare.exception.role.RoleNameNotFoundException;
import com.healthcare.exception.auth.UsernameAlreadyExistsException;
import com.healthcare.mapper.RegisterModelMapper;
import com.healthcare.model.dto.request.*;
import com.healthcare.model.dto.response.RegisterResponseDTO;
import com.healthcare.model.entity.Role;
import com.healthcare.model.entity.User;
import com.healthcare.repository.IRoleRepository;
import com.healthcare.repository.IUserRepository;
import com.healthcare.service.interfaces.IAuthService;
import com.healthcare.service.interfaces.IEmailService;
import com.healthcare.service.interfaces.ILoginHistoryService;
import com.healthcare.utility.JwtProvider;
import com.healthcare.utility.OtpGenerator;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {


    private final IUserRepository userRepo;

    private final IRoleRepository roleRepo;

    private final PasswordEncoder encoder;

    private final JwtProvider jwtProvider;

    private final HappyMedUserDetailsService  userDetailsService;

    private final IEmailService emailService;

    private final ILoginHistoryService loginHistory;

    private final OtpGenerator otpGenerator;


    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO)  {

        /**
         *
         * removed confirmPassword field from RegisterRequestDto since it is a frontend concern
         * and while patient-service or relevant service for register purpose it is not good to travel the confirmPassword over microservices
         *
        if(!registerRequestDTO.getPassword().equals(registerRequestDTO.getConfirmPassword())) {
            throw new PasswordMismatchException("Password and Confirm Password must be same");
        }
         */

        //check whether user exist by email or username
        if (userRepo.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("User already Exists having username:"+registerRequestDTO.getUsername());
        } else if (userRepo.findByEmail(registerRequestDTO.getEmail()).isPresent()) {
            throw new UsernameAlreadyExistsException("User already Exists having email:"+registerRequestDTO.getEmail());
        }

        //use mapper class to map DTO into User object
        RegisterModelMapper registerModelMapper = new RegisterModelMapper();
        User user = registerModelMapper.mapToRegisterObj(registerRequestDTO);

        //encode the password Using BCryptPasswordEncoder
        user.setPassword(encoder.encode(registerRequestDTO.getPassword()));

        //save the Role object
        Role role = roleRepo.findByName(registerRequestDTO.getRole())
                .orElseThrow(() -> new RoleNameNotFoundException("Role not found : "+registerRequestDTO.getRole()));

        user.setRoles(Set.of(role));

        //send otp
        //get otp
        String otp = otpGenerator.generateOtp();

        try{
            emailService.sendOtpEmail(user.getEmail(), otp);
        } catch (MessagingException e) {
           return
                   RegisterResponseDTO.builder()
                           .message("Sending OTP failed Please try again !!")
                           .statusCode(404)
                           .build();
        }


        //save the user object
        user.setOtp(otp);
        User savedUser = userRepo.save(user);

        return RegisterResponseDTO.builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("User Successfully Saved on AuthService")
                .build();
    }

    public ActivateAccountResposeDTO activateAccount(ActivateAccountRequestDTO activateAccountRequestDTO) throws EmailNotFoundException {

        //get the user using email address
        User user = userRepo.findByEmail(activateAccountRequestDTO.getEmail()).orElseThrow(() -> new EmailNotFoundException("Email Not found, please check again."));

        //check the password whether wrong or right
        if(!encoder.matches(activateAccountRequestDTO.getPassword(), user.getPassword())) {
            return new ActivateAccountResposeDTO("Invalid Password, Please check your password again!!",false);
        }

        //check whether the user is active or not
        if(user.isActive()){
            return  new ActivateAccountResposeDTO("Account is already active", true);
        }//if

        //verify OTP
        if(activateAccountRequestDTO.getOtp().equals(user.getOtp())){
            //change the active status
            user.setActive(true);

            //save the user
            userRepo.save(user);
            return  new ActivateAccountResposeDTO("Account successfully activated", true);
        }
        else {
            return  new ActivateAccountResposeDTO("Invalid OTP, Check OTP again", false);
        }


    }//activateAccount()




    //login feature
    @Override
    public String login(LoginRequestDTO loginRequestDTO, HttpServletRequest request) {
        // 1. Find the user by username
        User user = userRepo.findByUsername(loginRequestDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // 2. Check if the account is active (OTP verified)
        if (!user.isActive()) {
            throw new RuntimeException("Account is not active. Please verify your OTP first.");
        }

        // 3. Verify the password
        if (!encoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            // Optional: Record a failed login attempt here
            recordLoginHistory(user, request, false);
            throw new RuntimeException("Invalid username or password");
        }

        // 4. Record successful login history
        recordLoginHistory(user, request, true);

        // 5. Generate and return JWT token
        return jwtProvider.generateToken(user);
    }

    /**
     * Helper method to record login history
     */
    private void recordLoginHistory(User user, HttpServletRequest request, boolean status) {
        LoginHistoryDTO loginHistoryDTO = new LoginHistoryDTO();
        loginHistoryDTO.setUserId(user.getId());
        loginHistoryDTO.setIpAddress(request.getRemoteAddr());
        loginHistoryDTO.setSuccessStatus(status);
        loginHistoryDTO.setUserAgent(request.getHeader("User-Agent"));

        loginHistory.recordLogin(loginHistoryDTO);
    }

}
