import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JOptionPane;

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
	Node[][] nodeTable;
	PriorityQueue<Node> queue;
	
	public char[][] toVisualRep(int Mx,int My) {
		char[][]res = new char[this.place.length][];
		
		for (int i = 0; i < this.place.length; i++) {
	        res[i] = Arrays.copyOf(this.place[i], this.place[i].length);
	        
	    }
	    
		res[My][Mx] = 'M';
		System.out.println("painting blue at "+ Mx + " " + My);
		return res;
	}
			
	public boolean shouldMove(int x, int y,int cost) {
		if (this.nodeTable[y][x] == null)
			return true;
		else if (this.nodeTable[y][x].cost_so_far > cost) {
			this.queue.remove(this.nodeTable[y][x]);
			return true;
		} else 
			return false;
	}
	
	public int heuristic(Node n) {
		return (Math.abs(n.posX - this.tarX)
				+ Math.abs(n.posY - this.tarY));
	}
	
	public static void main(String[] args) {

		Main m = new Main();
		Robot me = new Robot();
		Robot target = new Robot();
		int i, j;
		int countStates = 0;
		// get the input
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"/Users/Marios/Documents/ntua/7o/ntua-ai/src/input6.txt"));
			String line = in.readLine();
			String[] a = line.split(" ");
			m.limY = Integer.parseInt(a[0]);
			m.limY--;
			m.limX = Integer.parseInt(a[1]);
			m.limX--;
			me.limX = m.limX;
			me.limY = m.limY;
			target.limX = m.limX;
			target.limY = m.limY;

			line = in.readLine();
			a = line.split(" ");
			me.posY = Integer.parseInt(a[0]);
			me.posY--;
			me.posX = Integer.parseInt(a[1]);
			me.posX--;
			me.velocity = 3;
			me.name = 'M';

			line = in.readLine();
			a = line.split(" ");
			target.posY = Integer.parseInt(a[0]);
			target.posY--;
			target.posX = Integer.parseInt(a[1]);
			target.posX--;
			target.velocity = 1;
			target.name = 'T';
			m.tarX = target.posX;
			m.tarY = target.posY;

			m.place = new char[m.limY+1][m.limX+1];
			for (i = 0; i <= m.limY; i++) {
				line = in.readLine();
				char[] array = line.toCharArray();
				for (j = 0; j <= m.limX; j++)
					m.place[i][j] = array[j];
			}

			me.place = m.place;
			target.place = m.place;

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// start the procedure
		m.place[target.posY][target.posX] = 'T';
		
		 System.out.println("very begin at " + me.posY + " " + me.posX);
		
		//visual representation
		JFrame frame = new JFrame();
	    frame.setTitle("A* Implementation");
	    frame.setSize((m.limY+1)*80,(m.limX+1)*35);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    Container contentPane = frame.getContentPane();
	    VisualRep p = new VisualRep();
	    p.plane = m.toVisualRep(me.posX, me.posY);
	    contentPane.add(p);
	    frame.setVisible(true);
	    
	    System.out.println("begin at " + me.posY + " " + me.posX);
		Robot tender = null; // tender robot to simulate the move

		Node node;
		Node curNode = null;
		int found = 0;
		Random randomGenerator = new Random();
		while (true) {
			
			try {
				tender = (Robot) me.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			tender.name = 'H';
			//System.out.println("robot is at " + tender.posY + " " + tender.posX);
			m.queue = new PriorityQueue<Node>();
			m.nodeTable = new Node[m.limY+1][m.limX+1];
			if (!tender.checkFound()) {
				if (tender.canMove(1)) {
					node = new Node(tender.posX + 1, tender.posY, null);
					node.cost_so_far = m.moved_so_far + 1;
					node.left_to_reach = m.heuristic(node);
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					m.queue.add(node);
					countStates++;
					m.nodeTable[node.posY][node.posX] = node;
				}
				if (tender.canMove(2)) {
					node = new Node(tender.posX - 1, tender.posY, null);
					node.cost_so_far = m.moved_so_far + 1;
					node.left_to_reach = m.heuristic(node);
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					m.queue.add(node);
					countStates++;
					m.nodeTable[node.posY][node.posX] = node;
				}
				if (tender.canMove(3)) {
					node = new Node(tender.posX, tender.posY + 1, null);
					node.cost_so_far = m.moved_so_far + 1;
					node.left_to_reach = m.heuristic(node);
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					m.queue.add(node);
					countStates++;
					m.nodeTable[node.posY][node.posX] = node;
				}
				if (tender.canMove(4)) {
					node = new Node(tender.posX, tender.posY - 1, null);
					node.cost_so_far = m.moved_so_far + 1;
					node.left_to_reach = m.heuristic(node);
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					m.queue.add(node);
					countStates++;
					m.nodeTable[node.posY][node.posX] = node;
				}

			} else
				found = 1;

			if (found == 0) {
				curNode = m.queue.poll();
				tender.go_to_point(curNode.posX, curNode.posY);
				
			}

			while (true) {
				
				if (tender.checkFound()) {
					System.out.println("found");
					break;
				}

				if ((tender.canMove(1)) && (m.shouldMove(tender.posX + 1,tender.posY,curNode.cost_so_far+1))) {
					node = new Node(tender.posX + 1, tender.posY,
							curNode);
					node.cost_so_far = curNode.cost_so_far + 1;
					node.left_to_reach = m.heuristic(node);
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					m.queue.add(node);
					countStates++;
					m.nodeTable[node.posY][node.posX] = node;
				} 
				
				if ((tender.canMove(2)) && (m.shouldMove(tender.posX - 1,tender.posY,curNode.cost_so_far+1))) {
					node = new Node(tender.posX - 1, tender.posY,
							curNode);
					node.cost_so_far = curNode.cost_so_far + 1;
					node.left_to_reach =m.heuristic(node);
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					m.queue.add(node);
					countStates++;
					m.nodeTable[node.posY][node.posX] = node;
				}
				if ((tender.canMove(3)) && (m.shouldMove(tender.posX,tender.posY+1,curNode.cost_so_far+1))) {
					node = new Node(tender.posX, tender.posY + 1,
							curNode);
					node.cost_so_far = curNode.cost_so_far + 1;
					node.left_to_reach = m.heuristic(node);
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					m.queue.add(node);
					countStates++;
					m.nodeTable[node.posY][node.posX] = node;
				}
				if ((tender.canMove(4)) && (m.shouldMove(tender.posX,tender.posY-1,curNode.cost_so_far+1))) {
					node = new Node(tender.posX, tender.posY - 1,
							curNode);
					node.cost_so_far = curNode.cost_so_far + 1;
					node.left_to_reach = m.heuristic(node);
					node.overall_cost = node.cost_so_far + node.left_to_reach;
					m.queue.add(node);
					countStates++;
					m.nodeTable[node.posY][node.posX] = node;
				}
				
				try {
					curNode = m.queue.poll();
					if (curNode == null)
						throw new canNotReach("The target is aunreachable\n");
				} catch (canNotReach c) {
					System.out.println(c.getMessage()); 
					JOptionPane.showMessageDialog(null,"The target is unreachable","A*",JOptionPane.WARNING_MESSAGE);
					System.exit(1);
				}
				
					
				tender.go_to_point(curNode.posX, curNode.posY);
				

			}

		
		
			
			while (curNode.depth > 3) 
				curNode = curNode.father;
				
			System.out.println("me before moving " + me.posY + " " + me.posX);
			me.go_to_point(curNode.posX,curNode.posY);
			System.out.println("me go to point " + me.posY + " " + me.posX);
			if (me.checkFound()) 
				break;
		    System.out.println("moved to " + me.posY + " " + me.posX);
			m.moved_so_far = m.moved_so_far + 3;
			
			// move the second robot
			i = randomGenerator.nextInt(3) + 1;
			while(!target.canMove(i))
				i = randomGenerator.nextInt(3) + 1;
			target.move(i);
			//System.out.println("The target went to " + target.posY + " " + target.posX);
			m.tarX = target.posX;
			m.tarY = target.posY;
			
			try {
		        Thread.sleep(500);
		    } catch(InterruptedException ex) {
		        Thread.currentThread().interrupt();
		        
		    }
		    
		    
		    p.plane = m.toVisualRep(me.posX, me.posY);
		    frame.validate();
		    frame.repaint();
			
			
		}
		System.out.println("Opened " + countStates + "states");
		JOptionPane.showMessageDialog(null,"Found the target","A*",JOptionPane.WARNING_MESSAGE);

	}

}
