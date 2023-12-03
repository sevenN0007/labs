package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    public void testAdd_EmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testAdd_SingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.add("5"));
    }

    @Test
    public void testAdd_MultipleNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.add("5,10"));
    }

    @Test
    public void testAdd_Multiple1Numbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1030, calculator.add("5,10,1000,15"));
    }

    @Test
    public void testAdd_Not_a_Numbers() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(NumberFormatException.class, () -> calculator.add("next"));
    }

}