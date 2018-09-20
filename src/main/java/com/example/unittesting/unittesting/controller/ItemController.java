package com.example.unittesting.unittesting.controller;

import com.example.unittesting.unittesting.model.Item;
import com.example.unittesting.unittesting.repository.ItemRepositoryImpl;
import com.example.unittesting.unittesting.service.ItemBusinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    ItemBusinesService itemBusinesService;

    @Autowired
    public ItemController(ItemBusinesService itemBusinesService) {
        this.itemBusinesService = itemBusinesService;
    }

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        Item item = new Item();
        item.setName("Pilka");
        item.setPrice(100);
        item.setQuantity(100);
        return item;
    }

    @GetMapping("/item-from-busines-service")
    public Item itemFromBusinesService(){
        Item item = itemBusinesService.retrieveHardcodedItem();
        return item;
    }

    @GetMapping("/allItems")
    public List<Item> getAllItems(){
        return itemBusinesService.retrievAllItems();
    }

    @PostMapping("/addNewItem")
    public Item addNewItem(@RequestBody Item item){
        return itemBusinesService.addNewItem(item);
    }
}
