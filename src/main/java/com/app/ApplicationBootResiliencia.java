package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ImportResource("dispatcher-servlet.xml")
public class ApplicationBootResiliencia {
	public static void main(String[] args) {
	    SpringApplication.run(ApplicationBootResiliencia.class, args);
	}
}
