package javaCode.code;

public class Accumulator {
    private int capacity;

    public Accumulator(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Accumulator [capacity=" + capacity + " Ah]";
    }
}