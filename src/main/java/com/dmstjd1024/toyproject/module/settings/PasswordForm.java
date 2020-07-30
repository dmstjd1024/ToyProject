package com.dmstjd1024.toyproject.module.settings;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasswordForm {

    private String newPassword;

    private String newPasswordConfirm;


}
