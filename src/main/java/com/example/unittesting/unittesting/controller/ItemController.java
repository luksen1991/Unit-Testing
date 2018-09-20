package com.example.unittesting.unittesting.controller;

import com.example.unittesting.unittesting.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"Ball",10,100);
    }
}
