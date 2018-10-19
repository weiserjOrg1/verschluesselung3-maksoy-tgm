package aksoy.cipher;

/**
 * This custom exception is used for MonoAlphabeticCipher. Used when the length
 * of the alphabet is not 30 characters.
 * 
 * @author Melih Aksoy
 * @version 19-10-2018
 */
public class CipherLengthException extends CipherException {
	public CipherLengthException() {
		super("Exception: Unsatisfied cipher length.");
	}
}
