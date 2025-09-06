package com.lojur.edu.backend.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lojur.edu.backend.dto.AccountRegistration;
import com.lojur.edu.backend.entities.account.Account;
import com.lojur.edu.backend.repositories.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public Account signup(AccountRegistration accountRegistration) {
        if (accountRepository.existsByEmail(accountRegistration.getEmail())) {
            throw new IllegalStateException("Email already taken");
        }

        var account = new Account();
        account.setEmail(accountRegistration.getEmail());
        account.setPassword(passwordEncoder.encode(accountRegistration.getPassword()));
        account.setFirstName(accountRegistration.getFirstName());
        account.setLastName(accountRegistration.getLastName().orElse(null));
        account.setAccountType(accountRegistration.getAccountType());

        return accountRepository.save(account);
    }

    public Account authenticate(String email, String password) {
        var authToken = new UsernamePasswordAuthenticationToken(email, password);
        var auth = authenticationManager.authenticate(authToken);
        return (Account) auth.getPrincipal();
    }
}
