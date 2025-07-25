package javaAnnotation.Annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    private final String starter;
    private final String sparkPlug;

    public Engine(@Value("${engine.starter}") String starter,
                  @Value("${engine.sparkPlug}") String sparkPlug) {
        this.starter = starter;
        this.sparkPlug = sparkPlug;
    }

    @Override
    public String toString() {
        return "Engine [starter=" + starter + ", sparkPlug=" + sparkPlug + "]";
    }
}