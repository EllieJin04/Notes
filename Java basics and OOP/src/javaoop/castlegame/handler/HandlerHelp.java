package javaoop.castlegame.handler;

import javaoop.castlegame.Game;

public class HandlerHelp extends Handler {

    public HandlerHelp(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String cmd) {
        System.out.print("Are you lost? You can do the following command: ");
        for (String command : game.getCommands()) {
            System.out.print(command + " ");
        }
        System.out.println("\nFor example: ");
        for (Handler handler : game.getHandlers()) {
            handler.cmdExp();
        }
    }
    @Override
    public String toString() {
        return "help";
    }
}
