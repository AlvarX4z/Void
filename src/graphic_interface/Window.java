package graphic_interface;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.border.MatteBorder;

import exceptions.InvalidAbsolutePathException;
import exceptions.InvalidItemDescriptionException;
import exceptions.InvalidItemMaxLengthException;
import exceptions.InvalidItemMinLengthException;
import exceptions.InvalidItemNameException;
import exceptions.InvalidStageDescriptionException;
import exceptions.InvalidStageNameException;
import game_elements.Protagonist;
import game_elements.Stage;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

/**
 * Creates the System Window in which the game will be run
 * @author Alvaro de Francisco Sanchez
 */
public final class Window extends JFrame {

	// ------------------------------
	// ----- INTERNAL VARIABLES -----
	// ------------------------------

	private Stage stage; // The Stage to be displayed in the Window
	private Protagonist player; // The main character of the game
	private JPanel buttonsPanel; // A JPane where the interactive buttons are located
	private JEditorPane textPanel; // A EditorPane where the text will be displayed
	private JLabel imageBackground; // A JLabel where the image for each Stage will be shown
	public static final File gameMusic = new File("./audio/terrorMusic.wav"); // Suspense music for the game

	// -----------------------
	// ----- CONSTRUCTOR -----
	// -----------------------

	/**
	 * Window's basic Constructor
	 * @throws InvalidAbsolutePathException Exception related to the use of an absolute path for files
	 * @throws InvalidItemDescriptionException Exception related to an invalid blank Item's description
	 * @throws InvalidItemNameException Exception related to an invalid blank Item's name
	 * @throws InvalidItemMinLengthException Exception threw when a Stage's minimum length is 0 or less
	 * @throws InvalidItemMaxLengthException Exception threw when surpassing a Stage's maximum length of 5
	 * @throws InvalidStageDescriptionException Exception related to an invalid blank Stage's description
	 * @throws InvalidStageNameException Exception related to an invalid blank Stage's name
	 */
	public Window() throws InvalidItemNameException, InvalidItemDescriptionException, InvalidAbsolutePathException, InvalidStageNameException, 
	InvalidStageDescriptionException, InvalidItemMaxLengthException, InvalidItemMinLengthException {

		// ------------------
		// ----- WINDOW -----
		// ------------------

		super(); // Gets the characteristics from the parent Class JFrame
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window
		setUndecorated(true); // Sets the window to Full Screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the program when the Window's X is clicked
		setTitle("Void"); // Window's title
		setIconImage(new ImageIcon("./img/void.png").getImage()); // Window's game icon
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR)); // Sets a crosshair mouse cursor for the Window

		// --------------------
		// ----- MENU BAR -----
		// --------------------

		JMenuBar menuBar = new JMenuBar(); // Creation of the Game's menu bar
		menuBar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY)); // Creates a bottom border for separating the menu from the in-game screen
		menuBar.setBackground(Color.BLACK); // Menu's bar background color
		setJMenuBar(menuBar); // Sets the JMenuBar

		// ------------------------------
		// ----- 'GAME OPTIONS' TAB -----
		// ------------------------------

		JMenu menuGame = new JMenu("Game Options"); // Creation of a tab option which spans several menu items options
		menuGame.setForeground(Color.WHITE); // Menu's tab option font color
		menuGame.setFont(new Font("Ink Free", Font.PLAIN, 20)); // Menu's tab option font family, style and size
		menuBar.add(menuGame); // Sets the JMenu

		// ----------------------
		// ----- MENU ITEMS -----
		// ----------------------

		// ***** NEW GAME ******
		VoidMenuItem menuNewGame = new VoidMenuItem("New Game"); // Creation of a 'New Game' Menu Item
		menuNewGame.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				JOptionPane.showMessageDialog(null, "Option not developed due to lack of time", "Option Not Developed", JOptionPane.INFORMATION_MESSAGE); // Shows an informative Dialog 
			}
		});	
		menuGame.add(menuNewGame); // Adds said Menu Item to the Game Options Menu

		// ***** SAVE GAME ******
		VoidMenuItem menuSaveGame = new VoidMenuItem("Save Game"); // Creation of a 'Save Game' Menu Item
		menuSaveGame.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				// saveGame(); // Saves the current status of the game
				JOptionPane.showMessageDialog(null, "Option not developed due to lack of time", "Option Not Developed", JOptionPane.INFORMATION_MESSAGE); // Shows an informative Dialog 
			}
		});
		menuGame.add(menuSaveGame); // Adds said Menu Item to the Game Options Menu

		// ***** LOAD GAME ******
		VoidMenuItem menuLoadGame = new VoidMenuItem("Load Game"); // Creation of a 'Load Game' Menu Item
		menuLoadGame.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				// loadGame(); // Load a 'Void' game
				JOptionPane.showMessageDialog(null, "Option not developed due to lack of time", "Option Not Developed", JOptionPane.INFORMATION_MESSAGE); // Shows an informative Dialog 
			}
		});
		menuGame.add(menuLoadGame); // Adds said Menu Item to the Game Options Menu

		// ***** KEYBINDINGS ******
		String keybindingsList = "------------------------------------------------\n"
				+ "          GAMEPLAY KEYBINDING\n"
				+ "------------------------------------------------\n"
				+ "Inventory   -   Ctrl+I\n"
				+ "------------------------------------------------\n"
				+ "          OPTIONS KEYBINDINGS\n"
				+ "------------------------------------------------\n"
				+ "New Game   -   Ctrl+N\n"
				+ "Save Game   -   Ctrl+S\n"
				+ "Load Game   -   Ctrl+L\n"
				+ "Keybindings   -   Ctrl+K\n"
				+ "Activate Sound   -   Ctrl+Y\n"
				+ "Deactivate Sound   -   Ctrl+U\n"
				+ "Exit Game   -   Ctrl+E\n"
				+ "------------------------------------------------\n\n"; // Message to be displayed in the Dialog
		VoidMenuItem menuKeybindings = new VoidMenuItem("Keybindings"); // Creation of a 'Keybindings' Menu Item
		menuKeybindings.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				JOptionPane.showMessageDialog(null, keybindingsList, "Keybindings", JOptionPane.INFORMATION_MESSAGE); // Shows the keybindings in a Dialog
			}
		});
		menuGame.add(menuKeybindings); // Adds said Menu Item to the Game Options Menu

		// ***** ACTIVATE SOUND ******
		VoidMenuItem menuActivateSound = new VoidMenuItem("Activate Sound"); // Creation of a 'Deactivate Sound' Menu Item
		menuActivateSound.setForeground(Color.LIGHT_GRAY); // Check Box Menu's Item font color
		menuActivateSound.setFont(new Font("Ink Free", Font.PLAIN, 25)); // Check Box Menu Item font family, style and size
		menuActivateSound.setBackground(Color.BLACK); // Check Box Menu's Item background color
		menuActivateSound.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				soundON(); // Enables the music and SFX sounds
			}
		});
		menuGame.add(menuActivateSound); // Adds said Check Box Menu Item to the Game Options Menu

		// ***** DEACTIVATE SOUND ******
		VoidMenuItem menuDeactivateSound = new VoidMenuItem("Deactivate Sound"); // Creation of a 'Deactivate Sound' Menu Item
		menuDeactivateSound.setForeground(Color.LIGHT_GRAY); // Check Box Menu's Item font color
		menuDeactivateSound.setFont(new Font("Ink Free", Font.PLAIN, 25)); // Check Box Menu Item font family, style and size
		menuDeactivateSound.setBackground(Color.BLACK); // Check Box Menu's Item background color
		menuDeactivateSound.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				soundOFF(); // Disables the music and SFX sounds
			}
		});
		menuGame.add(menuDeactivateSound); // Adds said Check Box Menu Item to the Game Options Menu

		// ***** EXIT ******
		VoidMenuItem menuExit = new VoidMenuItem("Exit"); // Creation of an 'Exit' Menu Item
		menuExit.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				System.exit(EXIT_ON_CLOSE); // Closes the program
			}
		});
		menuGame.add(menuExit); // Adds said Menu Item to the Game Options Menu

		// --------------------------------
		// ----- WINDOW'S KEYBINDINGS -----
		// --------------------------------

		addKeyListener(new KeyAdapter() { // Adds a Key Listener for keyboard input (keybindings)
			@Override
			public void keyPressed(KeyEvent e) { // Function that recognizes when a key is pressed in order to activate the event
				if (e.isControlDown()) { // Checks if the key 'Ctrl' is being pressed down
					switch (e.getKeyCode()) { // Depending on the pressed key, a case will be executed
					case KeyEvent.VK_I: // 'I' key
						JOptionPane.showMessageDialog(null, "Option not developed due to lack of time", "Option Not Developed", JOptionPane.INFORMATION_MESSAGE); // Shows an informative Dialog 
						break;
					case KeyEvent.VK_N: // 'N' key
						JOptionPane.showMessageDialog(null, "Option not developed due to lack of time", "Option Not Developed", JOptionPane.INFORMATION_MESSAGE); // Shows an informative Dialog 
						break;
					case KeyEvent.VK_S: // 'S' key
						saveGame(); // Saves the current status of the game
						break;
					case KeyEvent.VK_L: // 'L' key
						loadGame(); // Load a 'Void' game
						break;
					case KeyEvent.VK_K: // 'K' key
						JOptionPane.showMessageDialog(null, keybindingsList, "Keybindings", JOptionPane.INFORMATION_MESSAGE); // Shows the keybindings in a Dialog
						break;
					case KeyEvent.VK_Y: // 'Y' key
						soundON(); // Enables the music
						break;
					case KeyEvent.VK_U: // 'U' key
						soundOFF(); // Disables the music
						break;
					case KeyEvent.VK_E: // 'E' key
						System.exit(EXIT_ON_CLOSE); // Closes the program
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, 
							"You pressed an unexisting key combination!\nPlease, press the 'Ctrl' key first!\n\n" + keybindingsList + "\n", 
							"Wrong Key Combination", JOptionPane.INFORMATION_MESSAGE); // Shows an informative Dialog about the use of keybindings
				}
			}
		});

		// --------------------------------------
		// ----- GENERAL JPANEL'S STRUCTURE -----
		// --------------------------------------

		JPanel panel = new JPanel(); // A new JPanel's creation for the Window frame
		panel.setBackground(Color.BLACK); // Sets the background's color to black
		panel.setLayout(new BorderLayout()); // Sets a Border Layout to the panel
		add(panel); // Adds the JPanel to the Window frame

		imageBackground = new JLabel(); // A new JLabel's creation for the pixel-art background image

		buttonsPanel = new JPanel(); // A new JLabel's creation for the pixel-art background image

		// ------------------------------------------
		// ----- EAST BUTTON JPANEL'S STRUCTURE -----
		// ------------------------------------------

		textPanel = new JEditorPane(); // A new JEditorPane's creation for the text to be displayed
		textPanel.setBackground(Color.BLACK); // Sets the JEditorPane's background color to black
		textPanel.setEditable(false); // Disables the JEditorPane's edition
		textPanel.setForeground(Color.WHITE); // Sets the JEditorPane's font color to white
		textPanel.setFont(new Font("Ink Free", Font.PLAIN, 28)); // Sets the JEditorPane's font to 'Ink Free', plain style and size 28

		panel.add(imageBackground, BorderLayout.CENTER); // Adds the image to main JPanel
		panel.add(buttonsPanel, BorderLayout.EAST); // Adds the Button JPanel to the main JPanel
		panel.add(textPanel, BorderLayout.SOUTH); // Adds the JEditorPane to the main JPanel

		// -------------------------------
		// ----- WINDOW'S VISIBILITY -----
		// -------------------------------

		this.setContentPane(panel); // Sets the main JPanel to the Window
		Stage stage = new Stage("tent", this); // Creates the first Stage Object
		this.setStage(stage); // Enables the first Stage of the game to be shown due to the setStage function
		setVisible(true); // Makes the window to be visible
	}

	// ---------------------------------
	// ----- METHODS AND FUNCTIONS -----
	// ---------------------------------

	// *************************************************************************************************************
	// ********** THE BELOW FUNCTIONS WERE MEANT TO BE DEVELOPED BUT DUE TO LACK OF TIME THIS COULDN'T BE **********
	// *************************************************************************************************************

	/**
	 * Creates a new 'Void' game
	 */
	public static void newGame() {

	}

	/**
	 * Saves the current status of the game
	 */
	public static void saveGame() {

	}

	/**
	 * Loads a 'Void' save-game
	 */
	public static void loadGame() {

	}

	/**
	 * Turns the music on
	 */
	public static void soundON() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(gameMusic); // AudioInputStream for playing the music
			AudioFormat format = audioStream.getFormat(); // AudioFormat for allowing Java to understand the music's format file
			DataLine.Info info = new DataLine.Info(Clip.class, format); // DataLine for allowing the .wav file to be understood later in a Clip Object
			Clip music = (Clip)AudioSystem.getLine(info); // System's Audio recognizes the file as a music clip
			music.open(audioStream); // Opens the channel to play the music
			music.start(); // Music starts playing
			int infiniteLoop = music.LOOP_CONTINUOUSLY; // This variable keeps the enum value for an infinite loop
			music.loop(infiniteLoop); // States the music's loop
			// music.close(); Closes the channel to stop the music. This is commented because if not music doesn't play
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Turns the music off. This function does not work properly, have to check this later
	 */
	public static void soundOFF() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(gameMusic); // AudioInputStream for playing the music
			AudioFormat format = audioStream.getFormat(); // AudioFormat for allowing Java to understand the music's format file
			DataLine.Info info = new DataLine.Info(Clip.class, format); // DataLine for allowing the .wav file to be understood later in a Clip Object
			Clip music = (Clip)AudioSystem.getLine(info); // System's Audio recognizes the file as a music clip
			music.stop(); // Music stops playing
			music.close(); // Closes the channel to stop the music
			// music.close();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	// *************************************************************************************************************
	// ********** THE ABOVE FUNCTIONS WERE MEANT TO BE DEVELOPED BUT DUE TO LACK OF TIME THIS COULDN'T BE **********
	// *************************************************************************************************************

	/**
	 * Gets a JEditorPane Object
	 * @return A JEditorPane Object
	 */
	public JEditorPane getTextPanel() {
		return textPanel;
	}

	/*
	public void setStage(String stageName) {
		Stage stage;
		if (stageName.equals("")) {
			 stage = new Stage("tent", this); // Creates the first Stage Object
		} else {
			stage = new Stage(stageName, this);
		}
		this.setStage(stage); // Enables the first Stage of the game to be shown due to the setStage function
	}
	 */

	/**
	 * Sets a new Stage for playing the game
	 * @param stage Creates a new Stage
	 */
	public void setStage(Stage stage) {
		buttonsPanel.setLayout(new GridLayout(stage.getItems().size(), 1)); // Creates a Button JPanel for each Stage depending on how many interactive buttons there are
		buttonsPanel.removeAll(); // Removes all buttons from previous Stages
		for (byte i = 0; i < stage.getItems().size(); i++) { // A for loop for iterating the ArrayList<Item>
			buttonsPanel.add(stage.getItems().get(i).getButton()); // Adds each Item Button for each Stage
		}
		textPanel.setText(stage.getDescription()); // Sets the initial Stage's description in the JEditorPane
		imageBackground.setIcon(stage.getPixelArtBackground()); // Sets the Stage's image in the JLabel
		repaint(); // Repaints the window in order to see the changes
	}

}