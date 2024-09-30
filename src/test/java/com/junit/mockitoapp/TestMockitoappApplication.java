package com.junit.mockitoapp;

import org.springframework.boot.SpringApplication;

public class TestMockitoappApplication {

	public static void main(String[] args) {
		SpringApplication.from(MockitoappApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
