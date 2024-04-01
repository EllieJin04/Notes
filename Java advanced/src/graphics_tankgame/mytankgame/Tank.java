package graphics_tankgame.mytankgame;

public class Tank {

    // the horizontal coordinate of the tank
    private int x;

    // the vertical coordinate of the tank
    private int y;

    // the direction of the tank
    // up: 0, right: 1, down: 2, left: 3
    private int direction;

    // the speed of the tank
    // default value is 1
    private int speed = 1;

    public Tank(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // move the tank based on its direction
    public void moveUp() {
        y -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
