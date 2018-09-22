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
		 * A string � convertida em um array do tipo Char para a busca ser feita pelo m�todo lastIndexOf.
		 * Se o �ndice do char for o mesmo �ndice da �ltima ocorr�ncia do mesmo char no array ent�o s� existe uma ocorr�ncia.
		 * */
		for (char c : palavra.toCharArray()) {
			if (palavra.indexOf(c) == palavra.lastIndexOf(c)) {
				return c;
			}
		}

		return ' ';
	}

}
