package javaoop.foxandrabbit.foxnrabbit;


import javaoop.foxandrabbit.cell.Cell;
import javaoop.foxandrabbit.field.*;
import javaoop.foxandrabbit.animal.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class FoxAndRabbit {

    //成员变量
    private Field field;//Field变量，用来管理新的网格
    private View view;//继承自Jpanel的类，用来显示图形

    private JFrame frame;

    /*------构造函数------*/
    public FoxAndRabbit(int size) {
        //创建网格
        field = new Field(size,size);

        //遍历网格
        for (int row = 0; row< field.getHeight(); row++) {
            for (int col = 0; col< field.getWidth(); col++) {
                double probability = Math.random();

                //随机放入狐狸
                if (probability < 0.05) {
                    field.place(row, col, new Fox());
                } //随机放入兔子
                else if(probability < 0.15) {
                    field.place(row, col, new Rabbit());
                }

            }
        }

        /*------把theField加入到显示框------*/
        view = new View(field);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Fox and rabbit simulation");
        frame.add(view);
        JButton btnStep = new JButton("Single step change");
        btnStep.addActionListener(e -> {
            step();
            frame.repaint();
        });
        frame.add(btnStep, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    /*------开始函数，传入的参数是程序要执行的次数------*/
    public void start(int steps) {
        for (int i = 0; i < steps; i++) {
            step();

            view.repaint();//Java底层函数

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*------step()函数，每次更新表格- - - - - -*/
    public void step() {
        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                //获取所有Cell的对象变量
                Cell cell= field.get(row, col);

                if (cell != null) {
                    //把管理的对象造型为Animal对象
                    Animal animal = (Animal)cell;

                    //年龄增长
                    animal.grow();

                    if (animal.isAlive()) {
                        //向周围移动
                        Location loc = animal.move(field.getFreeNeighbour(row, col));
                        if (loc != null) { field.move(row,col,loc); }

                        //获取周围的兔子，储存进容器里面
                        Cell[] neighbour= field.getNeighbour(row, col);
                        ArrayList<Animal> listRabbit=new ArrayList<Animal>();
                        for (Cell an:neighbour) {
                            if (an instanceof Rabbit) { listRabbit.add((Rabbit)an); }
                        }

                        // 吃掉兔子
                        if (!listRabbit.isEmpty()) {
                            //这里涉及到了多态，这个animal实际上是Fox的对象，调用的是Fox的feed()
                            //(animal本身是抽象类，自己不可能有对象的)
                            Animal fed = animal.feed(listRabbit);
                            //fed得到了兔子的对象之后，调用函数删除这个对象(被吃掉
                            if (fed!=null) { field.remove((Cell)fed); }
                        }

                        //动物繁殖
                        Animal baby = animal.breed();
                        if (baby!=null) { field.placeRandomAdj(row,col,(Cell)baby); }
                    } else {
                        field.remove(row ,col);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        FoxAndRabbit fr = new FoxAndRabbit(30);
        // fr.start()
    }

}

