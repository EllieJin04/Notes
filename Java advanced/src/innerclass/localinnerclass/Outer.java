package innerclass.localinnerclass;
/*
    类的五大成员：属性，方法，构造器，代码块，内部类（attributes, methods, constructors, code blocks, inner classes.）
 */

/*
    局部内部类定义在外部类的局部位置，比如方法，或者代码块，并且有类名。
    1. 可以直接访问外部类的所有成员，包括私有的
    2. 因为它的地位是局部变量，所以局部内部类不能添加任何访问修饰符，但是final可以，因为局部变量也可以添加final
    3. 作用域：在它定义的方法或者代码块中
    4. 局部内部类访问外部类成员的方式：直接访问
    5. 外部类访问局部内部类成员的方式：创建对象，然后访问，但这个过程必须在作用域里
    6. 外部其他类不能访问局部内部类，因为局部内部类的地位就是一个局部变量。
    7. 如果外部类和局部内部类有成员重名时，默认遵循就近原则。所以如果一定要访问外部类成员，就需要用外部类名字.this.成员名
 */

// 外部其他类
class OuterOther {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m2();
    }
}

// 外部类
public class Outer {
    private int n = 200;
    private void m1() {
        System.out.println("m1()");
    }

    public Outer() {

    }

    public void m2() {
        // 局部内部类
        final class Inner {
            private int n = 100;

            public void m3() {
                System.out.println("外部类方法：m1()");
                System.out.println("访问重名变量n(外部类): " + Outer.this.n);
                System.out.println("访问重名变量n(局部内部类): " + n);
            }
        }

        //
        Inner inner = new Inner(); // new Inner().var可以快捷生成这行代码
        System.out.println("Local Inner Class can access all methods and fields in outer class.");
        System.out.println("For example, n in outer class: " + n);
        System.out.print("Also can access method: ");
        m1();
        inner.m3();
        System.out.println("局部内部类私有变量：" + inner.n);
    }
}
