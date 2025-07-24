package com.example.demo;

import com.example.demo.xml.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		// Проверка создания бина Car
		Car car = ctx.getBean(Car.class);
		System.out.println("Successfully created car: XML " + car );
	}
}