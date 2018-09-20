package com.example.unittesting.unittesting;

import com.example.unittesting.unittesting.repository.ItemRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemRepositoryImpl.class)
public class UnitTestingApplicationTests {

//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	public void contextLoads() {
//		RequestBuilder request = MockMvcRequestBuilders
//				.get("/item/dummy-item")
//				.accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().json(
//
//						"{\"id\":0,\"name\":\"Pilka\",\"price\":100,\"quantity\":100,\"value\":0}"))
//				.andReturn();
//	}

}
