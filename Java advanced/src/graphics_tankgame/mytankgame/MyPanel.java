package graphics_tankgame.mytankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    private Hero hero;

    private List<EnemyTank> enemies = new Vector<>();

    public MyPanel() {
        this.hero = new Hero(100, 100, 0);
        for (int i = 0; i < 3; i++) {
            enemies.add(new EnemyTank( (1 + i) * 100, 0, 2));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        // paint the background darkGray
        g.fillRect(0, 0,1000, 750);

        // draw the user's tank
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);

        // draw the enemies' tanks
        for (EnemyTank enemy : enemies) {
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 1);
        }
    }


    public void drawTank(int x, int y, Graphics g, int direction, int type) {

        // set the type of the tank
        switch (type) {
            // player's tank
            case 0:
                g.setColor(Color.cyan);
                break;

            // enemies' tank
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        // draw the tank according to the direction
        switch (direction) {
            // 0 represent up direction
            case 0:
                g.fill3DRect(x, y, 10, 60, false); // draw the left wheel
                g.fill3DRect(x + 30, y, 10, 60, false); // draw the right wheel
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // draw the body
                g.fillOval(x + 10, y + 20, 20, 20); // draw the turret
                g.drawLine(x + 20, y + 30, x + 20, y); // draw the gun barrel
                break;

            // 1 represent right direction
            case 1:
                g.fill3DRect(x, y, 60, 10, false); // draw the up wheel
                g.fill3DRect(x, y + 30, 60, 10, false);// draw the down wheel
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // draw the body
                g.fillOval(x + 20, y + 10, 20, 20);// draw the turret
                g.drawLine(x + 30, y + 20, x + 60, y + 20);// draw the gun barrel
                break;

            // 2 represent down direction
            case 2:
                g.fill3DRect(x, y, 10, 60, false); // draw the right wheel
                g.fill3DRect(x + 30, y, 10, 60, false); // draw the lft wheel
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // draw the body
                g.fillOval(x + 10, y + 20, 20, 20); // draw the turret
                g.drawLine(x + 20, y + 30, x + 20, y + 60); // draw the gun barrel
                break;

            // 3 represent left direction
            case 3:
                g.fill3DRect(x, y, 60, 10, false); // draw the up wheel
                g.fill3DRect(x, y + 30, 60, 10, false);// draw the down wheel
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // draw the body
                g.fillOval(x + 20, y + 10, 20, 20);// draw the turret
                g.drawLine(x + 30, y + 20, x, y + 20);// draw the gun barrel
                break;

            default:

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // press wdsa on keyboard moves the tank up, right, down, and left
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("The key use pressed is: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            hero.moveLeft();
        }

        // repaint the panel
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
