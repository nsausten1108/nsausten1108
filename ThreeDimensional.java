/*Nicholas Austen
 * CMSC335, Project 2
 * Professor Mujeye
 * Description: This is the ThreeDimensional class. This class utilizes swing components to prompt the user to select
 * from a JComboBox drop down list to select which type of shape they would like. EventListener then closes the created window
 * and opens the window of the desired shape for further user inputs.
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreeDimensional {

	private JFrame threeDShapeSelect;

	// Main method to launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreeDimensional window = new ThreeDimensional();
					window.getThreeDShapeSelect().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Class constructor
	public ThreeDimensional() {
		initialize();
	}

	// Add components to the JFrame
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		setThreeDShapeSelect(new JFrame());
		getThreeDShapeSelect().setBounds(100, 100, 450, 158);
		getThreeDShapeSelect().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		threeDShapeSelect.getContentPane().setLayout(null);
		// Prompt user to select the type of the three dimensional shape they would like
		// to create
		JLabel lblNewLabel = new JLabel("Please Select The Type Of Three Dimensional Shape");
		lblNewLabel.setBounds(0, 11, 434, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		threeDShapeSelect.getContentPane().add(lblNewLabel);
		// Second part of welcome prompt. Added to second line to account for font size.
		JLabel lblNewLabel_1 = new JLabel("That You Would Like To Make");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(0, 37, 434, 30);
		threeDShapeSelect.getContentPane().add(lblNewLabel_1);
		// Create JComboBox dropdown box for the user to select which type of shape they
		// would like to create. Uses switch statement for selections
		// Includes ActionListener to open the needed class based on user input
		JComboBox threeDimensionalChoices = new JComboBox();
		threeDimensionalChoices.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				String d = (String) threeDimensionalChoices.getSelectedItem();
				switch (d) {
				case "Cone":
					Cone a = new Cone();
					a.main(null);
					threeDShapeSelect.dispose();
					break;
				case "Cube":
					Cube b = new Cube();
					b.main(null);
					threeDShapeSelect.dispose();
					break;
				case "Cylinder":
					Cylinder c = new Cylinder();
					c.main(null);
					threeDShapeSelect.dispose();
					break;
				case "Pyramid":
					Pyramid f = new Pyramid();
					f.main(null);
					threeDShapeSelect.dispose();
					break;
				case "Sphere":
					Sphere g = new Sphere();
					g.main(null);
					threeDShapeSelect.dispose();
					break;
				case "Torus":
					Torus h = new Torus();
					h.main(null);
					threeDShapeSelect.dispose();
					break;
				}
			}
		});
		threeDimensionalChoices.setModel(
				new DefaultComboBoxModel(new String[] {"Cone", "Cube", "Cylinder", "Pyramid", "Sphere", "Torus"}));
		threeDimensionalChoices.setFont(new Font("Tahoma", Font.PLAIN, 16));
		threeDimensionalChoices.setBounds(152, 78, 104, 30);
		threeDShapeSelect.getContentPane().add(threeDimensionalChoices);
	}

	// Getters and setters to access private class frame from parent class
	public JFrame getThreeDShapeSelect() {
		return threeDShapeSelect;
	}

	public void setThreeDShapeSelect(JFrame threeDShapeSelect) {
		this.threeDShapeSelect = threeDShapeSelect;
		threeDShapeSelect.setTitle("Three Dimensional Shape Selector");
	}
}
