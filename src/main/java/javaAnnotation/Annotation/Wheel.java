package javaAnnotation.Annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Wheel {
    private final String type;

    public Wheel(@Value("${wheel.type}") String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Wheel [type=" + type + "]";
    }
}