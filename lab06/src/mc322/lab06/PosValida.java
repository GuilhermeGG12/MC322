package mc322.lab06;

public class PosValida {
	private static int MAX_X;
	private static int MAX_Y;
	
	public static boolean ehValida(int[] coordenadas) {
		return(((coordenadas[0] >= 0) && (coordenadas[0] < MAX_X)) &&
			   ((coordenadas[1] >= 0) && (coordenadas[1] < MAX_Y)));
	}
	
	public static boolean comparaPosicao(int[] coordenadasA, int[] coordenadasB) {
		return ((coordenadasA[0] == coordenadasB[0]) && (coordenadasA[1] == coordenadasB[1]));
	}
}
