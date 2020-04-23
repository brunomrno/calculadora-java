package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		if (salarioBase < 1039) {
			return Math.round(0.0);
		}

		double salarioInss;
		double salarioLiquido;
		salarioInss = calcularInss(salarioBase);
		salarioLiquido = calcularDescontoIrrf(salarioInss);

		return Math.round(salarioLiquido);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		double salarioInss = 0;

		if ((salarioBase >= 0) && (salarioBase <= 1500.00)) {
			// desconto 8%
			salarioInss = salarioBase - porcentagem(salarioBase, 8);

		} else if ((salarioBase >= 1500.01) && (salarioBase <= 4000.00)) {
			// desconto 9%
			salarioInss = salarioBase - porcentagem(salarioBase, 9);

		} else if (salarioBase > 4000.00) {
			// desconto 11%
			salarioInss = salarioBase - porcentagem(salarioBase, 11);
		}

		return salarioInss;
	}

	private double porcentagem(double valor, double porcentagem) {
		return (valor / 100) * porcentagem;
	}

	private double calcularDescontoIrrf(double salarioBaseInss) {

		double salarioFinal = 0;

		if ((salarioBaseInss >= 0) && (salarioBaseInss <= 3000.00)) {
			//isento
			salarioFinal = salarioBaseInss;

		} else if ((salarioBaseInss >= 3000.01) && (salarioBaseInss <= 6000.00)) {
			// desconto 7.5%
			salarioFinal = salarioBaseInss - porcentagem(salarioBaseInss, 7.5);


		} else if (salarioBaseInss > 6000.00) {
			// desconto 15%
			salarioFinal = salarioBaseInss - porcentagem(salarioBaseInss, 15);
		}

		return salarioFinal;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/