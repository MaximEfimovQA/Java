package javaCode.code;

public class Suspension {
    private String hinge;
    private String differential;

    public Suspension(String hinge, String differential) {
        this.hinge = hinge;
        this.differential = differential;
    }

    @Override
    public String toString() {
        return "Suspension [hinge=" + hinge + ", differential=" + differential + "]";
    }
}