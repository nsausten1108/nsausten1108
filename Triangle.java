/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Triangle class, which initiates a JFrame GUI to display what a triangle looks like, and provide
 * functionality to calculate the area of the triangle.
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

public class Triangle {

	private JFrame frmTriangleBuilder;
	private JTextField triangleHeightInput;
	private double calcdTriangleArea;
	private JTextField triangleBaseInput;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Triangle window = new Triangle();
					window.frmTriangleBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Circle class constructor
	public Triangle() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmTriangleBuilder = new JFrame();
		frmTriangleBuilder.setTitle("Triangle Builder");
		frmTriangleBuilder.setBounds(100, 100, 450, 411);
		frmTriangleBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTriangleBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the area of a triangle
		JLabel triangleArea = new JLabel("The Area Of A Triangle Is A=(1/2)x(b x h). ");
		triangleArea.setBounds(0, 0, 434, 20);
		triangleArea.setHorizontalAlignment(SwingConstants.CENTER);
		triangleArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmTriangleBuilder.getContentPane().add(triangleArea);
		// Prompt user to enter the height of the triangle within the provided JText
		// field
		JLabel triangleHeightPrompt = new JLabel("Please Enter Height Of The Triangle:");
		triangleHeightPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		triangleHeightPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		triangleHeightPrompt.setBounds(10, 228, 424, 14);
		frmTriangleBuilder.getContentPane().add(triangleHeightPrompt);
		// Create JText Field for user to input triangle's height
		triangleHeightInput = new JTextField();
		triangleHeightInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		triangleHeightInput.setBounds(114, 253, 183, 20);
		frmTriangleBuilder.getContentPane().add(triangleHeightInput);
		triangleHeightInput.setColumns(10);
		// Create JButton for user to calculate the area of the triangle once input of
		// parameters are input.
		JButton triangleButton = new JButton("Calculate Area");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		triangleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double triangleHeight = Double.parseDouble(triangleHeightInput.getText());
					double triangleBase = Double.parseDouble(triangleBaseInput.getText());
					calcdTriangleArea = (triangleHeight * triangleBase) / 2;
					JOptionPane.showMessageDialog(triangleButton,
							"The Area Of The Triangle Is " + calcdTriangleArea + ".", "Triangle Area", 0);
					frmTriangleBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(triangleButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		triangleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		triangleButton.setBounds(145, 338, 152, 23);
		frmTriangleBuilder.getContentPane().add(triangleButton);
		// JLabel with text to preceed graphic of triangle
		JLabel triangleExplain = new JLabel("This Is What A Triangle Looks Like:");
		triangleExplain.setVerticalAlignment(SwingConstants.TOP);
		triangleExplain.setHorizontalAlignment(SwingConstants.CENTER);
		triangleExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		triangleExplain.setBounds(41, 31, 315, 20);
		frmTriangleBuilder.getContentPane().add(triangleExplain);
		// JLabel for triangle graphic
		JLabel triangleImage = new JLabel("");
		triangleImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon trianglePic = new ImageIcon("triangle.png");
		triangleImage.setIcon(trianglePic);
		triangleImage.setBounds(100, 57, 208, 171);
		frmTriangleBuilder.getContentPane().add(triangleImage);
		// Prompt user to enter the length of the triangle's base
		JLabel triangleBasePrompt = new JLabel("Please Enter The Length Of The Triangle's Base");
		triangleBasePrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		triangleBasePrompt.setBounds(43, 284, 359, 14);
		frmTriangleBuilder.getContentPane().add(triangleBasePrompt);
		// JTextField for triangle base input
		triangleBaseInput = new JTextField();
		triangleBaseInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		triangleBaseInput.setColumns(10);
		triangleBaseInput.setBounds(114, 307, 183, 20);
		frmTriangleBuilder.getContentPane().add(triangleBaseInput);

	}
}