package innerclass.anonymousinnerclass.exercise;

public class CellPhone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }

    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
//        cellPhone.alarmClock(new Bell() {
//            @Override
//            public void ring() {
//                System.out.println("Time to go to school!");
//            }
//        });
        // lambda表达式更简化
        cellPhone.alarmClock(() -> System.out.println("Time to go to school!"));

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("Time to get up!");
            }
        });
    }
}
