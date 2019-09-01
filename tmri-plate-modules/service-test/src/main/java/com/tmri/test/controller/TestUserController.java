package com.tmri.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tmri.Upload;
import com.tmri.base.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestUserController {

    private String UPLOAD_FOLDER = "/Users/micro/Downloads/python/";

    @GetMapping("get_server_list")
    public Result get_server_list(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1000);
        jsonObject.put("name","服务器1");
        jsonObject.put("ip","192.168.100.19");
        jsonObject.put("version","0.0.0.1");
        jsonObject.put("status",true);
        jsonObject.put("createTime",new Date().toLocaleString());

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject.put("id",1000);
        jsonObject2.put("name","服务器2");
        jsonObject2.put("ip","192.168.100.20");
        jsonObject.put("status",true);
        jsonObject2.put("createTime",new Date().toLocaleString());
        jsonArray.add(jsonObject2);

        return new Result().success(jsonArray);

    }

    @PostMapping("post_new_package")
    public Result post_new_package(@RequestParam("file") MultipartFile file) {

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            try {
                new Upload().run(file.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return new Result().success();
    }


}
