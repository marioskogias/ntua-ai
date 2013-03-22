public class Robot implements Cloneable {

	/**
	 * @param args
	 */
	char name;
	int posX;
	int posY;
	int limX;
	int limY;
	int velocity;
	int prevX;
	int prevY;
	char[][] place; // to epipedo ergasias

	public void move(int direction) {
		switch (direction) {
		case 1: // 1 de3ia
			place[posY][posX] = 'O';
			posX = posX + velocity;
			place[posY][posX] = this.name;
			break;
		case 2: // 2 aristera
			place[posY][posX] = 'O';
			posX = posX - velocity;
			place[posY][posX] = this.name;
			break;
		case 3: // 3 katw
			place[posY][posX] = 'O';
			posY = posY + velocity;
			place[posY][posX] = this.name;
			break;
		case 4: // 4 panw
			place[posY][posX] = 'O';
			posY = posY - velocity;
			place[posY][posX] = this.name;
			break;

		}
	}

	public void go_to_point(int x,int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public boolean canMove(int direction) {
		switch (direction) {
		case 1: // 1 de3ia
			if ((posX + 3 <= limX) && (place[posY][posX + 1] == 'O')
					&& (place[posY][posX + 2] == 'O')
					&& (place[posY][posX + 3] == 'O'))
				return true;
			else
				return false;
		case 2: // 2 aristera
			if ((posX - 3 >= 0) && (this.place[posY][posX - 1] == 'O')
					&& (place[posY][posX - 2] == 'O')
					&& (place[posY][posX - 3] == 'O'))
				return true;
			else
				return false;
		case 3: // 3 katw
			if ((posY + 3 <= limY) && (place[posY + 1][posX] == 'O')
					&& (place[posY + 2][posX] == 'O')
					&& (place[posY + 3][posX] == 'O'))
				return true;
			else
				return false;
		case 4: // 4 panw
			if ((posY - 3 >=  0) && (place[posY - 1][posX] == 'O')
					&& (place[posY - 2][posX] == 'O')
					&& (place[posY - 3][posX] == 'O'))
				return true;
			else
				return false;

		}
		return false;

	}
	
	
	
	public boolean checkFound() {
		int i;
		for (i=0;i<4 && (posX+i)<limX;i++) { //de3ia
			if (place[posY][posX + i] == 'X')
				break;
			if (place[posY][posX+i] == 'T')
				return true;
		}
		
		for (i=0;i<4 && (posX-i)>=0;i++) { //aristera
			if (place[posY][posX - i] == 'X')
				break;
			if (place[posY][posX -i] == 'T')
				return true;
		}
		
		for (i=0;i<4 && (posY+i)<limY;i++) { //panw
			if (place[posY+i][posX] == 'X')
				break;
			if (place[posY+i][posX] == 'T')
				return true;
		}
		
		for (i=0;i<4 && (posY-i)>=0;i++) { //de3ia
			if (place[posY-i][posX] == 'X')
				break;
			if (place[posY-i][posX] == 'T')
				return true;
		}
		
		return false;
	}
	
	public Robot clone() throws CloneNotSupportedException {
        return (Robot) super.clone();
}
	

}
