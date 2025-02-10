package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final List<String> expectedList;
    private final String argument;

    public AnimalTest(List<String> expectedList, String argument) {
        this.expectedList = expectedList;
        this.argument = argument;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                {List.of("Трава", "Различные растения"), "Травоядное"},
                {List.of("Животные", "Птицы", "Рыба"), "Хищник"},
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> actualList = animal.getFood(argument);
        assertEquals(expectedList, actualList);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getFoodExceptionTest() throws Exception {
        Animal animal = new Animal();
        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        thrown.expect(Exception.class);
        thrown.expectMessage(expectedExceptionMessage);
        animal.getFood("Хизник");
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String expectedText = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualText = animal.getFamily();
        assertEquals(expectedText, actualText);
    }
}