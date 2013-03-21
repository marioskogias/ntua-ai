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

		// start the procedure
		Robot tender = null; // tender robot to simulate the move
		try {
			tender = (Robot) me.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
