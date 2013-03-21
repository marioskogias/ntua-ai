import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

	/**
	 * @param args
	 */
	int limX;
	int limY;
	int tarX;
	int tarY;
	int moved_so_far = 0;
	char[][] place; // to epipedo ergasias

	public static void main(String[] args) {

		Main m = new Main();
		Robot me = new Robot();
		Robot target = new Robot();
		int i, j;
		// get the input
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"/Users/marioskogias/Documents/ntua/ai-ntua/src/input.txt"));
			String line = in.readLine();
			String[] a = line.split(" ");
			m.limY = Integer.parseInt(a[0]);
			m.limX = Integer.parseInt(a[1]);
			me.limX = m.limX;
			me.limY = m.limY;
			target.limX = m.limX;
			target.limY = m.limY;

			line = in.readLine();
			a = line.split(" ");
			me.posY = Integer.parseInt(a[0]);
			me.posX = Integer.parseInt(a[1]);
			me.velocity = 3;
			me.name = 'M';

			line = in.readLine();
			a = line.split(" ");
			target.posY = Integer.parseInt(a[0]);
			target.posX = Integer.parseInt(a[1]);
			target.velocity = 1;
			target.name = 'T';
			m.tarX = target.posX;
			m.tarY = target.posX;

			m.place = new char[m.limY][m.limX];
			for (i = 0; i < m.limY; i++) {
				line = in.readLine();
				char[] array = line.toCharArray();
				for (j = 0; j < m.limX; j++)
					m.place[i][j] = array[j];
			}

			me.place = m.place;
			target.place = m.place;

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("my position is " +me.posY + " " + me.posX);
		// start the procedure
		Robot tender = null; // tender robot to simulate the move

		PriorityQueue<Node> queue;
		Node node;
		Node curNode = null;
		int found = 0;

	while (true) {
			try {
				tender = (Robot) me.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			System.out
					.println("robot is at " + tender.posY + " " + tender.posX);
			queue = new PriorityQueue<Node>();
			if (tender.checkFound() == 0) {
				if (tender.canMove(1) == 1) {
					System.out.println("can move 1");
					node = new Node(tender.posX + 3, tender.posY, 1);
					node.cost_so_far = m.moved_so_far + 3;
					node.left_to_reach = Math.abs(node.posX - m.tarX)
							+ Math.abs(node.posY - m.tarY);// this is gonna
															// change
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					queue.add(node);
				}
				if (tender.canMove(2) == 1) {
					System.out.println("can move 2");
					node = new Node(tender.posX - 3, tender.posY, 2);
					node.cost_so_far = m.moved_so_far + 3;
					node.left_to_reach = Math.abs(node.posX - m.tarX)
							+ Math.abs(node.posY - m.tarY);// this is gonna
															// change
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					queue.add(node);
				}
				if (tender.canMove(3) == 1) {
					System.out.println("can move 3");
					node = new Node(tender.posX, tender.posY + 3, 3);
					node.cost_so_far = m.moved_so_far + 3;
					node.left_to_reach = Math.abs(node.posX - m.tarX)
							+ Math.abs(node.posY - m.tarY);// this is gonna
															// change
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					queue.add(node);
				}
				if (tender.canMove(4) == 1) {
					System.out.println("can move 4");
					node = new Node(tender.posX, tender.posY - 3, 4);
					node.cost_so_far = m.moved_so_far + 3;
					node.left_to_reach = Math.abs(node.posX - m.tarX)
							+ Math.abs(node.posY - m.tarY);// this is gonna
															// change
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					queue.add(node);
				}

			} else
				found = 1;

			if (found == 0) {
				curNode = queue.poll();
				tender.prevX = tender.posX;
				tender.prevY = tender.posY;
				tender.go_to_point(curNode.posX, curNode.posY);
				System.out.println("robot is at " + tender.posY + " "
						+ tender.posX);
			}
			
			while (true) {
				System.out.println("in loop ");
				System.out.println("my position is " +me.posX + " " + me.posY);
				if (tender.checkFound() == 1) {
					System.out.println("found");
					break;
				}
					
				if ((tender.canMove(1) == 1)
						&& (tender.prevX != tender.posX + 3)) {
					System.out.println("can move 1");
					node = new Node(tender.posX + 3, tender.posY,
							curNode.initial_move);
					node.cost_so_far = curNode.cost_so_far + 3;
					node.left_to_reach = Math.abs(node.posX - m.tarX)
							+ Math.abs(node.posY - m.tarY);// this is gonna
															// change
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					queue.add(node);
				}
				if ((tender.canMove(2) == 1)
						&& (tender.prevX != tender.posX - 3)) {
					System.out.println("can move 2");
					node = new Node(tender.posX - 3, tender.posY,
							curNode.initial_move);
					node.cost_so_far = curNode.cost_so_far + 3;
					node.left_to_reach = Math.abs(node.posX - m.tarX)
							+ Math.abs(node.posY - m.tarY);// this is gonna
															// change
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					queue.add(node);
				}
				if ((tender.canMove(3) == 1)
						&& (tender.prevY != tender.posY + 3)) {
					System.out.println("can move 3");
					node = new Node(tender.posX, tender.posY + 3,
							curNode.initial_move);
					node.cost_so_far = curNode.cost_so_far + 3;
					node.left_to_reach = Math.abs(node.posX - m.tarX)
							+ Math.abs(node.posY - m.tarY);// this is gonna
															// change
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					queue.add(node);
				}
				if ((tender.canMove(4) == 1)
						&& (tender.prevY != tender.posY - 3)) {
					System.out.println("can move 4");
					node = new Node(tender.posX, tender.posY - 3,
							curNode.initial_move);
					node.cost_so_far = curNode.cost_so_far + 3;
					node.left_to_reach = Math.abs(node.posX - m.tarX)
							+ Math.abs(node.posY - m.tarY);// this is gonna
															// change
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					queue.add(node);
				}
				curNode = queue.poll();
				tender.prevX = tender.posX;
				tender.prevY = tender.posY;
				tender.go_to_point(curNode.posX, curNode.posY);
				System.out.println("robot is at " + tender.posY + " "
						+ tender.posX);

			}
			

			System.out.println(curNode.initial_move);
			System.out.println("my position is " +me.posY + " " + me.posX);
			me.move(curNode.initial_move);
			System.out.println("ok");
			m.moved_so_far = m.moved_so_far + 3;
			if (me.checkFound() == 1)
				break;
			
		}
		System.out.println("sth more than " + m.moved_so_far);

	}

}
