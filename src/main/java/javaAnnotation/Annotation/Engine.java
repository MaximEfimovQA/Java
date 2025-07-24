package javaAnnotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    private String starter;
    private String sparkPlug;

    @Autowired
    public void setStarter(String starter) {
        this.starter = starter;
    }

    @Autowired
    public void setSparkPlug(String sparkPlug) {
        this.sparkPlug = sparkPlug;
    }

    @Override
    public String toString() {
        return "Engine [starter=" + starter + ", sparkPlug=" + sparkPlug + "]";
    }
}