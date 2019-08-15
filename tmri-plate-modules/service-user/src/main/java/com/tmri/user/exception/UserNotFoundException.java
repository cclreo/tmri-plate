package com.tmri.user.exception;

import com.tmri.base.exception.ServiceException;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException() {
        super(10404, "用户不存在");
    }
}