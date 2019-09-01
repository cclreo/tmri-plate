package com.tmri.es.controller;

import com.tmri.es.entity.Item;
import com.tmri.es.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("es")
public class TestController {

    @Autowired
    ItemService itemService;

    @GetMapping("query")
    public void query(){

        itemService.deleteIndex(Item.class);
        itemService.createIndex(Item.class);
        itemService.addItem(new Item(2L, "坚果手机R1", " 手机", "锤子",
                3699.00, "http://image.baidu.com/13123.jpg"));
        itemService.query();

    }

}
