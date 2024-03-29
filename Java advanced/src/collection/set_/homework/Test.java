package collection.set_.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {

        HashSet<Employee> set = new HashSet<>();
        set.add(new Employee("Amy", 1200, new MyDate(1998, 10, 24)));
        set.add(new Employee("Susan", 2200, new MyDate(2002, 9, 5)));
        set.add(new Employee("Amy", 1200, new MyDate(1998, 10, 23)));
        set.add(new Employee("Amy", 1200, new MyDate(1999, 10, 23)));
        set.add(new Employee("Shirley", 1200, new MyDate(1999, 10, 24)));

        for (Employee employee : set) {
            System.out.println(employee);
        }

        System.out.println("-----------------------");

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("Amy", 1200, new MyDate(1998, 10, 24)));
        list.add(new Employee("Susan", 2200, new MyDate(2002, 9, 5)));
        list.add(new Employee("Amy", 1200, new MyDate(1998, 10, 23)));
        list.add(new Employee("Amy", 1200, new MyDate(1999, 10, 23)));
        list.add(new Employee("Shirley", 1200, new MyDate(1999, 10, 24)));
        list.sort((o1, o2) -> {
            int ret = o1.getName().compareTo(o2.getName());
            return (ret = o1.getName().compareTo(o2.getName())) == 0 ? o1.getBirthday().compareTo(o2.getBirthday()) : ret;
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
