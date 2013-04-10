package br.scrumban;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void testeVenda100Retorna5() {
		double valorVenda = 100;
		double comissaoEsperada = 5;
		Calculadora calc = new Calculadora();
		double valorRetornado = calc.calculaComissao(valorVenda);
		
		assertEquals(comissaoEsperada, valorRetornado, 0.001);
	}
	
	@Test
	public void testeVenda10000Retorna500() {
		double valorVenda = 10000;
		double comissaoEsperada = 500;
		
		Calculadora calc = new Calculadora();
		double valorRetornado = calc.calculaComissao(valorVenda);
		
		assertEquals(comissaoEsperada, valorRetornado, 0.001);
	}
	
	@Test
	public void testeVenda0Retorna0() {
		double valorVenda = 0;
		double comissaoEsperada = 0;
		
		Calculadora calc = new Calculadora();
		double valorRetornado = calc.calculaComissao(valorVenda);
		
		assertEquals(comissaoEsperada, valorRetornado, 0.001);
	}
	
	@Test
	public void testeVenda1Retorna5centavos() {
		double valorVenda = 1;
		double comissaoEsperada = 0.05;
		
		Calculadora calc = new Calculadora();
		double valorRetornado = calc.calculaComissao(valorVenda);
		
		assertEquals(comissaoEsperada, valorRetornado, 0.001);
	}

	@Test
	public void testeVenda25e59Retorna1e27(){
		double valorVenda = 25.59;
		double comissaoEsperada = 1.27;
		
		Calculadora calc = new Calculadora();
		double valorRetornado = calc.calculaComissao(valorVenda);
		
		assertEquals(comissaoEsperada, valorRetornado, 0.001);
		
	}
	
	@Test
	public void testeVenda100MilRetorna6Mil(){
		double valorVenda = 100000;
		double comissaoEsperada = 6000;
		
		Calculadora calc = new Calculadora();
		double valorRetornado = calc.calculaComissao(valorVenda);
		
		assertEquals(comissaoEsperada, valorRetornado, 0.001);
		
	}
	
}
