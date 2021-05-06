package mc322.lab05b;

public class Peca {
	protected int x, y;
	protected char tipo;
	
	Peca(int x, int y, char tipo) {
		this.x = x;
		this.y = y;
		this.tipo = tipo;
	}
	
	public int getCoordX() {
		return this.x;
	}
	
	public int getCoordY() {
		return this.y;
	}
	
	public char getTipo() {
		return this.tipo;
	}
	
	public int[] movimentoValido(Peca[] caminho) {
		return null;
	}
}
