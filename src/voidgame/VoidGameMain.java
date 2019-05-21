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
				| InvalidItemMinLengthException e) { // Catching related exceptions
			e.getMessage(); // Throws the corresponding exception message if a System error has happened
		}
	}
}