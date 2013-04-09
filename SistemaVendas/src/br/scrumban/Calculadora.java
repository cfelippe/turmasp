package br.scrumban;

public class Calculadora {

	public static double calculaComissao(double valorVenda) {
		double resultado = (0.05 * valorVenda)*100;
		
		return Math.floor(resultado)/100 ;
	}

}
