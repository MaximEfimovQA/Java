package javaCode.code;

public class Engine {
    private String starter;
    private String sparkPlug;

    public Engine(String starter, String sparkPlug) {
        this.starter = starter;
        this.sparkPlug = sparkPlug;
    }

    @Override
    public String toString() {
        return "Engine [starter=" + starter + ", sparkPlug=" + sparkPlug + "]";
    }
}