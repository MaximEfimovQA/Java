package javaAnnotation.Annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Accumulator {
    private final int capacity;

    public Accumulator(@Value("${accumulator.capacity}") int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Accumulator [capacity=" + capacity + "Ah]";
    }
}