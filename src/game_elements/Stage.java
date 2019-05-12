package game_elements;

import java.io.File;

import javax.swing.JLabel;

import graphic_interface.VoidPanel;

/**
 * Emulates the Stages' characteristics of the videogame
 * @author Alvaro de Francisco Sanchez
 */
public class Stage extends VoidPanel {

	// ------------------------------
	// ----- INTERNAL VARIABLES -----
	// ------------------------------

	private String name; // The Stage's name
	private Item[] items; // The Stage's interactive Items
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
	 * @param items | The Stage's interactive Items
	 * @param pixelArtBackground | The Stage's background pixel-art image
	 */
	public Stage(String name, Item[] items, JLabel pixelArtBackground) {
		super();
		this.name = name;
		this.items = items;
		this.pixelArtBackground = pixelArtBackground;
	}

	// --------------------------------
	// ----- GETTERS AND SETTERS ------
	// --------------------------------


}
