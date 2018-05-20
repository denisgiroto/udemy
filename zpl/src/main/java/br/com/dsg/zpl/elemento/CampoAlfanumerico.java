package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.conversor.ConversorMilimetrosParaPontos;
import br.com.dsg.zpl.elemento.core.ComandoGeral;
import br.com.dsg.zpl.elemento.core.Dimensao;

/**
 * @author denisgiroto
 *
 */
public class CampoAlfanumerico extends ComandoSimples {

	private ComandoGeral comandoGeral = new ComandoGeral("^A");

	private String tipoFonte;
	private String rotacao;
	private Dimensao dimensao;
	private String valor;

	public CampoAlfanumerico(Posicao posicao, String valor) {
		super(posicao);
		this.valor = valor;
	}

	public CampoAlfanumerico(Posicao posicao, Dimensao dimensao, String tipoFonte, String rotacao,
			String valor) {
		super(posicao);
		this.tipoFonte = tipoFonte;
		this.rotacao = rotacao;
		this.dimensao = dimensao;
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

	public CampoAlfanumerico comDimensao(Dimensao dimensao) {
		this.dimensao = dimensao;
		return this;
	}

	@Override
	protected void montaCampo() {

		if (tipoFonte != null && rotacao != null)
			comandoGeral.comValor(tipoFonte + rotacao);
		
		if (dimensao != null)
			comandoGeral.comValor(dimensao);
		
		registra(comandoGeral);
		
		registra(
				new ComandoGeral("^FD")
				.comValor(this.valor) 
		);

	}


}
