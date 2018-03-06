package br.calculadora.componente.calculos;

import java.math.BigDecimal;

import br.calculadora.Calculo;
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
		MemoriaDeValor resultado =  new MemoriaDeValor( qtdElementosExitente.getValor()  );
		//Aux N
		MemoriaDeValor fatElementosGrupo =  new MemoriaDeValor( numElementosGrupo.getValor() );
		
		//m!
		registraComponente(new Fatorial(resultado));
		//n!
		registraComponente(new Fatorial(fatElementosGrupo));
		// (m-n)
		registraComponente(new Subtracao(qtdElementosExitente,numElementosGrupo));
		// (m-n)!
		registraComponente(new Fatorial( qtdElementosExitente ));
		//n!(m-n)!
		registraComponente(new Multiplicacao(fatElementosGrupo,qtdElementosExitente));
		//m!/n!(m-n)!
		registraComponente(new Divisao(resultado,fatElementosGrupo));
		
		/*
		setMemoriaDoResultado(
				new Divisao(
							new Fatorial(resultado).getResultado(), 
							new Multiplicacao(
											  new Fatorial(fatElementosGrupo).getResultado(),
											  new Fatorial( 
													  		new Subtracao(qtdElementosExitente, numElementosGrupo)
													  		.getResultado() 
													  	   ).getResultado()
											  ).getResultado()
							).getResultado()
				
		);
		*/
	}
	

}
