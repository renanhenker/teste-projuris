package br.com.projuris;

import java.util.Arrays;

/**
 * 
 * @author renan.regis
 *
 */
public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {

		if (array == null || subArray == null) {
			return -1;
		}
		/*
		 * Os arrays são convertidos em string, sendo removidos os caracteres "[", "]" e  "," resultantes da aplicação do método Arrays.toString().
		 * */
		String arrayString = Arrays.toString(array).replaceAll("\\[|\\]|,|\\s", "");
		String subArrayString = Arrays.toString(subArray).replaceAll("\\[|\\]|,|\\s", "");
		
		return arrayString.lastIndexOf(subArrayString);
	}

}
