package com.junit.mockitoapp.test;

import com.junit.mockitoapp.MockitoappApplication;
import com.junit.mockitoapp.beans.CollegeStudent;
import com.junit.mockitoapp.beans.StudentGrades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = MockitoappApplication.class)
public class ReflectionTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private CollegeStudent firstStudent;

    @Autowired
    private StudentGrades studentGrades;
}
