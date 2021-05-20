package mc322.lab06;

public class Buraco extends Componente {
	private static int NUM_SECUNDARIOS = 4;
	
	Buraco(int[] coordenadas){
		super(coordenadas, 'B');
		int coordenadasSecundarios[][] = coordenadasSecundarios();
		this.secundarios = new Componente[NUM_SECUNDARIOS];
		for(int i = 0; i < NUM_SECUNDARIOS; i++) {
			if(PosValida.ehValida(coordenadasSecundarios[i])) {
				this.secundarios[this.numSecundarios] = new Brisa(coordenadasSecundarios[i]);
				this.numSecundarios++;
			}
		}
	}
	
	/*Buraco(String[] buraco){ //Construtor associado à leitura do arquivo CSV
		
	}
	*/
}
