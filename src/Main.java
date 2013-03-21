import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	/**
	 * @param args
	 */
	int limX;
	int limY;
	char[][] place; // to epipedo ergasias
	
	public static void main(String[] args) {
		
		Main m = new Main();
		Robot me = new Robot();
		Robot target = new Robot();
		int i,j;
		try {
			BufferedReader in = new BufferedReader (new FileReader ("/Users/marioskogias/Documents/ntua/ai-ntua/src/input.txt")) ;
			String line = in.readLine () ;
			String [] a = line.split (" ") ;
			m.limY = Integer.parseInt(a[0]) ;
			m.limX = Integer.parseInt(a[1]) ;
			me.limX = m.limX;
			me.limY = m.limY;
			target.limX = m.limX;
			target.limY = m.limY;
			
			line = in.readLine () ;
			a = line.split (" ") ;
			me.posY = Integer.parseInt(a[0]) ;
			me.posX = Integer.parseInt(a[1]) ;
			
			line = in.readLine () ;
			a = line.split (" ") ;
			target.posY = Integer.parseInt(a[0]) ;
			target.posX = Integer.parseInt(a[1]) ;
			
			m.place = new char[m.limY][m.limX];
			for (i=0;i<m.limY;i++){
				line = in.readLine();
				char[] array = line.toCharArray();
				for (j=0;j<m.limX;j++)
					m.place[i][j] = array[j];
			}
			
			me.place = m.place;
			target.place = m.place;
			
			in.close();
		}
		catch( IOException e ) {
			e . printStackTrace () ;
			}
		
		for (i=0;i<m.limY;i++){
			for(j=0;j<m.limX;j++)
				System.out.print(m.place[i][j]);
			System.out.println();

		}
			}

}
