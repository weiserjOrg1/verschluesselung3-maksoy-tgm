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
	public static final int MODE_KWORD = 2;
	public static final int MODE_TRANS = 3;

	private int selectedMethod;
	private MonoAlphabeticCipher cipher;
	private TranspositionCipher tcipher;

	public EncModel() {
		this.selectedMethod = MODE_SUBST;
		this.cipher = new MonoAlphabeticCipher();
	}

	/**
	 * The method change changes the chosen method of encryption to the one
	 * specified in the parameter.
	 * 
	 * @param input The desired encryption decryption mode.
	 */
	public void change(String input) {
		try {
			switch (this.selectedMethod) {
			case MODE_SUBST:
				this.cipher = new SubstitutionCipher(input);
				break;
			case MODE_SHIFT:
				int inputInt = Integer.parseInt(input);
				this.cipher = new ShiftCipher(inputInt);
				break;
			case MODE_KWORD:
				this.cipher = new KeywordCipher(input);
				break;
			case MODE_TRANS:
				inputInt = Integer.parseInt(input);
				this.tcipher = new TranspositionCipher(inputInt);
				break;
			}
			JOptionPane.showMessageDialog(null, "Change successful!");
		} catch (CipherException | NoKeywordException c) {
			JOptionPane.showMessageDialog(null, c.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Exception: Input is not a number.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void reset() {
		this.cipher = new MonoAlphabeticCipher();
		this.tcipher = new TranspositionCipher(1);
		JOptionPane.showMessageDialog(null, "Reset successful!");
	}

	public String encrypt(String input) {
		return (this.selectedMethod != MODE_TRANS) ? this.cipher.encrypt(input) : this.tcipher.encrypt(input);
	}

	public String decrypt(String output) {
		return (this.selectedMethod != MODE_TRANS) ? this.cipher.decrypt(output) : this.tcipher.decrypt(output);
	}

	public int getMode() {
		return this.selectedMethod;
	}

	public void setMode(int mode) {
		if (mode != MODE_TRANS) {
			this.cipher = new MonoAlphabeticCipher();
		} else {
			this.tcipher = new TranspositionCipher(1);
		}
		this.selectedMethod = mode;
	}
}
