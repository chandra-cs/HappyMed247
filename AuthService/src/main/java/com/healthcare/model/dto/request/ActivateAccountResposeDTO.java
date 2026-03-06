package com.healthcare.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivateAccountResposeDTO {
    private String message;
    private Boolean status;
}
