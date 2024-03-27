package enumeration;

public class Enumeration {
    public static void main(String[] args) {
        // 枚举类方法：values(), valueOf(), ordinal(), compareTo(), toString()
        // 遍历枚举类的所有常量
        System.out.println("All Seasons:");
        for (Season season : Season.values()) {
            System.out.println(season);
        }

        // 根据枚举常量名返回对应的枚举常量
        String seasonName = "SUMMER";
        Season summer = Season.valueOf(seasonName);
        System.out.println(seasonName + ": " + summer.getName() + " - " + summer.getDesc());

        // 获取枚举常量的序号，从0开始
        int ordinal = Season.AUTUMN.ordinal();
        System.out.println("Autumn's ordinal: " + ordinal);

        // 比较枚举常量的顺序
        Season firstSeason = Season.SPRING;
        Season secondSeason = Season.SUMMER;
        int comparison = firstSeason.compareTo(secondSeason);
        System.out.println("Comparison of Spring and Summer: " + comparison);

        // toString()方法
//        public String toString() {
//            return name;
//        }
        System.out.println("Name: " + firstSeason.toString());
    }
}

enum Season {
    // 枚举类的常量必须放在第一行，放在后面就会报错
    // 枚举类可以实现很多个接口，但不能继承其他类，因为enum已经隐式地继承了JAVA的Enum类
    SPRING("Spring", "Warm"), SUMMER("Summer", "Hot"), AUTUMN("Autumn", "Cool"), WINTER("Winter", "Cold");

    private final String name;

    private final String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

enum Gender {
    // 枚举类常量也可以没有参数，没有参数时()可以省略
    FEMALE, MALE, NON_BINARY, GENDER_FLUID
}
