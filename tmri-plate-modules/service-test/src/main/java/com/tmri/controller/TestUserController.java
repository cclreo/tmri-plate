package com.tmri.controller;

import com.tmri.RemoteService.UserService;
import com.tmri.base.entity.Result;
import org.apache.logging.slf4j.SLF4JLoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestUserController {

    Logger logger = LoggerFactory.getLogger(TestUserController.class);


    @Autowired
    UserService userService;
    /**
     * 根据Id查看单个用户的信息
     */
    @GetMapping("/user/{userId}")
    public Result get(@PathVariable("userId") long userId) {
        logger.info("------------");
        return new Result().success(userService.getById(userId));
    }


}
