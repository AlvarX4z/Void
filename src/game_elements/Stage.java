package game_elements;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;

import exceptions.InvalidItemMaxLengthException;
import exceptions.InvalidItemMinLengthException;
import exceptions.InvalidStageDescriptionException;
import exceptions.InvalidStageNameException;

/**
 * Emulates the Stages' characteristics of the videogame
 * @author Alvaro de Francisco Sanchez
 */
public class Stage {

	// ------------------------------
	// ----- INTERNAL VARIABLES -----
	// ------------------------------

	private String name; // The Stage's name
	private String description; // The Stage's initial description
	private ArrayList<Item> items; // The Stage's interactive Items
	private JLabel pixelArtBackground; // The Stage's background pixel-art image
	public static final File menuMusic = new File("./audio/terrorMusic.mp3"); // Suspense music for the main menu
	public static final File birdsSound = new File("./audio/birds.wav"); // Birds chirping sound for the first Stage
	public static final File windHowlingSound = new File("./audio/windHowling.wav"); // Wind howling sound for exteriors
	public static final File doorCreakingSound = new File("./audio/doorCreaking.wav"); // Door creaking sound
	public static final File stairsSound = new File("./audio/stairs.wav"); // Footsteps on stairs sound
	//TODO IMAGEN 7

	// ------------------------
	// ----- CONSTRUCTORS -----
	// ------------------------

	/**
	 * Stage's basic Constructor 
	 * @param name | The Stage's name
	 * @param description | The Stage's initial description
	 * @param items | The Stage's interactive Items
	 * @param pixelArtBackground | The Stage's background pixel-art image
	 * @throws InvalidStageNameException | Exception related to an invalid blank Stage's name
	 * @throws InvalidStageDescriptionException | Exception related to an invalid blank Stage's description
	 * @throws InvalidItemMinLengthException | Exception threw when a Stage's minimum length is 0 or less
	 * @throws InvalidItemMaxLengthException | Exception threw when surpassing a Stage's maximum length of 5 
	 */
	public Stage(String name, String description, ArrayList<Item> items, JLabel pixelArtBackground) throws InvalidStageNameException, 
	InvalidStageDescriptionException, InvalidItemMaxLengthException, InvalidItemMinLengthException {
		super(); // Gets the characteristics from the parent Class VoidPanel
		this.setDescription(description);
		this.setName(name);
		this.setItems(items);
		this.setPixelArtBackground(pixelArtBackground);;
	}

	// --------------------------------
	// ----- GETTERS AND SETTERS ------
	// --------------------------------

	/**
	 * Gets a Stage's name
	 * @return | The Stage's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a Stage's name
	 * @param name | The Stage's name
	 */
	public void setName(String name) {
		if (!name.equals("")) { // Checks if the Stage's name field hasn't a blank value
			this.name = name;
		} else {
			// ***** DUE TO UNKNOWN REASONS, I CANNOT THROW THIS EXCEPTION WITHOUT A TRY/CATCH BLOCK, ECLIPSE COMPLAINTS ABOUT THIS *****
			try {
				throw new InvalidStageNameException("The Stage's name cannot be blank!");
			} catch (InvalidStageNameException ex) {
				ex.getMessage();
			}
		}
	}
	
	/**
	 * Gets a Stage's initial description
	 * @return | The Stage's initial description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets a Stage's initial description
	 * @param description | The Stage's initial description
	 * @throws InvalidStageDescriptionException | Exception related to an invalid blank Stage's description
	 */
	public void setDescription(String description) throws InvalidStageDescriptionException {
		if (!description.equals("")) { // Checks if the Stage's description field hasn't a blank value
			this.description = description;
		} else {
			throw new InvalidStageDescriptionException("The Stage's description cannot be blank!");
		}
		
	}

	/**
	 * Gets a Stage's items array
	 * @return | The Stage's items array
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Sets a Stage's items array
	 * @param items | The Stage's items array
	 * @throws InvalidItemMaxLengthException | Exception threw when surpassing a Stage's maximum length of 5
	 * @throws InvalidItemMinLengthException | Exception threw when a Stage's minimum length is 0 or less
	 */
	public void setItems(ArrayList<Item> items) throws InvalidItemMaxLengthException, InvalidItemMinLengthException {
		this.items = items;
	}

	/**
	 * Gets a Stage's pixel-art background JLabel
	 * @return | The Stage's pixel-art background JLabel
	 */
	public JLabel getPixelArtBackground() {
		return pixelArtBackground;
	}

	/**
	 * Sets a Stage's pixel-art background JLabel
	 * @param pixelArtBackground | The Stage's pixel-art background JLabel
	 */
	public void setPixelArtBackground(JLabel pixelArtBackground) {
		this.pixelArtBackground = pixelArtBackground;
	}
}
