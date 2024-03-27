/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Cone class, which initiates a JFrame GUI to display what a cone looks like, and provide
 * functionality to calculate the volume of the cone.
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

public class Cone {

	private JFrame frmConeBuilder;
	private JTextField coneHeightInput;
	private double calcdConeVolume;
	private JTextField coneRadiusInput;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cone window = new Cone();
					window.frmConeBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Cone class constructor
	public Cone() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmConeBuilder = new JFrame();
		frmConeBuilder.setTitle("Cone Builder");
		frmConeBuilder.setBounds(100, 100, 450, 411);
		frmConeBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConeBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the volume of a cone
		JLabel coneVolume = new JLabel("The Volume Of A Cone Is V = (h x pi x r^2)/3");
		coneVolume.setBounds(0, 0, 434, 20);
		coneVolume.setHorizontalAlignment(SwingConstants.CENTER);
		coneVolume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmConeBuilder.getContentPane().add(coneVolume);
		// Prompt user to enter the height of the cone within the provided JText field
		JLabel coneHeightPrompt = new JLabel("Please Enter Height Of The Cone:");
		coneHeightPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		coneHeightPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		coneHeightPrompt.setBounds(10, 228, 424, 14);
		frmConeBuilder.getContentPane().add(coneHeightPrompt);
		// Create JText Field for user to input cone height
		coneHeightInput = new JTextField();
		coneHeightInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		coneHeightInput.setBounds(114, 253, 183, 20);
		frmConeBuilder.getContentPane().add(coneHeightInput);
		coneHeightInput.setColumns(10);
		// Create JButton for user to calculate the volume of the cone once parameters
		// are input.
		JButton coneButton = new JButton("Calculate Volume");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		coneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double coneHeight = Double.parseDouble(coneHeightInput.getText());
					double coneRadius = Double.parseDouble(coneRadiusInput.getText());
					calcdConeVolume = ((coneHeight * Math.PI) * Math.pow(coneRadius, 2)) / 3;
					JOptionPane.showMessageDialog(coneButton, "The Volume of the Cone Is " + calcdConeVolume + ".",
							"Cone Volume", 0);
					frmConeBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(coneButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		coneButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		coneButton.setBounds(134, 338, 163, 23);
		frmConeBuilder.getContentPane().add(coneButton);
		// JLabel with text to preceed graphic of cone
		JLabel coneExplain = new JLabel("This Is What A Cone Looks Like:");
		coneExplain.setVerticalAlignment(SwingConstants.TOP);
		coneExplain.setHorizontalAlignment(SwingConstants.CENTER);
		coneExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		coneExplain.setBounds(41, 31, 315, 20);
		frmConeBuilder.getContentPane().add(coneExplain);
		// JLabel for cone graphic
		JLabel coneImage = new JLabel("");
		coneImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon conePic = new ImageIcon("cone.png");
		coneImage.setIcon(conePic);
		coneImage.setBounds(100, 57, 208, 171);
		frmConeBuilder.getContentPane().add(coneImage);
		// JLabel to prompt user to enter the radius of the cone
		JLabel coneRadiusPrompt = new JLabel("Please Enter The Length Of The Cone's Radius");
		coneRadiusPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		coneRadiusPrompt.setBounds(43, 284, 359, 14);
		frmConeBuilder.getContentPane().add(coneRadiusPrompt);
		// JTextField for user to input the radius of the cone
		coneRadiusInput = new JTextField();
		coneRadiusInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		coneRadiusInput.setColumns(10);
		coneRadiusInput.setBounds(114, 307, 183, 20);
		frmConeBuilder.getContentPane().add(coneRadiusInput);

	}
}