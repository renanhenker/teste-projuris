package br.com.projuris;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class MyCalculoTest {

	private Funcionario funcionario1 = new Funcionario("Assistente", "Administrativo", new BigDecimal("1000.0"));
	private Funcionario funcionario2 = new Funcionario("Gerente", "Administrativo", new BigDecimal("7000.70"));
	private Funcionario funcionario3 = new Funcionario("Diretor", "Administrativo", new BigDecimal("10000.45"));
	private Funcionario funcionario4 = new Funcionario("Assistente", "Financeiro", new BigDecimal("1300.9"));
	private Funcionario funcionario5 = new Funcionario("Gerente", "Financeiro", new BigDecimal("7500"));
	private Funcionario funcionario6 = new Funcionario("Diretor", "Financeiro", new BigDecimal("11000.0"));
	private Funcionario funcionario7 = new Funcionario("Estagi�rio", "Jur�dico", new BigDecimal("700.4"));
	private Funcionario funcionario8 = new Funcionario("Assistente", "Jur�dico", new BigDecimal("1800.90"));
	private Funcionario funcionario9 = new Funcionario("Gerente", "Jur�dico", new BigDecimal("9500.50"));
	private Funcionario funcionario10 = new Funcionario("Diretor", "Jur�dico", new BigDecimal("13000.0"));

	private List<Funcionario> listaFuncionarios = Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4,
			funcionario5, funcionario6, funcionario7, funcionario8, funcionario9, funcionario10);

	public List<Funcionario> getListaFuncionarios(){
		return listaFuncionarios;
	}

	@Test
	public void deveriaCriarListaVazia(){

		MyCalculo myCalculo = new MyCalculo();
		List<Funcionario> funcionarios = null;
		List<CustoCargo> listaCCargo =  myCalculo.custoPorCargo(funcionarios);
		assertEquals(listaCCargo.size(),0);
	}



	@Test
	public void deveriaCalcularOCustoPorCargo() {

		MyCalculo myCalculo = new MyCalculo();
		List<CustoCargo> listaCCargo =  myCalculo.custoPorCargo(listaFuncionarios);

		assertEquals(new BigDecimal("4101.80"), getCustoPorCargo(listaCCargo, "Assistente"));
		assertEquals(new BigDecimal("24001.20"), getCustoPorCargo(listaCCargo, "Gerente") );
		assertEquals(new BigDecimal("34000.45"), getCustoPorCargo(listaCCargo, "Diretor"));
		assertEquals(new BigDecimal("700.4"), getCustoPorCargo(listaCCargo, "Estagi�rio"));
	}

	@Test
	public void deveriaCalcularOCustoPorDepartamento() {


		MyCalculo myCalculo = new MyCalculo();
		List<CustoDepartamento> listaCDepartamento =  myCalculo.custoPorDepartamento(listaFuncionarios);

		assertEquals(new BigDecimal("18001.15"), getCustoPorDepartamento(listaCDepartamento, "Administrativo"));
		assertEquals(new BigDecimal("19800.9"), getCustoPorDepartamento(listaCDepartamento, "Financeiro"));
		assertEquals(new BigDecimal("25001.80"), getCustoPorDepartamento(listaCDepartamento, "Jur�dico"));
	}
	
	
	/**
	 * M�todo criado para teste
	 * @param lista
	 * @param cargo
	 * @return
	 */
	public BigDecimal getCustoPorCargo(List<CustoCargo> lista, String cargo) {
		return lista.stream().filter(x -> x.getCargo().equals(cargo)).map(CustoCargo::getCusto).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}

	public BigDecimal getCustoPorDepartamento(List<CustoDepartamento> lista, String cargo) {
		return lista.stream().filter(x -> x.getDepartamento().equals(cargo)).map(CustoDepartamento::getCusto)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
