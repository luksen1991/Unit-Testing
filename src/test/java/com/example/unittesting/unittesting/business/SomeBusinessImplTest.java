package com.example.unittesting.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessImplTest {

    @Test
    public void calculateSumSimple() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSumEmpty() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSumNegativeNumbers() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{-1,1,-2,2});
        int expectedResult = 0;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSumOneValue() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{3});
        int expectedResult = 3;
        assertEquals(expectedResult,result);

    }
}