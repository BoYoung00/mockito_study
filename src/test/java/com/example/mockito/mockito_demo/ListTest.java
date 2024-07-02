package com.example.mockito.mockito_demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void simpleTest() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(3);

        assertEquals(3, listMock.size());
    }

    @Test
    public void multipleReturns() {
        List listMock = mock(List.class);

        // 값 주입
        when(listMock.size()).thenReturn(1).thenReturn(2);

        // 예상 값
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size()); // 마지막 반환 값이 계속 할당
    }

    @Test
    public void parameters() {
        List listMock = mock(List.class);

        // 값 주입
        when(listMock.get(0)).thenReturn("Som");

        // 예상 값
        assertEquals("Som", listMock.get(0));
        assertNull(listMock.get(1));
    }

    @Test
    public void genericParameters() {
        List listMock = mock(List.class);

        // Mockito.anyInt() : get(100)을 하든 그 안의 값을 가져옴
        when(listMock.get(Mockito.anyInt())).thenReturn("String");

        // 예상 값
        assertEquals("String", listMock.get(0));
        assertEquals("String", listMock.get(1));
    }
}
