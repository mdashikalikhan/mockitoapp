package com.junit.mockitoapp.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.junit.mockitoapp.beans.DemoUtils;
import org.junit.jupiter.api.*;

public class DemoUtilTest {


    DemoUtils demoUtils;

    @BeforeEach
    void setUp() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("@AfterEach");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@AfterAll");
    }


    @Test
    void testDemoUtilEqualsOrNotEquals() {
        int result = demoUtils.add(10, 20);
        int expected = 30;
        assertEquals(expected, result, "must be 20");
        //assertNotEquals(expected, result, "must not be 20");
    }

    @Test
    void testNull(){
        assertNull( null);

    }

    @Test
    void testAssertThrows(){
        assertThrows(ArithmeticException.class, ()->demoUtils.divide(10, 0));

    }
}
