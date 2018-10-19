package aksoy.cipher;

/**
 * This custom exception is used for MonoAlphabeticCipher. Used when two of the
 * same characters are used.
 * 
 * @author Melih Aksoy
 * @version 19-10-2018
 */
public class CipherDuplicateException extends CipherException {
	public CipherDuplicateException() {
		super("Exception: Character used twice.");
	}
}
