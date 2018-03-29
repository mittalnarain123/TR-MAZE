package com.nmittal.maze.generator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nmittal.maze.Aisle;
import com.nmittal.maze.Block;
import com.nmittal.maze.IMaze;
import com.nmittal.maze.Maze;
import com.nmittal.maze.Wall;
import com.nmittal.maze.domain.Direction;

public class MazeGeneratorRecursive implements IMazeGenerator {

	final Logger LOG = LoggerFactory.getLogger(MazeGeneratorRecursive.class);

	private Block[][] blocks;
	private Set<Block> visited = new HashSet<>();
	private final Deque<Block> stack = new ArrayDeque<>();

	@Override
	public IMaze generateMaze(int gridRows, int gridColumns) {
		if (!validate(gridRows, gridColumns)) {
			throw new IllegalArgumentException(
					String.format("Invalid grid values - must be even numbers > 4: %s, %s", gridRows, gridColumns));
		}
		blocks = createMazeGrid(gridRows, gridColumns);

		LOG.info("---------Maze grid-----------");
		LOG.info(new Maze(blocks, null, null).display(null));

		Block start = convertToAisle(1, 1);
		Block end = convertToAisle(gridRows - 1, gridColumns - 1);

		stack.push(start);
		visited.add(start);

		buildMaze();

		IMaze maze = new Maze(blocks, start, end);

		LOG.info("---------Maze generated-----------");
		LOG.info(maze.display(null));
		return maze;
	}

	public void buildMaze() {
		Block current = stack.peek();

		while (CollectionUtils.isNotEmpty(stack)) {
			if (null == current) {
				LOG.info("buildMaze: Null element encountered");
				current = stack.pop();
				continue;
			}
			// find all neighbors
			List<Block> neighbours = findNeighbours(current);

			if (CollectionUtils.isNotEmpty(neighbours)) {
				// pick random neighbor
				Block newBlock = neighbours.get(RandomUtils.nextInt(0, neighbours.size()));
				// break wall
				breakWall(current, newBlock);
				// mark visited
				visited.add(newBlock);
				// push to stack
				stack.push(newBlock);

				current = newBlock;
			} else {
				// back track
				current = stack.pop();
			}

		}

	}

	public void breakWall(final Block current, final Block newBlock) {
		if (current.getX() == newBlock.getX()) {
			convertToAisle(current.getX(), (current.getY() + newBlock.getY()) / 2);
		} else if (current.getY() == newBlock.getY()) {
			convertToAisle((current.getX() + newBlock.getX()) / 2, current.getY());
		} else {
			LOG.error(String.format("breakWall: Invalid block selected: %s, %s", current, newBlock));
			throw new IllegalArgumentException("breakWall: Invalid block selected");
		}
	}

	public List<Block> findNeighbours(Block block) {

		List<Block> neighbours = new ArrayList<>();
		// check by skipping a wall
		for (Direction direction : Direction.values()) {
			getNeighbourAcrossWall(block, direction).ifPresent((b) -> {
				if (b instanceof Aisle && !isBlockVisited(b)) {
					neighbours.add(b);
				}
			});
		}

		// TODO: check immediate next

		return neighbours;
	}

	public Optional<Block> getNeighbourAcrossWall(Block block, Direction direction) {
		final int step = 2;
		final int x = block.getX();
		final int y = block.getY();

		Block newBlock;

		switch (direction) {
		case BOTTOM:
			newBlock = getBlock(x + step, y);
			break;
		case RIGHT:
			newBlock = getBlock(x, y + step);
			break;
		case LEFT:
			newBlock = getBlock(x, y - step);
			break;
		case TOP:
			newBlock = getBlock(x - step, y);
			break;
		default:
			newBlock = null;
			break;
		}

		return Optional.ofNullable(newBlock);

	}

	public Block[][] createMazeGrid(int gridRows, int gridColumns) {

		try {
			Block[][] blocks = new Block[gridRows + 1][gridColumns + 1];
			for (int i = 0; i <= gridRows; i++) {
				for (int j = 0; j <= gridColumns; j++) {
					if (i % 2 == 0 || j % 2 == 0) {
						blocks[i][j] = new Wall(i, j);
					} else {
						blocks[i][j] = new Aisle(i, j);
					}
				}
			}

			return blocks;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("createMazeGrid: Invalid data");
		}
	}

	public Block convertToAisle(int x, int y) {
		try {
			Block block = new Aisle(x, y);
			LOG.info(String.format("New Aisle created: %s", block));
			blocks[x][y] = block;
			return block;
		} catch (ArrayIndexOutOfBoundsException a) {
			throw new IllegalArgumentException(String.format("convertToAisle: Invalid indices %s , %s", x, y));
		}
	}

	public Block getBlock(int x, int y) {
		try {
			return blocks[x][y];
		} catch (ArrayIndexOutOfBoundsException a) {
			// throw new IllegalArgumentException(String.format("getBlock: Invalid indices
			// %s , %s", x, y));
			return null;
		}
	}

	public boolean isBlockVisited(Block block) {
		return visited.contains(block);
	}

	@Override
	public boolean validate(int gridRows, int gridColumns) {
		if (gridRows > 4 && gridColumns > 4 && gridRows % 2 == 0 && gridColumns % 2 == 0) {
			return true;
		}
		return false;
	}

}
