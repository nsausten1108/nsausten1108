/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Rectangle class, which initiates a JFrame GUI to display what a rectangle looks like, and provide
 * functionality to calculate the area of the rectangle.
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

public class Rectangle {

	private JFrame frmRectangleBuilder;
	private JTextField rectangleHeightInput;
	private double calcdRectangleArea;
	private JTextField rectangleBaseInput;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rectangle window = new Rectangle();
					window.frmRectangleBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Rectangle class constructor
	public Rectangle() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmRectangleBuilder = new JFrame();
		frmRectangleBuilder.setTitle("Rectangle Builder");
		frmRectangleBuilder.setBounds(100, 100, 450, 411);
		frmRectangleBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRectangleBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the area of a rectangle
		JLabel rectangleArea = new JLabel("The Area Of A Rectangle Is A= b x h.");
		rectangleArea.setBounds(0, 0, 434, 20);
		rectangleArea.setHorizontalAlignment(SwingConstants.CENTER);
		rectangleArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmRectangleBuilder.getContentPane().add(rectangleArea);
		// Prompt user to enter the height of the rectangle within the provided JText
		// field
		JLabel rectangleHeightPrompt = new JLabel("Please Enter Height Of The Rectangle:");
		rectangleHeightPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		rectangleHeightPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rectangleHeightPrompt.setBounds(10, 228, 424, 14);
		frmRectangleBuilder.getContentPane().add(rectangleHeightPrompt);
		// Create JText Field for user input of rectangle height
		rectangleHeightInput = new JTextField();
		rectangleHeightInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rectangleHeightInput.setBounds(114, 253, 183, 20);
		frmRectangleBuilder.getContentPane().add(rectangleHeightInput);
		rectangleHeightInput.setColumns(10);
		// Create JButton for user to calculate the area of the rectangle once input of
		// parameters are input.
		JButton rectangleButton = new JButton("Calculate Area");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		rectangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rectangleHeight = Double.parseDouble(rectangleHeightInput.getText());
					double rectangleBase = Double.parseDouble(rectangleBaseInput.getText());
					calcdRectangleArea = rectangleHeight * rectangleBase;
					JOptionPane.showMessageDialog(rectangleButton,
							"The Area Of The Rectangle Is " + calcdRectangleArea + ".", "Rectangle Area", 0);
					frmRectangleBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(rectangleButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		rectangleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rectangleButton.setBounds(145, 338, 152, 23);
		frmRectangleBuilder.getContentPane().add(rectangleButton);
		// JLabel with text to preceed graphic of a rectangle
		JLabel rectangleExplain = new JLabel("This Is What A Rectangle Looks Like:");
		rectangleExplain.setVerticalAlignment(SwingConstants.TOP);
		rectangleExplain.setHorizontalAlignment(SwingConstants.CENTER);
		rectangleExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rectangleExplain.setBounds(41, 31, 315, 20);
		frmRectangleBuilder.getContentPane().add(rectangleExplain);
		// JLabel for rectangle graphic
		JLabel rectangleImage = new JLabel("");
		rectangleImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon rectanglePic = new ImageIcon("rectangle.png");
		rectangleImage.setIcon(rectanglePic);
		rectangleImage.setBounds(100, 57, 208, 171);
		frmRectangleBuilder.getContentPane().add(rectangleImage);
		//JLabel to prompt user to input the length of the rectangle's base
		JLabel rectangleBasePrompt = new JLabel("Please Enter The Length Of The Rectangle's Base");
		rectangleBasePrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rectangleBasePrompt.setBounds(43, 284, 359, 14);
		frmRectangleBuilder.getContentPane().add(rectangleBasePrompt);
		//JTextField for user input of length of rectangle's base
		rectangleBaseInput = new JTextField();
		rectangleBaseInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rectangleBaseInput.setColumns(10);
		rectangleBaseInput.setBounds(114, 307, 183, 20);
		frmRectangleBuilder.getContentPane().add(rectangleBaseInput);

	}
}