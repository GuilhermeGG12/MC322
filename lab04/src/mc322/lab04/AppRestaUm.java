package mc322.lab04;

public class AppRestaUm {
	public static String[] executaJogo(String pathcsv) {
		Tabuleiro tabuleiro = new Tabuleiro();
		CSVReader csv = new CSVReader();
		csv.setDataSource(pathcsv);
		String commands[] = csv.requestCommands();
		String estados[] = new String[commands.length + 1];
		estados[0] = tabuleiro.desenhaTabuleiro();
		System.out.println("Tabuleiro inicial");
		tabuleiro.imprimeTabuleiro();
		for(int i = 0; i < commands.length; i++) {
			System.out.println();
			tabuleiro.realizaAcao(commands[i]);
			estados[i + 1] = tabuleiro.desenhaTabuleiro();
			System.out.println("Source: " + commands[i].substring(0, 2));
			System.out.println("Target: " + commands[i].substring(3, 5));
			tabuleiro.imprimeTabuleiro();
		}
		
		return estados;
	}
	
	public static void main(String args[]) {
		executaJogo("C:\\Users\\guilh\\Desktop\\MC322\\lab04\\teste\\testeRestaUm.csv");
	}
}
