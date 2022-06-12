package com.example;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String checkedSex;
    private final boolean expectedSex;

    public LionTest(String checkedSex, boolean expectedSex) {
        this.checkedSex = checkedSex;
        this.expectedSex = expectedSex;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getKittenTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualCount = lion.getKittens();
        assertEquals(1, actualCount);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(checkedSex, feline);
        boolean actualSex = lion.doesHaveMane();
        assertEquals(expectedSex, actualSex);
    }

    @Test
    public void shouldCreatingLionThrowExeptionTest() {
        String expectedExeptionMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualExeptionMessage = "";
        try {
            Lion lion = new Lion("invalid", feline);
        } catch (Exception e) {
            actualExeptionMessage = e.getMessage();
        }
        assertEquals(expectedExeptionMessage, actualExeptionMessage);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualList = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualList);
    }

    @Test
    public void shouldGettingLionThrowExceptionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        String expectedExceptionMessage = "java.lang.Exception";
        String actualExceptionMessage = "";
        Mockito.when(feline.getFood("Хищник")).thenThrow(Exception.class);
        try {
            lion.getFood();
        } catch (Exception e) {
            actualExceptionMessage = e.toString();
        }
        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}