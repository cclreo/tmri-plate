package com.tmri.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tmri.base.entity.Result;
import com.tmri.user.entity.Test;
import com.tmri.user.service.TestService;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("get_server_list")
    public Result get_server_list(){

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","服务1");
        jsonObject.put("ip","192.168.100.10");
        jsonObject.put("createTime",new Date().toLocaleString());
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject);
        return new Result().success(jsonArray);
    }
        @GetMapping("save")
        public Result save(){

        log.info("...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Test test = new Test();
        test.setUpdateTime(new Timestamp(new Date().getTime()));
        return new Result().success("---");
    }

}
