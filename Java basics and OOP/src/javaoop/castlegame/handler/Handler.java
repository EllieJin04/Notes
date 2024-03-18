package javaoop.castlegame.handler;

import javaoop.castlegame.Game;

public class Handler {
    protected Game game;
    public Handler(Game game) {
        this.game = game;
    }

    public boolean isBye() {
        return false;
    }
    public void doCmd(String cmd) {

    }

    public void cmdExp() {
        System.out.println(this);
    }
}
