package br.calculadora.componente.calculos;

import java.math.BigDecimal;

import br.calculadora.Calculo;
import br.calculadora.MemoriaDeValor;
import br.calculadora.componente.fundamental.Divisao;
import br.calculadora.componente.fundamental.Multiplicacao;
import br.calculadora.componente.fundamental.Subtracao;
import br.calculadora.componente.outras.Fatorial;


public class CalculoBinomial extends Calculo{
	
	MemoriaDeValor m;
	MemoriaDeValor n;
	
	public CalculoBinomial(BigDecimal qtdExitente,BigDecimal numGrupo) {
		m = new MemoriaDeValor(qtdExitente);
		n = new MemoriaDeValor(numGrupo);
	}
	
	public void montaCalculo() {
		/*
		 * m!/n!(m-n)!
		 * 
		 */
		MemoriaDeValor dividendo =  new MemoriaDeValor( m.getValor() );
		MemoriaDeValor divisor =  new MemoriaDeValor(  n.getValor() );
		MemoriaDeValor subMn =  new MemoriaDeValor( m.getValor()  );
		
		//Aux M
		//MemoriaDeValor fatorialM =  new MemoriaDeValor( m.getValor()  );
		//Aux N
		MemoriaDeValor fatElementosGrupo =  new MemoriaDeValor( n.getValor() );
		
		//m!
		registraComponente(new Fatorial(dividendo));
		//n!
		registraComponente(new Fatorial(divisor));
		// (m-n)
		registraComponente(new Subtracao(subMn,n));
		// (m-n)!
		registraComponente(new Fatorial( subMn ));
		//n!(m-n)!
		registraComponente(new Multiplicacao(divisor, subMn));
		//m!/n!(m-n)!
		registraComponente(new Divisao(dividendo, divisor));
		
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
