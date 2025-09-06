package com.lojur.edu.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountSignIn {
    private String email;
    private String password;
}
