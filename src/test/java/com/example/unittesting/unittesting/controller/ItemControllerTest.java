package com.example.unittesting.unittesting.controller;

import com.example.unittesting.unittesting.model.Item;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void dummyItem() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

//        JSONAssert.assertEquals(result,result.getResponse().getContentAsString(),true);

    }
}