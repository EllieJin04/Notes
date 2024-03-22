package innerclass;

public class MemberInnerClass {
    public static void main(String[] args) {
        // 外部其他类访问内部类的第一种方式
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.m2();

        // 第二种方式
        Outer.Inner inner1 = outer.getInner();
        inner1.m2();

    }
}

class Outer {
    private int i = 10;

    private void m1() {

    }

    // 成员内部类可以使用任何修饰符：public private protected default
    class Inner {
        private int j = 100;

        public void m2() {
            System.out.println("i = " + i);
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public void m3() {
        Inner inner = new Inner();
        inner.m2();
    }
}
