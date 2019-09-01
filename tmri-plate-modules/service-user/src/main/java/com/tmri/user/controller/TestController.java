package com.tmri.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tmri.base.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("test")
public class TestController {

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
}
