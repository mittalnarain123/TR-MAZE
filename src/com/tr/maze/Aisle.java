package com.tr.maze;

/**
 * Implementation of Aisle object.
 * 
 * @author Narain Mittal
 * 
 */
public class Aisle extends Block {

	public Aisle(int x, int y) {
		super(Color.WHITE, x, y);
	}

	@Override
	public String display(IMazeSolver solver) {
		return solver.isBlockInSolution(this) ? " * " : "   ";
	}

}
