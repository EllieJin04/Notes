package javaoop.castlegame;

import java.util.HashMap;

public class Room {
    private String position;

    private HashMap<String, Room> exits = new HashMap<>();

    public Room(String position) {
        this.position = position;
    }

    public void setExit(String dir, Room room) {
        exits.put(dir, room);
    }

    public String getExitsDesc() {
        StringBuffer sb = new StringBuffer();
        for (String dir: exits.keySet()) {
            sb.append(dir);
            sb.append(" ");
        }
        return sb.toString();
    }

    public Room getExit(String dir) {
        return exits.get(dir);
    }

    @Override
    public String toString() {
        return position;
    }
}
