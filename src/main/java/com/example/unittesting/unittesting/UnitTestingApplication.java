package com.example.unittesting.unittesting;

import com.example.unittesting.unittesting.model.Item;
import com.example.unittesting.unittesting.repository.ItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class UnitTestingApplication  {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}

//	@Autowired
//	ItemRepositoryImpl itemRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Item item = new Item();
//		item.setName("Pilka");
//		item.setPrice(100);
//		item.setQuantity(300);
//
//		itemRepository.addElement(item);
//	}
}
