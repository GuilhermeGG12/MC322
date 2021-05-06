package mc322.lab05b;

public class AppDama {
	public static String[] executaJogo(String pathCsv, String pathCsvFinal) {
		Tabuleiro tabuleiro = new Tabuleiro();
		CSVHandling csv = new CSVHandling();
		String commands[];
		String estados[];
		boolean error = false;
		csv.setDataSource(pathCsv);
		commands = csv.requestCommands();
		estados = new String[commands.length + 1];
		System.out.println("Tabuleiro Inicial");
		estados[0] = tabuleiro.desenhaTabuleiro(); 
		tabuleiro.imprimeTabuleiro();
		for(int i = 0; i < commands.length; i++) {
			System.out.println();
			System.out.println("Source: " + commands[i].substring(0, 2));
			System.out.println("Target: " + commands[i].substring(3, 5));
			error = tabuleiro.requisitarMovimento(commands[i]);
			tabuleiro.imprimeTabuleiro();
			estados[i + 1] = tabuleiro.desenhaTabuleiro();
		}
		tabuleiro.exportarArquivo(pathCsvFinal, !error);
		return estados;
	}
	
	public static void main(String args[]) {
		executaJogo(rgs[0], args[1]);
	}
}
