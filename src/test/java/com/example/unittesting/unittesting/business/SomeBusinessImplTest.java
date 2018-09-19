package com.example.unittesting.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessImplTest {

    @Test
    public void calculateSum_simple() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_empty() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_NegativeNumbers() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{-1,1,-2,2});
        int expectedResult = 0;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_OneValue() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{3});
        int expectedResult = 3;
        assertEquals(expectedResult,result);

    }
}