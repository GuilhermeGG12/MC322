package mc322.lab06;

public class Heroi extends Componente {
	private int ouroNoInventario;
	private int flechaNoInventario;
	private boolean flechaPreparada;
	
	private static int MAX_FLECHAS = 1;
	
	Heroi(int[] coordenadas){
		super(coordenadas, 'P');
		this.ouroNoInventario = 0;
		this.flechaNoInventario = MAX_FLECHAS;
		this.flechaPreparada = false;
	}
	
	/*Heroi(String[] heroi){ //Construtor associado à leitura do arquivo CSV
	
	}
	*/
	
	public int getOuroNoInventario() {
		return this.ouroNoInventario;
	}
	
	public int getFlechaNoInventario() {
		return this.flechaNoInventario;
	}
	
	public boolean checaFlechaPreparada() {
		return this.flechaPreparada;
	}
	
	public boolean preparaFlecha() {
		if(this.flechaNoInventario > 0) {
			this.flechaNoInventario--;
			this.flechaPreparada = true;
			return true;
		}
		return false;
	}
	
	public void usaFlecha() {
		this.flechaPreparada = false;
	}
	
	public boolean pegaOuro() {
		Componente primario = this.caverna.getPrimario(this.coordenadas);
		if((primario == null) || (primario.getTipo() != 'O')) {
			return false;
		}
		else {
			this.caverna.excluiComponente(primario);
			this.ouroNoInventario++;
			return true;
		}
	}
	
	public void movimento(int[] coordenadasAlvo) {
		this.caverna.excluiComponente(this);
		this.coordenadas = coordenadasAlvo;
		this.caverna.insereComponente(this);
	}
}
