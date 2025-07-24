package javaAnnotation.Annotation;

import org.springframework.stereotype.Component;

@Component
public class Accumulator {
    private int capacity;

    // Конструктор по умолчанию (нужен для работы Spring)
    public Accumulator() {
        this.capacity = 60; // значение по умолчанию
    }

    // Сеттер для внедрения зависимости через XML или аннотации
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Accumulator capacity=" + capacity + " Ah";
    }
}