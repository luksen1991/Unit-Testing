package com.example.unittesting.unittesting.business;

import com.example.unittesting.unittesting.data.SomeDateService;

public class SomeBusinessImpl {

    SomeDateService somdeDateService;

    public void setSomdeDateService(SomeDateService somdeDateService) {
        this.somdeDateService = somdeDateService;
    }

    public int calculateSum(int [] data){

        int sum =0;

        for(int value: data){
               sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService(){

        int sum =0;
        int [] data = somdeDateService.retriveAllData();

        for(int value: data){
            sum += value;
        }
        return sum;
    }
}
