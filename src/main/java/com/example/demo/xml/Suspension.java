package com.example.demo.xml;

public class Suspension {
    private Hinge hinge;
    private Differential differential;

    // Вложенный класс Hinge
    public static class Hinge {
        private String material;

        public Hinge(String material) {
            this.material = material;
        }

        @Override
        public String toString() {
            return "Hinge material='" + material ;
        }
    }

    // Вложенный класс Differential
    public static class Differential {
        private String type;

        public Differential(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Differential type='" + type ;
        }
    }

    public Suspension(Hinge hinge, Differential differential) {
        this.hinge = hinge;
        this.differential = differential;
    }

    @Override
    public String toString() {
        return "Suspension " +
                "hinge=" + hinge +
                ", differential=" + differential
                ;
    }
}