package com.dmstjd1024.toyproject.module.account;

import com.dmstjd1024.toyproject.module.SignUpForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute(new SignUpForm());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String submitSignUpForm(SignUpForm signUpForm){

        accountService.saveNewAccount(signUpForm);
        return "redirect:/";
    }

}
