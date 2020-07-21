package com.dmstjd1024.toyproject.module.account;

import com.dmstjd1024.toyproject.module.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

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

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String nicknameOrEmail) throws UsernameNotFoundException {

        Account account = accountRepository.findByNickname(nicknameOrEmail);
        if(account == null){
            account = accountRepository.findByEmail(nicknameOrEmail);
        }

        if(account == null){
            throw new UsernameNotFoundException(nicknameOrEmail);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(Role.USER.getRole()));

        return new User(account.getNickname(), account.getPassword(), authorities);
    }
}
