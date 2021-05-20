package mc322.lab06;

public class Sala {
	private static int MAX_SECUNDARIOS = 4; // 3 Brisas e 1 Fedor na mesma sala
	
	private boolean visitada;
	private Componente heroi;
	private Componente primario;
	private int numSecundarios;
	private Componente secundarios[];
	
	
	Sala(){
		this.visitada = false;
		this.heroi = null;
		this.numSecundarios = 0;
		this.primario = null;
		this.secundarios = new Componente[MAX_SECUNDARIOS];	
		
	}
	
	public boolean foiVisitada() {
		return this.visitada;
	}
	
	public void visita() {
		this.visitada = true;
	}
	
	public Componente getHeroi() {
		return this.heroi;
	}
	
	public void addHeroi(Componente heroi) {
		this.heroi = heroi;
	}
	
	public void excluiHeroi() {
		this.heroi = null;
	}
	
	public Componente getPrimario() {
		return this.primario;
	}
	
	public boolean addPrimario(Componente primario) {
		if(primario == null) {
			this.primario = primario;
			return true;
		}
		return false;
	}
	
	public void excluiPrimario() {
		this.primario = null;
	}
	
	public int getNumSecundarios() {
		return this.numSecundarios;
	}
	
	public Componente[] getSecundarios() {
		return this.secundarios;
	}
	
	public void addSecundario(Componente secundario) {
		this.secundarios[this.numSecundarios] = secundario;
		this.numSecundarios++;
	}
	
	public void excluiSecundario(char tipo) {
		for(int i = 0; i < this.numSecundarios; i++) {
			if(this.secundarios[i].getTipo() == tipo) {
				this.secundarios[i] = null;
				this.secundarios[i] = this.secundarios[this.numSecundarios];
				this.secundarios[this.numSecundarios] = null;
				this.numSecundarios--;
			}
		}
	}
	
	public boolean insereComponente(Componente componente) {
		if(componente.getTipo() == 'P') {
			addHeroi(componente);
			return true;
		}
		else if(componente.ehPrimario()){
			return addPrimario(componente);
		}
		else {
			addSecundario(componente);
			return true;
		}
	}
	
	public void excluiComponente(Componente componente) {
		if(componente.getTipo() == 'P') {
			excluiHeroi();
		}
		else if(componente.ehPrimario()) {
			excluiPrimario();
		}
		else {
			excluiSecundario(componente.getTipo());
		}
	}
	
	public char ComponenteDaSala() {
		if(!this.visitada) {
			return '-';
		}
		
		if(this.primario != null) {
			return this.primario.getTipo();
		}
		
		if(this.heroi != null) {
			return this.heroi.getTipo();
		}
		if(this.numSecundarios > 0) {
			char prioridade = this.secundarios[0].getTipo();
			if(prioridade != 'f') {
				for(int i = 1; i < this.numSecundarios; i++) {
					if(this.secundarios[i].getTipo() == 'f') {
						prioridade = 'f';
					}
				}
			}
			return prioridade;
		}
		
		return '#';
	}
}
