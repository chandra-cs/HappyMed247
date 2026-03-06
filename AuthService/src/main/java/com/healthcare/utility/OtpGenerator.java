package com.healthcare.utility;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class OtpGenerator {

    //due to HappyMed (HM is prefix)
    private static final String  PREFIX = "HM-";

    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Generates a 6 digit OTP prefixed with HM-
     * Example: HM-432423
     *
     */
    public String generateOtp() {
        //generate number between 0 & 999_999
        int number = RANDOM.nextInt(1_000_000);

        //ensure leading zeros if the number is less than 6 digits
        return PREFIX + String.format("%06d", number);
    }


}
