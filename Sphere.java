/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Sphere class, which initiates a JFrame GUI to display what a sphere looks like, and provide
 * functionality to calculate the volume of the sphere.
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

public class Sphere {

	private JFrame frmSphereBuilder;
	private double calcdSphereVolume;
	private JTextField sphereRadiusInput;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sphere window = new Sphere();
					window.frmSphereBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Sphere class constructor
	public Sphere() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmSphereBuilder = new JFrame();
		frmSphereBuilder.setTitle("Sphere Builder");
		frmSphereBuilder.setBounds(100, 100, 450, 356);
		frmSphereBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSphereBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the volume of a sphere
		JLabel sphereVolume = new JLabel("The Volume Of A Sphere Is V = (4/3) x (pi x r^3)");
		sphereVolume.setBounds(0, 0, 434, 20);
		sphereVolume.setHorizontalAlignment(SwingConstants.CENTER);
		sphereVolume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmSphereBuilder.getContentPane().add(sphereVolume);
		// Prompt user to enter the radius of the sphere within the provided JText field
		JLabel sphereRadiusPrompt = new JLabel("Please Enter Radius Of The Sphere:");
		sphereRadiusPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		sphereRadiusPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sphereRadiusPrompt.setBounds(10, 228, 424, 14);
		frmSphereBuilder.getContentPane().add(sphereRadiusPrompt);
		// Create JText Field for user input
		sphereRadiusInput = new JTextField();
		sphereRadiusInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sphereRadiusInput.setBounds(114, 253, 183, 20);
		frmSphereBuilder.getContentPane().add(sphereRadiusInput);
		sphereRadiusInput.setColumns(10);
		// Create JButton for user to calculate the volume of the sphere once parameters
		// are input.
		JButton sphereButton = new JButton("Calculate Volume");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		sphereButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double sphereRadius = Double.parseDouble(sphereRadiusInput.getText());
					calcdSphereVolume = (4.0 / 3) * Math.PI * (Math.pow(sphereRadius, 3));
					JOptionPane.showMessageDialog(sphereButton,
							"The Volume of the Sphere Is " + calcdSphereVolume + ".", "Sphere Volume", 0);
					frmSphereBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(sphereButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		sphereButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sphereButton.setBounds(124, 284, 173, 23);
		frmSphereBuilder.getContentPane().add(sphereButton);
		// JLabel with text to preceed graphic of sphere
		JLabel sphereExplain = new JLabel("This Is What A Sphere Looks Like:");
		sphereExplain.setVerticalAlignment(SwingConstants.TOP);
		sphereExplain.setHorizontalAlignment(SwingConstants.CENTER);
		sphereExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sphereExplain.setBounds(41, 31, 315, 20);
		frmSphereBuilder.getContentPane().add(sphereExplain);
		// JLabel for sphere graphic
		JLabel sphereImage = new JLabel("");
		sphereImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon spherePic = new ImageIcon("sphere.png");
		sphereImage.setIcon(spherePic);
		sphereImage.setBounds(100, 57, 208, 171);
		frmSphereBuilder.getContentPane().add(sphereImage);

	}
}