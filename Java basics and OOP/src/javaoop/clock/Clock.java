package javaoop.clock;

public class Clock {
    private Display hour;
    private Display minute;

    private Display second;

    public Clock() {
        this.hour = new Display(24);
        this.minute = new Display(60);
        this.second = new Display(60);
    }

    public Clock(int hour, int minute, int second) {
        this.hour = new Display(hour, 24);
        this.minute = new Display(minute, 60);
        this.second = new Display(second, 60);
    }

    public void start() {
        while (true) {
            tick();
            System.out.printf(this.toString());
            try {
//                Thread.sleep(1000);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void tick() {
        second.increase();
        if (second.getValue() == 0) {
            minute.increase();
            if (minute.getValue() == 0) {
                hour.increase();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour.getValue(), minute.getValue(), second.getValue());
    }

    public static void main(String[] args) {
        Clock clock1 = new Clock(23, 59, 59);
//        Clock clock2 = new Clock();
//        clock1.start();
//        clock2.start();
        System.out.println(clock1);
        for (int i = 0; i < 21; i++) {
            clock1.tick();
            System.out.println(clock1);
        }


    }
}
