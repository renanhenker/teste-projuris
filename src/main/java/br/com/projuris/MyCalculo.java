package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyCalculo implements Calculo {

	public MyCalculo() {

	}

	@Override
	public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
		List<CustoCargo> lista = new ArrayList<>();

		if (funcionarios != null) {

			/*
			 * Lista é convertida em Map, agrupando os funcionarios por cargo. A  chave do Map é o cargo e o valor é a soma dos salarios dos funcionarios do cargo em questão; 
			 * O Map resultante é percorrido, sendo criado um objeto CustoCargo para cada elemento do Map;
			 * O Map é convertido novamente em Lista, do tipo Custo Cargo.
			 */
			lista = funcionarios.stream()
					.collect(Collectors.groupingBy(Funcionario::getCargo,
							Collectors.reducing(BigDecimal.ZERO, Funcionario::getSalario, BigDecimal::add)))
					.entrySet().stream().map(elemMap -> new CustoCargo(elemMap.getKey(), elemMap.getValue()))
					.collect(Collectors.toList());
		}
		return lista;
	}

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
		List<CustoDepartamento> lista = new ArrayList<>();

		if (funcionarios != null) {
			/*
			 * Lista é convertida em Map, agrupando os funcionarios por departamento. A  chave do Map é o cargo e o valor é a soma dos salarios dos funcionarios do departamento em questão; 
			 * O Map resultante é percorrido, sendo criado um objeto CustoDepartamento para cada elemento do Map;
			 * O Map é convertido novamente em Lista, do tipo CustoDepartamento.
			 */
			lista = funcionarios.stream()
					.collect(Collectors.groupingBy(Funcionario::getDepartamento,
							Collectors.reducing(BigDecimal.ZERO, Funcionario::getSalario, BigDecimal::add)))
					.entrySet().stream().map(elemMap -> new CustoDepartamento(elemMap.getKey(), elemMap.getValue()))
					.collect(Collectors.toList());
		}
		return lista;
	}

	/**
	 * Método criado para auxiliar nos testes
	 * 
	 * @param lista
	 * @param cargo
	 * @return
	 */
	public BigDecimal getCustoPorCargo(List<CustoCargo> lista, String cargo) {
		return lista.stream().filter(x -> x.getCargo().equals(cargo)).map(CustoCargo::getCusto).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}

	/**
	 * Método criado para auxiliar nos testes
	 * 
	 * @param lista
	 * @param departamento
	 * @return
	 */
	public BigDecimal getCustoPorDepartamento(List<CustoDepartamento> lista, String departamento) {
		return lista.stream().filter(x -> x.getDepartamento().equals(departamento)).map(CustoDepartamento::getCusto)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
