package javaAnnotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Suspension {
    private String hinge;
    private String differential;

    @Autowired
    public void setHinge(String hinge) {
        this.hinge = hinge;
    }

    @Autowired
    public void setDifferential(String differential) {
        this.differential = differential;
    }

    @Override
    public String toString() {
        return "Suspension [hinge=" + hinge + ", differential=" + differential + "]";
    }
}