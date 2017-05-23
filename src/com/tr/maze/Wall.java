package com.tr.maze;

public class Wall extends Block {
	public Wall(int x, int y) {
		super(Color.GREEN, x, y);
	}

	@Override
	public Block getNext() {
		throw new UnsupportedOperationException("not supported");
	}

	// @Override
	// public boolean equals(Object obj) {
	// return super.equals(obj);
	// }

}
