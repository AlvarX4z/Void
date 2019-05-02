package game_elements;

/**
 * Emulates the Items' characteristics of the videogame
 * @author Alvaro de Francisco Sanchez
 */
public class Item {

	// ----------------------
	// ----- VARIABLES ------
	// ----------------------

	private String name; // Item's name
	private String description; // Item's description
	private boolean interactive; // If the item is interactive: TRUE if it is, FALSE if it isn't

	// -------------------------
	// ----- CONSTRUCTORS ------
	// -------------------------

	/**
	 * Item's basic Constructor
	 * @param name | Item's name
	 * @param description | Item's description 
	 * @param interactive | If the item is interactive: TRUE if it is, FALSE if it isn't
	 */
	public Item(String name, String description, boolean interactive) {
		this.name = name;
		this.description = description;
		this.interactive = interactive; // If the item is interactive: TRUE if it is, FALSE if it isn't
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
	
	// ----------------------------------
	// ----- FUNCTIONS AND METHODS ------
	// ----------------------------------
}
