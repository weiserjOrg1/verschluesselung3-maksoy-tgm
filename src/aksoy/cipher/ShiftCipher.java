package aksoy.cipher;

/**
 * The ShiftCipher class inherits MonoAlphabeticCipher's functionalities and
 * expands on it by adding the shift cipher.
 * 
 * @author Melih Aksoy
 * @version 18-10-2018
 *
 */
public class ShiftCipher extends MonoAlphabeticCipher {
	public ShiftCipher() {
		super();
	}

	public ShiftCipher(int value) throws CipherException {
		this.setShiftValue(value);
	}

	public void setShiftValue(int value) throws CipherException {
		if (value == 0)
			return;
		String alph = super.getSecretAlphabet();
		String newAlph = "";
		value = value % 30;
		if (value >= 0) {
			newAlph = alph.substring(value);
			newAlph += alph.substring(0, value);
			super.setSecretAlphabet(newAlph);
		} else {
			newAlph = alph.substring(29 + value);
			newAlph += alph.substring(0, 29 + value);
			super.setSecretAlphabet(newAlph);
		}
	}
}