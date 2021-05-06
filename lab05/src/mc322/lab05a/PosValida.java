package mc322.lab05a;

public class PosValida { // Checa se a posi��o est� dentro do tabuleiro
	public static boolean noTabuleiro(int x, int y) {
		if((x < 0 || x > 7) || (y < 0 || y > 7))
			return false;
		else
			return true;
	}
}