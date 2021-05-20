package mc322.lab06;

public class Wumpus extends Componente {
	private static int NUM_SECUNDARIOS = 4;
	
	Wumpus(int[] coordenadas){
		super(coordenadas, 'W');
		int coordenadasSecundarios[][] = coordenadasSecundarios();
		this.secundarios = new Componente[NUM_SECUNDARIOS];
		for(int i = 0; i < NUM_SECUNDARIOS; i++) {
			if(PosValida.ehValida(coordenadasSecundarios[i])) {
				this.secundarios[this.numSecundarios] = new Fedor(coordenadasSecundarios[i]);
				this.numSecundarios++;
			}
		}
		/*Wumpus(String[] wumpus){ //Construtor associado à leitura do arquivo CSV
		
		}
		*/
	}
}
