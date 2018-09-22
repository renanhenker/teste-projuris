package br.com.projuris;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyFindChar implements FindCharacter {

	public MyFindChar() {

	}

	@Override
	public char findChar(String palavra) {
		if(palavra == null ){
			return ' ';
		}
		for (char c : palavra.toCharArray()) {
			if (palavra.indexOf(c) == palavra.lastIndexOf(c)) {
				return c;
			}
		}

		return ' ';
	}



//	public char findChar1(String word) {
//
//		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
//		char c[] = word.toCharArray();
//
//		for (char ch : c) {
//			if (map.containsKey(ch)) {
//				int count = map.get(ch);
//				map.put(ch, count + 1);
//			} else {
//				map.put(ch, 1);
//			}
//		}
//
//		for (char ch : c) {
//			if (map.get(ch) == 1) {
//				return ch;
//			}
//		}
//
//		return ' ';
//	}

}
