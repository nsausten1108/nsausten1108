/* Nicholas Austen
 * CMSC335, Project 2
 * Professor Mujeye
 * Description: Main parent class of program. Creates a GUI for the user to select type of shape they want to create. Utilizes 
 * JComboBox to create a drop down menu. Choices that a user can select are two dimensional or three dimensional shape.
 * From there, TwoDimensional or ThreeDimensional classes are invoked, which further invoke the individual shape classes
 * based on user input.
 */
//Import required components
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShapeSelector {

	private JFrame frmShapeSelectorHome;

	// Main class to launch program.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapeSelector window = new ShapeSelector();
					window.frmShapeSelectorHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Class constructor
	public ShapeSelector() {
		initialize();
	}

	//Method to provide contents to JFrame.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmShapeSelectorHome = new JFrame();
		frmShapeSelectorHome.setTitle("Shape Selector Home");
		frmShapeSelectorHome.setBounds(100, 100, 450, 119);
		frmShapeSelectorHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShapeSelectorHome.getContentPane().setLayout(null);
		// JLabel to prompt user to select shape type.
		JLabel welcomePrompt = new JLabel("Please Select The Type Of Shape You Would Like To Make");
		welcomePrompt.setBounds(0, 0, 434, 20);
		welcomePrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		welcomePrompt.setHorizontalAlignment(SwingConstants.CENTER);
		frmShapeSelectorHome.getContentPane().add(welcomePrompt);
		// JComboBox drop down menu for user to select choice of shape they want to
		// create
		// Includes ActionListener to provide functionality for user choice.
		JComboBox shapeChoices = new JComboBox();
		shapeChoices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = (String) shapeChoices.getSelectedItem();
				switch (t) {
				case "Two Dimensional":
					TwoDimensional a = new TwoDimensional();
					a.getTwoDShapeSelect().setVisible(true);
					frmShapeSelectorHome.dispose();
					break;
				case "Three Dimensional":
					ThreeDimensional b = new ThreeDimensional();
					b.getThreeDShapeSelect().setVisible(true);
					frmShapeSelectorHome.dispose();
					break;
				}
			}
		});
		shapeChoices.setFont(new Font("Tahoma", Font.PLAIN, 14));
		shapeChoices.setModel(new DefaultComboBoxModel(new String[] { "Two Dimensional", "Three Dimensional" }));
		shapeChoices.setBounds(105, 31, 217, 33);
		frmShapeSelectorHome.getContentPane().add(shapeChoices);
	}

}
