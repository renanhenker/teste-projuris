package br.com.projuris;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;



/**
 * Ainda por fazer
 * @author renan.regis
 *
 */
public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {
//		int indiceOcorrencia = -1;
//		List<Integer> lista = Arrays.asList(1, 2, 3);
//		// lista.stream().map(mapper)
//
//		if (subArray.length > array.length)
//			return -1;
//
//		for (int i = 0; i < subArray.length; i++) {
//			for (int j = indiceOcorrencia + 1; j < array.length; j++) {
//				if (array[j] != subArray[i]) {
//					continue;
//				}
//				indiceOcorrencia = j;
//				break;
//			}
//		}

		StringBuilder sb = new StringBuilder();
	      for (int i = 0; i < array.length; i++) {
	          sb.append(array[i]);
	      }
	      String string = sb.toString();

	      sb = new StringBuilder();
	      for (int i = 0; i < subArray.length; i++) {
	          sb.append(subArray[i]);
	      }
	      String subString = sb.toString();

	      return string.lastIndexOf(subString);
	}

}
