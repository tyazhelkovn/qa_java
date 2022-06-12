package com.example;

import org.junit.Test;
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

    @Test
    public void getFoodExceptionTest() {
        Animal animal = new Animal();
        String actualException = "";
        String expectedException = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            animal.getFood("Хизник");
        } catch (Exception e) {
            actualException = e.getMessage();
        }
        assertEquals(expectedException, actualException);
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String expectedText = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualText = animal.getFamily();
        assertEquals(expectedText, actualText);
    }
}