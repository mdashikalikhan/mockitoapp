package com.junit.mockitoapp;

import com.junit.mockitoapp.beans.CollegeStudent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class MockitoappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MockitoappApplication.class, args);
	}

	@Bean(name = "collegeStudent")
	@Scope(value = "prototype")
	public CollegeStudent getCollegeStudent() {
		return new CollegeStudent();
	}
}
