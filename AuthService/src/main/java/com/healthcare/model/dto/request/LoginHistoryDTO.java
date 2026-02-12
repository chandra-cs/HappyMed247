package com.healthcare.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginHistoryDTO {


    private Integer userId;
    private String ipAddress;
    private String userAgent;
    private Boolean successStatus;

}
