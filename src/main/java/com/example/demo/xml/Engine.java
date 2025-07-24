package com.example.demo.xml;

public class Engine {
    private Starter starter;
    private SparkPlug sparkPlug;

    // Вложенный класс Starter
    public static class Starter {
        private String model;

        public Starter(String model) {
            this.model = model;
        }

        @Override
        public String toString() {
            return "Starter model='" + model ;
        }
    }

    // Вложенный класс SparkPlug
    public static class SparkPlug {
        private String brand;

        public SparkPlug(String brand) {
            this.brand = brand;
        }

        @Override
        public String toString() {
            return "SparkPlug brand = " + brand ;
        }
    }

    public Engine(Starter starter, SparkPlug sparkPlug) {
        this.starter = starter;
        this.sparkPlug = sparkPlug;
    }

    @Override
    public String toString() {
        return "Engine " +
                "starter=" + starter +
                ", sparkPlug=" + sparkPlug
                ;
    }
}