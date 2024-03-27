package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import static java.util.Collections.swap;

/**
 * @author 韩顺平
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ListExercise02 {

    public static void main(String[] args) {

        //List list = new ArrayList();
        List<Book> list = new LinkedList<>();
        //List list = new Vector();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));
        //list.add(new Book("西游记", "吴承恩", 10));

        //如何对集合进行排序


        //遍历

        for (Book book : list) {
            System.out.println(book);
        }

        //冒泡排序
        bubbleSort(list);

        System.out.println("==排序后==");

        for (Book book : list) {
            System.out.println(book);
        }

    }

    //静态方法
    //价格要求是从小到大
    public static void bubbleSort(List<Book> list) {

        /*for (int i = 0; i < list.size(); i++) {
           for (int j = i + 1; j < list.size(); j++) {
               if (list.get(i).compareTo(list.get(j)) > 0) {
                   swap(list, i, j);
               }
           }
        }*/


        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }


    }
}

