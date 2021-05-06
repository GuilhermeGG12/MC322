package mc322.lab05b;

public class Peao extends Peca {
	Peao(int x, int y, char tipo) {
		super(x, y, tipo);
	}
	
	// Metodo para validar o movimento
	/* Andar uma casa diagonal
	 * Capturar peças - Diagonal pra tras e pra frente se for peça de cor contraria
	 */
	public int[] movimentoValido(Peca[] caminho) {
		if(caminho[caminho.length - 1] == null) {
			return null;
		}
		if(caminho.length == 0 || caminho.length > 2) {
			return null;
		}
		if(this.x == caminho[caminho.length-1].getCoordX() || this.y == caminho[caminho.length-1].getCoordY()) {
			return null;
		}
		if(caminho[caminho.length-1].getTipo() != '-') {
			return null;
		}
		
		if(caminho.length == 1) {
			if(this.tipo == 'b' && this.x > caminho[caminho.length - 1].getCoordX()) {
				return null;
			}
			if(this.tipo == 'p' && this.x < caminho[caminho.length - 1].getCoordX()) {
				return null;
			}
		}
		
		if(caminho.length == 2 && caminho[0].getTipo() == '-') {
			return null;
		}
		
		if(caminho.length == 1) {
			int capturada[] = {};
			return capturada;
		}
		
		if(this.tipo != Character.toLowerCase(caminho[0].getTipo())) {
			int capturada[] = {caminho[0].getCoordX(), caminho[0].getCoordY()};
			return capturada;
		}
		
		return null; // Peça no trajeto é da mesma cor
	}
	
	
}
