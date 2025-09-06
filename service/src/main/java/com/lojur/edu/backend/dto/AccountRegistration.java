package com.lojur.edu.backend.dto;

import java.util.Optional;

import com.lojur.edu.backend.entities.account.AccountType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AccountRegistration {
    private String email;
    private String password;
    private String firstName;
    private Optional<String> lastName;
    private AccountType accountType;
}
