package br.scrumban;

import java.util.ArrayList;
import java.util.List;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.Venda;



public class CalculadoraRoyalties {

	private VendaRepository repository;
	private Calculadora calculadoraComissao;

	public CalculadoraRoyalties(VendaRepository vendaRepository,
			Calculadora calculadora) {
		repository = vendaRepository;
		calculadoraComissao = calculadora;
	}

	public double calcula(int mes, int ano) {
		List<Venda> listaEntrada  = repository.obterVendasPorMesEAno(ano ,mes );
		
		double valorLiquidoAcumulado = 0;
		
		for(Venda v : listaEntrada){
			double valorLiquido = v.getValor() ; // - calculadoraComissao.calculaComissao(v.getValor());
			valorLiquidoAcumulado += valorLiquido;
		}
		
		
		return valorLiquidoAcumulado * 0.2;
	}

		
}
