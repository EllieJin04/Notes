package javaoop.castlegame;

import javaoop.castlegame.handler.Handler;
import javaoop.castlegame.handler.HandlerBye;
import javaoop.castlegame.handler.HandlerGo;
import javaoop.castlegame.handler.HandlerHelp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private Room currentRoom;
    private HashMap<String, Handler> handlers;
    public Game() {
        handlers = new HashMap<>();
        handlers.put("bye", new HandlerBye(this));
        handlers.put("go", new HandlerGo(this));
        handlers.put("help", new HandlerHelp(this));
        createRooms();
    }

    private void createRooms() {
        Room outside, lobby, pub, study, bedroom;

        // create rooms
        outside = new Room("Outside Castle");
        lobby = new Room("Lobby");
        pub = new Room("Pub");
        study = new Room("Study room");
        bedroom = new Room("Bedroom");

        // Initialize exits
        outside.setExit("east", lobby);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        lobby.setExit("east", study);
        study.setExit("west", lobby);
        study.setExit("south", bedroom);
        bedroom.setExit("north", study);
        pub.setExit("east", outside);

        currentRoom = outside;
    }

    private void printWelcome() {
        System.out.println("Welcome to the Castle Game, which is a very boring game.");
        System.out.println("If you need any help, enter help.\n");
        showPos();
    }

    private void showPos() {
        System.out.println("Your current location is " + currentRoom);
        System.out.println("Exits are: " + currentRoom.getExitsDesc());
    }

    public void goRoom(String dir) {
        if (currentRoom.getExit(dir) != null) {
            currentRoom = currentRoom.getExit(dir);
        } else {
            System.out.println("Invalid exit.");
        }
        showPos();
    }

    public void runGame() {
        printWelcome();
        Scanner s = new Scanner(System.in);
        while (true) {
            String[] commands = s.nextLine().split(" ");
            Handler handler = handlers.get(commands[0]);
            String command = commands.length > 1 ? commands[1] : "";
            if (handler != null) {
                handler.doCmd(command);
                if (handler.isBye()) {
                    break;
                }
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    public Set<String> getCommands() {
        return handlers.keySet();
    }

    public Collection<Handler> getHandlers() {
        return handlers.values();
    }
}
