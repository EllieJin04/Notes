package javaoop.castlegame.handler;

import javaoop.castlegame.Game;
import javaoop.castlegame.Room;

public class HandlerGo extends Handler {

    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String dir) {
        game.goRoom(dir);
    }

    @Override
    public String toString() {
        return "go";
    }

    @Override
    public void cmdExp() {
        System.out.println("go east");
    }
}
