package com.junit.mockitoapp.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.junit.mockitoapp.beans.DemoUtils;
import org.junit.jupiter.api.Test;

public class DemoUtilTest {
    @Test
    public void testDemoUtilEqualsOrNotEquals() {
        DemoUtils demoUtils = new DemoUtils();
        int result = demoUtils.add(10, 20);
        int expected = 30;
        assertEquals(expected, result, "must be 20");
        //assertNotEquals(expected, result, "must not be 20");
    }

    @Test
    void testNull(){
        DemoUtils demoUtils = null;
        assertNull(demoUtils);

    }
}
