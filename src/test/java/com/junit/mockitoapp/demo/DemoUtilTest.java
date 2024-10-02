package com.junit.mockitoapp.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.junit.mockitoapp.beans.DemoUtils;
import org.junit.jupiter.api.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
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
    //@DisplayName("Test_Equals_Or_Not")
    void testDemoUtilEqualsOrNotEquals() {
        int result = demoUtils.add(10, 20);
        int expected = 30;
        assertEquals(expected, result, "must be 20");
        //assertNotEquals(expected, result, "must not be 20");
        StringBuilder sb1 = new StringBuilder("1234");
        sb1.append("5678");

        StringBuilder sb2 = new StringBuilder("123456");
        sb2.append("78");

        assertEquals(sb1.toString(), sb2.toString(), "They are not equal");



    }

    @Test
    @DisplayName("Test_Null")
    void testNull(){
        assertNull( null);

    }

    @Test
    @DisplayName("Test_Throws")
    void testAssertThrows(){
        assertThrows(ArithmeticException.class, ()->demoUtils.divide(10, 0));

    }

    @Test
    @DisplayName("Test True or False")
    void testTrueFalse(){
        assertTrue(demoUtils.isGreater(10, 5));
    }

    @Test
    void sameOrNot(){
        String s1 = new String("Sample");
        assertSame(demoUtils.getStr(), demoUtils.getStrDuplicate(), "Not same");
        assertSame(demoUtils.getStrDuplicate(), s1, "s1 Not same");
    }

    @DisplayName("")
    @Test
    void testArrayEqual(){
        int[] testArr={1,2,3,4,5};
        assertArrayEquals(testArr, demoUtils.getIntegers(), "Array not equal");
    }
}
