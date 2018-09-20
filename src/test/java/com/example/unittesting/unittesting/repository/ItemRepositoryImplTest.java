package com.example.unittesting.unittesting.repository;

import com.example.unittesting.unittesting.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemRepositoryImpl.class)
public class ItemRepositoryImplTest {

    @Autowired
    ItemRepositoryImpl itemRepository;

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory( "myDatabase" );
    }

    @After
    public void destroy() {
        entityManagerFactory.close();
    }
    @Test
    public void findAll(){
        List<Item> list =itemRepository.findAllItems();
        assertEquals(2,list.size());
    }

    @Test
    public void addNewItem(){
        Item item = new Item("Kokali12233",100,200);
        itemRepository.addElement(item);
        assertEquals(itemRepository.findAllItems().get(item.getId()-1).getName(),item.getName());
    }

}