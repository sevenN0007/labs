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

    @Test
    public void testAdd_NumbersFrom() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(16, calculator.add("5\n10,1"));
        assertEquals(6, calculator.add("//[***]\n1***1***1***1\n1,1\n"));
        assertEquals(7, calculator.add("//[*][+++][%]\n1*2%3+++1"));
    }

    @Test
    public void testAdd_NegativesNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(NumberFormatException.class, () -> calculator.add("5\n-10,1"));
        assertThrows(NumberFormatException.class, () -> calculator.add("//[***]\n1***-1***1***1\n1,1"));
    }


}