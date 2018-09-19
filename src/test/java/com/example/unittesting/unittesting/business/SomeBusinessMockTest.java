package com.example.unittesting.unittesting.business;

import com.example.unittesting.unittesting.data.SomeDateService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {

    private SomeBusinessImpl business;
    private SomeDateService dataServiceMock;

    @Before
    public void initTesting(){
        business = new SomeBusinessImpl();
        dataServiceMock = mock(SomeDateService.class);
    }


    @Test
    public void calculateSumSomeDataService_simple() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{1,2,3});
        business.setSomdeDateService(dataServiceMock);
        int result = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_empty() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{});
        business.setSomdeDateService(dataServiceMock);
        int result = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_NegativeNumbers() {

        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{-1,-2,-3});
        business.setSomdeDateService(dataServiceMock);
        int result = business.calculateSumUsingDataService();
        int expectedResult = -6;
        assertEquals(expectedResult,result);

    }

    @Test
    public void calculateSum_OneValue() {

       when(dataServiceMock.retriveAllData()).thenReturn(new int[]{5});
        business.setSomdeDateService(dataServiceMock);
        int result = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult,result);

    }
}