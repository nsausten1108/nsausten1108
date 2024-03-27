/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Circle class, which initiates a JFrame GUI to display what a circle looks like, and provide
 * functionality to calculate the area of the circle.
 */

//Import Required Components
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Circle {

	private JFrame frmCircleBuilder;
	private JTextField circleInput;
	private double calcdCircleArea;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Circle window = new Circle();
					window.frmCircleBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Circle class constructor
	public Circle() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmCircleBuilder = new JFrame();
		frmCircleBuilder.setTitle("Circle Builder");
		frmCircleBuilder.setBounds(100, 100, 450, 348);
		frmCircleBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircleBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the area of a circle
		JLabel circleArea = new JLabel("The Area Of A Circle Is A=((pi)x(r^2)). ");
		circleArea.setBounds(0, 0, 434, 20);
		circleArea.setHorizontalAlignment(SwingConstants.CENTER);
		circleArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmCircleBuilder.getContentPane().add(circleArea);
		// Prompt user to enter the length of the circle's radius within the provided
		// JText field
		JLabel circlePrompt = new JLabel("Please Enter The Length Of The Circle's Radius:");
		circlePrompt.setHorizontalAlignment(SwingConstants.CENTER);
		circlePrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		circlePrompt.setBounds(10, 222, 424, 14);
		frmCircleBuilder.getContentPane().add(circlePrompt);
		// Create JText Field for user to input circle's radius
		circleInput = new JTextField();
		circleInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		circleInput.setBounds(125, 247, 183, 20);
		frmCircleBuilder.getContentPane().add(circleInput);
		circleInput.setColumns(10);
		// Create JButton for user to calculate the area of the circle once input of
		// parameters is complete.
		JButton circleButton = new JButton("Calculate Area");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		circleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double circleRadius = Double.parseDouble(circleInput.getText());
					calcdCircleArea = Math.PI * Math.pow(circleRadius, 2);
					JOptionPane.showMessageDialog(circleButton, "The Area Of The Circle Is " + calcdCircleArea + ".",
							"Circle Area", 0);
					frmCircleBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(circleButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		circleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		circleButton.setBounds(145, 278, 152, 23);
		frmCircleBuilder.getContentPane().add(circleButton);
		// JLabel with text to preceed graphic of circle
		JLabel circleExplain = new JLabel("This Is What A Circle Looks Like:");
		circleExplain.setVerticalAlignment(SwingConstants.TOP);
		circleExplain.setHorizontalAlignment(SwingConstants.CENTER);
		circleExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		circleExplain.setBounds(90, 31, 251, 20);
		frmCircleBuilder.getContentPane().add(circleExplain);
		// JLabel for circle graphic
		JLabel circleImage = new JLabel("");
		circleImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon circlePic = new ImageIcon("circle.png");
		circleImage.setIcon(circlePic);
		circleImage.setBounds(100, 60, 208, 171);
		frmCircleBuilder.getContentPane().add(circleImage);

	}
}