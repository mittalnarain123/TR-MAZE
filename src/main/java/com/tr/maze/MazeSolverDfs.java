package com.tr.maze;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Applies the DFS algirithm to solve the Maze. Uses stack data structure to keep a track of visited
 * blocks. Traverses the aisles recursively until reaches finish/ doesn't find a path to finish
 * 
 * @author Narain Mittal
 * 
 */
public class MazeSolverDfs implements IMazeSolver {

	private Maze maze;

	private Deque<Block> stack;

	@Override
	public boolean solve(Maze maze) {
		this.maze = maze;
		this.stack = new ArrayDeque<>();
		maze.getStart().setVisited(true);
		maze.getStart().setInPath(true);
		this.stack.push(maze.getStart());
		return solveDfs();
	}

	private boolean solveDfs() {
		Block block = stack.peekFirst();
		if (block == null) {
			// stack empty and not reached the finish yet; no solution
			return false;
		} else if (block.equals(maze.getEnd())) {
			// reached finish, exit the program
			return true;
		} else {
			Block next = maze.getNextAisle(block);
			// System.out.println("next:" + next);
			if (next == null) {
				// Dead end, chose alternate path
				Block discard = stack.pop();
				discard.setInPath(false);
				// System.out.println("Popped:" + discard);
			} else {
				// Traverse next block
				next.setVisited(true);
				next.setInPath(true);
				stack.push(next);
			}
		}
		return solveDfs();
	}

}
