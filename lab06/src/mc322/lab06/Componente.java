package mc322.lab06;

public abstract class Componente {
	protected int[] coordenadas;
	protected char tipo;
	protected int numSecundarios;
	protected Componente secundarios[];
	protected Caverna caverna;
	
	Componente(int[] coordenadas, char tipo){
		this.coordenadas = coordenadas;
		this.tipo = tipo;
		this.numSecundarios = 0;
		this.secundarios = null;
		this.caverna = null;
	}
	
	public char getTipo() {
		return this.tipo;
	}
	
	public int[] getCoordenadas() {
		return this.coordenadas;
	}
	
	public int getNumSecundarios() {
		return this.numSecundarios;
	}
	
	public Componente[] getSecundarios() {
		return(this.secundarios == null) ? null : this.secundarios;
	}
	
	public boolean setCaverna(Caverna caverna) {
		if(caverna.insereComponente(this)) {
			this.caverna = caverna;
			return true;
		}
		return false;
	}
	
	public Caverna getCaverna() {
		return this.caverna;
	}
	
	public boolean ehPrimario() {
		return (this.tipo == 'O' || this.tipo == 'B' || this.tipo == 'W');
	}
	
	protected int[][] coordenadasSecundarios() {
		int coordenadasSecundarios[][] = new int[4][2];
		coordenadasSecundarios[0] = new int[] {this.coordenadas[0] + 1, this.coordenadas[1]};
		coordenadasSecundarios[1] = new int[] {this.coordenadas[0], this.coordenadas[1] + 1};
		coordenadasSecundarios[2] = new int[] {this.coordenadas[0] - 1, this.coordenadas[1]};
		coordenadasSecundarios[3] = new int[] {this.coordenadas[0], this.coordenadas[1] - 1};
		return coordenadasSecundarios;
	}
}
