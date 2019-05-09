package game_elements;

/**
 * Emulates the Protagonist's characteristics of the videogame
 * @author Alvaro de Francisco Sanchez
 */
public class Protagonist {

	// ------------------------------
	// ----- INTERNAL VARIABLES -----
	// ------------------------------

	private String firstName; // Protagonist's first name
	private String lastName; // Protagonist's last name
	private Item[] inventory; // Protagonist's current inventory
	// TODO PENSAR Y ENCONTRAR TODOS LOS ARCHIVOS DE SONIDO (CLASE FILE)

	// -------------------------
	// ----- CONSTRUCTORS ------
	// -------------------------

	/**
	 * Protagonist's basic Constructor
	 * @param inventory | Protagonist's inventory 
	 */
	public Protagonist(Item [] inventory) {
		this.setFirstName("Randolph"); // The game's story is based on this first name for the protagonist
		this.setLastName("Carter"); // The game's story is based on this last name for the protagonist
		this.setInventory(null); // Inventory is set at null because at the beginning of the game the player hasn't any items on him/her
	}

	// --------------------------------
	// ----- GETTERS AND SETTERS ------
	// --------------------------------

	/**
	 * Gets the Protagonist's first name
	 * @return The Protagonist's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the Protagonist's first name
	 * @param | firstName The Protagonist's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the Protagonist's last name
	 * @return The Protagonist's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the Protagonist's last name
	 * @param | lastName The Protagonist's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the Protagonist's inventory
	 * @return The Protagonist's inventory
	 */
	public Item[] getInventory() {
		return inventory;
	}

	/**
	 * Sets the Protagonist's inventory
	 * @param inventory | The Protagonist's inventory
	 */
	public void setInventory(Item[] inventory) {
		this.inventory = inventory;
	}
	
	//TODO GETTERS Y SETTERS DE LOS ARCHIVOS RELACIONADOS CON SONIDO

	// ----------------------------------
	// ----- FUNCTIONS AND METHODS ------
	// ----------------------------------

}
