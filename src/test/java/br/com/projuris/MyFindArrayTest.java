package br.com.projuris;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyFindArrayTest {

	@Test
	public void deveriaRetornarAPosicao() {
		
		int array1[] = {4,9,3,7,8};
		int subArray1[] = {3,7};
		int array2[] = {1,3,5};
		int subArray2[] = {1};
		int array3[] = {4,9,3,7,8,3,7,1};
		int subArray3[] = {3,7};
		
		MyFindArray myFindArray = new MyFindArray();
		assertEquals(2, myFindArray.findArray(array1, subArray1));
		assertEquals(0, myFindArray.findArray(array2, subArray2));
		assertEquals(5, myFindArray.findArray(array3, subArray3));
	}

	@Test
	public void deveriaRetornarMenosUm() {
		
		int array1[] = {7,8,9};
		int subArray1[] = {8,9,10};
		
		MyFindArray myFindArray = new MyFindArray();
		assertEquals(-1, myFindArray.findArray(array1, subArray1));
	}
}
