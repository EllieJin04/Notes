package graphics_tankgame.mytankgame;

import javax.swing.*;
import java.awt.*;

public class TankGame extends JFrame {
    private MyPanel p;

    public TankGame() {
        p = new MyPanel();
        this.add(p);
        this.setSize(1000, 750);
        this.addKeyListener(p);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }
}
