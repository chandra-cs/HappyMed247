package com.healthcare.service.interfaces;

import com.healthcare.model.dto.request.RoleCreationRequestDTO;
import com.healthcare.model.dto.response.RoleCreationResponseDTO;

public interface IRoleService {

    public RoleCreationResponseDTO createRole(RoleCreationRequestDTO roleCreationRequestDTO);

}
