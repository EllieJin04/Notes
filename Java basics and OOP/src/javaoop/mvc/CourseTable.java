package javaoop.mvc;

import javax.swing.*;

public class CourseTable {
    public static void main(String[] args) {
        // MVC设计模式
        // Model: CourseTableData, 它负责提供数据给视图（View）展示，即JTable中的数据。
        // View: JFrame、JTable、JScrollPane等Swing组件，它们负责展示数据，并与用户进行交互。
        // Control: 在这段代码中，View和Control被合并成为JTable了，因为控制或者说得到用户的输入本来就是在图形界面上完成的
        JFrame frame = new JFrame();
        JTable table = new JTable(new CourseTableData());
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Course Table");
        frame.setVisible(true);
    }
}
