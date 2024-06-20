package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// 2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

public class Funcionario  extends Pessoa  {
	private BigDecimal salario, novoSalario;
	private String funcao;
	
	DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public BigDecimal calcularSalariosMinimos(BigDecimal salarioMinimo) {
		return salario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);
	}
	
	
	
	

	@Override
	public String toString() {
		
		return  "Nome = " + getNome() + '\n'
				+ "Data de Nascimento = " + getDataNascimento().format(formatarData) + '\n'
				+ "Salario = " + new DecimalFormat("###,###.##").format(salario) + '\n'
				+ "Função = '" + funcao  + '\n';
	}

	}