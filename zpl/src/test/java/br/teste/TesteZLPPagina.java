package br.teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dsg.zpl.ZPL;
import br.com.dsg.zpl.elemento.CampoAlfanumerico;
import br.com.dsg.zpl.elemento.Fonte;
import br.com.dsg.zpl.elemento.Posicao;
import junit.framework.Assert;

public class TesteZLPPagina {

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
	public void testPagina() {
		String valor = ZPL.novaPagina(12, 70, 150)
				.escrever();

		System.out.println(valor);
		Assert.assertEquals(valor, "^XA^LL560^XZ");
	}
	
	@Test
	public void testPaginaMoldura() {
		String valor = ZPL.novaPagina(12, 99, 150)
				.comMargem()
				.escrever();

		System.out.println(valor);
		Assert.assertEquals(valor, "^XA^LL560^XZ");
	}

	

}
