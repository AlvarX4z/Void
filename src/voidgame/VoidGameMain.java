package voidgame;

import java.util.Scanner;

import game_elements.Protagonist;
import graphic_interface.Window;

public class VoidGameMain {

	/**
	 * Main Class for executing the videogame
	 * @param args
	 * @author Alvaro de Francisco Sanchez
	 */
	public static void main(String[] args) {
		Window w = new Window();
	}

	public static void mainMenu() {
		Scanner sc = new Scanner(System.in); // Scanner for input testing while building up the game in console
		String mainMenu = "-----------------------\n"
				+ "\tVOID\n"
				+ "-----------------------\n\n"
				+ "1 - New Game\n"
				+ "2 - Load Game\n\n"; // Main Menu for testing in console
		System.out.println(mainMenu);
		System.out.println("Choose an option by typing a number:");
		try {
			byte menuOption = Byte.parseByte(sc.nextLine()); // Input for choosing a menu's option
			while (menuOption != 1 && menuOption != 2) { // While loop in case the user's typed an invalid option from the menu
				System.out.println("You typed an invalid option. Please, try again:");
				menuOption = Byte.parseByte(sc.nextLine());
			}
			if (menuOption == 1) { // Control flow in order to start a new game or load one
				newGame(); 
			}
		} catch (NumberFormatException ex) {
			System.err.println("\nYou didn't type a number!\n");
			ex.printStackTrace();
		}

	}

	public static void newGame() {
		Protagonist protagonist = new Protagonist(null);
		prologueStage(protagonist);
		tentStage(protagonist);
		
	}
	
	public static void prologueStage(Protagonist protagonist) {
		String prologueMsg = "Your name is " + protagonist.getFirstName() + " " + protagonist.getLastName() + ".\n"
				+ "You are a citizen of the city of Arkham (Massachusetts) and a History professor specialised in American Indian culture "
				+ "at the Mistakonic University.\n"
				+ "You are currently on vacations and you have decided to spend some time on your favorite hobby: hiking and sleeping in "
				+ "his tent at nature at the Miskatonic Valley.\n\n"
				+ "Thus, this story begins...\n";
		System.out.println("\n--------------------");
		System.out.println(prologueMsg);
	}
	
	public static void tentStage(Protagonist protagonist) {
		String prologueMsg = "Such a wonderful day! I've just finished preparing the tent! It didn't take too much time, even less than I "
				+ "expected. ";
	}
}
