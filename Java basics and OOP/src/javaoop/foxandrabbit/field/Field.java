package javaoop.foxandrabbit.field;


import javaoop.foxandrabbit.cell.Cell;

import java.util.ArrayList;
import java.util.Arrays;


public class Field {
    private int width;
    private int height;
    private Cell[][] field;
    private static final Location[] adjacent = {
            new Location(-1, -1), new Location(-1, 0), new Location(-1, 1),
            new Location(0, -1), new Location(0, 0), new Location(0, 1),
            new Location(1, -1), new Location(1, 0), new Location(1, 1),
    };

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        field = new Cell[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell place(int row, int col, Cell cell) {
        Cell ret = field[row][col];
        field[row][col] = cell;
        return ret;
    }

    public Cell get(int row, int col) {
        return field[row][col];
    }

    public Cell[] getNeighbour(int row, int col) {
        ArrayList<Cell> list = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int r = row + i;
                int c = col + j;
                if (r > -1 && r < height && c > -1 && c < width && !(r == row && c == col)) {
                    list.add(field[r][c]);
                }
            }
        }
        return list.toArray(new Cell[list.size()]);
    }

    public Location[] getFreeNeighbour(int row, int col) {
        ArrayList<Location> list = new ArrayList<>();
        for (Location loc : adjacent) {
            int r = row + loc.getRow();
            int c = col + loc.getCol();
            if (r > -1 && r < height && c > -1 && c < width && field[r][c] == null) {
                list.add(new Location(r, c));
            }
        }
        return list.toArray(new Location[list.size()]);
    }

    public boolean placeRandomAdj(int row, int col, Cell cell) {
        boolean ret = false;
        Location[] freeAdj = getFreeNeighbour(row, col);
        if (freeAdj.length > 0) {
            int idx = (int) (Math.random() * freeAdj.length);
            field[freeAdj[idx].getRow()][freeAdj[idx].getCol()] = cell;
            ret = true;
        }
        return ret;
    }

    public void clear() {
        Arrays.fill(field, null);
    }

    public void remove(Cell fed) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (field[row][col] == fed) {
                    field[row][col] = null;
                    break;
                }
            }
        }
    }

    public Cell remove(int row, int col) {
        field[row][col] = null;
        Cell ret = field[row][col];
        return ret;
    }

    public void move(int row, int col, Location loc) {
        field[loc.getRow()][loc.getCol()] = field[row][col];
        remove(row, col);
    }
}
