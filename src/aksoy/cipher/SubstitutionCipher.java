package aksoy.cipher;

/**
 * Uses the class MonoAlphabeticCipher's basic functionality to encrypt and
 * decrypt text.
 * 
 * @author Melih Aksoy
 * @version 10-10-2018
 */
public class SubstitutionCipher extends MonoAlphabeticCipher {
	public SubstitutionCipher() {
		super();
	}

	public SubstitutionCipher(String secretAlphabet) throws CipherException {
		this.setSecretAlphabet(secretAlphabet);
	}

	public void setSecretAlphabet(String secretAlphabet) throws CipherException {
		super.setSecretAlphabet(secretAlphabet);
	}
}
