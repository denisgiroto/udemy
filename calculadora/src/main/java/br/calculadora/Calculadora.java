package br.calculadora;

import java.math.BigDecimal;


public abstract class Calculadora implements ComponenteCalculo {
	
	
	private MemoriaDeValor resultado = new MemoriaDeValor(new BigDecimal(0));
	
	public void	aplica() {
			doAplica();
	}
	
	public MemoriaDeValor getResultado() {
		return this.resultado;
	}

	public final void setMemoriaDoResultado(MemoriaDeValor memoriaDeCalculo) {
		this.resultado = memoriaDeCalculo;
	}

	
	public abstract void doAplica();
	
}
