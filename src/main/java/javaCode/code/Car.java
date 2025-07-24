package javaCode.code;

public class Car {
    private Wheel wheel;
    private Engine engine;
    private Accumulator accumulator;
    private Suspension suspension;

    public Car(Wheel wheel, Engine engine, Accumulator accumulator, Suspension suspension) {
        this.wheel = wheel;
        this.engine = engine;
        this.accumulator = accumulator;
        this.suspension = suspension;
    }

    @Override
    public String toString() {
        return "Car components:\n" +
                "- " + wheel + "\n" +
                "- " + engine + "\n" +
                "- " + accumulator + "\n" +
                "- " + suspension;
    }
}