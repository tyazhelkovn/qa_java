package com.example;

import org.junit.Test;
import org.mockito.Mock;
import java.util.List;
import static org.junit.Assert.*;

public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(new Feline());
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = cat.getFood();
        assertEquals(expectedList, actualList);
    }
}