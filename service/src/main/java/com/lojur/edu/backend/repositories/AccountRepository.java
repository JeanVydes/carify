package com.lojur.edu.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojur.edu.backend.entities.account.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
    public Optional<Account> findByEmail(String email);
    public boolean existsByEmail(String email);
}
