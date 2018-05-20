package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.conversor.ConversorMilimetrosParaPontos;
import br.com.dsg.zpl.elemento.core.ComandoGeral;
import br.com.dsg.zpl.elemento.core.ComandoSimples;

/**
 * @author denisgiroto
 * Imprimindo Linhas e Molduras
 *
 */
public class Moldura extends ComandoSimples {

	private ComandoGeral comandoGeral = new ComandoGeral("^GB");

	private Integer largura;
	private Integer altura;
	private Integer larguraCorFundo;
	private String corFundo;



	/**
	 * @param posicao
	 * @param altura
	 * @param largura
	 * @param larguraCorFundo
	 * @param corFundo W ou B
	 */
	public Moldura(Posicao posicao, Integer largura, Integer altura,Integer larguraCorFundo, String corFundo) {
		super(posicao);
		this.largura = largura;
		this.altura = altura;
		this.larguraCorFundo = larguraCorFundo;
		this.corFundo = corFundo;
	}

	

	@Override
	protected void montaCampo() {

		comandoGeral.comValor(largura.toString(), new ConversorMilimetrosParaPontos());
		comandoGeral.comValor(altura.toString(), new ConversorMilimetrosParaPontos());
		
		if( larguraCorFundo>altura && larguraCorFundo>largura) {
			if(altura<largura) {
				larguraCorFundo=altura;
			}else {
				larguraCorFundo=largura;
			}
		}
		comandoGeral.comValor(larguraCorFundo.toString(), new ConversorMilimetrosParaPontos());
		comandoGeral.comValor(corFundo);
		
		registra(comandoGeral);
		

	}


}
