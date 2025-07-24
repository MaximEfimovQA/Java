package com.example.demo.xml;

public class Car {
    private final Wheel wheel;
    private final Engine engine;
    private final Accumulator accumulator;
    private final Suspension suspension;

    // Конструктор должен соответствовать XML-конфигурации
    public Car(Wheel wheel, Engine engine, Accumulator accumulator, Suspension suspension) {
        this.wheel = wheel;
        this.engine = engine;
        this.accumulator = accumulator;
        this.suspension = suspension;
    }

    // Добавьте toString() для удобства отладки
    @Override
    public String toString() {
        return "Car : \n  " +
                "wheel=" + wheel +
                ", \n engine=" + engine +
                ", \n accumulator=" + accumulator +
                ", \n suspension=" + suspension
                ;
    }
}