package aksoy.cipher;

/**
 * Uses the class MonoAlphabeticCipher's basic functionality to encrypt and
 * decrypt text. Changes alphabet based on the secret keyword that is put in.
 * 
 * @author Melih Aksoy
 * @version 20-10-2018
 */
public class KeywordCipher extends MonoAlphabeticCipher {

	public KeywordCipher(String keyword) throws CipherException, NoKeywordException {
		this.setKeyword(keyword);
	}

	/**
	 * This method changes the input keyword to fit in to the alphabet. Once all
	 * unneeded and duplicate characters are removed, the rest of the alphabet is
	 * added to the keyword.
	 * 
	 * @param keyword Keyword for use in the alphabet
	 * @throws CipherException    Thrown when alphabet does not satisfy
	 *                            requirements.
	 * @throws NoKeywordException Thrown when no keyword is given.
	 */
	public void setKeyword(String keyword) throws CipherException, NoKeywordException {
		if (keyword.length() == 0)
			throw new NoKeywordException();
		keyword = keyword.toLowerCase();
		String newAlph = "";
		for (int i = 0; i < keyword.length(); i++) {
			boolean verwendet = false;
			for (int j = 0; j < newAlph.length(); j++) {
				if (newAlph.charAt(j) == keyword.charAt(i))
					verwendet = true;
			}
			if (!verwendet) {
				switch (keyword.charAt(i)) {
				case 'ä':
					newAlph += 'ä';
					break;
				case 'ö':
					newAlph += 'ö';
					break;
				case 'ü':
					newAlph += 'ü';
					break;
				case 'ß':
					newAlph += 'ß';
					break;
				default:
					if (keyword.charAt(i) >= 97 && keyword.charAt(i) <= 122)
						newAlph += keyword.charAt(i);
				}
			}
		}
		int keywordLength = newAlph.length();
		for (int i = 0; i < 30; i++) {
			boolean verwendet = false;
			char nextLetter = (char) (97 + i);
			switch (nextLetter) {
			case 123:
				nextLetter = 'ä';
				break;
			case 124:
				nextLetter = 'ö';
				break;
			case 125:
				nextLetter = 'ü';
				break;
			case 126:
				nextLetter = 'ß';
				break;
			}
			for (int j = 0; j < keywordLength; j++) {
				if (nextLetter == newAlph.charAt(j))
					verwendet = true;
			}
			if (!verwendet) {
				switch (nextLetter) {
				case 123:
					newAlph += 'ä';
					break;
				case 124:
					newAlph += 'ö';
					break;
				case 125:
					newAlph += 'ü';
					break;
				case 126:
					newAlph += 'ß';
					break;
				default:
					newAlph += nextLetter;
				}
			}
		}
		super.setSecretAlphabet(newAlph);
	}
}
