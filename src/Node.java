import java.util.ArrayList;

public class Node implements Comparable<Node>{
	int initial_move;
	int cost_so_far;
	int left_to_reach;
	int overall_cost;
	int posX;
	int posY;
	ArrayList<Node> children;


	public int compareTo(Node n) {
		if (n.overall_cost > this.overall_cost)
			return -1;
		else if (n.overall_cost < this.overall_cost)
			return 1;
		else 
			return 0;
	}


}