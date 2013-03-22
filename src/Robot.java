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
			posX++;
			place[posY][posX] = this.name;
			break;
		case 2: // 2 aristera
			place[posY][posX] = 'O';
			posX--;
			place[posY][posX] = this.name;
			break;
		case 3: // 3 katw
			place[posY][posX] = 'O';
			posY++;
			place[posY][posX] = this.name;
			break;
		case 4: // 4 panw
			place[posY][posX] = 'O';
			posY--;
			place[posY][posX] = this.name;
			break;

		}
	}

	public void go_to_point(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	public boolean canMove(int direction) {
		switch (direction) {
		case 1: // 1 de3ia
			if ((posX + 1 <= limX) && (place[posY][posX + 1] != 'X'))
				return true;
			else
				return false;
		case 2: // 2 aristera
			if ((posX - 1 >= 0) && (this.place[posY][posX - 1] != 'X'))
				return true;
			else
				return false;
		case 3: // 3 katw
			if ((posY + 1 <= limY) && (place[posY + 1][posX] != 'X'))
				return true;
			else
				return false;
		case 4: // 4 panw
			if ((posY - 1 >= 0) && (place[posY - 1][posX] != 'X'))
				return true;
			else
				return false;

		}
		return false;

	}

	public boolean checkFound() {
		if (place[this.posY][this.posX] == 'T')
			return true;
		else
			return false;
	}

	public Robot clone() throws CloneNotSupportedException {
		return (Robot) super.clone();
	}

}
