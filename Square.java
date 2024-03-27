/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Square class, which initiates a JFrame GUI to display what a square looks like, and provide
 * functionality to calculate the area of the square.
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

public class Square {

	private JFrame frmSquareBuilder;
	private JTextField squareInput;
	private double calcdSquareArea;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Square window = new Square();
					window.frmSquareBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Square class constructor
	public Square() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmSquareBuilder = new JFrame();
		frmSquareBuilder.setTitle("Square Builder");
		frmSquareBuilder.setBounds(100, 100, 450, 384);
		frmSquareBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSquareBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the area of a square
		JLabel squareArea = new JLabel("The Area Of A Square Is A=S^2.");
		squareArea.setBounds(0, 0, 434, 20);
		squareArea.setHorizontalAlignment(SwingConstants.CENTER);
		squareArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmSquareBuilder.getContentPane().add(squareArea);
		// Prompt user to enter the length of one of the square sides within the
		// provided JText field
		JLabel squarePrompt = new JLabel("Please Enter The Length Of One Of The Square's Sides:");
		squarePrompt.setHorizontalAlignment(SwingConstants.CENTER);
		squarePrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		squarePrompt.setBounds(10, 255, 424, 14);
		frmSquareBuilder.getContentPane().add(squarePrompt);
		// Create JText Field for user to input the length of one of the square's sides
		squareInput = new JTextField();
		squareInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		squareInput.setBounds(127, 280, 183, 20);
		frmSquareBuilder.getContentPane().add(squareInput);
		squareInput.setColumns(10);
		// Create JButton for user to calculate the area of the square once input of
		// parameters is complete.
		JButton squareButton = new JButton("Calculate Area");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		squareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double squareSide = Double.parseDouble(squareInput.getText());
					calcdSquareArea = Math.pow(squareSide, 2);
					JOptionPane.showMessageDialog(squareButton, "The Area Of The Square Is " + calcdSquareArea + ".",
							"Square Area", 0);
					frmSquareBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(squareButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		squareButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		squareButton.setBounds(146, 311, 152, 23);
		frmSquareBuilder.getContentPane().add(squareButton);
		// JLabel with text to preceed graphic of square
		JLabel squareExplain = new JLabel("This Is What A Square Looks Like:");
		squareExplain.setVerticalAlignment(SwingConstants.TOP);
		squareExplain.setHorizontalAlignment(SwingConstants.CENTER);
		squareExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		squareExplain.setBounds(90, 31, 251, 20);
		frmSquareBuilder.getContentPane().add(squareExplain);
		// JLabel for square graphic
		JLabel squareImage = new JLabel("");
		squareImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon squarePic = new ImageIcon("square.png");
		squareImage.setIcon(squarePic);
		squareImage.setBounds(100, 60, 208, 171);
		frmSquareBuilder.getContentPane().add(squareImage);

	}
}
