package br.teste;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.calculadora.Calculo;
import br.calculadora.ComponenteCalculo;
import br.calculadora.Fracao;
import br.calculadora.MemoriaDeValor;
import br.calculadora.componente.fracao.SomaDeFracao;
import br.calculadora.componente.fracao.SubtracaoDeFracao;
import br.calculadora.componente.fundamental.Divisao;
import br.calculadora.componente.fundamental.Multiplicacao;
import br.calculadora.componente.fundamental.Soma;
import br.calculadora.componente.fundamental.Subtracao;


public class TesteCalculo {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testSomaSubtacaoMultDivisao() {
		ComponenteCalculo c = new Calculo(){
			MemoriaDeValor m1 = new MemoriaDeValor(new BigDecimal(1));
			MemoriaDeValor m2 = new MemoriaDeValor(new BigDecimal(2));
			
			public void montaCalculo() {
				MemoriaDeValor r = new MemoriaDeValor(new BigDecimal(0));
				registraComponente(new Soma(r,m1,m2));
				registraComponente(new Multiplicacao(getResultado(),r,m2));
				registraComponente(new Divisao(getResultado(),r,m2));
				registraComponente(new Subtracao(getResultado(),r,m2));
				
			}
		};
		c.aplica();
		System.out.println(c.recuperaResultado());
		assertEquals(c.recuperaResultado().intValue(), 1);
	}
	
	
	@Test
	public void testSomaSubtacaoMultDivisaoDeFracao() {
		ComponenteCalculo c = new Calculo(){
			MemoriaDeValor m1 = new MemoriaDeValor(new BigDecimal(0));
			MemoriaDeValor m2 = new MemoriaDeValor(new BigDecimal(0));
			
			public void montaCalculo() {
				m1.setFracao(new Fracao("2/8"));
				m2.setFracao(new Fracao("7/8"));
				MemoriaDeValor r = new MemoriaDeValor(new BigDecimal(0));
				registraComponente(new SomaDeFracao(getResultado(),m1,m2));
				MemoriaDeValor m3 = new MemoriaDeValor(new BigDecimal(0));
				m3.setFracao(new Fracao("3/4"));
				registraComponente(new SubtracaoDeFracao(getResultado(),getResultado(),m3));
			}
		};
		c.aplica();
		System.out.println(c.getResultado().getFracao()); 
		
		//assertEquals(c.getResultado().getFracao().getNumerador(), 3);
		//assertEquals(c.getResultado().getFracao().getDenominador(),8);
	}
	


}
