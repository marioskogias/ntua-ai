import java.io.*;

public class Robot {

	/**
	 * @param args
	 */
	char name;
	int posX;
	int posY;
	int limX;
	int limY;
	int velocity;
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
		case 3: // 3 panw
			place[posY][posX] = 'O';
			posX = posY + velocity;
			place[posY][posX] = this.name;
			break;
		case 4: // 4 katw
			place[posY][posX] = 'O';
			posX = posY - velocity;
			place[posY][posX] = this.name;
			break;

		}
	}

	public int canMove(int direction) {
		switch (direction) {
		case 1: // 1 de3ia
			if ((posX + 3 <= limX) && (place[posY][posX + 1] == 'O')
					&& (place[posY][posX + 2] == 'O')
					&& (place[posY][posX + 3] == 'O'))
				return 1;
			else
				return 0;
		case 2: // 2 aristera
			if ((posX - 3 <= limX) && (this.place[posY][posX - 1] == 'O')
					&& (place[posY][posX - 2] == 'O')
					&& (place[posY][posX - 3] == 'O'))
				return 1;
			else
				return 0;
		case 3: // 3 panw
			if ((posY + 3 <= limX) && (place[posY + 1][posX] == 'O')
					&& (place[posY + 2][posX] == 'O')
					&& (place[posY + 3][posX] == 'O'))
				return 1;
			else
				return 0;
		case 4: // 4 katw
			if ((posY - 3 <= limX) && (place[posY - 1][posX] == 'O')
					&& (place[posY - 2][posX] == 'O')
					&& (place[posY - 3][posX] == 'O'))
				return 1;
			else
				return 0;

		}
		return 0;

	}

	

}
