package graphic_interface;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.border.MatteBorder;

import voidgame.VoidGame;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Creates the System Window in which the game will be run
 * @author Alvaro de Francisco Sanchez
 */
public class Window extends JFrame {

	/**
	 * Window's basic Constructor
	 */
	public Window() {
		
		// ------------------
		// ----- WINDOW -----
		// ------------------

		super(); // Gets the characteristics from the parent Class JFrame
		setSize(new Dimension(1920, 1080)); // Full HD 16:9 resolution
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the program when the Window's X is clicked
		setBackground(Color.BLACK); // Window's default background color
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
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				//TODO PREGUNTAR POR LOS EVENTOS DE ACTION PERFORMED COMO MENU ITEM Y POR QUÉ ME CIERRA EN NEW GAME EN VEZ DE EN EXIT
				VoidGame.newGame(); // Creates a 'Void' new game
			}
		});
		menuGame.add(menuNewGame); // Adds said Menu Item to the Game Options Menu

		// ***** SAVE GAME ******
		VoidMenuItem menuSaveGame = new VoidMenuItem("Save Game"); // Creation of a 'Save Game' Menu Item
		menuSaveGame.addActionListener(new ActionListener() { // Function that creates an action listener
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				//TODO PREGUNTAR POR LOS EVENTOS DE ACTION PERFORMED COMO MENU ITEM Y POR QUÉ ME CIERRA EN NEW GAME EN VEZ DE EN EXIT
				VoidGame.saveGame(); // Saves the current status of the game
			}
		});
		menuGame.add(menuSaveGame); // Adds said Menu Item to the Game Options Menu

		// ***** LOAD GAME ******
		VoidMenuItem menuLoadGame = new VoidMenuItem("Load Game"); // Creation of a 'Load Game' Menu Item
		menuNewGame.addActionListener(new ActionListener() { // Function that creates an action listener
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				//TODO PREGUNTAR POR LOS EVENTOS DE ACTION PERFORMED COMO MENU ITEM Y POR QUÉ ME CIERRA EN NEW GAME EN VEZ DE EN EXIT
				VoidGame.loadGame(); // Load a 'Void' game
			}
		});
		menuGame.add(menuLoadGame); // Adds said Menu Item to the Game Options Menu

		// ***** KEYBINDINGS ******
		VoidMenuItem menuKeybindings = new VoidMenuItem("Keybindings"); // Creation of a 'Keybindings' Menu Item
		menuNewGame.addActionListener(new ActionListener() { // Function that creates an action listener
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				//TODO PREGUNTAR POR LOS EVENTOS DE ACTION PERFORMED COMO MENU ITEM Y POR QUÉ ME CIERRA EN NEW GAME EN VEZ DE EN EXIT
				String keybindingsList = "Inventory\t-\tCtrl+I\n"
						+ "\n---------------------------------\n"
						+ "New Game\t-\tCtrl+N\n"
						+ "Save Game\t-\tCtrl+S\n"
						+ "Load Game\t-\tCtrl+L\n"
						+ "Keybindings\t-\tCtrl+K\n"
						+ "De/Activate Sound\t-\tCtrl+Y\n"
						+ "Exit Game\t-\tEsc\n"; // Message to be displayed in the Dialog
				JOptionPane.showMessageDialog(null, keybindingsList, "Void - Keybindings", JOptionPane.CLOSED_OPTION); // Shows the keybindings in a Dialog
			}
		});
		menuGame.add(menuKeybindings); // Adds said Menu Item to the Game Options Menu

		// ***** DEACTIVATE SOUND ******
		JCheckBoxMenuItem menuSound = new JCheckBoxMenuItem("Deactivate Sound"); // Creation of a 'Deactivate Sound' Menu Item
		menuSound.setForeground(Color.LIGHT_GRAY); // Check Box Menu's Item font color
		menuSound.setFont(new Font("Ink Free", Font.PLAIN, 25)); // Check Box Menu's Item font family, style and size
		menuSound.setBackground(Color.BLACK); // Check Box Menu's Item background color
		menuNewGame.addActionListener(new ActionListener() { // Function that creates an action listener
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				//TODO PREGUNTAR POR LOS EVENTOS DE ACTION PERFORMED COMO MENU ITEM Y POR QUÉ ME CIERRA EN NEW GAME EN VEZ DE EN EXIT
			}
		});
		menuGame.add(menuSound); // Adds said Check Box Menu Item to the Game Options Menu

		// ***** EXIT ******
		VoidMenuItem menuExit = new VoidMenuItem("Exit"); // Creation of an 'Exit' Menu Item
		menuNewGame.addActionListener(new ActionListener() { // Function that creates an action listener
			public void actionPerformed(ActionEvent arg0) { // Menu Item uses as event an 'actionPerformed'
				//TODO PREGUNTAR POR LOS EVENTOS DE ACTION PERFORMED COMO MENU ITEM Y POR QUÉ ME CIERRA EN NEW GAME EN VEZ DE EN EXIT
				System.exit(0); // Closes the program
			}
		});
		menuGame.add(menuExit); // Adds said Menu Item to the Game Options Menu

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
