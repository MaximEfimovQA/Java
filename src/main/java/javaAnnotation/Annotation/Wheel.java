package javaAnnotation.Annotation;

import org.springframework.stereotype.Component;

@Component
public class Wheel {
    private String type = "Alloy";

    @Override
    public String toString() {
        return "Wheel type=" + type;
    }
}