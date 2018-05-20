package br.teste;

import br.com.dsg.zpl.ZPL;
import br.com.dsg.zpl.elemento.CaixaTexto;
import br.com.dsg.zpl.elemento.Posicao;
import br.com.dsg.zpl.elemento.core.Pagina;

public class TestMontar {

	public static void main(String[] args) {
		((Pagina) 
				ZPL
				.novaPagina(12, 99, 110)
				.comMargem()
				.registra(new CaixaTexto(new Posicao(10, 10), "A", "N", "4", "3", "DeS","S","tva")
						)
				

		).test();

	}

}
/*
 * .registra(new CampoAlfanumerico(new Posicao(10, 10), "D") .comRotacao("A",
 * "N") .comDimensao("10", "10")) .registra(new CampoAlfanumerico(new
 * Posicao(21, 10), "E") .comRotacao("A", "N") .comDimensao("10", "10"))
 * .registra(new CampoAlfanumerico(new Posicao(32, 10), "N") .comRotacao("A",
 * "N") .comDimensao("10", "10")) .registra(new CampoAlfanumerico(new
 * Posicao(43, 10), "I") .comRotacao("A", "N") .comDimensao("10", "10"))
 */