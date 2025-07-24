package javaCode.javaconfig;

import javaCode.code.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Wheel wheel() {
        return new Wheel("Alloy");
    }

    @Bean
    public Engine engine() {
        return new Engine("Electric Starter", "Iridium Spark Plug");
    }

    @Bean
    public Accumulator accumulator() {
        return new Accumulator(70);
    }

    @Bean
    public Suspension suspension() {
        return new Suspension("Steel Hinge", "Limited Slip Differential");
    }

    @Bean
    public Car car(Wheel wheel, Engine engine, Accumulator accumulator, Suspension suspension) {
        return new Car(wheel, engine, accumulator, suspension);
    }
}