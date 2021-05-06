package mc322.lab05b;

public class PosValida { // Checa se a posição está dentro do tabuleiro
	public static boolean noTabuleiro(int x, int y) {
		if((x < 0 || x > 7) || (y < 0 || y > 7))
			return false;
		else
			return true;
	}
}