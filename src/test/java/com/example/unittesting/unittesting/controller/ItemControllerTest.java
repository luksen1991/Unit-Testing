package com.example.unittesting.unittesting.controller;

import com.example.unittesting.unittesting.model.Item;
import com.example.unittesting.unittesting.service.ItemBusinesService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinesService itemBusinesService;

    @Test
    public void retriveAllItems() throws Exception {

        when(itemBusinesService.retrievAllItems()).thenReturn(
                Arrays.asList(new Item("Pilka",100,200),new Item("Pilka2",200,300))
        );
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item/allItems")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(

                                "[{id:0, name:Pilka, price:100, quantity:200},{id:0, name:Pilka2, price:200, quantity:300}]"))
                .andReturn();

//        JSONAssert.assertEquals(result,result.getResponse().getContentAsString(),true);

    }

}