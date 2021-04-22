package mc332.lab04;

public class Peca {
	private char estado;
	
	Peca(boolean estado){ // Inicializa Peca
		if(estado)
			this.estado = 'P';
		else
			this.estado = '-';
	}
	
	char getEstado() { // Retorna o estado da peça
		return this.estado;
	}
}
