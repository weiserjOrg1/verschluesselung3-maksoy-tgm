package aksoy.cipher;

public class KeywordCipher extends MonoAlphabeticCipher {

	public KeywordCipher(String keyword) throws CipherException {
		this.setKeyword(keyword);
	}

	public void setKeyword(String keyword) throws CipherException {
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
				case '�':
					newAlph += '�';
					break;
				case '�':
					newAlph += '�';
					break;
				case '�':
					newAlph += '�';
					break;
				case '�':
					newAlph += '�';
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
				nextLetter = '�';
				break;
			case 124:
				nextLetter = '�';
				break;
			case 125:
				nextLetter = '�';
				break;
			case 126:
				nextLetter = '�';
				break;
			}
			for (int j = 0; j < keywordLength; j++) {
				if (nextLetter == newAlph.charAt(j))
					verwendet = true;
			}
			if (!verwendet) {
				switch (nextLetter) {
				case 123:
					newAlph += '�';
					break;
				case 124:
					newAlph += '�';
					break;
				case 125:
					newAlph += '�';
					break;
				case 126:
					newAlph += '�';
					break;
				default:
					newAlph += nextLetter;
				}
			}
		}
		super.setSecretAlphabet(newAlph);
	}
}
