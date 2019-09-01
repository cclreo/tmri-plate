package com.tmri;

import com.tmri.es.entity.Item;
import com.tmri.es.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    ItemService itemService;

    @Test
    public void contextLoads() {

        List<Item> list = new ArrayList<>();
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子",
                3699.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为",
                4499.00, "http://image.baidu.com/13123.jpg"));

        // 接收对象集合，实现批量新增
        itemService.addItem(new Item(2L, "坚果手机R1", " 手机", "锤子",
                3699.00, "http://image.baidu.com/13123.jpg"));

        // 接收对象集合，实现批量新增
        itemService.addItem(new Item(2L, "坚果手机R1", " 手机", "锤子",
                3699.00, "http://image.baidu.com/13123.jpg"));
    }

}
