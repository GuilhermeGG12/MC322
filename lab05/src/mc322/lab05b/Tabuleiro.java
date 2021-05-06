package mc322.lab05b;

public class Tabuleiro {
	public Peca[][] pecas;
	
	Tabuleiro(){
		this.pecas = new Peca[8][8];
		
		for(int i  = 0; i < 3; i++) {
			if(i == 0 || i == 2) {
				for(int j = 0; j < 8; j += 2) {
					this.pecas[i][j] = new Peao(i, j, 'b');
					this.pecas[i][j + 1] = new Peca(i, j + 1, '-');
				}
			}
			else {
				for(int j = 0; j < 8; j += 2) {
					this.pecas[i][j] = new Peca(i, j, '-');
					this.pecas[i][j + 1] = new Peao(i, j + 1, 'b');
				}
			}
		}
		
		for(int i = 3; i < 5; i++) {
			for(int j = 0; j < 8; j++) {
				this.pecas[i][j] = new Peca(i, j, '-');
			}
		}
		
		for(int i = 5; i < 8; i++) {
			if(i == 5 || i == 7) {
				for(int j = 0; j < 8; j += 2) {
					this.pecas[i][j] = new Peca(i, j, '-');
					this.pecas[i][j + 1] = new Peao(i, j + 1, 'p');
				}
			}
			else {
				for(int j = 0; j < 8; j += 2) {
					this.pecas[i][j] = new Peao(i, j, 'p');
					this.pecas[i][j + 1] = new Peca(i, j + 1, '-');
				}
			}
		}
	}
	
	public String desenhaTabuleiro() {
		String tabuleiro = "";
		for(int i = 7; i >= 0; i--) {
			for(int j = 0; j < 8; j++) {
				tabuleiro += this.pecas[i][j].getTipo(); 
			}
			tabuleiro += '\n';
		}
		
		return tabuleiro;
	}
	
	public void imprimeTabuleiro() {
		for(int i = 7; i >= 0; i--) {
			System.out.print(i + 1);
			for(int j = 0; j < 8; j++) {
				System.out.print(" " + this.pecas[i][j].getTipo());
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public void exportarArquivo(String pathCsv, boolean error) {
        CSVHandling csv = new CSVHandling();
        csv.setDataExport(pathCsv);
        String tabuleiro[];
        if (!error) {
            tabuleiro = new String[8 * 8];
            char coluna, linha;
            for (int j = 0; j < 8; j++) {
                coluna = (char)(j + (int)('a'));
                for (int i = 0; i < 8; i++) {
                    linha = (char)(i + (int)('1'));
                    tabuleiro[j * 8 + i] = "";
                    tabuleiro[j * 8 + i] += coluna;
                    tabuleiro[j * 8 + i] += linha;
                    if (this.pecas[i][j].getTipo() == '-') {
                        tabuleiro[j * 8 + i] += '_';
                    } else {
                        tabuleiro[j * 8 + i] += this.pecas[i][j].getTipo();
                    }
                }
            }
        } else {
            tabuleiro = new String[] {"erro"};
        }
        csv.exportState(tabuleiro);
    }
	
	private void virarDama(Peca peca) {
		int x = peca.getCoordX();
		int y = peca.getCoordY();
		char tipo = peca.getTipo();
		if(tipo == 'b' && x == 7) {
			this.pecas[x][y] = new Dama(x, y, 'B');
		}
		else if(tipo == 'p' && x == 0) {
			this.pecas[x][y] = new Dama(x, y, 'P');
		}
	}
	
	private Peca[] caminhoPercorrido(int atualX, int atualY, int alvoX, int alvoY) {
		Peca caminho[];
		int distancia = (alvoX != atualX) ? Math.abs(alvoX - atualX) : Math.abs(alvoY - atualY);
		caminho = new Peca[distancia];
		int deslocamentoX = (alvoX - atualX) / distancia;
		int deslocamentoY = (alvoY - atualY) / distancia;
		int i = atualX + deslocamentoX;
		int j = atualY + deslocamentoY;
		
		for(int coordenada = 0; coordenada < distancia; coordenada++) {
			if(PosValida.noTabuleiro(i, j)) {
				caminho[coordenada] = this.pecas[i][j];
			}
			else {
				caminho[coordenada] = null;
			}
			i += deslocamentoX;
			j += deslocamentoY;
		}
		
		return caminho;
	}
	
	public boolean requisitarMovimento(String commands) {
		int atualX = commands.charAt(1) - '0' - 1;
		int atualY = commands.charAt(0) - 'a';
		int alvoX = commands.charAt(4) - '0' - 1;
		int alvoY = commands.charAt(3) - 'a';
		
		if(!PosValida.noTabuleiro(atualX, atualY)) {
			return false;
		}
		Peca caminho[] = caminhoPercorrido(atualX, atualY, alvoX, alvoY);
		int capturada[] = this.pecas[atualX][atualY].movimentoValido(caminho);
		if(capturada != null) {
			char atualTipo = this.pecas[atualX][atualY].getTipo();
			this.pecas[atualX][atualY] = new Peca(atualX, atualY, '-');
			
			if(capturada.length == 2) {
				this.pecas[capturada[0]][capturada[1]] = new Peca(capturada[0], capturada[1], '-');
			}
			
			if(atualTipo == 'b' || atualTipo == 'p') {
				this.pecas[alvoX][alvoY] = new Peao(alvoX, alvoY, atualTipo);
				virarDama(this.pecas[alvoX][alvoY]); // Sempre que realizar ação checa se pode virar dama
			}
			else {
				this.pecas[alvoX][alvoY] = new Dama(alvoX, alvoY, atualTipo);
			}
			
			return true;
		}
		else {
			System.out.println("Movimento inválido!");
			return false;
		}
	}
}
