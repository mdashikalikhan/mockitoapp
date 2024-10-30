package com.junit.mockitoapp.test;

import com.junit.mockitoapp.MockitoappApplication;
import com.junit.mockitoapp.beans.CollegeStudent;
import com.junit.mockitoapp.beans.StudentGrades;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MockitoappApplication.class)
public class ReflectionTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private CollegeStudent firstStudent;

    @Autowired
    private StudentGrades studentGrades;

    @BeforeEach
    void beforeEach(){
        firstStudent.setFirstname("MD ASHIK");
        firstStudent.setLastname("ALI KHAN");
        firstStudent.setEmailAddress("khan.ashik@gmail.com");
        firstStudent.setStudentGrades(studentGrades);

        ReflectionTestUtils.setField(firstStudent, "id", "100");
        ReflectionTestUtils.setField(firstStudent, "studentGrades",
                new StudentGrades(new ArrayList<>(List.of(100.0,99.9))));
    }

    @Test
    void testPrivateField(){
        assertEquals("100", ReflectionTestUtils.getField(firstStudent, "id"));
    }

    @Test
    void testPrivateMethod(){
        assertEquals("100 MD ASHIK ALI KHAN", ReflectionTestUtils.invokeMethod(firstStudent,
                "getIdAndName"));
    }
}
