package com.tr.maze;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Applies the DFS algirithm to solve the Maze. Uses stack data structure to keep a track of visited
 * blocks. Traverses the aisles recursively until reaches finish/ doesn't find a path to finish
 * 
 * @author Narain Mittal
 * 
 */
public class MazeSolverDfs implements IMazeSolver {

	private Maze maze;

	private final Deque<Block> stack = new ArrayDeque<>();

	private final Set<Block> visitedBlocks = new HashSet<>();

	private final Set<Block> solutionBlocks = new HashSet<>();

	@Override
	public boolean solve(Maze maze) {
		this.maze = maze;
		this.visitedBlocks.add(maze.getStart());
		this.solutionBlocks.add(maze.getStart());
		this.stack.push(maze.getStart());
		return solveDfs();
	}

	@Override
	public Block getNextTraversableAisle(Block block) {
		int x = block.getX();
		int y = block.getY();
		Block next = null;
		if (isValidAisle(x + 1, y)) {
			next = maze.getBlock(x + 1, y);
		}
		else if (isValidAisle(x, y + 1)) {
			next = maze.getBlock(x, y + 1);
		}
		else if (isValidAisle(x, y - 1)) {
			next = maze.getBlock(x, y - 1);
		}
		else if (isValidAisle(x - 1, y)) {
			next = maze.getBlock(x - 1, y);
		}
		return next;
	}

	/**
	 * Checks if the block at designated indices is an Aisle which is not visited yet.
	 * 
	 * @param x
	 * @param y
	 * @return true if valid, false otherwise
	 */
	private boolean isValidAisle(int x, int y) {
		try {
			Block b = maze.getBlock(x, y);
			return (b instanceof Aisle) && !isBlockVisited(b);
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}

	}

	private boolean solveDfs() {
		Optional<Block> block = Optional.ofNullable(stack.peekFirst());
		if (!block.isPresent()) {
			// stack empty and not reached the finish yet; no solution
			return false;
		} else if (block.get().equals(maze.getEnd())) {
			// reached finish, exit the program
			return true;
		} else {
			Optional<Block> next = block.map(this::getNextTraversableAisle);
			if (!next.isPresent()) {
				// Dead end, backtrack and chose alternate path
				backTrack();
			} else {
				// Traverse next block
				traverseNextBlock(next.get());
			}
		}
		return solveDfs();
	}

	private Optional backTrack(){
		this.solutionBlocks.remove(stack.pop());
		return Optional.empty();
	}

	private void traverseNextBlock(Block next){
		this.solutionBlocks.add(next);
		this.visitedBlocks.add(next);
		stack.push(next);
	}

	@Override
	public boolean isBlockInSolution(Block block) {
		return solutionBlocks.contains(block);
	}

	@Override
	public boolean isBlockVisited(Block block) {
		return visitedBlocks.contains(block);
	}

}
