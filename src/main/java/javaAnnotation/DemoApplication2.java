package javaAnnotation;

import javaAnnotation.Annotation.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:AnnotationMetod.xml") // Подключаем XML-конфиг
public class DemoApplication2 {
	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplication2.class, args);
		Car car = ctx.getBean(Car.class);
		System.out.println("Spring Boot + Annotations:\n" + car);
	}
}