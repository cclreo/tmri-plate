package com.tmri.RemoteService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/15.
 */
@Component
public class UserServiceHystrix implements UserService{

    @Override
    public String getById(@RequestParam(value = "name") long userId) {
        return "default user info";
    }
}
