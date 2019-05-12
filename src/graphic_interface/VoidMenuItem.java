package graphic_interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenuItem;

/**
 * Creates my own customized JMenuItems in the game top menu
 * @author Alvaro de Francisco Sanchez
 */
public final class VoidMenuItem extends JMenuItem {
	
	/**
	 * My own customized JMenuItems in the game top menu within 'Game Options' tab
	 * @param title | The text to be displayed in the Menu's item as information of what this option does when clicked
	 */
	public VoidMenuItem(String title) {
		super(); // Gets the characteristics from the parent Class JMenuItem
		this.setText(title); // Menu's Item informative text
		setForeground(Color.LIGHT_GRAY); // Menu's Item font color
		setFont(new Font("Ink Free", Font.PLAIN, 25)); // Menu's Item font family, style and size
		setBackground(Color.BLACK); // Menu's Item background color
	}
}
