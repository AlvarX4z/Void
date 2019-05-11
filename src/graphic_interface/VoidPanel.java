package graphic_interface;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

/**
 * Creates my own customized JPanels for the game
 * @author Alvaro de Francisco Sanchez
 */
public class VoidPanel extends JPanel {

	// -----------------------
	// ----- CONSTRUCTOR -----
	// -----------------------
	
	/**
	 * VoidPanel's basic Constructor
	 */
	public VoidPanel() {
		super();
		setLayout(new BorderLayout());
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:/Alvar/Imágenes/be4.png"));
		
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		JButton b5 = new JButton();
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(5, 1));
		eastPanel.add(b1);
		eastPanel.add(b2);
		eastPanel.add(b3);
		eastPanel.add(b4);
		eastPanel.add(b5);
		eastPanel.setVisible(true);
		
		JEditorPane textPane = new JEditorPane();
		textPane.setBackground(Color.BLACK);
		textPane.setEditable(false);
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Ink Free", Font.PLAIN, 20));
		textPane.setText("UWU");
		
		add(eastPanel, BorderLayout.EAST);
		add(lblNewLabel, BorderLayout.CENTER);
		add(textPane, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
		// JBUTTON PERSONALIZADOOOOOOOOOOOOOO
		
	}
}
