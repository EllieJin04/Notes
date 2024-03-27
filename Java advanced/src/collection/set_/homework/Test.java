package collection.set_.homework;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {

        HashSet<Employee> set = new HashSet<>();
        set.add(new Employee("Amy", 1200, new MyDate(1998, 10, 24)));
        set.add(new Employee("Susan", 2200, new MyDate(2002, 9, 5)));
        set.add(new Employee("Amy", 1200, new MyDate(1998, 10, 24)));

        for (Employee employee : set) {
            System.out.println(employee);
        }
    }
}
