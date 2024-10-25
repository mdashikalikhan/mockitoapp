package com.junit.mockitoapp;

import com.junit.mockitoapp.beans.CollegeStudent;
import com.junit.mockitoapp.dao.ApplicationDao;
import com.junit.mockitoapp.service.ApplicationService;
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

	@Bean(name = "applicationExample")
	ApplicationService getApplicationService() {
		return new ApplicationService();
	}

	/* New for Section 2.2 */
	@Bean(name = "applicationDao")
	ApplicationDao getApplicationDao() {
		return new ApplicationDao();
	}
}
