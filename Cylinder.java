/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Cylinder class, which initiates a JFrame GUI to display what a cylinder looks like, and provide
 * functionality to calculate the volume of the cylinder.
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

public class Cylinder {

	private JFrame frmCylinderBuilder;
	private JTextField cylinderHeightInput;
	private double calcdCylinderVolume;
	private JTextField cylinderRadiusInput;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cylinder window = new Cylinder();
					window.frmCylinderBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Cylinder class constructor
	public Cylinder() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmCylinderBuilder = new JFrame();
		frmCylinderBuilder.setTitle("Cylinder Builder");
		frmCylinderBuilder.setBounds(100, 100, 450, 411);
		frmCylinderBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCylinderBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the volume of a cylinder
		JLabel cylinderVolume = new JLabel("The Volume Of A Cylinder Is V = (pi x r^2) x h");
		cylinderVolume.setBounds(0, 0, 434, 20);
		cylinderVolume.setHorizontalAlignment(SwingConstants.CENTER);
		cylinderVolume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmCylinderBuilder.getContentPane().add(cylinderVolume);
		// Prompt user to enter the height of the cylinder within the provided JText
		// field
		JLabel cylinderHeightPrompt = new JLabel("Please Enter Height Of The Cylinder:");
		cylinderHeightPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		cylinderHeightPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cylinderHeightPrompt.setBounds(10, 228, 424, 14);
		frmCylinderBuilder.getContentPane().add(cylinderHeightPrompt);
		// Create JText Field for user input of cylinder height
		cylinderHeightInput = new JTextField();
		cylinderHeightInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cylinderHeightInput.setBounds(114, 253, 183, 20);
		frmCylinderBuilder.getContentPane().add(cylinderHeightInput);
		cylinderHeightInput.setColumns(10);
		// Create JButton for user to calculate the volume of the cylinder once
		// parameters are input.
		JButton cylinderButton = new JButton("Calculate Volume");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		cylinderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double cylinderHeight = Double.parseDouble(cylinderHeightInput.getText());
					double cylinderRadius = Double.parseDouble(cylinderRadiusInput.getText());
					calcdCylinderVolume = (Math.PI * Math.pow(cylinderRadius, 2) * cylinderHeight);
					JOptionPane.showMessageDialog(cylinderButton,
							"The Volume of the Cylinder Is " + calcdCylinderVolume + ".", "Cylinder Volume", 0);
					frmCylinderBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(cylinderButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		cylinderButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cylinderButton.setBounds(114, 338, 183, 23);
		frmCylinderBuilder.getContentPane().add(cylinderButton);
		// JLabel with text to preceed graphic of cylinder
		JLabel cylinderExplain = new JLabel("This Is What A Cylinder Looks Like:");
		cylinderExplain.setVerticalAlignment(SwingConstants.TOP);
		cylinderExplain.setHorizontalAlignment(SwingConstants.CENTER);
		cylinderExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cylinderExplain.setBounds(41, 31, 315, 20);
		frmCylinderBuilder.getContentPane().add(cylinderExplain);
		// JLabel for cylinder graphic
		JLabel cylinderImage = new JLabel("");
		cylinderImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon cylinderPic = new ImageIcon("cylinder.png");
		cylinderImage.setIcon(cylinderPic);
		cylinderImage.setBounds(100, 57, 208, 171);
		frmCylinderBuilder.getContentPane().add(cylinderImage);
		// JLabel to prompt user to enter the radius of the cylinder
		JLabel cylinderRadiusPrompt = new JLabel("Please Enter The Length Of The Cylinder's Radius:");
		cylinderRadiusPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cylinderRadiusPrompt.setBounds(43, 284, 359, 14);
		frmCylinderBuilder.getContentPane().add(cylinderRadiusPrompt);
		// JTextField for user to input the radius of the cylinder
		cylinderRadiusInput = new JTextField();
		cylinderRadiusInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cylinderRadiusInput.setColumns(10);
		cylinderRadiusInput.setBounds(114, 307, 183, 20);
		frmCylinderBuilder.getContentPane().add(cylinderRadiusInput);

	}
}