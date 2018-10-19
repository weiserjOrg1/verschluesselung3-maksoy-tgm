package aksoy.cipher;

/**
 * This custom exception is used for MonoAlphabeticCipher. Used when an illegal
 * character is used.
 * 
 * @author Melih Aksoy
 * @version 19-10-2018
 */
public class CipherCharException extends CipherException {
	public CipherCharException() {
		super("Exception: Illegal character used.");
	}
}
