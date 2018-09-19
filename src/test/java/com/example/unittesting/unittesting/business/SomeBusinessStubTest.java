package com.example.unittesting.unittesting.business;

import com.example.unittesting.unittesting.data.SomeDateService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SomeDataServiceStub implements  SomeDateService{
    @Override
    public int[] retriveAllData() {
        return new int[]{1,2,3};
    }
}

class SomeDataServiceStubEmpty implements  SomeDateService{
    @Override
    public int[] retriveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceStubNegativeNumbers implements  SomeDateService{
    @Override
    public int[] retriveAllData() {
        return new int[]{-1,-2,-3};
    }
}

class SomeDataServiceStubOneValue implements  SomeDateService{
    @Override
    public int[] retriveAllData() {
        return new int[]{5};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumSomeDataService_simple() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomdeDateService(new SomeDataServiceStub());
        int result = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_empty() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomdeDateService(new SomeDataServiceStubEmpty());
        int result = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_NegativeNumbers() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomdeDateService(new SomeDataServiceStubNegativeNumbers());
        int result = business.calculateSumUsingDataService();
        int expectedResult = -6;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_OneValue() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomdeDateService(new SomeDataServiceStubOneValue());
        int result = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult,result);

    }
}