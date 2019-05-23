package game_elements;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

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

	private Window window; // The Window Class in which a Stage will be running
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
	 * @param window The Window Class in which a Stage will be running
	 */
	public Stage(String name, Window window) {
		this.window = window; // Links the window parameter to the Stage's internal variable
		switch (name) { // Checks what's the name of the Stage's Object when the constructor is called
		case "tent":
			// ******************************************
			// ********** 1ST STAGE - THE TENT **********
			// ******************************************
			this.description = "Your name is Randolph Carter.\n"
					+ "You're a citizen of the city of Arkham (Massachusetts) and a History professor specialised in Indian American culture at the Mistakonic "
					+ "University.\n"
					+ "You're currently on vacations and you have decided to spend some time on your favorite hobby: hiking and sleeping in his tent at nature at "
					+ "the Miskatonic Valley.\n\n"
					+ "Thus, this story begins...\n\n"
					+ "------------------------------\n\n"
					+ "Finally! I've finished preparing the tent! It's been quite a tiresome task, but I like the result!\n"
					+ "I guess that I can take a nap while I hear the birds chirping."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/1p.jpg"); // Setting the Stage's pixel-art background
			Item birds, tent, flashlight, nap; // Declaring the Stage's Items
			try {
				birds = new Item("Birds", "It's truly amazing and relaxing the sounds these birds have. I could spend all the afternoon just hearing them.", 
						false, new VoidButton("Birds")); // Initializing this Stage's first Item
				tent = new Item("Tent", "Quite a strong and well-built tent. I'm very happy about buying it last month.", false, new VoidButton("Tent")); // Initializing this Stage's second Item
				flashlight = new Item("Flashlight", "My trustful flashlight. It was an expensive acquisition, but totally worth it. I'm gonna keep it with me.\n\n"
						+ "Preparing the tent has exhausted me, I should take a nap and wake up in a while...",
						true, new VoidButton("Flashlight")); // Initializing this Stage's third Item
				nap = new Item("Take a nap", " ", false, new VoidButton("Take a nap")); // Initializing this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(birds);
				items.add(tent); 
				items.add(flashlight); 
				items.add(nap); 
				// ***** 1ST ITEM - BIRDS *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Birds' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - TENT *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Tent' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - FLASHLIGHT *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Flashlight' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 4TH ITEM - TAKE A NAP *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Take a nap' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("forest", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "forest": 
			// ********************************************
			// ********** 2ND STAGE - THE FOREST **********
			// ********************************************
			this.description = "Hmmmmm, it looks like I slept more than I wanted to.\n\n"
					+ "It seems to be darker than it should be at this time and there are no noises coming from the forest.\n"
					+ "And why is there mist? It's getting colder and I've got a strange feeling, I'd better take the path and "
					+ "go to my car to pick my jacket up."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/2p.jpg"); // Setting the Stage's pixel-art background
			Item mist, birdsForest, feelingForest, getCar; // Declaring the Stage's Items
			try {
				mist = new Item("Mist", "It isn't the proper season for mists in this area and it makes me feel... unease.", false, 
						new VoidButton("Mist")); // Initializing this Stage's first Item
				birdsForest = new Item("Birds?", "There aren't any noises from the sparrows and swallows, a very strange fact in this forest.", 
						false, new VoidButton("Birds?")); // Initializing this Stage's second Item
				feelingForest = new Item("Feeling", "I don't know exactly why, but I've got a strange feeling about this place.\n\n"
						+ "I should hurry and get to my car before it gets even darker and makes my way harder.", false, 
						new VoidButton("Feeling")); // Initializing this Stage's third Item
				getCar = new Item("Get to the car", " ", false, new VoidButton("Get to the car")); // Initializing this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(mist); 
				items.add(birdsForest); 
				items.add(feelingForest); 
				items.add(getCar);
				// ***** 1ST ITEM - MIST *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Mist' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - BIRDS? *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Birds?' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - FEELING *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Feeling' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 4TH ITEM - GET TO THE CAR *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Get to the car' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("house", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "house": 
			// ****************************************************************
			// ********** 3RD STAGE - THE HOUSE SEEN FROM THE FOREST **********
			// ****************************************************************
			this.description = "Damn, the moon's up and I lost my way to the car. I've been already wandering for 30 minutes.\n"
					+ "Ouch! I tripped onto something and I fell down...\n\n"
					+ "Hmmm? Why is there a pavimented path here?\n"
					+ "Maybe it leads to some interesting place, best chances are I'll find someone who can help me.\n\n"
					+ "------------------------------\n\n"
					+ "Finally! There seems to be a house with a light coming from the attic's window. I must get closer!"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/3p.jpg"); // Setting the Stage's pixel-art background
			Item pavimentedPath, darkness, light, headHouse; // Declaring the Stage's Items
			try {
				pavimentedPath = new Item("Pavimented Path", "A stone pavimented path. It may look odd, but this path feels like it "
						+ "doesn't belong to this forest.", false, new VoidButton("Pavimented Path")); // Initializing this Stage's first Item
				darkness = new Item("Darkness", "The forest trully gets scarier at night. I wonder if this could be more dangerous than I've "
						+ "first ever thought...", false, new VoidButton("Darkness")); // Initializing this Stage's second Item
				light = new Item("Light", "When I look at the light, I feel like something is urging me to get closer to it.\n\n"
						+ "The house's still far from where I stand, but I'd say it looks like an old mountain cabin. That "
						+ "place is my goal right now.", false, new VoidButton("Light")); // Initializing this Stage's third Item
				headHouse = new Item("Head to the house", " ", false, new VoidButton("Head to the house")); // Initializing this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(pavimentedPath); 
				items.add(darkness); 
				items.add(light); 
				items.add(headHouse);
				// ***** 1ST ITEM - PAVIMENTED PATH *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Pavimented Path' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - DARKNESS *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Darkness' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - LIGHT *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Light' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 4TH ITEM - HEAD TO THE HOUSE *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Head to the house' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("outdoors", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "outdoors": 
			// ******************************************************
			// ********** 4TH STAGE - THE HOUSE'S OUTDOORS **********
			// ******************************************************
			this.description = "I was right! It's an old cabin after all... Very old, indeed.\n\n"
					+ "The house seems to be abandoned for a very long time and there aren't any lights except for the "
					+ "attic's one.\n"
					+ "I probably should head to the entrance and see if there's someone at this place..."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/4p.jpg"); // Setting the Stage's pixel-art background
			Item wall, windows, lookForEntrance; // Declaring the Stage's Items
			try {
				wall = new Item("Wall", "This wall looks pretty damaged and abandoned for a long time. There are breaches on the stone and "
						+ "mold on it.", false, new VoidButton("Wall")); // Initializing this Stage's first Item
				windows = new Item("Windows", "These windows are as damaged as the walls... The glass is either broken or dirty.\n\n"
						+ "I believe this house's entrance is over there. Let's check it.", false, new VoidButton("Windows")); // Initializing this Stage's second Item
				lookForEntrance = new Item("Look for the entrance", " ", false, new VoidButton("Look for the entrance")); // Initializing this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(wall); 
				items.add(windows); 
				items.add(lookForEntrance); 
				// ***** 1ST ITEM - WALL *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Wall' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - WINDOWS *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Windows' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - LOOK FOR THE ENTRANCE *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Look for the Entrance' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("entrance", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "entrance":
			// ******************************************************
			// ********** 5TH STAGE - THE HOUSE'S ENTRANCE **********
			// ******************************************************
			this.description = "I've found the entrance! Although there's no door to knock on it and it's pitch black. I "
					+ "did the right thing picking my flashlight up before at my tent...\n\n"
					+ "Hmmm, I guess I can shout if there's someone in here before coming in."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/5p.jpg"); // Setting the Stage's pixel-art background
			Item threshold, shout, comeIn; // Declaring the Stage's Items
			try {
				threshold = new Item("Threshold", "Definitely there was once a door here... Hmmm? Irregular wood pieces? Looks like the "
						+ "door was smashed somehow?", false, new VoidButton("Threshold")); // Initializing this Stage's first Item
				shout = new Item("Shout", "\t- Hello? Anyone here? I got lost in the forest and saw this place! May I come in?\n\n"
						+ "No response from anyone. What I expected.\n\n"
						+ "Well, time to come in. Glad I have my flashlight with me!", false, new VoidButton("Shout")); // Initializing this Stage's second Item
				comeIn = new Item("Come in", " ", false, new VoidButton("Come in")); // Initializing this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(threshold); 
				items.add(shout); 
				items.add(comeIn); 
				// ***** 1ST ITEM - THRESHOLD *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Threshold' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - SHOUT *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Shout' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - COME IN *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Come in' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("hall", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "hall": 
			// ***********************************************************
			// ********** 6TH STAGE - THE HOUSE'S HALL - PART 1 **********
			// ***********************************************************
			this.description = "Inside the house looks no better than its outdoors. The place seems to be built out of wood, rotten now.\n\n"
					+ "I can see a door to my left and some stairs at the end of this hall. There are a lot of debris impending my way downstairs.\n"
					+ "If I want to use the stairs, upstairs' the only way."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/6p.jpg"); // Setting the Stage's pixel-art background
			Item door, lightStairs, upstairs; // Declaring the Stage's Items
			try {
				door = new Item("Door", "A wooden locked door. I can see there's a keyhole under the pommel. Maybe is there a key somewhere?",
						false, new VoidButton("Door")); // Initializing this Stage's first Item
				lightStairs = new Item("Light", "The light at the hall's end... That must be the light coming from the attic I saw before!\n\n"
						+ "The wooden steps seem to be rotten as well. I must be careful... I could injure myself while going upstairs.", 
						false, new VoidButton("Light")); // Initializing this Stage's second Item
				upstairs = new Item("Go upstairs", " ", false, new VoidButton("Go upstairs")); // Initializing this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(door); 
				items.add(lightStairs); 
				items.add(upstairs); 
				// ***** 1ST ITEM - DOOR *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Door' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - LIGHT *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Light' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - GO UPSTAIRS *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Go upstairs' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("attic", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "attic":
			// ***************************************
			// ********** 7TH STAGE - ATTIC **********
			// ***************************************
			this.description = "\t*Cough* *Cough*\n\n"
					+ "This attic is dust-filled! It's hard to breathe in here without coughing.\n"
					+ "Hmmm? The light at the end has faded out? I should check what's in there."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/7p.jpg"); // Setting the Stage's pixel-art background
			Item dust, floor, checkLight; // Declaring the Stage's Items
			try {
				dust = new Item("Dust", "This dust confirms that nobody's been here for a long, long time...", false, 
						new VoidButton("Dust")); // Initializing this Stage's first Item
				floor = new Item("Floor", "Are there dustless areas on the floor? And... with a foot's shape? Was there "
						+ "recently someone up here after all...?\n\n"
						+ "All right, let's just focus in unraveling the light's mistery.", false, new VoidButton("Floor")); // Initializing this Stage's second Item
				checkLight = new Item("Check light", " ", false, new VoidButton("Check light")); // Initializing this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(dust); 
				items.add(floor); 
				items.add(checkLight); 
				// ***** 1ST ITEM - DUST *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Dust' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - FLOOR *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Floor' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - CHECK LIGHT *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Check light' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("lantern", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "lantern": 
			// *****************************************
			// ********** 8TH STAGE - LANTERN **********
			// *****************************************
			this.description = "There's a brush and a lantern on this carpet-covered box. Could this lantern be turned on just a "
					+ "moment ago?"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/8p.jpg"); // Setting the Stage's pixel-art background
			Item carpet, brush, touchLantern, examineKey; // Declaring the Stage's Items
			try {
				carpet = new Item("Carpet", "This carpet covers this big box, but dust surely covers this carpet.", false, 
						new VoidButton("Carpet")); // Initializing this Stage's first Item
				brush = new Item("Brush", "Such an odd object at this place. Nothing remarkable about it.", false, 
						new VoidButton("Brush")); // Initializing this Stage's second Item
				touchLantern = new Item("Touch lantern", "Was this turned on just bef...?\n\n"
						+ "OUCH! It's very hot to be touched by my bare hand!\n"
						+ "Wait... when I touched it, I noticed that there's something metallic and loose inside "
						+ "the lantern. I wonder if I should smash it...\n\n"
						+ "Let's see what's inside!\n\n"
						+ "\t*CRUSH*\n\n"
						+ "Look at this! A key!", false, new VoidButton("Touch lantern")); // Initializing this Stage's third Item
				examineKey = new Item("Examine the key", " ", true, new VoidButton("Examine the key")); // Initializing this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(carpet); 
				items.add(brush); 
				items.add(touchLantern); 
				items.add(examineKey); 
				// ***** 1ST ITEM - CARPET *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Carpet' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - BRUSH *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Brush' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - TOUCH LANTERN *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Touch lantern' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 4TH ITEM - EXAMINE THE KEY *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Examine the key' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("key", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "key": 
			// ************************************************
			// ********** 9TH STAGE - KEY AND LETTER **********
			// ************************************************
			this.description = "There's a key inside the smashed lantern! And... a letter? How hasn't this got burned by the "
					+ "lantern?\n\n"
					+ "Pretty odd... What's written?"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/9p.jpg"); // Setting the Stage's pixel-art background
			Item key, letter, hide; // Declaring the Stage's Items
			try {
				key = new Item("Key", "A little rusted iron key. Why isn't the key hot as the lantern?\n"
						+ "Anyway, I bet this key opens the door I discovered in the hall downstairs. I'm sure it's worth a shot.", 
						true, new VoidButton("Key")); // Initializing this Stage's first Item
				letter = new Item("Letter", "This letter is not burned, but a little charred... There's still a legible part...\n\n"
						+ "\t... the Old God ....................\n"
						+ "\t................ we're nothing ....\n"
						+ "\tawakening ...........................\n\n"
						+ "What? This letter makes no sense! I don't understand its meaning!\n"
						+ "Hmmmm? Do I hear something?\n\n"
						+ "That noise... sounds like footsteps!!\n"
						+ "I must hide behind the box, I don't know if it's someone friendly after all I've seen in here.", false, 
						new VoidButton("Letter")); // Initializing this Stage's second Item
				hide = new Item("Hide", " ", false, new VoidButton("Hide")); // Initializing this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(key); 
				items.add(letter); 
				items.add(hide); 
				// ***** 1ST ITEM - KEY *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Key' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - LETTER *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Letter' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - HIDE *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Hide' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("acolyte", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}	
			break;
		case "acolyte": 
			// **********************************************
			// ********** 10TH STAGE - THE ACOLYTE **********
			// **********************************************
			this.description = "I didn't expect someone wearing a robe and chanting some sinister chores...\n"
					+ "What is he saying?\n\n"
					+ "\tPh'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn\n\n"
					+ "This is insane! He must be mad and he could be dangerous. I should avoid him, but how can I "
					+ "sneak downstairs...?\n\n"
					+ "\t*CAW* *CAW*\n\n"
					+ "Hmmm? Is that a crow?"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/10p.jpg"); // Setting the Stage's pixel-art background
			Item acolyte, crow, sneak; // Declaring the Stage's Items
			try {
				acolyte = new Item("Acolyte", "A mad man chanting in some strange language. I wonder what he's saying...", false, 
						new VoidButton("Acolyte")); // Initializing this Stage's first Item
				crow = new Item("Crow", "The bird I saw seems to be a big crow. It's landed on the windowsill and the "
						+ "acolyte looks at it trully fascinated.\n\n"
						+ "This is my chance to sneak from this place out!\n"
						+ "I must remain in silence and be careful. I can do this!", false, new VoidButton("Crow")); // Initializing this Stage's second Item
				sneak = new Item("Sneak out", " ", false, new VoidButton("Sneak out")); // Initializing this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(acolyte); 
				items.add(crow); 
				items.add(sneak); 
				// ***** 1ST ITEM - ACOLYTE *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Acolyte' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - CROW *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Crow' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - SNEAK OUT *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Sneak out' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("hall2", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}	
			break;
		case "hall2": 
			// ************************************************************
			// ********** 11TH STAGE - THE HOUSE'S HALL - PART 2 **********
			// ************************************************************
			this.description = "That was close! The acolyte didn't notice me and I hope he doesn't come downstairs.\n"
					+ "I must hurry and try to open the locked door!"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/6p.jpg"); // Setting the Stage's pixel-art background
			Item chanting, lock, openDoor; // Declaring the Stage's Items
			try {
				chanting = new Item("Chanting", "The acolyte's still upstairs, I can hear his chanting. I should avoid getting near the stairs at any cost!", 
						false, new VoidButton("Chanting")); // Initializing this Stage's first Item
				lock = new Item("Lock", "I knew it! The key I picked up before fits perfectly in. Now I can open the door!\n\n"
						+ "I hope it doesn't make any cracking noises at all while opening it...",false, new VoidButton("Lock")); // Initializing this Stage's second Item
				openDoor = new Item("Open the door", " ", false, new VoidButton("Open the door")); // Initializing this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(chanting); 
				items.add(lock); 
				items.add(openDoor); 
				// ***** 1ST ITEM - CHANTING *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Chanting' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - LOCK *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Lock' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - OPEN THE DOOR *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Open the door' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("livingRoom", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}	
			break;
		case "livingRoom": 
			// **************************************************
			// ********** 12TH STAGE - THE LIVING ROOM **********
			// **************************************************
			this.description = "This place looks like a living room and it's quite different from the rest of this dismal house.\n"
					+ "It even feels warmer... Maybe was the acolyte here all this time while I was exploring the house?\n"
					+ "I should explore and see what I can find..."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/12p.jpg"); // Setting the Stage's pixel-art background
			Item livingRoom, candelabrum, clock, checkTable; // Declaring the Stage's Items
			try {
				livingRoom = new Item("Living room", "This room of the house isn't dilapidated as the rest and it even "
						+ "looks from... another century?\n"
						+ "These pieces of furniture and the painted walls aren't contemporary, that's for sure.", false, 
						new VoidButton("Living room")); // Initializing this Stage's first Item
				candelabrum = new Item("Candelabrum", "A metallic candelabrum with five lighted, non-consumed candles on it.\n"
						+ "This helps me to get a warmer feeling.", false, new VoidButton("Candelabrum")); // Initializing this Stage's second Item
				clock = new Item("Clock", "Such a very old, elegant and fascinating clock. It looks polished and new, but how "
						+ "can that be possible?\n"
						+ "I just noticed it isn't ticking the time, that's strange... and its hands stopped at the 2:06 time?\n\n"
						+ "I wish I could take this to my house!\n\n"
						+ "There's a little wooden table at the clock's left side. It's worth to check if there's something on it.", false, 
						new VoidButton("Clock")); // Initializing this Stage's third Item
				checkTable = new Item("Check the table", " ", false, new VoidButton("Check the table")); // Initializing this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(livingRoom); 
				items.add(candelabrum); 
				items.add(clock); 
				items.add(checkTable); 
				// ***** 1ST ITEM - LIVING ROOM *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Living room' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - CANDELABRUM *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Candelabrum' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - CLOCK *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Clock' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 4TH ITEM - CHECK THE TABLE *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Check the table' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("pistol", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "pistol": 
			// *********************************************
			// ********** 13TH STAGE - THE PISTOL **********
			// *********************************************
			this.description = "There seems to be a blanket covering something under it. I wonder what's there beneath it...\n\n"
					+ "A SKULL?! I hope it's a fake one... And what do I have here?"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/13p.jpg"); // Setting the Stage's pixel-art background
			Item skull, bottle, map, checkPainting; // Declaring the Stage's Items
			try {
				skull = new Item("Skull", "Damn, after examining the skull, I discovered it isn't fake, but a real one...\n"
						+ "Did that acolyte killed someone? Maybe someone lost in the forest like me...?\n\n"
						+ "I must stop thinking about this and focus!", false, new VoidButton("Skull")); // Initializing this Stage's first Item
				bottle = new Item("Bottle", "An elegant glass bottle. I wonder what liquid is contained in it, though it looks like alcohol.\n\n"
						+ "\t*SNIFF* *SNIFF*\n\n"
						+ "This liquor is an old rum! Not very frequent to see in Arkham.", false, new VoidButton("Bottle")); // Initializing this Stage's second Item
				map = new Item("Read map", "Under the skull I can find an old map. I must be careful with the paper's status as it's very fragile.\n"
						+ "Hmmm... It pinpoints to a small island in the Pacific Ocean called Ponapé... There seems to be an almost unredable "
						+ "description in Spanish:\n\n"
						+ "\t'... La expedición de Alonso de Salazar en 1526 falleció al acercarse a las coordenadas donde"
						+ "se encontraba la hundida ciudad de R'lyeh ...\n"
						+ "\t... La codiciosa búsqueda de tesoros en alta mar desencadenó la ira del Dios Antiguo ...'\n\n"
						+ "My Spanish is very rusted, but I believe that I can figure the main meaning out...\n"
						+ "... Something about an expedition, a sunken city and an Old God? ...\n\n"
						+ "There's an old flintlock pistol on the map. It looks like one from the 16th century.\n"
						+ "It's in a pretty new shape and... \n\n"
						+ "\t*SNIFF SNIFF*\n\n"
						+ "The gun's loaded, I can tell this from the smell. I'd better pick it up, it could be useful...\n\n"
						+ "Oh! There's a painting on the wall above the table!", false, 
						new VoidButton("Read map")); // Initializing this Stage's third Item
				checkPainting = new Item("Check painting", " ", true, new VoidButton("Check painting")); // Initializing this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(skull); 
				items.add(bottle); 
				items.add(map); 
				items.add(checkPainting); 
				// ***** 1ST ITEM - SKULL *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Skull' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - BOTTLE *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Bottle' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - MAP *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Map' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 4TH ITEM - CHECK PAINTING *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Check painting' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("painting", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "painting": 
			// ***********************************************
			// ********** 14TH STAGE - THE PAINTING **********
			// ***********************************************
			this.description = "What's this image? What depicts the picture...?\n\n"
					+ "I should examine it in detail."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/14p.jpg"); // Setting the Stage's pixel-art background
			Item painting, paintingDescription, rlyeh, turnAround; // Declaring the Stage's Items
			try {
				painting = new Item("Painting", "A painting in such a good condition, although a terrifying image is represented.\n"
						+ "Hmmmm? There's a description carved at the frame's bottom...", false, new VoidButton("Painting")); // Initializing this Stage's first Item
				paintingDescription = new Item("Description", "The description says:\n\n"
						+ "\t'Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn'\n"
						+ "\t'In his house at R'lyeh, dead Cthulhu waits dreaming'\n\n"
						+ "R'lyeh? That's the map's indicated location! May this Cthulhu be the representation of that Old God?"
						, false, 
						new VoidButton("Description")); // Initializing this Stage's second Item
				rlyeh = new Item("R'lyeh", "According to the map, this city is located at the Pacific Ocean... Is this God the sovereign of this forgotten "
						+ "civilization?\n"
						+ "Is it sleeping at this sunken city according to the tale?\n\n"
						+ "May this image be a depicting of said Old God? ... My heart feels at dispared when I look at it..\n"
						+ "It looks like a metaphorical end of life...\n"
						+ "Might it be a Death God for this civilization?\n\n"
						+ "\t*SHRIEK*\n\n"
						+ "What's that screeching I hear in the hall?", false, new VoidButton("R'lyeh")); // Initializing this Stage's third Item
				turnAround = new Item("Turn around", " ", false, new VoidButton("Turn around")); // Initializing this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(painting); 
				items.add(paintingDescription); 
				items.add(rlyeh); 
				items.add(turnAround); 
				// ***** 1ST ITEM - PAINTING *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Painting' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - DESCRIPTION *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Description' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 3RD ITEM - R'LYEH *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'R'lyeh' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 4TH ITEM - TURN AROUND *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Turn around' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("monster", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "monster": 
			// **********************************************
			// ********** 15TH STAGE - THE MONSTER **********
			// **********************************************
			this.description = "What's that creature!?\n\n"
					+ "What kind of nightmarish being is it!?"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/15p.jpg"); // Setting the Stage's pixel-art background
			Item monster, faint; // Declaring the Stage's Items
			try {
				monster = new Item("Monster", "It has a human shape, but it isn't human at all...\n\n"
						+ "It's about to jump at me and its claws seem very sharp, I must fire the pistol at it!\n\n"
						+ "\t- NO, STAY BACK!!\n\n"
						+ "\t*BANG*\n\n"
						+ "...........\n\n"
						+ "This has exhausted me and I suffer the adrenaline's strain...\n\n "
						+ "I'm... fainting...", false, 
						new VoidButton("Monster")); // Initializing this Stage's first Item
				faint = new Item("Faint", " ", false, new VoidButton("Faint")); // Initializing this Stage's second Item
				this.items = new ArrayList<Item>(2); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(monster);
				items.add(faint);
				// ***** 1ST ITEM - MONSTER *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Monster' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - FAINT *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Faint' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("blackness", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "blackness":
			// ********************************************
			// ********** 16TH STAGE - BLACKNESS **********
			// ********************************************
			this.description = "Mmmmmm... Ohhhh...\n\n"
					+ ".........\n\n"
					+ "My head aches a lot... What's that sound?...\n"
					+ "I should open my eyes and see what happened..."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/16p.jpg"); // Setting the Stage's pixel-art background
			Item sound, eyes; // Declaring the Stage's Items
			try {
				sound = new Item("Sound", "It sounds like the sea's waves... But that cannot be! I'm miles away from the shore!\n"
						+ "... and it sounds like a big mass of water is moving in the water...", false, new VoidButton("Sound")); // Initializing this Stage's first Item
				eyes = new Item("Open eyes", " ", false, new VoidButton("Open eyes")); // Initializing this Stage's second Item
				this.items = new ArrayList<Item>(2); // Initializing the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(sound);
				items.add(eyes);
				// ***** 1ST ITEM - SOUND *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Sound' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						window.getTextPanel().setText(description); // Gets the JEditorPane from the Window and sets the Item's description
						window.repaint(); // Repaints the window in order to show the changes
					}
				});
				// ***** 2ND ITEM - OPEN EYES *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Open eyes' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("revelation", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "revelation":
			// *************************************************
			// ********** 17TH STAGE - THE REVELATION **********
			// *************************************************
			this.description = "Why am I at the shore? This doesn't even look like Massachussets...\n\n"
					+ "WHAT? THIS CAN'T BE REAL!\n"
					+ "IS IT A REAL BEING!? ISN'T IT A TALE!?"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/17p.jpg"); // Setting the Stage's pixel-art background
			Item lookSea; // Declaring the Stage's Items
			try {
				lookSea = new Item("Look at the sea", " ", false, new VoidButton("Look at the sea")); // Initializing this Stage's first Item
				this.items = new ArrayList<Item>(1); // Initializing the Item ArrayList which will hold the previous Items
				items.add(lookSea); // Adding this Stage's Item to its corresponding ArrayList
				// ***** 1ST ITEM - LOOK AT THE SEA *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Look at the sea' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("old one", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "old one":
			// ****************************************************
			// ********** 18TH STAGE - THE GREAT OLD ONE **********
			// ****************************************************
			this.description = "The painting said it was dreaming until now!?\n\n"
					+ ".........\n\n"
					+ "It's doom incarnated... Mankind's nothing against it...\n"
					+ "WE'RE DOOMED!! THE VOID AWAITS US ALL!!"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/18p.jpg"); // Setting the Stage's pixel-art background
			Item faceFate; // Declaring the Stage's Items
			try {
				faceFate = new Item("Face your fate", " ", false, new VoidButton("Face your fate")); // Initializing this Stage's first Item
				this.items = new ArrayList<Item>(1); // Initializing the Item ArrayList which will hold the previous Items
				items.add(faceFate); // Adding this Stage's Item to its corresponding ArrayList
				// ***** 1ST ITEM - FACE YOUR FATE *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Face your fate' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						Stage stage = new Stage("void", window); // Creates the new Stage
						window.setStage(stage); // Sets the new Stage in the Window
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		case "void":
			// *******************************************
			// ********** 19TH STAGE - THE VOID **********
			// *******************************************
			this.description = "Made by Álvaro de Francisco Sánchez\n\n"
					+ "I hope you liked the game!"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/19p.jpg"); // Setting the Stage's pixel-art background
			Item exitGame; // Declaring the Stage's Items
			try {
				exitGame = new Item("Exit game", " ", false, new VoidButton("Exit game")); // Initializing this Stage's first Item
				this.items = new ArrayList<Item>(1); // Initializing the Item ArrayList which will hold the previous Items
				items.add(exitGame); // Adding this Stage's Item to its corresponding ArrayList
				// ***** 1ST ITEM - EXIT GAME *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the 'Exit game' Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0); // Closes the program
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
		}
	}

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