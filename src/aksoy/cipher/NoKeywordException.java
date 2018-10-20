package aksoy.cipher;

/**
 * This custom exception is used for KeywordCipher.
 * 
 * @author Melih Aksoy
 * @version 19-10-2018
 */
public class NoKeywordException extends Exception {
	public NoKeywordException() {
		super("Exception: No Keyword input.");
	}
}
