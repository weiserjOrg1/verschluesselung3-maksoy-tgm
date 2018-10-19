package aksoy.cipher;

/**
 * MonoAlphabeticCipher is the class that contains the basic functionalities
 * like encryption and decryption and the changing of the secret alphabet.
 * 
 * @author Melih Aksoy
 * @version 10-10-2018
 */
public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet;

	public MonoAlphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}

	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}

	/**
	 * This method changes the current secret alphabet to the one defined in the
	 * parameter, assuming it satisfies all conditions.
	 * 
	 * @param secretAlphabet
	 *            The desired secret alphabet.
	 * @throws CipherException
	 *             The Exception that is thrown when an issue is found in the input.
	 */
	protected void setSecretAlphabet(String secretAlphabet) throws CipherException {
		if (secretAlphabet.length() != 30) {
			throw new CipherException("Exception: Unsatisfied length condition");
		}
		String tempString = "";
		secretAlphabet = secretAlphabet.toLowerCase();
		for (int i = 0; i < this.secretAlphabet.length(); i++) {
			char letter = secretAlphabet.charAt(i);
			boolean isDouble = false;
			for (int j = 0; j < tempString.length(); j++) {
				if (letter == tempString.charAt(j)) {
					isDouble = true;
					break;
				}
			}
			if (!isDouble) {
				switch (letter) {
				case 'ä':
				case 'ö':
				case 'ü':
				case 'ß':
					tempString += letter;
					break;
				default:
					if (letter >= 97 && letter <= 122) {
						tempString += letter;
					} else {
						throw new CipherException("Exception: Illegal character used");
					}
				}
			} else {
				throw new CipherException("Exception: Letter used twice");
			}
		}
		this.secretAlphabet = tempString;
	}

	/**
	 * This method encrypts the specified text using the secret alphabet.
	 * 
	 * @param text
	 *            The text to encrypt.
	 * @return The encrypted text.
	 */
	public String encrypt(String text) {
		String output = "";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			switch (text.charAt(i)) {
			case 'ä':
				output += this.secretAlphabet.charAt(123 - 97);
				break;
			case 'ö':
				output += this.secretAlphabet.charAt(124 - 97);
				break;
			case 'ü':
				output += this.secretAlphabet.charAt(125 - 97);
				break;
			case 'ß':
				output += this.secretAlphabet.charAt(126 - 97);
				break;
			default:
				if (text.charAt(i) >= 97 && text.charAt(i) <= 122) {
					output += this.secretAlphabet.charAt(text.charAt(i) - 97);
				} else {
					output += text.charAt(i);
				}
			}
		}
		return output;
	}

	/**
	 * This method decrypts the specified text using the secret alphabet.
	 * 
	 * @param text
	 *            The text to decrypt.
	 * @return The decrypted text.
	 */

	public String decrypt(String text) {
		String output = "";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			if ((letter >= 97 && letter <= 122) || letter == 228 || letter == 246 || letter == 252 || letter == 223) {
				int id = this.secretAlphabet.indexOf(letter);
				char letterAdd = (char) (97 + id);
				switch (letterAdd) {
				case 123:
					output += 'ä';
					break;
				case 124:
					output += 'ö';
					break;
				case 125:
					output += 'ü';
					break;
				case 126:
					output += 'ß';
					break;
				default:
					output += letterAdd;
				}
			} else {
				output += letter;
			}
		}
		return output;
	}
}
