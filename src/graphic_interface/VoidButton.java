package graphic_interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * Creates my own customized JButton in the grid located to the right
 * @author Alvaro de Francisco Sanchez
 */
public final class VoidButton extends JButton {
	
	/**
	 * My own customized JButton in the grid located to the right
	 */
	public VoidButton(String name) {
		super(); // Gets the characteristics from the parent Class JButton
		setForeground(Color.LIGHT_GRAY); // Menu's Item font color
		setFont(new Font("Ink Free", Font.PLAIN, 25)); // Menu's Item font family, style and size
		setBackground(Color.BLACK); // Menu's Item background color
		setText(name);
	}
}