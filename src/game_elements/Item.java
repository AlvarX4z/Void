package game_elements;

import java.io.File;

/**
 * Emulates the Items' characteristics of the videogame
 * @author Alvaro de Francisco Sanchez
 */
public class Item {

	// ------------------------------
	// ----- INTERNAL VARIABLES -----
	// ------------------------------

	private String name; // Item's name
	private String description; // Item's description
	private boolean interactive; // If the item is interactive: TRUE if it is, FALSE if it isn't
	private static File pickingUpSound; // Sound file for picking up items. Null if the item isn't meant to be picked up
	private static File usingSound; // Sound file for using items. Null if the item isn't meant to be used

	// -------------------------
	// ----- CONSTRUCTORS ------
	// -------------------------

	/**
	 * Item's basic Constructor
	 * @param name | Item's name
	 * @param description | Item's description 
	 * @param interactive | If the item is interactive: TRUE if it is, FALSE if it isn't
	 * @param pickingUpSound | Sound file for picking up items. Null if the item isn't meant to be picked up
	 * @param usingSound | Sound file for using items. Null if the item isn't meant to be used
	 */
	public Item(String name, String description, boolean interactive, File pickingUpSound, File usingSound) {
		this.name = name;
		this.description = description;
		this.interactive = interactive; // If the item is interactive: TRUE if it is, FALSE if it isn't
		this.pickingUpSound = pickingUpSound;
		this.usingSound = usingSound;
	}

	// --------------------------------
	// ----- GETTERS AND SETTERS ------
	// --------------------------------

	/**
	 * Gets the Item's name
	 * @return The Item's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Item's name
	 * @param name | The Item's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the Item's description
	 * @return The Item's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the Item's description
	 * @param description | The Item's description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets if an Item is interactive 
	 * @return TRUE if it is interactive, FALSE if it isn't
	 */
	public boolean isInteractive() {
		return interactive;
	}

	/**
	 * Sets if an Item is interactive 
	 * @param interactive | TRUE if it is interactive, FALSE if it isn't
	 */
	public void setInteractive(boolean interactive) {
		this.interactive = interactive;
	}
	
	//TODO RESTO DE GETTERS Y SETTERS RELACIONADOS CON LOS ARCHIVOS DE SONIDO

	// ----------------------------------
	// ----- FUNCTIONS AND METHODS ------
	// ----------------------------------
}
