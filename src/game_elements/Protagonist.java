package game_elements;

import java.io.File;
import java.util.ArrayList;

/**
 * Emulates the Protagonist's characteristics of the videogame
 * @author Alvaro de Francisco Sanchez
 */
public class Protagonist {

	// ------------------------------
	// ----- INTERNAL VARIABLES -----
	// ------------------------------

	public static final String firstName = "Randolph"; // The game's story is based on this first name for the Protagonist
	public static final String lastName = "Carter"; // The game's story is based on this last name for the Protagonist
	private ArrayList<Item> inventory; // Protagonist's current inventory
	public static final File yawningSound = new File("./audio/yawning.wav"); // Sound file for a yawning
	public static final File huhSound = new File("./audio/huh.wav"); // Sound file for a 'huh' sound
	//TODO IMAGEN 7
	
	// -------------------------
	// ----- CONSTRUCTORS ------
	// -------------------------

	/**
	 * Protagonist's basic Constructor
	 * @param inventory Protagonist's inventory 
	 */
	public Protagonist(ArrayList<Item> inventory) {
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
	 * Gets the Protagonist's last name
	 * @return The Protagonist's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the Protagonist's inventory
	 * @return The Protagonist's inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	/**
	 * Sets the Protagonist's inventory
	 * @param inventory The Protagonist's inventory
	 */
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	// ----------------------------------
	// ----- FUNCTIONS AND METHODS ------
	// ----------------------------------

}
