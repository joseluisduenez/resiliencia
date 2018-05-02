package com.app;

import java.text.SimpleDateFormat;
import java.util.Date;

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
//		Date date =  new Date();
//		SimpleDateFormat dt1 = new SimpleDateFormat("MMMMM yyyy");
//        System.out.println(dt1.format(date));
	}
}
	