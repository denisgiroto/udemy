package br.calculadora;

import java.math.BigDecimal;


public abstract class Decorator extends OperacoesMatematicas implements ComponenteCalculo {
	
	
	private MemoriaDeValor resultado = new MemoriaDeValor(new BigDecimal(0));
	
	public abstract void doAplica();
	
	public void	aplica() {
			doAplica();
	}
	
	public MemoriaDeValor getResultado() {
		return this.resultado;
	}

	public void setMemoriaDoResultado(MemoriaDeValor memoriaDeCalculo) {
		this.resultado = memoriaDeCalculo;
	}

	public BigDecimal recuperaResultado() {
		return getResultado().getValor();
	}
	
	public Fracao recuperaResultadoFracao() {
		return getResultado().getFracao();
	}
	
	public void armazenaResultado(BigDecimal valor) {
		getResultado().setValor(valor);
	}
	
}
