package com.healthcare.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmailNotFoundException extends Exception {

    private final String message;



}
