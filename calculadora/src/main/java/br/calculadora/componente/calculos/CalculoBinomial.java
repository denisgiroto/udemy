package br.calculadora.componente.calculos;

import java.math.BigDecimal;

import br.calculadora.Calculo;
import br.calculadora.ComponenteCalculo;
import br.calculadora.MemoriaDeValor;
import br.calculadora.componente.fundamental.Divisao;
import br.calculadora.componente.fundamental.Multiplicacao;
import br.calculadora.componente.fundamental.Subtracao;
import br.calculadora.componente.outras.Fatorial;


public class CalculoBinomial extends Calculo{
	MemoriaDeValor qtdElementosExitente;
	MemoriaDeValor numElementosGrupo;
	
	public CalculoBinomial(BigDecimal qtdExitente,BigDecimal numGrupo) {
		qtdElementosExitente = new MemoriaDeValor(qtdExitente);
		numElementosGrupo = new MemoriaDeValor(numGrupo);
	}
	
	public void montaCalculo() {
		/*
		 * m!/n!(m-n)!
		 * 
		 */
		
		//Aux M
		MemoriaDeValor fatElementosExitente =  new MemoriaDeValor(new BigDecimal(0));
		//Aux N
		MemoriaDeValor fatElementosGrupo =  new MemoriaDeValor(new BigDecimal(0));
		
		//m!
		registraComponente(new Fatorial(fatElementosExitente,qtdElementosExitente));
		//n!
		registraComponente(new Fatorial(fatElementosGrupo,numElementosGrupo));
		// (m-n)
		registraComponente(new Subtracao(getResultado(),qtdElementosExitente,numElementosGrupo));
		// (m-n)!
		registraComponente(new Fatorial(getResultado(),getResultado()));
		//n!(m-n)!
		registraComponente(new Multiplicacao(getResultado(),fatElementosGrupo,getResultado()));
		//m!/n!(m-n)!
		registraComponente(new Divisao(getResultado(),fatElementosExitente,getResultado()));
	}
	
	public static void main(String[] args) {
		ComponenteCalculo c = new CalculoBinomial(new BigDecimal(8),new BigDecimal(6));
		c.aplica();
		System.out.println(c.recuperaResultado());
	}
	
}
