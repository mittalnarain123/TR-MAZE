/*
 * Copyright 2018 Thomson Reuters/ONESOURCE. All rights reserved.
 */

package com.nmittal.maze;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;


/**
 * Applies the BFS algorithm to solve the Maze. Uses queue data structure to keep a track of visited
 * blocks. Traverses the aisles recursively until reaches finish/ doesn't find a path to finish
 *
 * @author Narain Mittal
 */
public class MazeSolverBfs implements IMazeSolver {

    private Maze maze;

    private final Queue<Block> queue = new ArrayDeque<>();

    private final Set<Block> visitedBlocks = new HashSet<>();

    private final Set<Block> solutionBlocks = new HashSet<>();

    private final Map<Block, Block> parentMap = new HashMap<>();


    public MazeSolverBfs(Maze maze) {
        this.maze = Objects.requireNonNull(maze);
    }

    @Override
    public boolean solve(Maze maze) {
        Block start = maze.getStart();
        this.visitedBlocks.add(start);
        this.parentMap.put(start, null);
        this.queue.offer(maze.getStart());
        return solveBfs();
    }

    @Override
    public long solutionPathSize() {
        return this.solutionBlocks.size();
    }

    private boolean solveBfs() {
        Optional<Block> block = Optional.ofNullable(queue.poll());
        if (!block.isPresent()) {
            // queue empty and not reached the finish yet; no solution
            return false;
        } else {
            if (block.get().equals(maze.getEnd())) {
                // reached finish, exit the program
                buildSolutionPath();
                return true;
            } else {
                process(block.get());
            }
        }
        return solveBfs();
    }

    private void process(Block block) {
        int x = block.getX();
        int y = block.getY();
        addValidAisle(x + 1, y, block);
        addValidAisle(x, y + 1, block);
        addValidAisle(x, y - 1, block);
        addValidAisle(x - 1, y, block);
    }

    private void addValidAisle(int x, int y, Block parent) {
        if (isValidAisle(x, y)) {
            Block b = maze.getBlock(x, y);
            this.queue.offer(b);
            this.visitedBlocks.add(b);
            this.parentMap.put(b, parent);
        }
    }

    /**
     * Creates the solution path
     */
    private void buildSolutionPath() {
        Optional<Block> last = Optional.ofNullable(this.maze.getEnd());
        Block previous = null;

        // Backtrack from the end of maze to lookup their parent blocks till we reach the start/dead end
        while (last.isPresent()) {
            Block block = last.get();
            this.solutionBlocks.add(block);
            last = Optional.ofNullable(this.parentMap.get(block));
            previous = block;
        }

        // if we did not reach the starting point, there was no solution
        if (!Objects.equals(this.maze.getStart(), previous)) {
            this.solutionBlocks.clear();
        }

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


    @Override
    public boolean isBlockInSolution(Block block) {
        return solutionBlocks.contains(block);
    }

    @Override
    public boolean isBlockVisited(Block block) {
        return visitedBlocks.contains(block);
    }

}
