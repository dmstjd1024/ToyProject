package com.dmstjd1024.toyproject.module.account;

import com.dmstjd1024.toyproject.module.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public Account saveNewAccount(SignUpForm signUpForm){

        signUpForm.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
        Account account = new Account();
        account.setNickname(signUpForm.getNickname());
        account.setEmail(signUpForm.getEmail());
        account.setPassword(signUpForm.getPassword());

        return accountRepository.save(account);
    }

}
