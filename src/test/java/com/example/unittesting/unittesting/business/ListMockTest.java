package com.example.unittesting.unittesting.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListMockTest {


    List<String> mock = mock(List.class);

    @Test
    public void sizeBasic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }

    @Test
    public void returnDiffrentValue(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParameters(){

        when(mock.get(0)).thenReturn("HelloWorld");
        assertEquals("HelloWorld",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    //Check parameters
    @Test
    public void returnWithGenericParameters(){

        when(mock.get(anyInt())).thenReturn("HelloWorld");
        assertEquals("HelloWorld",mock.get(0));
        assertEquals("HelloWorld",mock.get(1));
        assertEquals(5,mock.size());
    }

    // Check call method
    @Test
    public void verificationBasics(){

        String value = mock.get(0);
        String value2 = mock.get(5);

        verify(mock).get(0);
        verify(mock).get(5);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atLeast(2)).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(3); // is ok because get(3) is never call
    }

    @Test
    public void argumentCapturing(){

        mock.add("SomeString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString",captor.getValue());

    }

    @Test
    public void argumentCapturingMultipleTime(){

        mock.add("SomeString");
        mock.add("Egg");
        mock.add("Ice Cream");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock,times(3)).add(captor.capture());

        List<String> getAllValues = captor.getAllValues();
        assertEquals("Egg",getAllValues.get(1));

    }

    @Test
    public void spying(){
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //null
        System.out.println( arrayListMock.size()); //0
        System.out.println( arrayListMock.add("First"));
        System.out.println(arrayListMock.add("Second"));
        System.out.println(arrayListMock.size());//0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//5
    }


    @Spy
    List<String> spyList = new ArrayList<String>();

    @Test
    public void spyingArrayList(){
        spyList.add("Jajko");
        spyList.add("Sadzone");

        verify(spyList).add("Jajko");
        verify(spyList).add("Sadzone");

        assertEquals(2,spyList.size());
    }



}