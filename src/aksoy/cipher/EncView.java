package aksoy.cipher;

/**
 * The EncView class contains all visual components of the GUI.
 * @author Melih Aksoy
 * @version 18-10-2018
 */
import javax.swing.*;
import java.awt.*;

public class EncView extends JFrame {
	private EncModel m;
	private EncController c;

	private JPanel selection;
	private JPanel changeAlphabetBox;
	private JPanel inputOutputBox;

	private JRadioButton subCipherR;
	private JRadioButton shiCipherR;
	private ButtonGroup radioGroup;

	private JTextField inputShift;
	private JTextField inputSubst;
	private JLabel shiftLabel;
	private JLabel substLabel;
	private JPanel inpShiftPanel;
	private JPanel inpSubstPanel;
	private JButton applyChangeB;
	private JButton resetB;

	private JTextField text;
	private JTextField output;
	private JButton encrypt;
	private JButton decrypt;

	public EncView(EncController con, EncModel mod) {
		this.m = mod;
		this.c = con;
		this.setTitle("Ncrypt-Dcrypt");
		this.setMinimumSize(new Dimension(350, 500));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		this.subCipherR = new JRadioButton("Substitution", true);
		this.shiCipherR = new JRadioButton("Shift Cipher");
		this.subCipherR.addActionListener(this.c);
		this.subCipherR.addFocusListener(this.c);
		this.shiCipherR.addActionListener(this.c);
		this.shiCipherR.addFocusListener(this.c);
		this.radioGroup = new ButtonGroup();
		this.radioGroup.add(this.subCipherR);
		this.radioGroup.add(this.shiCipherR);

		this.selection = new JPanel();
		this.selection.setBorder(BorderFactory.createTitledBorder("Encryption Method"));
		this.selection.add(this.subCipherR);
		this.selection.add(this.shiCipherR);
		this.selection.setMaximumSize(new Dimension(this.getWidth(), 60));

		this.changeAlphabetBox = new JPanel();
		this.changeAlphabetBox.setBorder(BorderFactory.createTitledBorder("Alphabet Settings"));
		this.changeAlphabetBox.setMaximumSize(new Dimension(this.getWidth(), 120));
		this.changeAlphabetBox.setLayout(new GridLayout(3, 1));

		this.substLabel = new JLabel("Substitution: ");
		this.inputSubst = new JTextField();

		this.inpSubstPanel = new JPanel();
		this.inpSubstPanel.setLayout(new GridLayout(1, 2));
		this.inpSubstPanel.add(this.substLabel);
		this.inpSubstPanel.add(this.inputSubst);

		this.shiftLabel = new JLabel("Shifting: ");
		this.inputShift = new JTextField();
		this.inputShift.setEditable(false);

		this.inpShiftPanel = new JPanel();
		this.inpShiftPanel.setLayout(new GridLayout(1, 2));
		this.inpShiftPanel.add(this.shiftLabel);
		this.inpShiftPanel.add(this.inputShift);

		this.applyChangeB = new JButton("Apply");
		this.applyChangeB.addActionListener(this.c);

		this.resetB = new JButton("Reset");
		this.resetB.addActionListener(this.c);

		JPanel applyPanel = new JPanel();
		applyPanel.setLayout(new GridLayout(1, 4));
		applyPanel.add(new Container());
		applyPanel.add(this.applyChangeB);
		applyPanel.add(this.resetB);
		applyPanel.add(new Container());

		this.changeAlphabetBox.add(this.inpSubstPanel);
		this.changeAlphabetBox.add(this.inpShiftPanel);
		this.changeAlphabetBox.add(applyPanel);

		this.inputOutputBox = new JPanel();
		this.inputOutputBox.setBorder(BorderFactory.createTitledBorder("Input & Output"));
		this.inputOutputBox.setLayout(new GridLayout(4, 1));

		this.text = new JTextField("");
		JLabel textLabel = new JLabel("Input: ");
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2));
		textPanel.add(textLabel);
		textPanel.add(this.text);

		this.output = new JTextField("");
		JLabel outLabel = new JLabel("Output: ");
		JPanel outPanel = new JPanel();
		outPanel.setLayout(new GridLayout(1, 2));
		outPanel.add(outLabel);
		outPanel.add(this.output);
		this.output.setEditable(false);

		this.encrypt = new JButton("Encrypt");
		this.encrypt.addActionListener(this.c);
		this.decrypt = new JButton("Decrypt");
		this.decrypt.addActionListener(this.c);

		this.inputOutputBox.add(textPanel);
		this.inputOutputBox.add(outPanel);
		this.inputOutputBox.add(this.encrypt);
		this.inputOutputBox.add(this.decrypt);

		this.add(this.selection);
		this.add(this.changeAlphabetBox);
		this.add(this.inputOutputBox);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * Checks if Substitution is selected.
	 * 
	 * @return True if Substitution is selected, false otherwise.
	 */
	public boolean isSubstSelected() {
		return (this.subCipherR.isSelected()) ? true : false;
	}

	/**
	 * Checks if the component the user interacted with is the Substitution radio
	 * button.
	 * 
	 * @param s
	 *            Object taken by ActionEvent
	 * @return True if s is the Substitution radio button, false otherwise.
	 */
	public boolean isSubst(Object s) {
		if (s == this.subCipherR)
			return true;
		return false;
	}

	/**
	 * Checks if Shift Cipher is selected.
	 * 
	 * @return True if Shift Cipher is selected, false otherwise.
	 */
	public boolean isShiftSelected() {
		return (this.shiCipherR.isSelected()) ? true : false;
	}

	/**
	 * Checks if the component the user interacted with is the Shift Cipher radio
	 * button.
	 * 
	 * @param s
	 *            Object taken by ActionEvent
	 * @return True if s is the Shift Cipher radio button, false otherwise.
	 */
	public boolean isShift(Object s) {
		if (s == this.shiCipherR)
			return true;
		return false;
	}

	/**
	 * Returns the input in the Substitution input field.
	 * 
	 * @return Input in the Substitution input field.
	 */
	public String getSubstInp() {
		return this.inputSubst.getText();
	}

	/**
	 * Returns the input in the Shifting input field.
	 * 
	 * @return Input in the Shifting input field.
	 */
	public String getShiftInp() {
		return this.inputShift.getText();
	}

	/**
	 * Returns the text to be encrypted.
	 * 
	 * @return Text for the encryption.
	 */
	public String getInput() {
		return this.text.getText();
	}

	/**
	 * Changes the text for the output field for results.
	 */
	public void setOutput(String output) {
		this.output.setText(output);
	}

	/**
	 * Checks if the specified Object s is the button for applying changes.
	 * 
	 * @param s
	 *            Object taken by ActionEvent
	 * @return True if s is the button for changing the alphabet, false otherwise.
	 */
	public boolean isApplyChange(Object s) {
		if (s == this.applyChangeB)
			return true;
		return false;
	}

	/**
	 * Checks if the specified Object s is the button for resetting changes.
	 * 
	 * @param s
	 *            Object taken by ActionEvent
	 * @return True if s is the button for resetting all alphabets, false otherwise.
	 */
	public boolean isReset(Object s) {
		if (s == this.resetB)
			return true;
		return false;
	}

	/**
	 * Checks if the specified Object s is the button for encrypting input.
	 * 
	 * @param s
	 *            Object taken by ActionEvent
	 * @return True if s is the button for encrypting, false otherwise.
	 */
	public boolean isEncrypt(Object s) {
		if (s == this.encrypt)
			return true;
		return false;
	}

	/**
	 * Checks if the specified Object s is the button for decrypting input.
	 * 
	 * @param s
	 *            Object taken by ActionEvent
	 * @return True if s is the button for decrypting, false otherwise.
	 */
	public boolean isDecrypt(Object s) {
		if (s == this.decrypt)
			return true;
		return false;
	}

	/**
	 * This method changes the layout to fit the cipher method that was chosen.
	 * 
	 * @param mode
	 *            The current chosen cipher method
	 */
	public void setChangeLayout(int mode) {
		if (mode == EncModel.MODE_SUBST) {
			this.inputSubst.setEditable(true);
			this.inputShift.setEditable(false);
			this.m.setMode(EncModel.MODE_SUBST);
		} else {
			this.inputSubst.setEditable(false);
			this.inputShift.setEditable(true);
			this.m.setMode(EncModel.MODE_SHIFT);
		}
	}
}
