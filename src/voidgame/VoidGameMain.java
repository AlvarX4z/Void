package voidgame;

import exceptions.InvalidAbsolutePathException;
import exceptions.InvalidItemDescriptionException;
import exceptions.InvalidItemMaxLengthException;
import exceptions.InvalidItemMinLengthException;
import exceptions.InvalidItemNameException;
import exceptions.InvalidStageDescriptionException;
import exceptions.InvalidStageNameException;
import game_elements.Protagonist;
import graphic_interface.Window;

public class VoidGameMain {

	/**
	 * Main Class for executing the videogame
	 * @param args
	 * @author Alvaro de Francisco Sanchez
	 */
	public static void main(String[] args) {
		try {
			Window w = new Window();
		} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException
				| InvalidStageNameException | InvalidStageDescriptionException | InvalidItemMaxLengthException
				| InvalidItemMinLengthException e) {
			e.printStackTrace();
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
