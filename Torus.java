/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Torus class, which initiates a JFrame GUI to display what a torus looks like, and provide
 * functionality to calculate the volume of the torus.
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

public class Torus {

	private JFrame frmTorusBuilder;
	private JTextField majorRadiusInput;
	private double calcdTorusVolume;
	private JTextField minorRadiusInput;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Torus window = new Torus();
					window.frmTorusBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Torus class constructor
	public Torus() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmTorusBuilder = new JFrame();
		frmTorusBuilder.setTitle("Torus Builder");
		frmTorusBuilder.setBounds(100, 100, 450, 485);
		frmTorusBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTorusBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the volume of a torus
		JLabel torusVolume = new JLabel("The Volume Of A Torus Is V = (pi x r^2)x(2 x pi x R)");
		torusVolume.setBounds(0, 0, 434, 20);
		torusVolume.setHorizontalAlignment(SwingConstants.CENTER);
		torusVolume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmTorusBuilder.getContentPane().add(torusVolume);
		// Prompt user to enter the major radius of the torus within the provided JText
		// field
		JLabel majorRadiusPrompt = new JLabel("Please Enter Major Radius Of The Torus:");
		majorRadiusPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		majorRadiusPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		majorRadiusPrompt.setBounds(10, 295, 424, 14);
		frmTorusBuilder.getContentPane().add(majorRadiusPrompt);
		// Create JText Field for user input
		majorRadiusInput = new JTextField();
		majorRadiusInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		majorRadiusInput.setBounds(114, 320, 183, 20);
		frmTorusBuilder.getContentPane().add(majorRadiusInput);
		majorRadiusInput.setColumns(10);
		// Create JButton for user to calculate the volume of the torus once parameters
		// are input.
		JButton torusButton = new JButton("Calculate Volume");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		torusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double majorRadius = Double.parseDouble(majorRadiusInput.getText());
					double minorRadius = Double.parseDouble(minorRadiusInput.getText());
					//If-else statement. For a torus, the major radius must be a greater value than the minor radius.
					//If a greater value is entered for the minor radius, then a dialog message will inform the user of this fact.
					//If correct values are enterer (the major radius being larger), then the program will calculate the volume successfully.
					if (majorRadius > minorRadius){
						calcdTorusVolume = (Math.PI * Math.pow(minorRadius, 2)) * (2 * Math.PI * majorRadius);
						JOptionPane.showMessageDialog(torusButton, "The Volume of the Torus Is " + calcdTorusVolume + ".",
								"Torus Volume", 0);
						frmTorusBuilder.dispose();
					}
					else{
					JOptionPane.showMessageDialog(torusButton, "The major radius must be a greater value than the minor radius.", null,0);	
					frmTorusBuilder.dispose();
					}
					}
				catch (Exception a) {
					JOptionPane.showMessageDialog(torusButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		torusButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		torusButton.setBounds(114, 401, 183, 23);
		frmTorusBuilder.getContentPane().add(torusButton);
		// JLabel with text to preceed graphic of a torus
		JLabel torusExplain = new JLabel("This Is What A Torus Looks Like:");
		torusExplain.setVerticalAlignment(SwingConstants.TOP);
		torusExplain.setHorizontalAlignment(SwingConstants.CENTER);
		torusExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		torusExplain.setBounds(42, 82, 315, 20);
		frmTorusBuilder.getContentPane().add(torusExplain);
		// JLabel for torus graphic
		JLabel torusImage = new JLabel("");
		torusImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon torusPic = new ImageIcon("torus.png");
		torusImage.setIcon(torusPic);
		torusImage.setBounds(100, 113, 208, 171);
		frmTorusBuilder.getContentPane().add(torusImage);
		// JLabel to prompt user to enter the minor radius of the torus
		JLabel minorRadiusPrompt = new JLabel("Please Enter The Minor Radius Of The Torus:");
		minorRadiusPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		minorRadiusPrompt.setBounds(41, 345, 359, 14);
		frmTorusBuilder.getContentPane().add(minorRadiusPrompt);
		// JTextField for user to input the minor radius of the torus
		minorRadiusInput = new JTextField();
		minorRadiusInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		minorRadiusInput.setColumns(10);
		minorRadiusInput.setBounds(114, 370, 183, 20);
		frmTorusBuilder.getContentPane().add(minorRadiusInput);
		//JLabel to inform user that the value of the major radius must exceed the value of the
		//minor radius. This message is split among two JLabels to account for font size
		JLabel radiusVolumeRequirement1 = new JLabel("The Value Of The Major Radius Must Exceed ");
		radiusVolumeRequirement1.setHorizontalAlignment(SwingConstants.CENTER);
		radiusVolumeRequirement1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radiusVolumeRequirement1.setBounds(21, 31, 389, 14);
		frmTorusBuilder.getContentPane().add(radiusVolumeRequirement1);
		//Second part of JLabel radius information statement.
		JLabel radiusVolumeRequirement2 = new JLabel("The Value Of The Minor Radius");
		radiusVolumeRequirement2.setHorizontalAlignment(SwingConstants.CENTER);
		radiusVolumeRequirement2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radiusVolumeRequirement2.setBounds(31, 56, 389, 14);
		frmTorusBuilder.getContentPane().add(radiusVolumeRequirement2);

	}
}