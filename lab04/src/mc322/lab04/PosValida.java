package mc322.lab04;

public class PosValida { // Verifica se a posição está no tabuleiro
	public static boolean noTabuleiro(int x, int y) {
		if((x < 0 || x > 6) || (y < 0 || y > 6))
			return false;
		else if((x < 2 || x > 4) && (y < 2 || y > 4))
			return false;
		else
			return true;
	}
}
