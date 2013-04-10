package br.scrumban;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.verification.VerificationMode;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.Venda;


public class TestCalculadoraRoyalties {
	
	@Test
	public void testeRoyaltiesMesSemVendas() {
		int mes = 1;
		int ano = 2013;
		double esperado = 0;
		
		
		List<Venda> listaEntrada = new ArrayList<Venda>();

		VendaRepository vendaRepositoryMock = mock(VendaRepository.class);
		when(vendaRepositoryMock.obterVendasPorMesEAno(ano,mes)).thenReturn(listaEntrada);	
		
		Calculadora calcMock = mock(Calculadora.class);

		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties(vendaRepositoryMock, calcMock);
		
		double retornado = calcRoyalties.calcula(mes, ano);
		
		assertEquals(esperado, retornado, 0.001);
		
		
		
	}


	@Test
	public void testeRoyaltiesMesComUmaVenda100Reais() {
		int mes = 2;
		int ano = 2013;
		double esperado = 19;
		int id = 1;
		int vendedor = 1;
		double valorVenda = 100.0;
		double comissao = 5.0;
		
		List<Venda> listaEntrada = new ArrayList<Venda>();
		listaEntrada.add(new Venda(id, vendedor, mes, ano, valorVenda));
		
		VendaRepository vendaRepositoryMock = mock(VendaRepository.class);
		when(vendaRepositoryMock.obterVendasPorMesEAno(ano,mes)).thenReturn(listaEntrada);	
		
		Calculadora calcMock = mock(Calculadora.class);
		when(calcMock.calculaComissao(valorVenda)).thenReturn(comissao);	
		
		
		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties(vendaRepositoryMock, calcMock );
		
		double retornado = calcRoyalties.calcula(mes, ano);
		
		assertEquals(esperado, retornado, 0.001);
		
		
		
	}
	
	@Test
	public void testeRoyaltiesMesComUmaVenda1000Reais() {
		int mes = 2;
		int ano = 2013;
		double esperado = 190;
		int id = 1;
		int vendedor = 1;
		double valorVenda = 1000.0;
		double comissao = 50.0;
		
		List<Venda> listaEntrada = new ArrayList<Venda>();
		listaEntrada.add(new Venda(id, vendedor, mes, ano, valorVenda));
		
		VendaRepository vendaRepositoryMock = mock(VendaRepository.class);
		when(vendaRepositoryMock.obterVendasPorMesEAno(ano,mes)).thenReturn(listaEntrada);	
		
		Calculadora calcMock = mock(Calculadora.class);
		when(calcMock.calculaComissao(valorVenda)).thenReturn(comissao);	
		
		
		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties(vendaRepositoryMock, calcMock );
		
		double retornado = calcRoyalties.calcula(mes, ano);
		
		assertEquals(esperado, retornado, 0.001);
		
		
		
	}

	
	@Test
	public void testeRoyaltiesMesComDuasVendaDe100ReaisCadaUma() {
		int mes = 2;
		int ano = 2013;
		double esperado = 40;
		int id1 = 1;
		int id2 = 2;
		int vendedor = 1;
		double valorVenda = 100.0;
		double comissao = 0;
		
		List<Venda> listaEntrada = new ArrayList<Venda>();
		listaEntrada.add(new Venda(id1, vendedor, mes, ano, valorVenda));
		listaEntrada.add(new Venda(id2, vendedor, mes, ano, valorVenda));
		
		VendaRepository vendaRepositoryMock = mock(VendaRepository.class);
		when(vendaRepositoryMock.obterVendasPorMesEAno(ano,mes)).thenReturn(listaEntrada);	
		
		Calculadora calcMock = mock(Calculadora.class);
		when(calcMock.calculaComissao(valorVenda)).thenReturn(comissao);	
		
		
		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties(vendaRepositoryMock, calcMock );
		
		double retornado = calcRoyalties.calcula(mes, ano);
		
		assertEquals(esperado, retornado, 0.001);
		
		verify(calcMock).calculaComissao(valorVenda);
		
		
	}

}
