package com.risk.manager;

import org.springframework.boot.SpringApplication;

public class TestManagerApplication {

	public static void main(String[] args) {
		SpringApplication.from(ManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
