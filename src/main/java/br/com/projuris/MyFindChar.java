package br.com.projuris;

public class MyFindChar implements FindCharacter {

	public MyFindChar() {

	}

	@Override
	public char findChar(String palavra) {
		if(palavra == null ){
			return ' ';
		}
		
		/*
		 * A string é convertida em um array do tipo Char para a busca ser feita pelo método lastIndexOf.
		 * Se o índice do char for o mesmo índice da última ocorrência do mesmo char no array então só existe uma ocorrência.
		 * */
		for (char c : palavra.toCharArray()) {
			if (palavra.indexOf(c) == palavra.lastIndexOf(c)) {
				return c;
			}
		}

		return ' ';
	}

}
