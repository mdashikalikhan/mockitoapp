package com.junit.mockitoapp.test;

import com.junit.mockitoapp.MockitoappApplication;
import com.junit.mockitoapp.beans.CollegeStudent;
import com.junit.mockitoapp.beans.Student;
import com.junit.mockitoapp.beans.StudentGrades;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest(classes = MockitoappApplication.class)
public class ApplicationContextTest {

    @Value("${info.college.name}")
    private String collegeName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    @Autowired
    ApplicationContext context;

    private static int count = 0;

    @BeforeEach
    public void beforeEachTest() {
        count += 1;
        System.out.println("count: " + count +
                ", description: " + appDescription +
                ", version: " + appVersion +
                ", College Name: " + collegeName );

        student.setFirstname("MD ASHIK");

        student.setLastname("ALI KHAN");

        student.setEmailAddress("khan.ashik@gmail.com");

        studentGrades.setMathGradeResults(
                new ArrayList<>(Arrays.asList(90.9, 89.9, 89.0, 89.99))
        );

        student.setStudentGrades(studentGrades);
    }

    /*@Test
    void context(){

    }*/

    @DisplayName("Test Grade Summation Equal")
    @Test
    void testGradeSummationEqual(){
        assertEquals(359.79, studentGrades.addGrades());
    }

    @DisplayName("Test Grade Summation Not Equal")
    @Test
    void testGradeSummationNoEqual(){
        assertNotEquals(0.79, studentGrades.addGrades());
    }


    @DisplayName("Verify Student is prototype")
    @Test
    void verifyPrototype(){
        CollegeStudent student1 = context.getBean("collegeStudent", CollegeStudent.class);

        assertNotSame(student1, student);
    }

    @DisplayName("Test All Assertions")
    @Test
    void testAllAssert(){

        assertAll(
                "Heading ALl",
                ()-> assertNotEquals(10,1),
                ()->assertNull(null)

        );
    }
}
