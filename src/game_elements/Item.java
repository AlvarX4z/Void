package game_elements;

import java.io.File;

import exceptions.InvalidAbsolutePathException;
import exceptions.InvalidItemDescriptionException;
import exceptions.InvalidItemNameException;

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
	private File pickingUpSound; // Sound file for picking up items. Null if the item isn't meant to be picked up. It is a static variable because the sound File will be the same for all the Item Objects
	private File usingSound; // Sound file for using items. Null if the item isn't meant to be used

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
	 * @throws InvalidItemNameException | Exception related to an invalid blank Item's name
	 * @throws InvalidItemDescriptionException | Exception related to an invalid blank Item's description
	 * @throws InvalidAbsolutePathException | Exception related to the use of an absolute path for files
	 */
	public Item(String name, String description, boolean interactive, File pickingUpSound, File usingSound) throws InvalidItemNameException, InvalidItemDescriptionException, InvalidAbsolutePathException {
		this.setName(name);
		this.setDescription(description);
		this.setInteractive(interactive); // If the item is interactive: TRUE if it is, FALSE if it isn't
		this.setPickingUpSound(pickingUpSound);
		this.setUsingSound(usingSound);
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
	 * @throws InvalidItemNameException | Exception related to an invalid blank Item's name
	 */
	public void setName(String name) throws InvalidItemNameException {
		if (!name.equals("")) { // Checks if the Item's name field hasn't a blank value
			this.name = name;
		} else {
			throw new InvalidItemNameException("The Item's name cannot be blank!");
		}
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
	 * @throws InvalidItemDescriptionException | Exception related to an invalid blank Item's description
	 */
	public void setDescription(String description) throws InvalidItemDescriptionException {
		if (!description.equals("")) { // Checks if the Item's description field hasn't a blank value
			this.description = description;
		} else {
			throw new InvalidItemDescriptionException("The Item's description cannot be blank!");
		}
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
	
	/**
	 * Sets an Item's picking up sound File
	 * @param pickingUpSound | The Item's picking up sound File
	 * @throws InvalidAbsolutePathException | Exception related to the use of an absolute path for files
	 */
	public void setPickingUpSound(File pickingUpSound) throws InvalidAbsolutePathException {
		if (!pickingUpSound.isAbsolute()) { // Checks if the picking up sound File hasn't an absolute path
			this.pickingUpSound = pickingUpSound;
		} else {
			throw new InvalidAbsolutePathException("You can't use an absolute path for your media files!");
		}
	}
	
	/**
	 * Sets an Item's using sound File
	 * @param usingSound | The Item's using sound File
	 * @throws InvalidAbsolutePathException | Exception related to the use of an absolute path for files
	 */
	public void setUsingSound(File usingSound) throws InvalidAbsolutePathException {
		if (!usingSound.isAbsolute()) { // Checks if the using sound File hasn't an absolute path
			this.usingSound = usingSound;
		} else {
			throw new InvalidAbsolutePathException("You can't use an absolute path for your media files!");
		}
		
	}

}
