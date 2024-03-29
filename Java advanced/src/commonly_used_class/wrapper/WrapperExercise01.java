package commonly_used_class.wrapper;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class WrapperExercise01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Double d = 100d; //ok, 自动装箱 Double.valueOf(100d);
        Float f = 1.5f; //ok, 自动装箱 Float.valueOf(1.5f);

        /*
            在 Java 中使用三元运算符时，条件表达式的两个分支必须具有相同的类型，否则会发生类型转换。
            在这种情况下，new Integer(1) 和 new Double(2.0) 分别返回 Integer 和 Double 类型的对象。
            由于 Double 类型的范围比 Integer 类型的范围更广，因此在三元运算符中，Integer 类型的对象会被自动转换为
            Double 类型。因此，obj 实际上引用了一个 Double 类型的对象，其值为 1.0。
         */
        Object obj1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj1);// 1.0

        Object obj2;
        if(true)
            obj2 = new Integer(1);
        else
            obj2 = new Double(2.0);
        System.out.println(obj2);//1
        //输出什么 ? 1， 分别计算

    }
}
