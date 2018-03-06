package br.calculadora;

import java.math.BigDecimal;

public interface ComponenteCalculo{
	public void aplica();
	public MemoriaDeValor getResultado();
	public Fracao recuperaResultadoFracao();
	public BigDecimal recuperaResultado();
}
