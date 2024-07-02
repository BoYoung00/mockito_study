package com.example.mockito.mockito_demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // 목을 초기화하고 스터빙을 처리하는 확장
public class SomBusinessImplMockTest {

    @Mock // MockitoExtension
    private DataService dataService;
    @InjectMocks // MockitoExtension
    private SomeBusinessImpl businessImpl;

    @Test // 더 간단한 방법
    void findTheGreatestFromAllData_basicScenario() {
        // 테스트 값 지정
        when(dataService.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray() {
        // 테스트 값 지정
        when(dataService.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_OneValue() {
        // 모킹 선언
        DataService dataService = mock(DataService.class);
        // 객체 주입 하고
        SomeBusinessImpl business = new SomeBusinessImpl(dataService);
        // 테스트 값 지정
        when(dataService.retrieveAllData()).thenReturn(new int[] {35});
        int result = business.findTheGreatestFromAllData();
        assertEquals(35, result);
    }

}
