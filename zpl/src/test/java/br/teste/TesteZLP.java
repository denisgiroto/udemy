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

public class TesteZLP {

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
	public void testFonte() {
		String valor = ZPL.novaPagina(12, 70,150)
				.registra(new Fonte(12))
				.escrever();

		System.out.println(valor);
		Assert.assertEquals(valor, "^XA^LL560^CF0,96^XZ");

	}

	@Test
	public void testAlfa() {
		String valor = ZPL.novaPagina(12, 70,150)
				.registra(new CampoAlfanumerico(new Posicao(10, 10), "Denis Giroto")
						.comRotacao("A", "I"))
				.escrever();

		System.out.println(valor);
		Assert.assertEquals(valor, "^XA^LL560^FO80,80^AAI^FDDenis Giroto^FS^XZ");

	}

	@Test
	public void testFonteComAlfa() {
		String valor = ZPL.novaPagina(12, 70, 150)
				.registra(new Fonte(12))
				.registra(new CampoAlfanumerico(new Posicao(10, 10), "D")
						.comRotacao("A", "N")
						.comDimensao("10", "10"))
				.registra(new CampoAlfanumerico(new Posicao(21, 10), "E")
						.comRotacao("A", "N")
						.comDimensao("10", "10"))
				.registra(new CampoAlfanumerico(new Posicao(32, 10), "N")
						.comRotacao("A", "N")
						.comDimensao("10", "10"))
				.registra(new CampoAlfanumerico(new Posicao(43, 10), "I")
						.comRotacao("A", "N")
						.comDimensao("10", "10"))
				.escrever();

		System.out.println(valor);
		Assert.assertEquals(valor, "^XA^LL560^CF0,96^FO80,80^AAN,80,80^FDD^FS^FO168,80^AAN,80,80^FDE^FS^FO256,80^AAN,80,80^FDN^FS^FO344,80^AAN,80,80^FDI^FS^XZ");
	}

}
