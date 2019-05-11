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

	private String name;
	private Item[] items;
	private JLabel pixelArtBackground;
	private File music;

	// ------------------------
	// ----- CONSTRUCTORS -----
	// ------------------------

	/**
	 * Stage's basic Constructor 
	 * @param name
	 * @param items
	 * @param pixelArtBackground
	 * @param music
	 */
	public Stage(String name, Item[] items, JLabel pixelArtBackground, File music) {
		super();
		this.name = name;
		this.items = items;
		this.pixelArtBackground = pixelArtBackground;
		this.music = music;
	}

	// -------------------------
	// ----- CONSTRUCTORS ------
	// -------------------------


}
