package com.tr.maze;

public class Wall extends Block {

	public Wall(int x, int y) {
		super(Color.GREEN, x, y);
	}

	@Override
	public String display() {
		return "X";
	}

}
