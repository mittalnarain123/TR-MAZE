package com.tr.maze;

import java.util.ArrayDeque;
import java.util.Deque;

public class MazeSolverDfs implements IMazeSolver {

	private Maze maze;

	private Deque<Block> stack;

	@Override
	public void solve(Maze maze) {
		this.maze = maze;
		this.stack = new ArrayDeque<>();
		maze.getStart().setVisited(true);
		maze.getStart().setInPath(true);
		this.stack.push(maze.getStart());
		solveDfs();
	}

	private void solveDfs() {
		Block block = stack.peekFirst();
		if (block == null) {
			throw new IllegalArgumentException("No solution available");
		} else if (block.equals(maze.getEnd())) {
			return;
		} else {
			Block next = maze.getNextAisle(block);
			// System.out.println("next:" + next);
			if (next == null) {
				Block discard = stack.pop();
				discard.setInPath(false);
				// System.out.println("Popped:" + discard);
			} else {
				next.setVisited(true);
				next.setInPath(true);
				stack.push(next);
			}
		}
		solveDfs();
	}

}
