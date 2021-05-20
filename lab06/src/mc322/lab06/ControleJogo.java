package mc322.lab06;

public class ControleJogo {
	
	private static int ADICAO_SAIDA_COM_OURO = 1000;
    private static int ADICAO_MORTE = -1000;
    private static int ADICAO_MOVIMENTO = -15;
    private static int ADICAO_USO_FLECHA = -100;
    private static int ADICAO_VITORIA_WUMPUS = 500;
    private static int[] COORD_INI_HEROI = {0, 0};
    
    private boolean jogoTerminado;
    private int score;
    private Heroi heroi;
    private String nomePlayer;
    
    ControleJogo(Heroi heroi, String nomePlayer) {
        this.jogoTerminado = false;
        this.score = 0;
        this.heroi = heroi;
        this.nomePlayer = nomePlayer;
    }
    
    public boolean chegouAoFim() {
    	return this.jogoTerminado;
    }
    
    public int getScore() {
    	return this.score;
    }
    
    public String getNomePlayer() {
    	return this.nomePlayer;
    }
    
    private void aumentaScore(int adicao) {
    	this.score += adicao;
    }
    
    private void terminaJogo(boolean morreu) {
    	if(morreu) {
    		System.out.println("Você perdeu =(...");
    	}
    	else if(this.heroi.getOuroNoInventario() > 0 && PosValida.comparaPosicao(heroi.getCoordenadas(), COORD_INI_HEROI)) {
    		aumentaScore(ADICAO_SAIDA_COM_OURO);
    		System.out.println("Você ganhou =D 	!!!");
    	}
    	else {
    		System.out.println("Volte sempre!");
    	}
    	this.jogoTerminado = true;
    }
    
    private boolean moveParaCima() {
    	int destino[] = heroi.getCoordenadas();
    	destino[0]--;
    	if(PosValida.ehValida(destino)) {
    		this.heroi.movimento(destino);
    		return true;
    	}
    	return false;
    }
    
    private boolean moveParaBaixo() {
    	int destino[] = heroi.getCoordenadas();
    	destino[0]++;
    	if(PosValida.ehValida(destino)) {
    		this.heroi.movimento(destino);
    		return true;
    	}
    	return false;
    }
    
    private boolean moveParaDireita() {
    	int destino[] = heroi.getCoordenadas();
    	destino[1]++;
    	if(PosValida.ehValida(destino)) {
    		this.heroi.movimento(destino);
    		return true;
    	}
    	return false;
    }
    
    private boolean moveParaEsquerda() {
    	int destino[] = heroi.getCoordenadas();
    	destino[1]--;
    	if(PosValida.ehValida(destino)) {
    		this.heroi.movimento(destino);
    		return true;
    	}
    	return false;
    }
    
    public void realizarComandos(String commands) {
    	if(this.jogoTerminado) {
    		return;
    	}
    	boolean flechaEstaEquipada = false;
    	switch(commands) {
    	case "w":
    		if(moveParaCima()) {
    			aumentaScore(ADICAO_MOVIMENTO);
    		}
    		else {
    			System.out.println("Limite de cima!");
    		}
    		break;
    	case "s":
    		if(moveParaBaixo()) {
    			aumentaScore(ADICAO_MOVIMENTO);
    		}
    		else {
    			System.out.println("Limite de baixo!");
    		}
    		break;
    	case "d":
    		if(moveParaDireita()) {
    			aumentaScore(ADICAO_MOVIMENTO);
    		}
    		else {
    			System.out.println("Limite da direita!");
    		}
    		break;
    	case "a":
            if (moveParaEsquerda()) {
            	aumentaScore(ADICAO_MOVIMENTO);
            } 
            else {
                System.out.println("Limite da esquerda!");
            }
            break;
    	case "k":
    		if(!this.heroi.preparaFlecha()) {
    			System.out.println("Sem flecha no inventário!");
    		}
    		else {
    			flechaEstaEquipada = true;
    			System.out.println("Equipou a flecha!");
    		}
    		break;
    	case "c":
    		if(!this.heroi.pegaOuro()) {
    			System.out.println("Não tem ouro na sala!");
    		}
    		break;
    	case "q":
    		terminaJogo(false);
    		break;
    	default:
    		System.out.println("Comando Inválido!");
    		break;
    	}
    }
    
    public void apresentaJogo() {
        Caverna caverna = this.heroi.getCaverna();
        caverna.imprimeCaverna();
        System.out.println("");
        System.out.println("Player: " + this.nomePlayer);
        System.out.println("Score: " + this.score);
        System.out.println("Flechas no Inventário: " + this.heroi.getFlechaNoInventario());
        System.out.println("Ouro no Inventário: " + this.heroi.getOuroNoInventario());
    }
}
