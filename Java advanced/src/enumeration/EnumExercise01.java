package enumeration;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class EnumExercise01 {
    public static void main(String[] args) {
        Gender2 female1 = Gender2.FEMALE;//OK
        Gender2 female2 = Gender2.FEMALE;//OK
        System.out.println(Gender2.FEMALE);//输出BOY //本质就是调用 Gender2 的父类Enum的 toString()
//        public String toString() {
//            return name;
//        }
        System.out.println(female1 == female2);  //True
    }
}

enum Gender2{ //父类 Enum 的toString
    FEMALE, MALE, NON_BINARY, GENDER_FLUID;
}

