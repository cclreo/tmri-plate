package com.tmri.user.exception;

import com.tmri.base.exception.ServiceException;

public class PasswordErrorException extends ServiceException {
    public PasswordErrorException() {
        super(10400, "密码错误");
    }
}