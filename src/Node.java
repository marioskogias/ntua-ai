//import java.util.ArrayList;

public class Node implements Comparable<Node>{
	Node father;
	int cost_so_far;
	int left_to_reach;
	int overall_cost;
	int posX;
	int posY;
	int depth;
	//ArrayList<Node> children;

	public Node(int x, int y, Node father) {
		this.posX = x;
		this.posY = y;
		if (father == null)
			this.depth = 1;
		else 
			this.depth = father.depth + 1;
	}
	
	public int compareTo(Node n) { // arxika me over_all_const se isothta mikrotero ayto me to mikrotero left_to_reach
		if (n.overall_cost > this.overall_cost)
			return -1;
		else if (n.overall_cost < this.overall_cost)
			return 1;
		else 
			if (n.left_to_reach > this.left_to_reach)
				return -1;
			else 
				return 1;
	}


}