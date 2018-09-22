package br.com.projuris;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyFindCharTest {

	@Test
	public void deveriaRetornarAPrimeiraOcorrenciaNaoRepetida() {
		String s1 = "stress";
		String s2 = "reembolsar";

		MyFindChar myFindChar = new MyFindChar();
		assertEquals(myFindChar.findChar(s1), 't');
		assertEquals(myFindChar.findChar(s2), 'm');
	}

	@Test
	public void deveriaRetornarCaracterVazio() {
		String s1 = "sstrrteess";
		String s2 = "";
		String s3 = null;
		MyFindChar myFindChar = new MyFindChar();
		assertEquals(myFindChar.findChar(s1), ' ');
		assertEquals(myFindChar.findChar(s2), ' ');
		assertEquals(myFindChar.findChar(s3), ' ');
	}

}
