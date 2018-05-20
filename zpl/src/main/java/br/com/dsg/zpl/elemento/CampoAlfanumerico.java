package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.conversor.ConversorMilimetrosParaPontos;
import br.com.dsg.zpl.elemento.core.ComandoGeral;
import br.com.dsg.zpl.elemento.core.ComandoSimples;

/**
 * @author denisgiroto
 *
 */
public class CampoAlfanumerico extends ComandoSimples {

	private ComandoGeral comandoGeral = new ComandoGeral("^A");

	private String tipoFonte;
	private String rotacao;
	private String altura;
	private String largura;
	private String valor;

	public CampoAlfanumerico(Posicao posicao, String valor) {
		super(posicao);
		this.valor = valor;
	}

	public CampoAlfanumerico(Posicao posicao, String tipoFonte, String rotacao, String altura, String largura,
			String valor) {
		super(posicao);
		this.tipoFonte = tipoFonte;
		this.rotacao = rotacao;
		this.altura = altura;
		this.largura = largura;
		this.valor = valor;
	}

	/**
	 * @param tipoFonte
	 *            A,B,C,D,E,F,G,H
	 * @param rotacao
	 *            N,R,I e B
	 * @return
	 */
	public CampoAlfanumerico comRotacao(String tipoFonte, String rotacao) {
		this.tipoFonte = tipoFonte;
		this.rotacao = rotacao;
		return this;
	}

	public CampoAlfanumerico comDimensao(String altura, String largura) {
		this.altura = altura;
		this.largura = largura;
		return this;
	}

	@Override
	protected void montaCampo() {

		if (tipoFonte != null && rotacao != null)
			comandoGeral.comValor(tipoFonte + rotacao);
		
		if (altura != null)
			comandoGeral.comValor(altura, new ConversorMilimetrosParaPontos());
		if (largura != null)
			comandoGeral.comValor(largura, new ConversorMilimetrosParaPontos());
		
		registra(comandoGeral);
		registra(
				new ComandoGeral("^FD")
				.comValor(this.valor) 
		);

	}


}
