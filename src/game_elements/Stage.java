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

	private Window window;
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
		// ******************************************
		// ********** 1ST STAGE - THE TENT **********
		// ******************************************
		case "tent": 
			this.description = "Your name is Randolph Carter.\n"
					+ "You're a citizen of the city of Arkham (Massachusetts) and a History professor specialised in Indian American culture "
					+ "at the Mistakonic University.\n"
					+ "You're currently on vacations and you have decided to spend some time on your favorite hobby: hiking and sleeping in "
					+ "his tent at nature at the Miskatonic Valley.\n\n"
					+ "Thus, this story begins...\n\n"
					+ "------------------------------\n\n"
					+ "Finally! I finished preparing the tent! It's been quite a tiresome task, but I like the result!"
					+ "I guess that I can take a nap while I hear the birds chirping."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/1p.jpg"); // Setting the Stage's pixel-art background
			Item birds, tent, flashlight, nap; // Declaring the Stage's Items
			try {
				birds = new Item("Birds", "It is truly amazing and relaxing the sounds these birds have. I could spend a long time just hearing them.", 
						false, new VoidButton("Birds")); // Initialising this Stage's first Item
				tent = new Item("Tent", "Quite a strong and well-built tent. I'm very happy about buying it last month.", false, new VoidButton("Tent")); // Initialising this Stage's second Item
				flashlight = new Item("Flashlight", "My trustful flashlight. It was an expensive acquisition, but totally worth it. I'm gonna keep it with me",
						true, new VoidButton("Flashlight")); // Initialising this Stage's third Item
				nap = new Item("Take a nap", "Preparing the tent has exhausted me, I should take a nap and wake up in a while...", false, 
						new VoidButton("Take a nap")); // Initialising this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(birds);
				items.add(tent); 
				items.add(flashlight); 
				items.add(nap); 
				// ***** 1ST ITEM - BIRDS *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Birds Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - TENT *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Tent Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - FLASHLIGHT *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Flashlight Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 4TH ITEM - TAKE A NAP *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Nap Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(3).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						//TODO SET STAGE
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
			// ********************************************
			// ********** 2ND STAGE - THE FOREST **********
			// ********************************************
		case "forest": 
			this.description = "Mmmmmm, it looks like I slept more than I wanted to.\n"
					+ "What is this? It seems to be darker than it should be at this time and there are no noises in the forest.\n"
					+ "And why is this mist forming? It's getting colder and I've got a strange feeling, I'd better take the path and "
					+ "go to my car to pick my jacket up."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/2p.jpg"); // Setting the Stage's pixel-art background
			Item mist, birdsForest, feelingForest, path; // Declaring the Stage's Items
			try {
				mist = new Item("Mist", "It isn't the proper season for mists in this area and it makes me feel... unease.", false, 
						new VoidButton("Mist")); // Initialising this Stage's first Item
				birdsForest = new Item("Birds?", "There aren't any noises from the sparrows and swallows, a very strange fact in this forest.", 
						false, new VoidButton("Birds?")); // Initialising this Stage's second Item
				feelingForest = new Item("Feeling", "I don't know exactly why, but I've got a strange feeling about this place.", false, 
						new VoidButton("Feeling")); // Initialising this Stage's third Item
				path = new Item("Path", "I should hurry and get to my car before it gets any darker and makes my way harder.", false, 
						new VoidButton("Path")); // Initialising this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(mist); 
				items.add(birdsForest); 
				items.add(feelingForest); 
				items.add(path);
				// ***** 1ST ITEM - MIST *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Mist Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - BIRDS? *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Birds? Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - FEELING *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Feeling Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 4TH ITEM - PATH *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Path Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(3).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						//TODO SET STAGE
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
			// ****************************************************************
			// ********** 3RD STAGE - THE HOUSE SEEN FROM THE FOREST **********
			// ****************************************************************
		case "house": 
			this.description = "Damn, it got darker and I lost my way to the car. I've been already wandering for 30 minutes...\n"
					+ "Ouch! I tripped onto something and I fell... Hmmm? Why is there a pavimented path here?\n"
					+ "Maybe it leads to some interesting place, best chance I will find someone who can help me.\n\n"
					+ "------------------------------\n\n"
					+ "Finally! There seems to be a house with a light coming from the attic's window. I've got to get closer!"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/3p.jpg"); // Setting the Stage's pixel-art background
			Item pavimentedPath, darkness, light, house; // Declaring the Stage's Items
			try {
				pavimentedPath = new Item("Pavimented Path", "This is a stone pavimented path. It may look odd, but this path feels like it "
						+ "doesn't belong to this forest.", false, new VoidButton("Pavimented Path")); // Initialising this Stage's first Item
				darkness = new Item("Darkness", "The forest trully gets scarier at night. I wonder if this could be more dangerous than I've "
						+ "first ever thought...", false, new VoidButton("Darkness")); // Initialising this Stage's second Item
				light = new Item("Light", "When I look at the light, I feel like something is urging me to get closer to it.", false, 
						new VoidButton("Light")); // Initialising this Stage's third Item
				house = new Item("House", "The house's still far from where I stand, but I'd say it looks like an old mountain cabin. That "
						+ "place is my goal right now", false, new VoidButton("House")); // Initialising this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(pavimentedPath); 
				items.add(darkness); 
				items.add(light); 
				items.add(house);
				// ***** 1ST ITEM - PAVIMENTED PATH *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Pavimented Path Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - DARKNESS *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Darkness Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - LIGHT *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Light Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 4TH ITEM - HOUSE *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the House Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(3).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
						//TODO SET STAGE
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
			// ******************************************************
			// ********** 4TH STAGE - THE HOUSE'S OUTDOORS **********
			// ******************************************************
		case "outdoors": 
			this.description = "I was right! It's an old cabin after all... Very old, indeed.\n"
					+ "The house seems to be abandoned for a very long time and there aren't any lights except for the "
					+ "attic's one.\n"
					+ "I probably should head to the entrance and see if there is someone at this place...\n\n"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/4p.jpg"); // Setting the Stage's pixel-art background
			Item wall, windows, entrance; // Declaring the Stage's Items
			try {
				wall = new Item("Wall", "This wall looks pretty damaged and abandoned for a long time. There are breaches on the stone and "
						+ "mold on it.", false, new VoidButton("Wall")); // Initialising this Stage's first Item
				windows = new Item("Windows", "These windows are as damaged as the walls... The glass is either broken or dirty.", false, 
						new VoidButton("Windows")); // Initialising this Stage's second Item
				entrance = new Item("Entrance", "I believe that this house's entrance is over there. Let's check it.", false, 
						new VoidButton("Entrance")); // Initialising this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(wall); 
				items.add(windows); 
				items.add(entrance); 
				// ***** 1ST ITEM - WALL *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Wall Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - WINDOWS *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Windows Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - ENTRANCE *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Entrance Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						//TODO SET STAGE
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
			// ******************************************************
			// ********** 5TH STAGE - THE HOUSE'S ENTRANCE **********
			// ******************************************************
		case "entrance":
			this.description = "I've found the entrance! Although there's no door to knock on it and it's pitch black. I "
					+ "did the right thing picking my flashlight up before at my tent...\n"
					+ "Hmmm, I guess I can shout if there's someone in here before coming in.\n"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/5p.jpg"); // Setting the Stage's pixel-art background
			Item threshold, shout, comeIn; // Declaring the Stage's Items
			try {
				threshold = new Item("Threshold", "Definitely there was once a door here... Hmmm? Irregular wood pieces? Looks like the "
						+ "door was smashed somehow?", false, new VoidButton("Threshold")); // Initialising this Stage's first Item
				shout = new Item("Shout", "\t- Hello? Anyone here? I got lost in the forest and discovered this place! May I come in?...\n\n"
						+ "No response from anyone. No surprise either.",  false, new VoidButton("Shout")); // Initialising this Stage's second Item
				comeIn = new Item("Come in", "Well, time to come in. Glad I have my flashlight with me!", false, new VoidButton("Come in")); // Initialising this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(threshold); 
				items.add(shout); 
				items.add(comeIn); 
				// ***** 1ST ITEM - THRESHOLD *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Threshold Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - SHOUT *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Shout Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - COME IN *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Come in Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						//TODO SET STAGE
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
			// ***********************************************************
			// ********** 6TH STAGE - THE HOUSE'S HALL - PART 1 **********
			// ***********************************************************
		case "hall": 
			this.description = "Inside the house looks no better than its outdoors. The place seems to be built out of wood, rotten now.\n"
					+ "I can see a door to my left and some stairs at the end of this hall, though heading downstairs there are a lot of "
					+ "debris impending my way. If I want to use the stairs, I can only go upstairs.\n"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/6p.jpg"); // Setting the Stage's pixel-art background
			Item door, lightStairs, stairs; // Declaring the Stage's Items
			try {
				door = new Item("Door", "A wooden locked door. I can see there's a keyhole under the pommel. Maybe is there a key somewhere?",
						false, new VoidButton("Door")); // Initialising this Stage's first Item
				lightStairs = new Item("Light", "The light at the hall's end... That must be the light coming from the attic I saw before!", 
						false, new VoidButton("Light")); // Initialising this Stage's second Item
				stairs = new Item("Stairs", "The wooden steps seem to be rotten as well. I must be careful going upstairs! It could be very "
						+ "hurtful to fall down in this place.", false, new VoidButton("Stairs")); // Initialising this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(door); 
				items.add(lightStairs); 
				items.add(stairs); 
				// ***** 1ST ITEM - DOOR *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Door Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - LIGHT *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Light Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - STAIRS *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Stairs Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						//TODO SET STAGE
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
			// ***************************************
			// ********** 7TH STAGE - ATTIC **********
			// ***************************************
		case "attic":
			this.description = "*\tCough**Cough*.\n\n"
					+ "This attic is dust-filled! It's hard to breathe in here without coughing.\n"
					+ "Hmmm? The light at the end has faded out? I should check what's in there."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/7p.jpg"); // Setting the Stage's pixel-art background
			Item dust, floor, check; // Declaring the Stage's Items
			try {
				dust = new Item("Dust", "This dust confirms that nobody has been living here for a long, long time...", false, 
						new VoidButton("Dust")); // Initialising this Stage's first Item
				floor = new Item("Floor", "Are there dustless are on the floor? And... with a foot's shape? May it be that "
						+ "there's someone here after all?", false, new VoidButton("Floor")); // Initialising this Stage's second Item
				check = new Item("Check light", "Let's find out what's in there.", false, new VoidButton("Check light")); // Initialising this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(dust); 
				items.add(floor); 
				items.add(check); 
				// ***** 1ST ITEM - DUST *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Dust Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - FLOOR *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Floor Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - CHECK LIGHT *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Check light Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						//TODO SET STAGE
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
			// *****************************************
			// ********** 8TH STAGE - LANTERN **********
			// *****************************************
		case "lantern": 
			this.description = "There's a brush and a lantern on this carpet-covered box. Could this be this lantern turned on just a "
					+ "moment ago?\n"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/8p.jpg"); // Setting the Stage's pixel-art background
			Item carpet, brush, touchLantern, smashLantern; // Declaring the Stage's Items
			try {
				carpet = new Item("Carpet", "This carpet covers this big box, but dust surely covers this carpet.", false, 
						new VoidButton("Carpet")); // Initialising this Stage's first Item
				brush = new Item("Brush", "Such an odd object in this place. Nothing remarkable about it.", false, 
						new VoidButton("Brush")); // Initialising this Stage's second Item
				touchLantern = new Item("Touch lantern", "Was this turned on just bef...?\n\n"
						+ "OUCH! It's very hot to be touched by my bare hand!\n"
						+ "Hmmm, when I touched it, I noticed that there's something metallic and loose inside "
						+ "the lantern. I wonder if I should smash it...", false, new VoidButton("Touch lantern")); // Initialising this Stage's third Item
				smashLantern = new Item("Smash lantern", "Let's see what's inside!\n\n"
						+ "*CRUSH*\n\nLook at this! A key!", true, new VoidButton("Smash light")); // Initialising this Stage's fourth Item
				this.items = new ArrayList<Item>(4); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(carpet); 
				items.add(brush); 
				items.add(touchLantern); 
				items.add(smashLantern); 
				// ***** 1ST ITEM - CARPET *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Carpet Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - BRUSH *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Brush Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - TOUCH LANTERN *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Touch lantern Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 4TH ITEM - SMASH LANTERN *****
				items.get(3).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Smash lantern Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						//TODO SET STAGE
						description = items.get(3).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}
			break;
			// ************************************************
			// ********** 9TH STAGE - KEY AND LETTER **********
			// ************************************************
		case "key": 
			this.description = "There's a key inside the smashed lantern! And... a letter? How hasn't this got burned by the "
					+ "lantern?\nPretty odd, let's see what I can find out."; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/9p.jpg"); // Setting the Stage's pixel-art background
			Item key, letter, footsteps; // Declaring the Stage's Items
			try {
				key = new Item("Key", "A little rusted iron key. Why isn't the key hot as the lantern?...\n"
						+ "Anyways, I bet this key opens the door I discovered in the hall downstairs. I'm sure it's worth a shot", 
						true, new VoidButton("Key")); // Initialising this Stage's first Item
				letter = new Item("Letter", "This letter is not burned, but a little charred... There's still a legible part...\n\n"
						+ "\t... our God ...\n\t................ we're nothing ...\n\twill return soon .....................\n\n"
						+ "What? This letter makes no sense. I don't get the meaning of this!\n"
						+ "Hmmmm? Do I hear something?", false, new VoidButton("Letter")); // Initialising this Stage's second Item
				footsteps = new Item("Footsteps", "That noise... sounds like footsteps!\n"
						+ "I must hide behind the box, I don't know if it's someone friendly after all I've seen\n", false, 
						new VoidButton("Footsteps")); // Initialising this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(key); 
				items.add(letter); 
				items.add(footsteps); 
				// ***** 1ST ITEM - KEY *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Key Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - LETTER *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Letter Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - FOOTSTEPS *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Footsteps Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						//TODO SET STAGE
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}	
			break;
			// **********************************************
			// ********** 10TH STAGE - THE ACOLYTE **********
			// **********************************************
		case "acolyte": 
			this.description = "WHAT? I didn't expect someone wearing a robe and chanting some sinister chores...\n"
					+ "What is he saying?\n\n"
					+ "\t'Ph'nglui mglw'nafh Cthulhu R'lyeh wgah'nagl fhtagn'\n\n"
					+ "This is insane! He must be mad and he could be dangerous. I should avoid him, but how can I "
					+ "sneak downstairs...?\n"
					+ "Hmmm? Is that a crow?"; // Stage's context to be displayed in the JEditorPane
			this.pixelArtBackground = new ImageIcon("./img/10p.jpg"); // Setting the Stage's pixel-art background
			Item acolyte, crow, sneak; // Declaring the Stage's Items
			try {
				acolyte = new Item("Acolyte", "A mad man chanting in some strange language. I wonder what he's saying...\n", false, 
						new VoidButton("Acolyte")); // Initialising this Stage's first Item
				crow = new Item("Crow", "The bird I saw seems to be a big crow. It has landed on the windowsill and the "
						+ "acolyte looks at it truly fascinated and absorted.\n"
						+ "This is my chance to sneak from this place out!", false, new VoidButton("Crow")); // Initialising this Stage's second Item
				sneak = new Item("Sneak out", "I must remain in silence and be careful. I can do this!", false, 
						new VoidButton("Sneak out")); // Initialising this Stage's third Item
				this.items = new ArrayList<Item>(3); // Initialising the Item ArrayList which will hold the previous Items
				// Adding this Stage's Item to its corresponding ArrayList
				items.add(acolyte); 
				items.add(crow); 
				items.add(sneak); 
				// ***** 1ST ITEM - ACOLYTE *****
				items.get(0).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Acolyte Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(0).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 2ND ITEM - CROW *****
				items.get(1).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Crow Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						description = items.get(1).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
				// ***** 3RD ITEM - SNEAK OUT *****
				items.get(2).getButton().addMouseListener(new MouseAdapter() { // Mouse Click Event for the Sneak out Button Item
					@Override
					public void mouseClicked(MouseEvent e) {
						//TODO SET STAGE
						description = items.get(2).getDescription(); // Stage's context to be displayed in the JEditorPane after clicking the Item's Button
					}
				});
			} catch (InvalidItemNameException | InvalidItemDescriptionException | InvalidAbsolutePathException | InvalidItemNullButton e) { // Catching related exceptions
				e.getMessage(); // Throws the corresponding exception message if a System error has happened
			}	
			break;
			// ************************************************************
			// ********** 11TH STAGE - THE HOUSE'S HALL - PART 2 **********
			// ************************************************************
		case "hall2": 
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
		case "ending": // 19th: The End (the player didn't pick the gun up)
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
