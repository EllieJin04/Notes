package javabasics.clock;

public class Display {
    private int value;
    private int limit;

    public Display(int limit) {
        this.value = 0;
        this.limit = limit;
    }

    public Display(int value, int limit) {
        this.value = value;
        this.limit = limit;
    }

    public void increase() {
        value++;
        if (value == limit) {
            value = 0;
        }
    }

    public int getValue() {
        return value;
    }
}
