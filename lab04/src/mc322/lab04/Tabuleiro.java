package mc322.lab04;

public class Tabuleiro {
	private Peca[][] pecas; 
	
	Tabuleiro() { // Inicializa Tabuleiro, insere as pe�as e retira a do meio
		this.pecas = new Peca[7][7];	
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if(PosValida.noTabuleiro(i, j)) {
					inserePeca(i, j);
				}
				else {
					this.pecas[i][j] = null;
				}
			}
		}
		retiraPeca(3, 3);
	}
	
	private boolean eh_valido(String comando) { // Checa validade dos movimentos no tabuleiro

		int atualX, atualY, alvoX, alvoY, intermX, intermY;
		atualX = comando.charAt(0) - 'a';
		atualY = comando.charAt(1) - '0' - 1;
		alvoX = comando.charAt(3) - 'a';
		alvoY = comando.charAt(4) - '0' - 1;
		intermX = (atualX + alvoX) / 2;
		intermY = (atualY + alvoY) / 2;
		
		if(!PosValida.noTabuleiro(atualX, atualY)) {
			System.out.println("Inv�lida: Atual fora do Tabuleiro");
			return false;
		}
		
		if(!PosValida.noTabuleiro(alvoX, alvoY)) {
			System.out.println("Inv�lida: Alvo fora do Tabuleiro");
			return false;
		}
		
		if(atualX == alvoX && atualY == alvoY) {
			System.out.println("Inv�lida: Atual e Alvo nas mesmas posi��es");
			return false;
		}
		
		if(atualX != alvoX && atualY != alvoY) {
			System.out.println("Inv�lida: Movimento na diagonal");
			return false;
		}
		
		if(this.pecas[atualX][atualY].getEstado() == '-') {
			System.out.println("Inv�lida: Atual est� vazio");
			return false;
		}
		
		if(this.pecas[alvoX][alvoY].getEstado() == 'P') {
			System.out.println("Inv�lida: Alvo tem pe�a");
			return false;
		}
		
		if(Math.abs(atualX - alvoX) > 2 || Math.abs(atualY - alvoY) > 2) {
			System.out.println("Inv�lida: Mais de uma pe�a intermediaria");
			return false;
		}
		
		if(this.pecas[intermX][intermY].getEstado() == '-') {
			System.out.println("Inv�lida: Intermediaria vazia");
			return false;
		}
		
		return true;
	}
	
	private void inserePeca(int x, int y) { // Insere pe�a no tabuleiro
		if(PosValida.noTabuleiro(x, y))
			this.pecas[x][y] = new Peca(true);
	}
	
	private void retiraPeca(int x, int y) { // Retira pe�a do tabuleiro
		if(PosValida.noTabuleiro(x, y))
			this.pecas[x][y] = new Peca(false);
	}
	
	public void realizaA�ao(String comando) { // Executa o movimento indicado
		int atualX, atualY, alvoX, alvoY, intermX, intermY;
		if(!eh_valido(comando))
			return;
		
		atualX = comando.charAt(0) - 'a';
		atualY = comando.charAt(1) - '0' - 1;
		alvoX = comando.charAt(3) - 'a';
		alvoY = comando.charAt(4) - '0' - 1;
		intermX = (atualX + alvoX) / 2;
		intermY = (atualY + alvoY) / 2;
		
		retiraPeca(atualX, atualY);
		retiraPeca(intermX, intermY);
		inserePeca(alvoX, alvoY);
	}
	
	public String desenhaTabuleiro() { // Atualiza o tabuleiro para cada estado
		String tabuleiro = "";
		for(int j = 6; j >= 0; j--) {
			for(int i = 0; i < 7; i++) {
				if(PosValida.noTabuleiro(i, j))
					tabuleiro += this.pecas[i][j].getEstado();
				else
					tabuleiro += ' ';
			}
			tabuleiro += '\n';
		}
		
		return tabuleiro;
	}
	
	public void imprimeTabuleiro() { // Imprime o tabuleiro para cada estado
		for(int j = 6; j >= 0; j--) {
			System.out.print(j + 1);
			for(int i = 0; i < 7; i++) {
				if(PosValida.noTabuleiro(i, j))
					System.out.print(" " + this.pecas[i][j].getEstado());
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g");
	}
}
