/* Nicholas Austen
 * CMSC 335, Project 2
 * Professor Mujeye
 * Description: This is the Pyramid class, which initiates a JFrame GUI to display what a pyramid looks like, and provide
 * functionality to calculate the volume of the pyramid.
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

public class Pyramid {

	private JFrame frmPyramidBuilder;
	private JTextField pyramidHeightInput;
	private JTextField pyramidBaseWidthInput;
	private JTextField pyramidBaseLengthInput;
	private double calcdPyramidVolume;

	// Launch Application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pyramid window = new Pyramid();
					window.frmPyramidBuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//Pyramid class constructor
	public Pyramid() {
		initialize();
	}

//Method to provide contents to JFrame. 
	private void initialize() {
		frmPyramidBuilder = new JFrame();
		frmPyramidBuilder.setTitle("Pyramid Builder");
		frmPyramidBuilder.setBounds(100, 100, 450, 498);
		frmPyramidBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPyramidBuilder.getContentPane().setLayout(null);
		// Provides label with formula for the volume of a pyramid
		JLabel pyramidVolume = new JLabel("The Volume Of A Pyramid is V = (bl x bw x h)/3");
		pyramidVolume.setBounds(0, 0, 434, 20);
		pyramidVolume.setHorizontalAlignment(SwingConstants.CENTER);
		pyramidVolume.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmPyramidBuilder.getContentPane().add(pyramidVolume);
		// Prompt user to enter the length of the base of the pyramid within the
		// provided JText field
		JLabel pyramidBaseLengthPrompt = new JLabel("Please Enter The Length Of The Pyramid's Base:");
		pyramidBaseLengthPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		pyramidBaseLengthPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pyramidBaseLengthPrompt.setBounds(10, 228, 424, 14);
		frmPyramidBuilder.getContentPane().add(pyramidBaseLengthPrompt);
		// Create JText Field for user input
		pyramidBaseLengthInput = new JTextField();
		pyramidBaseLengthInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pyramidBaseLengthInput.setBounds(114, 253, 183, 20);
		frmPyramidBuilder.getContentPane().add(pyramidBaseLengthInput);
		pyramidBaseLengthInput.setColumns(10);
		// Create JButton for user to calculate the volume of the pyramid once
		// parameters are input.
		JButton pyramidButton = new JButton("Calculate Volume");
		// ActionListener for button. Includes error handling if incorrect data type is
		// input by user.
		pyramidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double pyramidBaseLength = Double.parseDouble(pyramidBaseLengthInput.getText());
					double pyramidBaseWidth = Double.parseDouble(pyramidBaseWidthInput.getText());
					double pyramidHeight = Double.parseDouble(pyramidHeightInput.getText());

					calcdPyramidVolume = (pyramidBaseLength * pyramidBaseWidth * pyramidHeight) / 3;
					JOptionPane.showMessageDialog(pyramidButton,
							"The Volume of the Pyramid Is " + calcdPyramidVolume + ".", "Pyramid Volume", 0);
					frmPyramidBuilder.dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(pyramidButton, "You have entered an incorrect data type.", null, 0);
				}
			}
		});
		pyramidButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pyramidButton.setBounds(114, 413, 183, 23);
		frmPyramidBuilder.getContentPane().add(pyramidButton);
		// JLabel with text to preceed graphic of pyramid
		JLabel pyramidExplain = new JLabel("This Is What A Pyramid Looks Like:");
		pyramidExplain.setVerticalAlignment(SwingConstants.TOP);
		pyramidExplain.setHorizontalAlignment(SwingConstants.CENTER);
		pyramidExplain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pyramidExplain.setBounds(41, 31, 315, 20);
		frmPyramidBuilder.getContentPane().add(pyramidExplain);
		// JLabel for pyramid graphic
		JLabel pyramidImage = new JLabel("");
		pyramidImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon pyramidPic = new ImageIcon("pyramid.png");
		pyramidImage.setIcon(pyramidPic);
		pyramidImage.setBounds(100, 57, 208, 171);
		frmPyramidBuilder.getContentPane().add(pyramidImage);
		// JLabel to prompt user to enter the width of the base of the pyramid
		JLabel pyramidBaseWidthPrompt = new JLabel("Please Enter The Width of the Pyramid's Base:");
		pyramidBaseWidthPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		pyramidBaseWidthPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pyramidBaseWidthPrompt.setBounds(43, 284, 359, 14);
		frmPyramidBuilder.getContentPane().add(pyramidBaseWidthPrompt);
		// JTextField for user to input the width of the pyramid's base
		pyramidBaseWidthInput = new JTextField();
		pyramidBaseWidthInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pyramidBaseWidthInput.setColumns(10);
		pyramidBaseWidthInput.setBounds(114, 307, 183, 20);
		frmPyramidBuilder.getContentPane().add(pyramidBaseWidthInput);
		// JLabel to prompt user to enter the height of the pyramid
		JLabel pyramidHeightPrompt = new JLabel("Please Enter The Height of the Pyramid:");
		pyramidHeightPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		pyramidHeightPrompt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pyramidHeightPrompt.setBounds(41, 343, 359, 14);
		frmPyramidBuilder.getContentPane().add(pyramidHeightPrompt);
		// JTextField for user to input the height of the pyramid
		pyramidHeightInput = new JTextField();
		pyramidHeightInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pyramidHeightInput.setColumns(10);
		pyramidHeightInput.setBounds(114, 368, 183, 20);
		frmPyramidBuilder.getContentPane().add(pyramidHeightInput);

	}
}