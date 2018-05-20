package br.teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.dsg.zpl.ZPL;
import br.com.dsg.zpl.elemento.CampoAlfanumerico;
import br.com.dsg.zpl.elemento.Fonte;
import br.com.dsg.zpl.elemento.Moldura;
import br.com.dsg.zpl.elemento.Posicao;
import junit.framework.Assert;

public class TesteZLPMoldura {

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
	public void testlinha() {
		String valor = ZPL.novaPagina(12, 70,150)
				.registra(new Moldura(new Posicao(10, 10), 30,5,1,"B")
						)
				.escrever();

		System.out.println(valor);
		Assert.assertEquals(valor, "^XA^LL560^FO80,80^GB240,40,8,B^FS^XZ");
	}

}
