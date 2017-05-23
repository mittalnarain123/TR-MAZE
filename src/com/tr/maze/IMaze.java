package com.tr.maze;

public interface IMaze {

	public Block getStart();

	public Block getEnd();

	public Block getNextAisle(Block block);

	public void solve(IMazeSolver mazeSolver);
}
