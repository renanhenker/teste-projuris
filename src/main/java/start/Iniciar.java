package start;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.projuris.CustoCargo;
import br.com.projuris.Funcionario;
import br.com.projuris.MyCalculo;

public class Iniciar {

	public static void main(String[] args) {
		int i = Collections.indexOfSubList(Arrays.asList(1,2,3,4,2,3), Arrays.asList(4));
		System.out.println(i);


		"hey duke".chars().forEach(c -> System.out.println((char)c));


		Funcionario funcionario1 = new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0));
		Funcionario funcionario2 = new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70));
		Funcionario funcionario3 = new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45));
		Funcionario funcionario4 = new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9));
		Funcionario funcionario5 = new Funcionario("Gerente", "Financeiro", new BigDecimal(7500));
		Funcionario funcionario6 = new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0));
		Funcionario funcionario7 = new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.4));
		Funcionario funcionario8 = new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90));
		Funcionario funcionario9 = new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50));
		Funcionario funcionario10 = new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.0));

		List<Funcionario> listaFuncionarios = Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4,
				funcionario5, funcionario6, funcionario7, funcionario8, funcionario9, funcionario10);

		MyCalculo myCalculo = new MyCalculo();
		List<CustoCargo> listaCCargo =  myCalculo.custoPorCargo(listaFuncionarios);

//		BigDecimal big = myCalculo.getCustoPorCargo(listaCCargo, "Assistente");

	}

}
