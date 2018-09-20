package com.example.unittesting.unittesting.business;

import com.example.unittesting.unittesting.data.SomeDateService;
import com.example.unittesting.unittesting.model.Item;
import com.example.unittesting.unittesting.repository.ItemRepositoryImpl;
import com.example.unittesting.unittesting.service.ItemBusinesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinesService business;

    @Mock
    private ItemRepositoryImpl repository;


    @Test
    public void calculateSumSomeDataServiceSimple() {
        when(repository.findAllItems()).thenReturn(Arrays.asList(new Item("Pilka",100,200),new Item("Pilka2",200,300)));
        List<Item> list =business.retrievAllItems();
        assertEquals(20000,list.get(0).getValue());
        assertEquals(60000,list.get(1).getValue());

    }
}