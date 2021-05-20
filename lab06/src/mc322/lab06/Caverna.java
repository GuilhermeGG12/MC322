package mc322.lab06;

public class Caverna {
	private static int MAX_X;
	private static int MAX_Y;
	
	private Sala[][] salas;
	
	Caverna(){ // Inicializa caverna
		this.salas = new Sala[MAX_X][MAX_Y];
		for(int i = 0; i < MAX_X; i++) {
			for(int j = 0; j < MAX_Y; j++) {
				this.salas[i][j] = new Sala();
			}
		}
		
	}
	
	public void imprimeCaverna() { // Imprime caverna e coordenadas
		for(int i = 0; i < MAX_X; i++) {
			System.out.print((i + 1) + " ");
			for(int j = 0; j < MAX_Y; j++) {
				System.out.print(this.salas[i][j].ComponenteDaSala() + " ");
			}
			System.out.println();
		}
		System.out.print(" ");
		for(int j = 0; j < MAX_Y; j++) {
			System.out.print(" " + (j + 1));
		}
		System.out.println("");
	}
	
	public Componente getPrimario(int coordenadas[]) {
		return this.salas[coordenadas[0]][coordenadas[1]].getPrimario();
	}
	
	public boolean insereComponente(Componente componente) { // Adiciona componentes (Primarios, heroi e/ou secundarios) à caverna
		int[] coordenadas = componente.getCoordenadas();
		if(!this.salas[coordenadas[0]][coordenadas[1]].insereComponente(componente)) {
			return false; // Já tem componente primário na sala
		}
		int numSecundarios = componente.getNumSecundarios();
		if(numSecundarios > 0) {
			Componente secundarios[] = componente.getSecundarios();
			for(int i = 0; i < numSecundarios; i++) {
				if(!insereComponente(secundarios[i])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void excluiComponente(Componente componente) {
		int[] coordenadas = componente.getCoordenadas();
		int numSecundarios = componente.getNumSecundarios();
		this.salas[coordenadas[0]][coordenadas[1]].excluiComponente(componente);
		if(numSecundarios > 0) {
			Componente secundarios[] = componente.getSecundarios();
			for(int i = 0; i < numSecundarios; i++) {
				excluiComponente(secundarios[i]);
			}
		}
	}
}
