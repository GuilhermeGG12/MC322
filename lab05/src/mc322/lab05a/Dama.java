package mc322.lab05a;

public class Dama extends Peca {
	Dama(int x, int y, char tipo) {
		super(x, y, tipo);
	}
	
	// Metodo para validar os movimentos
	private int pecasNoCaminho(Peca[] caminho) {
		int qtd = 0;
		for(int coordenada = 0; coordenada < caminho.length - 1; coordenada++) {
			if(caminho[coordenada].getTipo() != '-') {
				qtd++;
			}
		}
		return qtd;
	}
	
	public int[] movimentoValido(Peca[] caminho) {
		if(caminho[caminho.length - 1] == null) {
			return null;
		}
		
		if(caminho.length == 0) {
			return null;
		}
		
		if(this.x == caminho[caminho.length - 1].getCoordX() || this.y == caminho[caminho.length - 1].getCoordY()) {
			return null;
		}
		
		if(caminho[caminho.length - 1].getTipo() != '-') {
			return null;
		}
		
		int qtd = pecasNoCaminho(caminho);
		
		if(qtd > 1) {
			return null;
		}
		
		if(qtd == 0) {
			int[] capturada = {};
			return capturada;	
		}
		
		if(caminho[caminho.length - 2].getTipo() != '-') {
			return null;
		}
		
		for(int i = caminho.length - 2; i >= 0; i--) {
			if(Character.toLowerCase(this.tipo) != Character.toLowerCase(caminho[i].getTipo()) &&
			   Character.toLowerCase(caminho[i].getTipo()) != '-'){
					int capturada[] = {caminho[i].getCoordX(), caminho[i].getCoordY()};
					return capturada;
			}
		
		}
		return null;
	}
	
}
