package com.dmstjd1024.toyproject.account;

import com.dmstjd1024.toyproject.module.SignUpForm;
import com.dmstjd1024.toyproject.module.account.Account;
import com.dmstjd1024.toyproject.module.account.AccountRepository;
import com.dmstjd1024.toyproject.module.account.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @BeforeEach
    void beforeEach() {
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setNickname("test");
        signUpForm.setEmail("test@email.com");
        signUpForm.setPassword("!qwer1234");
        accountService.saveNewAccount(signUpForm);
    }

    @DisplayName("회원가입 실패")
    @Test
    void submitSignUpForm_fail() throws Exception {
        mockMvc.perform(post("/sign-up")
                .param("nickname", "tes")
                .param("email", "tes")
                .param("password", "12345")
                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("sign-up"));

    }

    @DisplayName("회원가입 성공")
    @Test
    void submitSignUpForm_success() throws Exception {

        SignUpForm signUpForm = new SignUpForm("eunseong", "eunseong@email.com", "12345");

        mockMvc.perform(post("/sign-up")
                .param("nickname", signUpForm.getNickname())
                .param("email", signUpForm.getEmail())
                .param("password", signUpForm.getPassword())
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        Account account = accountRepository.findByNickname("eunseong");
        assertNotNull(account);
        assertNotEquals(account.getPassword(), signUpForm.getPassword());

    }

    @DisplayName("로그인")
    @Test
    void submitLogin_success() throws Exception {
        mockMvc.perform(post("/login")
                .param("username", "test")
                .param("password", "!qwer1234")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(authenticated().withUsername("test"));
    }

}
