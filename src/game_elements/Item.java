package game_elements;

import exceptions.InvalidAbsolutePathException;
import exceptions.InvalidItemDescriptionException;
import exceptions.InvalidItemNameException;
import exceptions.InvalidItemNullButton;
import graphic_interface.VoidButton;

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
	private boolean interactive; // If the item is interactive (can be picked up or used): TRUE if it is, FALSE if it isn't
	private VoidButton button; // The Item's related button

	// -------------------------
	// ----- CONSTRUCTORS ------
	// -------------------------

	/**
	 * Item's basic Constructor
	 * @param name Item's name
	 * @param description Item's description 
	 * @param interactive If the item is interactive: TRUE if it is, FALSE if it isn't
	 * @param button The Item's related button
	 * @param pickingUpSound Sound file for picking up items. Null if the item isn't meant to be picked up
	 * @param usingSound Sound file for using items. Null if the item isn't meant to be used
	 * @throws InvalidItemNameException Exception related to an invalid blank Item's name
	 * @throws InvalidItemDescriptionException Exception related to an invalid blank Item's description
	 * @throws InvalidAbsolutePathException Exception related to the use of an absolute path for files
	 * @throws InvalidItemNullButton Exception related to an invalid blank Item's button
	 */
	public Item(String name, String description, boolean interactive, VoidButton button) throws InvalidItemNameException, InvalidItemDescriptionException, 
	InvalidAbsolutePathException, InvalidItemNullButton {
		this.setName(name);
		this.setDescription(description);
		this.setInteractive(interactive); // If the item is interactive: TRUE if it is, FALSE if it isn't
		this.setButton(button);
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
	 * @param name The Item's name
	 * @throws InvalidItemNameException Exception related to an invalid blank Item's name
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
	 * @param description The Item's description
	 * @throws InvalidItemDescriptionException Exception related to an invalid blank Item's description
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
	 * @param interactive TRUE if it is interactive, FALSE if it isn't
	 */
	public void setInteractive(boolean interactive) {
		this.interactive = interactive;
	}
	
	/**
	 * Gets an Item's button
	 * @return The Item's button
	 */
	public VoidButton getButton() {
		return button;
	}
	
	/**
	 * Sets an Item's button
	 * @param button The Item's button
	 * @throws InvalidItemNullButton Exception related to an invalid blank Item's button
	 */
	public void setButton(VoidButton button) throws InvalidItemNullButton {
		if (button != null) {
			this.button = button;
		} else {
			throw new InvalidItemNullButton("The Item's button can't be a null value!");
		}
	}

}