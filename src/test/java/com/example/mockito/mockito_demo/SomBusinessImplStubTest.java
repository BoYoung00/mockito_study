package com.example.mockito.mockito_demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataServiceStub1 dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void findTheGreatestFromAllData_whitOneValue() {
        DataServiceStub2 dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(35, result);
    }
}

class DataServiceStub1 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 15, 5};
    }
}

class DataServiceStub2 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {35};
    }
}

