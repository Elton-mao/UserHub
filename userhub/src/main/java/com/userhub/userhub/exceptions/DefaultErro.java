package com.userhub.userhub.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultErro {
    private int error;
    private String message;
}
