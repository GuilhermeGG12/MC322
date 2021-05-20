package mc322.lab06;

public class MontadorCaverna {
	private static int MAX_X = 4;
	private static int MAX_Y = 4;
	private static int MIN_BURACO = 2;
	private static int MAX_BURACO = 3;
	private static int MAX_WUMPUS = 1;
	private static int MAX_OURO = 1;
	private static int[] COORD_INI_HEROI = {0, 0};
	
	public static Heroi montaCaverna(String path) {
		String componentesDaCaverna[][] = leComandos(path);
		if((componentesDaCaverna == null) || componentesDaCaverna.length != MAX_X * MAX_Y) {
			return null;
		}
		Caverna caverna = new Caverna();
		Heroi heroi = null;
		Componente componente;
		int numBuraco = 0, numWumpus = 0, numOuro = 0, numHeroi = 0;
		for(int i = 0; i < componentesDaCaverna.length; i++) {
			switch(componentesDaCaverna[i][1]) {
			case "_":
				break;
			case "B":
				componente = new Buraco(componentesDaCaverna[i]);
				if(!componente.setCaverna(caverna)) {
					return null;
				}
				numBuraco++;
				break;
			case "W":
				componente = new Wumpus(componentesDaCaverna[i]);
				if(!componente.setCaverna(caverna)) {
					return null;
				}
				numWumpus++;
				break;
			case "O":
				componente = new Ouro(componentesDaCaverna[i]);
				if(!componente.setCaverna(caverna)) {
					return null;
				}
				numOuro++;
				break;
			case "P":
				heroi = new Heroi(componentesDaCaverna[i]);
				if(!PosValida.comparaPosicao(COORD_INI_HEROI, heroi.getCoordenadas())) {
					return null;
				}
				if(!heroi.setCaverna(caverna)) {
					return null;
				}
				numHeroi++;
				break;
			default:
				return null;
			}
		}
		if((numBuraco < MIN_BURACO) || (numBuraco > MAX_BURACO) || (numWumpus != MAX_WUMPUS) || 
		   (numOuro != MAX_OURO) || (numHeroi != 1)) {
			return null;
		}
		return heroi;
	}
	
	private static String[][] leComandos(String path){
		CSVHandling csv = new CSVHandling();
		String componentesDaCaverna[][];
		csv.setDataSource(path);
		componentesDaCaverna = csv.requestCommands();
		return componentesDaCaverna;
	}
}
