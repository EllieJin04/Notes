package javaoop.cellmachine.cellmachine;

import javax.swing.JFrame;

import javaoop.cellmachine.cell.Cell;
import javaoop.cellmachine.field.Field;
import javaoop.cellmachine.field.View;

public class CellMachine {

	public static void main(String[] args) {
		// initialize the field
		Field field = new Field(30,30);
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				field.place(row, col, new Cell());
			}
		}

		// Iterate over all cells in the filed, with a certain probability, reborn the cells
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				Cell cell = field.get(row, col);
				if (Math.random() < 0.2 ) {
					cell.reborn();
				}
			}
		}

		// initialize the panel
		View view = new View(field);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Cells");
		frame.add(view);
		frame.pack();
		frame.setVisible(true);

		// update 1000 times
		for (int i = 0; i < 1000; i++) {
			for (int row = 0; row < field.getHeight(); row++) {
				for (int col = 0; col < field.getWidth(); col++) {
					Cell cell = field.get(row, col);
					Cell[] neighbour = field.getNeighbour(row, col);
					int numOfLive = 0;
					// count how many neighbours are alive
					for (Cell c : neighbour) {
						if (c.isAlive()) {
							numOfLive++;
						}
					}
					System.out.printf("[%d][%d]:", row, col);
					System.out.print(cell.isAlive() ? "live" : "dead");
					System.out.printf(":%d-->", numOfLive);

					// if cell is alive and the number of its alive neighbours <2 or >3, the cell die
					// if cell is not alive, and the number of its alive neighbours is 3, the cell reborn
					if (cell.isAlive()) {
						if (numOfLive < 2 || numOfLive > 3) {
							cell.die();
							System.out.print("die");
						}
					} else if ( numOfLive == 3 ) {
						cell.reborn();
						System.out.print("reborn");
					}
					System.out.println();
				}
			}
			System.out.println("UPDATE");
			frame.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
