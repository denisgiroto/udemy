package util;

import java.math.BigDecimal;

import br.calculadora.Calculo;
import br.calculadora.ComponenteCalculo;
import br.calculadora.Fracao;
import br.calculadora.MemoriaDeValor;
import br.calculadora.componente.fracao.SomaDeFracao;
import br.calculadora.componente.fundamental.Multiplicacao;
import br.calculadora.componente.fundamental.Soma;



public class CalculoTeste extends Calculo{
	MemoriaDeValor m1 = new MemoriaDeValor(new BigDecimal(10));
	MemoriaDeValor m2 = new MemoriaDeValor(new BigDecimal(10));
	
	public void montaCalculo() {
		m1.setFracao(new Fracao("2/8"));
		m2.setFracao(new Fracao("7/7"));
		
		ComponenteCalculo c = new Calculo(){
			MemoriaDeValor m1 = new MemoriaDeValor(new BigDecimal(10));
			MemoriaDeValor m2 = new MemoriaDeValor(new BigDecimal(10));
			
			public void montaCalculo() {
				MemoriaDeValor r = new MemoriaDeValor(new BigDecimal(0));
				registraComponente(new Soma(r,m1,m2));
				registraComponente(new Multiplicacao(getResultado(),r,m1));
			}
		};
		
		MemoriaDeValor r = new MemoriaDeValor(new BigDecimal(0));
		registraComponente(new Soma(r,m1,m2));
		registraComponente(new Multiplicacao(getResultado(),getResultado(),m1));
		registraComponente(c);
		registraComponente(new Soma(getResultado(),c.getResultado(),getResultado()));
		registraComponente(new SomaDeFracao(getResultado(),m1,m2));
	}
	
	
	public static void main(String[] args) {
		ComponenteCalculo c = new CalculoTeste();
		c.aplica();
		System.out.println(c.recuperaResultado());
		System.out.println(c.recuperaResultadoFracao());
		
		
	}
	
}

