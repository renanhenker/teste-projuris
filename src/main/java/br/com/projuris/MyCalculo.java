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

			Map<String, BigDecimal> map = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getCargo,
					Collectors.reducing(BigDecimal.ZERO, Funcionario::getSalario, BigDecimal::add)));

			lista = funcionarios.stream()
					.collect(Collectors.groupingBy(Funcionario::getCargo,
							Collectors.reducing(BigDecimal.ZERO, Funcionario::getSalario, BigDecimal::add)))
					.entrySet().stream().map( e1 -> new CustoCargo(e1.getKey(), e1.getValue()))
					.collect(Collectors.toList());
			
//			 Primeira versão, sem stream
//			Map<String, BigDecimal> map = new LinkedHashMap<String, BigDecimal>();
//			for (Funcionario func : funcionarios) {
//				if (map.containsKey(func.getCargo())) {
//					BigDecimal custo = map.get(func.getCargo());
//					map.put(func.getCargo(), custo.add(func.getSalario()));
//				} else {
//					map.put(func.getCargo(), func.getSalario());
//				}
//			}
//			map.forEach((k, v) -> {
//				CustoCargo cc = new CustoCargo();
//				cc.setCargo(k);
//				cc.setCusto(v);
//				lista.add(cc);
//			});
		}
		return lista;
	}

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
		List<CustoDepartamento> lista = new ArrayList<>();

		if (funcionarios != null) {

			lista = funcionarios.stream()
					.collect(Collectors.groupingBy(Funcionario::getDepartamento,
							Collectors.reducing(BigDecimal.ZERO, Funcionario::getSalario, BigDecimal::add)))
					.entrySet().stream().map( e1 -> new CustoDepartamento(e1.getKey(), e1.getValue()))
					.collect(Collectors.toList());
			
//			 Primeira versão, sem stream
//			Map<String, BigDecimal> map = new LinkedHashMap<String, BigDecimal>();
//			for (Funcionario func : funcionarios) {
//				if (map.containsKey(func.getDepartamento())) {
//					BigDecimal custo = new BigDecimal(map.get(func.getDepartamento()).toString());
//					map.put(func.getDepartamento(), custo.add(func.getSalario()));
//				} else {
//					map.put(func.getDepartamento(), func.getSalario());
//				}
//			}
//			map.forEach((k, v) -> {
//				CustoDepartamento cd = new CustoDepartamento();
//				cd.setDepartamento(k);
//				cd.setCusto(v);
//				lista.add(cd);
//			});
		}
		return lista;
	}

}
