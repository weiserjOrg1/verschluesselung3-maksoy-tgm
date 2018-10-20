package aksoy.cipher;

/**
 * The class TPException is thrown when an invalid value for the transposition
 * level is entered (ex. -5).
 * 
 * @author Melih Aksoy
 * @version 20-10-2018
 */
public class TPException extends Exception {
	public TPException() {
		super("Exception: Invalid number for level entered.");
	}
}
