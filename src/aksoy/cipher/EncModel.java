package aksoy.cipher;

/** The Model class contains all cipher methods available
 * for use. It also changes and resets the alphabets of
 * each cipher method.
 * @author Melih Aksoy
 * @version 18-10-2018
 */
import javax.swing.JOptionPane;

public class EncModel {
	public static final int MODE_SUBST = 0;
	public static final int MODE_SHIFT = 1;

	private int selectedMethod;
	private SubstitutionCipher subst;
	private ShiftCipher shift;

	public EncModel() {
		this.selectedMethod = MODE_SUBST;
		this.subst = new SubstitutionCipher();
		this.shift = new ShiftCipher();
	}

	public void change(String input) {
		try {
			if (this.selectedMethod == MODE_SUBST) {
				this.subst.setSecretAlphabet(input);
				JOptionPane.showMessageDialog(null, "Change successful!");
			} else {
				try {
					int inputInt = Integer.parseInt(input);
					this.shift.setShiftValue(inputInt);
					JOptionPane.showMessageDialog(null, "Change successful!");
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: Input is not a number.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (CipherException c) {
			JOptionPane.showMessageDialog(null, c.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void reset() {
		this.subst = new SubstitutionCipher();
		this.shift = new ShiftCipher();
		JOptionPane.showMessageDialog(null, "Reset successful!");
	}

	public String encrypt(String input) {
		return (this.selectedMethod == MODE_SUBST ? this.subst.encrypt(input) : this.shift.encrypt(input));
	}

	public String decrypt(String output) {
		return (this.selectedMethod == MODE_SUBST ? this.subst.decrypt(output) : this.shift.decrypt(output));
	}

	public int getMode() {
		return this.selectedMethod;
	}

	public void setMode(int mode) {
		this.selectedMethod = mode;
	}
}
