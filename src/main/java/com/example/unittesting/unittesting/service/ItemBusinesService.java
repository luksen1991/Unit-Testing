package com.example.unittesting.unittesting.service;

import com.example.unittesting.unittesting.model.Item;
import com.example.unittesting.unittesting.repository.ItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ItemBusinesService {

    @Autowired
    ItemRepositoryImpl itemRepository;

    public Item retrieveHardcodedItem() {
        Item item = new Item();
        item.setId(1);
        item.setName("Jajko");
        item.setPrice(100);
        item.setQuantity(200);
        return item;
    }

    public List<Item> retrievAllItems() {
        List<Item> items = itemRepository.findAllItems();
        for(Item item: items){
            item.setValue(item.getPrice()*item.getQuantity());
        }
        return items;
    }

    public Item addNewItem(Item item){ return itemRepository.addElement(item); }
}
