/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Cube class, which initiates a JFrame GUI to display what a cube looks like, and provide
 * functionality to calculate the volume of the cube.
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

public class Cube {

	private JFrame frmCubeBuilder;
	private double calcdCubeVolume;
	private JTextField cubeEdgeInput;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cube window = new Cube();
					window.frmCubeBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Cube class constructor
	public Cube() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmCubeBuilder = new JFrame();
		frmCubeBuilder.setTitle("Cube Builder");
		frmCubeBuilder.setBounds(100, 100, 450, 361);
		frmCubeBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCubeBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the volume of a cube
		JLabel cubeVolume = new JLabel("The Volume Of A Cube Is V = s^3");
		cubeVolume.setBounds(0, 0, 434, 20);
		cubeVolume.setHorizontalAlignment(SwingConstants.CENTER);
		cubeVolume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmCubeBuilder.getContentPane().add(cubeVolume);
		// Prompt user to enter the length of one of the cube's edges within the
		// provided JText field
		JLabel cubeEdgePrompt = new JLabel("Please Enter Length Of One Of The Cube's Edges:");
		cubeEdgePrompt.setHorizontalAlignment(SwingConstants.CENTER);
		cubeEdgePrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cubeEdgePrompt.setBounds(10, 228, 424, 14);
		frmCubeBuilder.getContentPane().add(cubeEdgePrompt);
		// Create JText Field for user input
		cubeEdgeInput = new JTextField();
		cubeEdgeInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cubeEdgeInput.setBounds(114, 253, 183, 20);
		frmCubeBuilder.getContentPane().add(cubeEdgeInput);
		cubeEdgeInput.setColumns(10);
		// Create JButton for user to calculate the volume of the cube once parameters
		// are input.
		JButton cubeButton = new JButton("Calculate Volume");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		cubeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double cubeEdge = Double.parseDouble(cubeEdgeInput.getText());
					calcdCubeVolume = Math.pow(cubeEdge, 3);
					JOptionPane.showMessageDialog(cubeButton, "The Volume of the Cube Is " + calcdCubeVolume + ".",
							"Cube Volume", 0);
					frmCubeBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(cubeButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		cubeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cubeButton.setBounds(124, 284, 173, 23);
		frmCubeBuilder.getContentPane().add(cubeButton);
		// JLabel with text to preceed graphic of cube
		JLabel cubeExplain = new JLabel("This Is What A Cube Looks Like:");
		cubeExplain.setVerticalAlignment(SwingConstants.TOP);
		cubeExplain.setHorizontalAlignment(SwingConstants.CENTER);
		cubeExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cubeExplain.setBounds(41, 31, 315, 20);
		frmCubeBuilder.getContentPane().add(cubeExplain);
		// JLabel for cube graphic
		JLabel cubeImage = new JLabel("");
		cubeImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon cubePic = new ImageIcon("cube.png");
		cubeImage.setIcon(cubePic);
		cubeImage.setBounds(100, 57, 208, 171);
		frmCubeBuilder.getContentPane().add(cubeImage);

	}
}