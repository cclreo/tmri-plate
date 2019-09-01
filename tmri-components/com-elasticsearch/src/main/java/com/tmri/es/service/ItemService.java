package com.tmri.es.service;

import com.tmri.es.entity.Item;

import java.util.List;

public interface ItemService {

    public void createIndex(Class clazz);

    public void deleteIndex(Class clazz);

    public void addItem(Item item);

    public List<Item> query();

}
