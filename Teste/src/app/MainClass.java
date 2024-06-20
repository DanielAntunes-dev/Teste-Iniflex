package app;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Funcionario;

// 3 – Deve conter uma classe Principal para executar as seguintes ações:
public class MainClass {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<>();

		BigDecimal salarioMinimo = new BigDecimal("1212.00");
		

		// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
		// acima.
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
		funcionarios
				.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
		funcionarios
				.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

		// 3.2 – Remover o funcionário “João” da lista.
		funcionarios.removeIf(p -> p.getNome().equals("João"));

		// 3.3 – Imprimir todos os funcionários com todas suas informações
		System.out.println("lista de todos os Funcionários após a remoção do João:");
		System.out.println();
		for (Funcionario f : funcionarios)
			System.out.println(f);
		System.out.println("____________________________________________");

		System.out.println();

		// 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
		// de funcionários com novo valor.
		aplicarAumento(funcionarios, BigDecimal.valueOf(0.10));

		System.out.println("\nFuncionários após o aumento de 10%:");
		System.out.println();
		for (Funcionario f : funcionarios)
			System.out.println(f);
		System.out.println("____________________________________________");
		System.out.println();

		// 3.10 – Imprimir a lista de funcionários por ordem alfabética.
		Collections.sort(funcionarios, (Funcionario a, Funcionario b) -> a.getNome().compareTo(b.getNome()));
		System.out.println("Funcionários em ordem alfabética:");
		System.out.println();
		funcionarios.forEach(System.out::println);
		System.out.println("____________________________________________");

		// 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
		// Agrupando funcionários por função
		Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao(funcionarios);
		System.out.println("\nFuncionários agrupados por função:");
		imprimirFuncionariosPorFuncao(funcionariosPorFuncao);

		// 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
		imprimirAniversariantes(funcionarios, 10);
		System.out.println();
		imprimirAniversariantes(funcionarios, 12);
		System.out.println();
		System.out.println("____________________________________________");

		// 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
		// idade.
		imprimirFuncionarioMaiorIdade(funcionarios);
		System.out.println();
		System.out.println("____________________________________________");

		BigDecimal totalSalarios = BigDecimal.ZERO;
		for (Funcionario funcionario : funcionarios) {
			totalSalarios = totalSalarios.add(funcionario.getSalario());
		}
		// 3.11 – Imprimir o total dos salários dos funcionários.
		System.out.println("Total dos salários dos funcionários: " + new DecimalFormat("###,###.##").format(totalSalarios));
		System.out.println();
		System.out.println("____________________________________________");

		// 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
		// que o salário mínimo é R$1212.00.
		//// NÃO CONSEGUI FAZER SOZINHO, PESQUISEI E ENCONTREI
		System.out.println("Salários em salários mínimos:");
		for (Funcionario funcionario : funcionarios) {
			BigDecimal salariosMinimos = funcionario.calcularSalariosMinimos(salarioMinimo);
			System.out.println(funcionario.getNome() + ": " + salariosMinimos + " salários mínimos");
		}
		System.out.println();

	}

	// 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
	// de funcionários com novo valor.
	private static void aplicarAumento(List<Funcionario> funcionarios, BigDecimal percentualAumento) {
		for (Funcionario funcionario : funcionarios) {
			BigDecimal salarioAtual = funcionario.getSalario();
			BigDecimal aumento = salarioAtual.multiply(percentualAumento);
			BigDecimal novoSalario = salarioAtual.add(aumento);
			funcionario.setSalario(novoSalario);
		}
	}

	// 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
	// e o valor a “lista de funcionários”.
	// NÃO CONSEGUI FAZER SOZINHO, PESQUISEI E ENCONTREI
	private static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
		Map<String, List<Funcionario>> map = new HashMap<>();

		// Itera sobre a lista de funcionários
		for (Funcionario funcionario : funcionarios) {
			String funcao = funcionario.getFuncao();

			// Verifica se a função já está no mapa
			if (!map.containsKey(funcao)) {
				map.put(funcao, new ArrayList<>()); // Se não estiver, adiciona uma nova lista vazia
			}

			// Adiciona o funcionário à lista correspondente à sua função
			map.get(funcao).add(funcionario);
		}

		return map;
	}

	// 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
	// NÃO CONSEGUI FAZER SOZINHO, PESQUISEI E ENCONTREI
	private static void imprimirAniversariantes(List<Funcionario> funcionarios, int mes) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Funcionários que fazem aniversário no mês " + mes + ":");

		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getDataNascimento().getMonthValue() == mes) {
				
				
				String dataNascimento = funcionario.getDataNascimento().format(dateFormatter);
				System.out.println("Nome: " + funcionario.getNome());
				System.out.println("Data de Nascimento: " + dataNascimento);
				System.out.println("Função: " + funcionario.getFuncao());
				System.out.println(); // Linha em branco entre funcionários
			}
		}
	}
	

	// 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e
	// idade.
	// NÃO CONSEGUI FAZER SOZINHO, PESQUISEI E ENCONTREI
	private static void imprimirFuncionarioMaiorIdade(List<Funcionario> funcionarios) {
		String nomeMaisVelho = null;
		int idadeMaisVelho = Integer.MIN_VALUE;

		LocalDate dataAtual = LocalDate.now();

		for (Funcionario funcionario : funcionarios) {
			LocalDate dataNascimento = funcionario.getDataNascimento();

			int idade = dataAtual.getYear() - dataNascimento.getYear();

			if (idade > idadeMaisVelho) {
				idadeMaisVelho = idade;
				nomeMaisVelho = funcionario.getNome();
			}
		}

		if (nomeMaisVelho != null) {
			System.out.println("Funcionário mais velho:");
			System.out.println("Nome: " + nomeMaisVelho);
			System.out.println("Idade: " + idadeMaisVelho);
		} else {
			System.out.println("Não há funcionários na lista.");
		}
	}
	

	// 3.6 – Imprimir os funcionários, agrupados por função.
	// NÃO CONSEGUI FAZER SOZINHO, PESQUISEI E ENCONTREI
	private static void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
		for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
			String funcao = entry.getKey();
			List<Funcionario> funcionarios = entry.getValue();

			System.out.println();
			System.out.println("Funcionários da função: " + funcao);
			System.out.println();

			// Itera sobre a lista de funcionários da função atual
			for (Funcionario funcionario : funcionarios) {
				DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				System.out.println("Nome: " + funcionario.getNome());
				System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(formatarData));
				System.out.println("Salário: " + new DecimalFormat("###,###.##").format(funcionario.getSalario()));
				System.out.println();
			}
			System.out.println("____________________________________________");
		}
	}

}
