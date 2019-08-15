package com.tmri.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tmri.user.data.SignInData;
import com.tmri.user.data.SignUpData;
import com.tmri.user.entity.User;
import com.tmri.user.view.SignInView;

public interface UserService extends IService<User> {
    SignInView signIn(SignInData data);
    void signUp(SignUpData data);
}
