package javaCode;

import javaCode.javaconfig.AppConfig;
import javaCode.code.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class) // Импортируем Java-конфиг вместо XML
public class  DemoApplication3 {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication3.class, args);
		Car car = ctx.getBean(Car.class);
		System.out.println("Spring Boot + Java Config:\n" + car);
	}
}