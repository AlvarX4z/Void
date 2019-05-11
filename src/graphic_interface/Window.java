package graphic_interface;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.border.MatteBorder;

import voidgame.VoidGame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

/**
 * Creates the System Window in which the game will be run
 * @author Alvaro de Francisco Sanchez
 */
public class Window extends JFrame  {

	// ------------------------------
	// ----- INTERNAL VARIABLES -----
	// ------------------------------
	
	private VoidGame game;

	/**
	 * Window's basic Constructor
	 */
	public Window() {

		// ------------------
		// ----- WINDOW -----
		// ------------------
		super(); // Gets the characteristics from the parent Class JFrame
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window
		setUndecorated(true); // Sets the window to Full Screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the program when the Window's X is clicked
		setTitle("Void"); // Window's title
		setIconImage(new ImageIcon("./img/void.png").getImage()); // Window's game icon

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
				VoidGame.newGame(); // Creates a 'Void' new game
				VoidGame.getPrimeraPantalla();
				VoidGame.siguientePantalla
			}
		});
		menuGame.add(menuNewGame); // Adds said Menu Item to the Game Options Menu

		// ***** SAVE GAME ******
		VoidMenuItem menuSaveGame = new VoidMenuItem("Save Game"); // Creation of a 'Save Game' Menu Item
		menuSaveGame.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				VoidGame.saveGame(); // Saves the current status of the game
			}
		});
		menuGame.add(menuSaveGame); // Adds said Menu Item to the Game Options Menu

		// ***** LOAD GAME ******
		VoidMenuItem menuLoadGame = new VoidMenuItem("Load Game"); // Creation of a 'Load Game' Menu Item
		menuLoadGame.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				VoidGame.loadGame(); // Load a 'Void' game
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
				+ "De/Activate Sound   -   Ctrl+Y\n"
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

		// ***** DEACTIVATE SOUND ******
		JCheckBoxMenuItem menuSound = new JCheckBoxMenuItem("Deactivate Sound"); // Creation of a 'Deactivate Sound' Menu Item
		menuSound.setForeground(Color.LIGHT_GRAY); // Check Box Menu's Item font color
		menuSound.setFont(new Font("Ink Free", Font.PLAIN, 25)); // Check Box Menu Item font family, style and size
		menuSound.setBackground(Color.BLACK); // Check Box Menu's Item background color
		menuSound.addActionListener(new ActionListener() { // Function that creates an action listener
			@Override
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				if (menuSound.getState()) { // Checks if the Check Box Menu Item is checked
					VoidGame.soundON(); // Enables the music and SFX sounds
				} else { 
					VoidGame.soundOFF(); // Disables the music and SFX sounds
				}
			}
		});
		menuGame.add(menuSound); // Adds said Check Box Menu Item to the Game Options Menu

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
						//TODO CONECTAR EL EVENTO A LA FUNCIÓN DE VER EL INVENTARIO
						; // 
						break;
					case KeyEvent.VK_N: // 'N' key
						VoidGame.newGame(); // Creates a 'Void' new game
						break;
					case KeyEvent.VK_S: // 'S' key
						VoidGame.saveGame(); // Saves the current status of the game
						break;
					case KeyEvent.VK_L: // 'L' key
						VoidGame.loadGame(); // Load a 'Void' game
						break;
					case KeyEvent.VK_K: // 'K' key
						JOptionPane.showMessageDialog(null, keybindingsList, "Keybindings", JOptionPane.INFORMATION_MESSAGE); // Shows the keybindings in a Dialog
						break;
					case KeyEvent.VK_Y: // 'Y' key
						if (menuSound.getState()) { // Checks if the Check Box Menu Item is checked
							VoidGame.soundON(); // Enables the music and SFX sounds
						} else { 
							VoidGame.soundOFF(); // Disables the music and SFX sounds
						}
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

		// -------------------------------
		// ----- WINDOW'S VISIBILITY -----
		// -------------------------------

		setVisible(true); // Makes the window to be visible
	}

	/* if(Hay partida de bd) {
			//traigo todos los datos
		}else { //crea partida por defecto
			Objeto candilp1=new Objeto(.bd..bd.)
			Objeto hachap1=new Objeto(.bd..bd.);
			Objeto espadap2=new Objeto(.bd..bd.)
					ArrayList objetosp1= {candilp1,hachap1}
			ArrayList objetosp2= {espadap2}
			Pantalla p1=new Pantalla(objetosp1 , .bd..bd.)
			Pantalla p2= new Pantalla(objetosp2 ..bd..)
			ArrayList pantallas = {p1,p2}
			juego=new VoidGame(personaje,pantallas, ...,0) <-- 0 es la pantalla en el array por la que vas

		}
		this.setContentPane(pantallas[pantallaActual]); */


}
