package org.ds.datastructures.graphs;

public class RobotTraversal {

	enum Direction{
		E,
		W,
		S,
		N
	}
	enum Move{
		LEFT,
		RIGHT
	}
	private Direction intial;
	public RobotTraversal(Direction d) {
		this.intial = d;
	}
	
	private Direction direction(Direction d, Move move) {
		Direction returnDir = null;
		switch (d) {
		case E:
			switch(move) {
			case LEFT:
				returnDir = Direction.N;
				break;
			case RIGHT:
				returnDir = Direction.S;
			}
			break;
			
		case W:
			switch(move) {
			case LEFT:
				returnDir = Direction.S;
				break;
			case RIGHT:
				returnDir = Direction.N;
			}
		case S:
			switch(move) {
			case LEFT:
				returnDir = Direction.W;
				break;
			case RIGHT:
				returnDir = Direction.E;
			}
			
		case N:
			switch(move) {
			case LEFT:
				returnDir = Direction.E;
				break;
			case RIGHT:
				returnDir = Direction.W;
			}	
		default:
			break;
		}
		return returnDir;
	}
	
	private boolean isCycle(char[] path) {

		// Initialize starting
		// point for robot as
		// (0, 0) and starting
		// direction as N North
		int x = 0, y = 0;
		int dir = 0;

		// Traverse the path given for robot
		for (int i = 0; i < path.length; i++) {
			// Find current move
			char move = path[i];

			// If move is left or
			// right, then change direction
			if (move == 'R')
				dir = (dir + 1) % 4;
			else if (move == 'L')
				dir = (4 + dir - 1) % 4;

			// If move is Go, then
			// change x or y according to
			// current direction
			else // if (move == 'G')
			{
				if (dir == 0)
					y++;
				else if (dir == 1)
					x++;
				else if (dir == 2)
					y--;
				else // dir == 3
					x--;
			}
		}

		// If robot comes back to
		// (0, 0), then path is cyclic
		return (x == 0 && y == 0);
	}
	private void traverse(String path) {
		char[] path_c = path.toCharArray();
		
		for(int i=0;i<path_c.length; i++) {
			char move = path_c[i];
		}
		
	}
	public static void main(String s[]) {
		
		RobotTraversal t = new RobotTraversal(Direction.E);
		String path_ = "GLGLGLG";
		t.isCycle(path_.toCharArray());
		
		t.traverse(path_);
		
		
		
	}
}
