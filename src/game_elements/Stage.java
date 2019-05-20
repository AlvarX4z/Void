package game_elements;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import exceptions.InvalidAbsolutePathException;
import exceptions.InvalidItemDescriptionException;
import exceptions.InvalidItemMaxLengthException;
import exceptions.InvalidItemMinLengthException;
import exceptions.InvalidItemNameException;
import exceptions.InvalidItemNullButton;
import exceptions.InvalidStageDescriptionException;
import exceptions.InvalidStageNameException;
import graphic_interface.VoidButton;
import graphic_interface.Window;

/**
 * Emulates the Stages' characteristics of the videogame
 * @author Alvaro de Francisco Sanchez
 */
public class Stage {

	// ------------------------------
	// ----- INTERNAL VARIABLES -----
	// ------------------------------

	private Window w;
	private String name; // The Stage's name
	private String description; // The Stage's initial description
	private ArrayList<Item> items; // The Stage's interactive Items
	private ImageIcon pixelArtBackground; // The Stage's background pixel-art image
	public static final File pickingUpSound = new File("./audio/pickingUp.mp3"); // Sound for picking up items by the player
	private static File usingSound; // Sound for using an item in a Stage
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
	 * @param name The Stage's name
	 */
	public Stage(String name) {
		switch (name) { // Checks what's the name of the Stage's Object when the constructor is called
		case "tent": // 1st Stage: The tent
			this.description = "Your name is Randolph Carter.\n"
					+ "You're a citizen of the city of Arkham (Massachusetts) and a History professor specialised in Indian American culture "
					+ "at the Mistakonic University.\n"
					+ "You're currently on vacations and you have decided to spend some time on your favorite hobby: hiking and sleeping in "
					+ "his tent at nature at the Miskatonic Valley.\n\n"
					+ "Thus, this story begins...\n\n"
					+ "------------------------------\n\n"
					+ "Finally! I finished preparing the tent! It's been quite a tiresome task, but I like the result!"
					+ "I guess that I can take a nap while I hear the birds chirping.";
			this.pixelArtBackground = new ImageIcon("./img/1pp.jpg");
			Item birds, tent, flashlight, nap;
			try {
				birds = new Item("Birds", "It is truly amazing and relaxing the sounds these birds have. I could spend a long time just hearing them.", 
						false, new VoidButton("Birds"));
				tent = new Item("Tent", "Quite a strong and well-built tent. I'm very happy about buying it last month.", false, new VoidButton("Tent"));
				flashlight = new Item("Flashlight", "My trustful flashlight. It was an expensive acquisition, but totally worth it", true, 
						new VoidButton("Flashlight"));
				nap = new Item("Take a nap", "Preparing the tent has exhausted me, I should take a nap and wake up in a while...", false, new VoidButton("Take a nap"));
				this.items = new ArrayList<Item>(4);
				items.add(birds);
				items.add(tent);
				items.add(flashlight);
				items.add(nap);
				items.get(0).getButton().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription();
					}
				});


			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException
					| InvalidItemNullButton e) {
				e.getMessage();
			}
			break;
		case "forest": // 2nd Stage: The forest
			break;
		case "house": // 3rd Stage: The first glimpse of the house
			break;
		case "outdoors": // 4th Stage: The house's exterior walls
			break;
		case "entrance": // 5th Stage: The house's main entrance
			break;
		case "hall": // 6th Stage: The house's hall
			break;
		case "attic": // 7th Stage: The house's attic
			break;
		case "lantern": // 8th Stage: The lantern in the attic
			break;
		case "key": // 9th Stage: The key and note inside the lantern
			break;
		case "acolyte": // 10th: The acolyte wandering at the attic
			break;
		case "hall2": // 11th: Coming back to the hall again, this time with the key from the attic
			break;
		case "livingRoom": // 12th: The house's living room
			break;
		case "gun": // 13th: The gun on the table
			break;
		case "painting": // 14th: The strange painting hanging on the living room's wall
			break;
		case "monster": // 15th: The attacking monster
			break;
		case "blackness": // 16th: The player fainted
			break;
		case "eye": // 17th: The player's scared eye image
			break;
		case "beach": // 18th: The player's contemplating the end
			break;
		case "shortEnding": // 19th: The End (the player didn't pick the gun up)
			break;
		case "longEnding": // 20th: The End (the player picked the gun up)
			break;
		}
	}

	/*
		case "inicial":

			VoidButton botonSigPant=New VoidButton(loquetenga);
					botonSIgPant.addMouseListener(
							mouseclicked(){
								window.setStage(new Stage("bosque"));
							}
							)
			Item sigPant=new Item
			this.items=
	 */


	// --------------------------------
	// ----- GETTERS AND SETTERS ------
	// --------------------------------

	/**
	 * Gets a Stage's name
	 * @return The Stage's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a Stage's name
	 * @param name The Stage's name
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
	 * @return The Stage's initial description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets a Stage's initial description
	 * @param description The Stage's initial description
	 * @throws InvalidStageDescriptionException Exception related to an invalid blank Stage's description
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
	 * @return The Stage's items array
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Sets a Stage's items array
	 * @param items The Stage's items array
	 * @throws InvalidItemMaxLengthException Exception threw when surpassing a Stage's maximum length of 5
	 * @throws InvalidItemMinLengthException Exception threw when a Stage's minimum length is 0 or less
	 */
	public void setItems(ArrayList<Item> items) throws InvalidItemMaxLengthException, InvalidItemMinLengthException {
		this.items = items;
	}

	/**
	 * Gets a Stage's pixel-art background ImageIcon
	 * @return The Stage's pixel-art background ImageIcon
	 */
	public ImageIcon getPixelArtBackground() {
		return pixelArtBackground;
	}

	/**
	 * Sets a Stage's pixel-art background ImageIcon
	 * @param pixelArtBackground The Stage's pixel-art background ImageIcon
	 */
	public void setPixelArtBackground(ImageIcon pixelArtBackground) {
		this.pixelArtBackground = pixelArtBackground;
	}
}
