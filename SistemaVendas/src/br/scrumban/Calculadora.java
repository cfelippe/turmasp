package br.scrumban;

public class Calculadora {

	public double calculaComissao(double valorVenda) {
		double resultado=0;
		
		if(valorVenda <= 10000 )
		{
			resultado = (0.05 * valorVenda)*100;
		}
		else
		{
			resultado = (0.06 * valorVenda)*100;
		}
		
		return Math.floor(resultado)/100 ;
	}

}
