package com.dmstjd1024.toyproject.module.settings;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class PasswordFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return PasswordForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordForm passwordForm = (PasswordForm)target;
        if(!passwordForm.getNewPassword().equals(passwordForm.getNewPasswordConfirm())){
            errors.rejectValue("newPassword", "wrong.value", "새 패스워드가 일치하지 않습니다.");
        }

    }
}
