package com.shop.persistence.security.dto;

import lombok.Data;

@Data
public class AuthCredentialsDto {
    private String email;
    private String password;
}
