package com.example.demo.xml;

public class Wheel {
    private String type;

    public Wheel(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Wheel type='" + type + "'";
    }
}