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
	private JRadioButton kwdCipherR;
	private JRadioButton trpCipherR;
	private ButtonGroup radioGroup;

	private JTextField changeInput;
	private JLabel changeLabel;
	private JPanel changePanel;
	private JButton applyChangeB;
	private JButton resetB;
	private JPanel applyPanel;

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
		this.shiCipherR = new JRadioButton("Shift");
		this.kwdCipherR = new JRadioButton("Keyword");
		this.trpCipherR = new JRadioButton("Transpos");
		this.subCipherR.addActionListener(this.c);
		this.subCipherR.addFocusListener(this.c);
		this.shiCipherR.addActionListener(this.c);
		this.shiCipherR.addFocusListener(this.c);
		this.kwdCipherR.addActionListener(this.c);
		this.kwdCipherR.addFocusListener(this.c);
		this.trpCipherR.addActionListener(this.c);
		this.trpCipherR.addFocusListener(this.c);
		this.radioGroup = new ButtonGroup();
		this.radioGroup.add(this.subCipherR);
		this.radioGroup.add(this.shiCipherR);
		this.radioGroup.add(this.kwdCipherR);
		this.radioGroup.add(this.trpCipherR);

		this.selection = new JPanel();
		this.selection.setBorder(BorderFactory.createTitledBorder("Encryption Method"));
		this.selection.add(this.subCipherR);
		this.selection.add(this.shiCipherR);
		this.selection.add(this.kwdCipherR);
		this.selection.add(this.trpCipherR);
		this.selection.setMaximumSize(new Dimension(this.getWidth(), 60));

		this.changeAlphabetBox = new JPanel();
		this.changeAlphabetBox.setBorder(BorderFactory.createTitledBorder("Alphabet Settings"));
		this.changeAlphabetBox.setMaximumSize(new Dimension(this.getWidth(), 120));
		this.changeAlphabetBox.setLayout(new GridLayout(2, 1));

		this.changeLabel = new JLabel("Substitution: ");
		this.changeInput = new JTextField();

		this.changePanel = new JPanel();
		this.changePanel.setLayout(new GridLayout(1, 2));
		this.changePanel.add(this.changeLabel);
		this.changePanel.add(this.changeInput);

		this.applyChangeB = new JButton("Apply");
		this.applyChangeB.addActionListener(this.c);

		this.resetB = new JButton("Reset");
		this.resetB.addActionListener(this.c);

		this.applyPanel = new JPanel();
		this.applyPanel.setLayout(new GridLayout(1, 4));
		this.applyPanel.add(new Container());
		this.applyPanel.add(this.applyChangeB);
		this.applyPanel.add(this.resetB);
		this.applyPanel.add(new Container());

		this.changeAlphabetBox.add(this.changePanel);
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
	 * Checks if the component the user interacted with is the Substitution radio
	 * button.
	 * 
	 * @param s Object taken by ActionEvent
	 * @return True if s is the Substitution radio button, false otherwise.
	 */
	public boolean isSubst(Object s) {
		if (s == this.subCipherR)
			return true;
		return false;
	}

	/**
	 * Checks if the component the user interacted with is the Shift Cipher radio
	 * button.
	 * 
	 * @param s Object taken by ActionEvent
	 * @return True if s is the Shift Cipher radio button, false otherwise.
	 */
	public boolean isShift(Object s) {
		if (s == this.shiCipherR)
			return true;
		return false;
	}

	/**
	 * Checks if the component the user interacted with is the Keyword Cipher radio
	 * button.
	 * 
	 * @param s Object taken by ActionEvent
	 * @return True if s is the Keyword Cipher radio button, false otherwise.
	 */
	public boolean isKeyword(Object s) {
		if (s == this.kwdCipherR)
			return true;
		return false;
	}

	/**
	 * Checks if the component the user interacted with is the Transposition radio
	 * button.
	 * 
	 * @param s Object taken by ActionEvent
	 * @return True if s is the Keyword Cipher radio button, false otherwise.
	 */
	public boolean isTrans(Object s) {
		if (s == this.trpCipherR)
			return true;
		return false;
	}

	/**
	 * Returns the input in the change input field.
	 * 
	 * @return Input in the change input field.
	 */
	public String getChangeInp() {
		return this.changeInput.getText();
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
	 * @param s Object taken by ActionEvent
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
	 * @param s Object taken by ActionEvent
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
	 * @param s Object taken by ActionEvent
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
	 * @param s Object taken by ActionEvent
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
	 * @param mode The current chosen cipher method
	 */
	public void setChangeLayout(int mode) {
		switch (mode) {
		case EncModel.MODE_SUBST:
			this.changeLabel.setText("Substitution");
			this.m.setMode(EncModel.MODE_SUBST);
			break;
		case EncModel.MODE_SHIFT:
			this.changeLabel.setText("Shifting");
			this.m.setMode(EncModel.MODE_SHIFT);
			break;
		case EncModel.MODE_KWORD:
			this.changeLabel.setText("Keyword");
			this.m.setMode(EncModel.MODE_KWORD);
			break;
		case EncModel.MODE_TRANS:
			this.changeLabel.setText("Transposition Level");
			this.m.setMode(EncModel.MODE_TRANS);
		}
	}
}
