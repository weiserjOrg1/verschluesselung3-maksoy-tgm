package aksoy.cipher;
/**The interface Cipher provides two methods to
 * be overwritten by any class it gets implemented in.
 * @author Melih Aksoy
 * @version 10-10-2018
 */
public interface Cipher {
	public String encrypt(String text);
	public String decrypt(String text);
}
