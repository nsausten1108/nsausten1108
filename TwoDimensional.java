/*Nicholas Austen
 * CMSC335, Project 2
 * Professor Mujeye
 * Description: This is the TwoDimensional class. This class utilizes swing components to prompt the user to select
 * from a JComboBox drop down list to select which type of shape they would like. EventListener then closes the created window
 * and opens the window of the desired shape for further user inputs.
 */

//Import required components
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TwoDimensional {

	private JFrame twoDShapeSelect;

//Main method to launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwoDimensional window = new TwoDimensional();
					window.getTwoDShapeSelect().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Class Constructor
	public TwoDimensional() {
		initialize();
	}

//Method to provide contents to JFrame
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		setTwoDShapeSelect(new JFrame());
		getTwoDShapeSelect().setBounds(100, 100, 450, 167);
		getTwoDShapeSelect().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		twoDShapeSelect.getContentPane().setLayout(null);
		// JLabel to prompt user to select the type of two dimension shape they would
		// like to make
		JLabel lblNewLabel = new JLabel("Please Select The Type Of Two Dimensional Shape  ");
		lblNewLabel.setBounds(0, 0, 434, 36);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twoDShapeSelect.getContentPane().add(lblNewLabel);
		// Creates JComboBox to provide user choices with which shape they would like to
		// select. Uses switch statement for choices.
		// Adds action listenener to invoke necessary classes based on user input
		JComboBox twoDimensionalChoices = new JComboBox();
		twoDimensionalChoices.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				String t = (String) twoDimensionalChoices.getSelectedItem();
				switch (t) {
				case "Circle":
					Circle a = new Circle();
					a.main(null);
					twoDShapeSelect.dispose();
					break;
				case "Rectangle":
					Rectangle b = new Rectangle();
					b.main(null);
					twoDShapeSelect.dispose();
					break;
				case "Square":
					Square c = new Square();
					c.main(null);
					twoDShapeSelect.dispose();
					break;
				case "Triangle":
					Triangle d = new Triangle();
					d.main(null);
					twoDShapeSelect.dispose();
					break;
				}
			}
		});
		twoDimensionalChoices.setBounds(125, 72, 152, 36);
		twoDimensionalChoices.setFont(new Font("Tahoma", Font.PLAIN, 16));
		twoDimensionalChoices
				.setModel(new DefaultComboBoxModel(new String[] { "Circle", "Rectangle", "Square", "Triangle" }));
		twoDShapeSelect.getContentPane().add(twoDimensionalChoices);
		// Second part of user prompt to allow for font size. Moves second part of
		// prompt to a new line.
		JLabel lblNewLabel_1 = new JLabel("That You Would Like To Make");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(32, 35, 359, 26);
		twoDShapeSelect.getContentPane().add(lblNewLabel_1);
	}

//Getters and setters for class. Allows parent class to access frame.
	public JFrame getTwoDShapeSelect() {
		return twoDShapeSelect;
	}

	public void setTwoDShapeSelect(JFrame twoDShapeSelect) {
		this.twoDShapeSelect = twoDShapeSelect;
		twoDShapeSelect.setTitle("Two Dimensional Shape Selector");
	}
}
