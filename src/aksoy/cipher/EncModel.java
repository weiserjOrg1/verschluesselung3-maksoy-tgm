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

	private int selectedMethod;
	private MonoAlphabeticCipher cipher;

	public EncModel() {
		this.selectedMethod = MODE_SUBST;
		this.cipher = new MonoAlphabeticCipher();
	}

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
			}
			JOptionPane.showMessageDialog(null, "Change successful!");
		} catch (CipherException c) {
			JOptionPane.showMessageDialog(null, c.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Exception: Input is not a number.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (NoKeywordException d) {
			JOptionPane.showMessageDialog(null, d.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void reset() {
		this.cipher = new MonoAlphabeticCipher();
		JOptionPane.showMessageDialog(null, "Reset successful!");
	}

	public String encrypt(String input) {
		return this.cipher.encrypt(input);
	}

	public String decrypt(String output) {
		return this.cipher.decrypt(output);
	}

	public int getMode() {
		return this.selectedMethod;
	}

	public void setMode(int mode) {
		this.cipher = new MonoAlphabeticCipher();
		this.selectedMethod = mode;
	}
}
