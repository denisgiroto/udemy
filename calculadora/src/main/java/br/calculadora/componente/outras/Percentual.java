package br.calculadora.componente.outras;

import br.calculadora.Decorator;
import br.calculadora.MemoriaDeValor;



public class Percentual extends Decorator {
	private MemoriaDeValor memoriaDoPercentual;
	private MemoriaDeValor memoriaDoValorBase;

	public MemoriaDeValor getMemoriaDoPercentual() {
		return this.memoriaDoPercentual;
	}

	public void setMemoriaDoPercentual(MemoriaDeValor percentual) {
		this.memoriaDoPercentual = percentual;
	}

	public Percentual(
		MemoriaDeValor memoriaDoResultado,
		MemoriaDeValor valorBase,
		MemoriaDeValor percentual) {
		super();
		setMemoriaDoResultado(memoriaDoResultado);
		setMemoriaDoValorBase(valorBase);
		setMemoriaDoPercentual(percentual);
	}
	
	public MemoriaDeValor getMemoriaDoValorBase() {
		return this.memoriaDoValorBase;
	}

	public void setMemoriaDoValorBase(MemoriaDeValor valorBase) {
		this.memoriaDoValorBase = valorBase;
	}
	

	public void doAplica() {
		armazenaResultado(
				multiplica(getMemoriaDoValorBase().getValor(), transformaPercentualEmTaxa(getMemoriaDoPercentual().getValor())));
	}

}