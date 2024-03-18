package javaoop.castlegame.handler;

import javaoop.castlegame.Game;

public class HandlerBye extends Handler {
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String cmd) {
        System.out.println("Thank you for playing the Castle Game.");
        System.out.println("See you next time!");
    }

    public boolean isBye() {
        return true;
    }

    @Override
    public String toString() {
        return "bye";
    }

}
