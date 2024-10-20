package com.junit.mockitoapp.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    @Test
    @DisplayName("Divisible by Three")
    @Order(1)
    void testForDivisibleByThree() {
        //fail("fail");
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    @Test
    @DisplayName("Divisible by Five")
    @Order(2)
    void testForDivisibleByFive() {
        //fail("fail");
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(10), "Should return Buzz");
    }

    @Test
    @DisplayName("Divisible by Three and Five")
    @Order(3)
    void testForDivisibleByThreeAndFive() {
        //fail("fail");
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }


    @DisplayName("Test FizzBuzz from CSV file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/fiz-buzz-test.csv")
    @Order(4)
    void testFromCsvFile(int value, String expected) {
        //fail("fail");
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
