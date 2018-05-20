package br.com.dsg.zpl.elemento.core;

import br.com.dsg.zpl.elemento.CaixaTexto;
import br.com.dsg.zpl.elemento.Posicao;

public class TestMontar {

	public static void main(String[] args) {
		((Pagina) 
				ZPLBuilder
				
				.novaPagina(UnidadeMedida.MILIMETROS,Densidade.OITO_PONTOS, 99, 110)
				.comMargem()
				.registra(
						new CaixaTexto(new Posicao(10, 10),new Dimensao(3, 4), "A", "N", "DeS","S","tva")
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