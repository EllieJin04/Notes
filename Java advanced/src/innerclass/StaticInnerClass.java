package innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {
        Outer02.Inner inner = new Outer02.Inner();
        inner.m2();

        Outer02.Inner inner1 = Outer02.getInner();
        inner1.m2();

    }
}

class Outer02 {
    private static int i = 10;

    private void m1() {

    }

    // 成员内部类可以使用任何修饰符：public private protected default
    static class Inner {
        private int j = 100;

        public void m2() {
            // 静态内部类只能访问外部类中的静态成员或方法
            // 但是静态内部类可以有实例变量
            System.out.println("i = " + i);
            System.out.println("j = " + j);
        }
    }

    public static Inner getInner() {
        return new Inner();
    }


    public void m3() {
        Inner inner = new Inner();
        inner.m2();
    }
}
