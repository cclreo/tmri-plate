package com.tmri.es.service.impl;

import com.tmri.es.entity.Item;
import com.tmri.es.dao.ItemRepository;
import com.tmri.es.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void createIndex(Class clazz) {
        elasticsearchTemplate.createIndex(Item.class);
    }

    @Override
    public void deleteIndex(Class clazz) {
        elasticsearchTemplate.deleteIndex(Item.class);
    }

    @Override
    public void addItem(Item item) {

        itemRepository.save(item);

    }



    @Override
    public List<Item> query() {

        List<Item> list = new ArrayList();
        itemRepository.findAll().forEach(new Consumer<Item>() {
            @Override
            public void accept(Item item) {
                log.info(item.toString());
            }
        });
        itemRepository.search(QueryBuilders.matchQuery("title","坚果手机R1"))
                .forEach(new Consumer<Item>() {
            @Override
            public void accept(Item item) {
                log.info(item.toString());
            }
        });

        log.info(itemRepository.findByTitle("坚果手机R1").toString());

        return list;

    }


}
