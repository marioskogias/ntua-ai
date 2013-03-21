
public class Robot {

	/**
	 * @param args
	 */
	
	int posX;
	int posY;
	int velocity;
	char [][] place; // to epipedo ergasias
	
	public void move(int direction) {
		switch(direction) {
			case 1: // 1 de3ia
				posX = posX+velocity;
				break;
			case 2: // 2 aristera
				posX = posX-velocity;
				break;
			case 3: // 3 panw
				posX = posY+velocity;
				break;
			case 4: // 4 katw
				posX = posY-velocity;
				break;
					
		
		}
	}
	
	public static void main(String[] args) {
	
		Robot r = new Robot();
		r.posX = 3;
		r.velocity = 1;
		r.move(2);
		System.out.println(r.posX);
		
		
	}

}
