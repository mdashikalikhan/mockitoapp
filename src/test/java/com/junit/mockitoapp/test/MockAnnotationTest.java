package com.junit.mockitoapp.test;

import com.junit.mockitoapp.MockitoappApplication;
import com.junit.mockitoapp.beans.CollegeStudent;
import com.junit.mockitoapp.beans.StudentGrades;
import com.junit.mockitoapp.dao.ApplicationDao;
import com.junit.mockitoapp.service.ApplicationService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import static org.mockito.Mockito.*;

@SpringBootTest (classes = MockitoappApplication.class)
public class MockAnnotationTest {
    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent firstStudent;

    @Autowired
    StudentGrades grades;

    //@Mock
    @MockBean
    private ApplicationDao applicationDao;

    @Autowired
    private ApplicationService  applicationService;

    @BeforeEach
    public void beforeEach(){
        firstStudent.setFirstname("MD ASHIK");
        firstStudent.setLastname("ALI KHAN");
        firstStudent.setEmailAddress("khan.ashik@gmail.com");
        firstStudent.setStudentGrades(grades);
    }

    @DisplayName("When & Verify Grades")
    @Test
    public void testGradeSum(){

        when(applicationService.addGradeResultsForSingleClass(
                firstStudent.getMathGrades())).thenReturn(990.0)
                .thenReturn(100.0);

        assertEquals(990.0,
                applicationService.addGradeResultsForSingleClass(
                        firstStudent.getMathGrades()
                ));

        assertEquals(100.0,
                applicationService.addGradeResultsForSingleClass(
                        firstStudent.getMathGrades()
                ));


        /*verify(applicationDao).addGradeResultsForSingleClass(
                firstStudent.getMathGrades());

        verify(applicationDao).addGradeResultsForSingleClass(
                firstStudent.getMathGrades());*/

        verify(applicationDao, times(2)).addGradeResultsForSingleClass(
                firstStudent.getMathGrades());

    }

    @DisplayName("TEST GPA")
    @Test
    void testGPA(){
        when(applicationDao.findGradePointAverage(firstStudent.getMathGrades()))
                .thenReturn(89.9);

        assertEquals(89.9, applicationService.findGradePointAverage(
                firstStudent.getMathGrades()
        ));
    }

    @DisplayName("Test Null")
    @Test
    void testNotNull(){
        when(applicationDao.checkNull(firstStudent.getMathGrades()))
                .thenReturn(true);

        assertNotNull(applicationService.checkNull(firstStudent.getMathGrades()));

        verify(applicationDao).checkNull(firstStudent.getMathGrades());
    }

    @DisplayName("Test consecutive")
    @Test
    void testConsecutiveCalls(){
        CollegeStudent nullStudent = (CollegeStudent)context.getBean("collegeStudent");

        when(applicationDao.checkNull(nullStudent))
                .thenThrow(new RuntimeException())
                .thenReturn("NO EXCEPTION");

        assertThrows(RuntimeException.class,
                ()->{
                    applicationService.checkNull(nullStudent);
                });

        assertEquals("NO EXCEPTION", applicationService.checkNull(nullStudent));

        verify(applicationDao, times(2))
                .checkNull(nullStudent);
    }
}
