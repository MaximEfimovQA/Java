package javaAnnotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Suspension {
    private final Hinge hinge;
    private final Differential differential;

    @Autowired
    public Suspension(Hinge hinge, Differential differential) {
        this.hinge = hinge;
        this.differential = differential;
    }

    @Override
    public String toString() {
        return "Suspension [hinge=" + hinge + ", differential=" + differential + "]";
    }

    @Component
    public static class Hinge {
        private final String material;

        public Hinge(@Value("${suspension.hinge.material}") String material) {
            this.material = material;
        }

        @Override
        public String toString() {
            return "Hinge [material=" + material + "]";
        }
    }

    @Component
    public static class Differential {
        private final String type;

        public Differential(@Value("${suspension.differential.type}") String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Differential [type=" + type + "]";
        }
    }
}