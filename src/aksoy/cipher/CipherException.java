package aksoy.cipher;
/**
 * This custom exception is used for MonoAlphabeticCipher.
 * @author Melih Aksoy
 * @version 10-10-2018
 */
public class CipherException extends Exception{
	public CipherException(String msg) {
		super(msg);
	}
	public CipherException() {
		super("Exception: Unspecified cipher exception");
	}
}
