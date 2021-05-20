package mc322.lab06;

import java.util.Scanner;

public class AppMundoWumpus {
	
	public static void main(String args[]) {
		Heroi heroi = MontadorCaverna.montaCaverna(args[0]);
		if(heroi == null) {
			System.out.println("Erro no arquivo!");
			return;
		}
		Scanner keyboard = new Scanner(System.in);
		String nomePlayer;
		ControleJogo controle;
		String commands;
		System.out.print("Nome do Player: ");
		nomePlayer = keyboard.nextLine();
		controle = new ControleJogo(heroi, nomePlayer);
		controle.apresentaJogo();
		while(!controle.chegouAoFim()) {
			System.out.println("");
			commands = keyboard.nextLine();
			System.out.println("");
			controle.realizarComandos(commands);
			controle.apresentaJogo();
		}
		
		keyboard.close();
	}
}
