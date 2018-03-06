package br.calculadora.componente.outras;

import java.math.BigDecimal;

import br.calculadora.Calculadora;
import br.calculadora.MemoriaDeValor;
import br.calculadora.componente.fundamental.FundamentalBase;




public class Fatorial extends FundamentalBase {
	
	private MemoriaDeValor valor;

	public Fatorial(MemoriaDeValor memoriaDoResultado) {
		super(memoriaDoResultado);
		
		this.valor = memoriaDoResultado;
	}
	
	
	public long fatorial(long num){
		long resposta = 1;
		for (long i = 1; i <= num; i++) {
			resposta = resposta * i;
		}
		return resposta;
	}
	
	public void doAplica() {
		
		long valor = this.valor.getValor().longValue();
		
		armazenaValor(
				
				new BigDecimal( fatorial(valor) )
		);
		
	}
	

}