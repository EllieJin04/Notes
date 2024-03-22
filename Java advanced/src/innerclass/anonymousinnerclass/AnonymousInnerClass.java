package innerclass.anonymousinnerclass;

/*
    匿名内部类可以实现接口和类。
    匿名内部类的编译类型和运行类型是不同的。
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            @Override
            public void eat() {
                System.out.println("Dog eat meat.");
            }
        };
        dog.eat();
        System.out.println(dog.getClass());

        Electronic phone = new Electronic() {
            @Override
            public void turnOn() {
                System.out.println("Phone is turned on.");
            }
        };
        phone.turnOn();
        System.out.println(phone.getClass());
    }
}
