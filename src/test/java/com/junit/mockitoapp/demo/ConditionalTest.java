package com.junit.mockitoapp.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalTest {

    @Test
    @DisplayName("Basic Test")
    @Disabled("Only run after JIRA #1 resolved")

    void testBasic(){

    }

    @Test
    @DisplayName("Test On Windows")
    @EnabledOnOs(OS.WINDOWS)
    void testOnWindows(){
        System.out.println("Windows Test");
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On Linux")
    @EnabledOnOs(OS.LINUX)
    void testOnLinux(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On Mac")
    @EnabledOnOs(OS.MAC)
    void testOnMac(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On Mac or Windows")
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testOnMacOrWindows(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On Java 8")
    @EnabledOnJre(JRE.JAVA_8)
    void testOnJava8(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On Java 17")
    @EnabledOnJre(JRE.JAVA_17)
    void testOnJava1(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On Java 11 to 13")
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_13,
    disabledReason = "Only support java 11 to 13")
    void testOnJava11To13(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On Java 17 to 19")
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_19,
            disabledReason = "Only support java 11 to 19")
    void testOnJava17To19(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On Minimum Java 11")
    @EnabledForJreRange(min = JRE.JAVA_11,
            disabledReason = "Only support minimum java 11")
    void testOnMinJava11(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On QC")
    @EnabledIfEnvironmentVariable(named = "env", matches = "QC")
    void testOnQC(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }

    @Test
    @DisplayName("Test On System")
    @EnabledIfSystemProperty(named = "sys", matches = "@@@")
    void testOnSystem(){
        assertThrows(Exception.class, () -> {
            throw new Exception();
        });
    }
}
