package voidgame;

import java.util.Scanner;

import game_elements.Protagonist;

public class VoidGameMain {

	/**
	 * Main Class for executing the videogame
	 * @param args
	 * @author Alvaro de Francisco Sanchez
	 */
	public static void main(String[] args) {
		
		// ---------------------------------------------------
		// ----- INITIALISING REQUIRED CLASSES' OBJECTS ------
		// ---------------------------------------------------

		Protagonist protagonist = new Protagonist(null); 

		// ----------------------
		// ----- MAIN FLOW ------
		// ----------------------

		mainMenu();
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
			} else {
				loadGame();
			}
		} catch (NumberFormatException ex) {
			System.err.println("\nYou didn't type a number!\n");
			ex.printStackTrace();
		}

	}

	public static void newGame() {
		String prologueMsg = "";
	}

	public static void loadGame() {

	}
}
