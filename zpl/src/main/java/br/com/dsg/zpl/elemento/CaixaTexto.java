package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.conversor.ConversorMilimetrosParaPontos;
import br.com.dsg.zpl.elemento.core.ComandoGeral;
import br.com.dsg.zpl.elemento.core.ComandoSimples;

/**
 * @author denisgiroto
 *
 */
public class CaixaTexto extends ComandoSimples {

	private ComandoGeral comandoGeral = new ComandoGeral("^A");

	private String tipoFonte;
	private String rotacao;
	private String altura;
	private String largura;
	private String[] valor;

	

	/**
	 * @param posicao
	 * @param tipoFonte  A,B,C,D,E,F,G,H
	 * @param rotacao  N,R,I e B
	 * @param altura
	 * @param largura
	 * @param valor
	 */
	public CaixaTexto(Posicao posicao, String tipoFonte, String rotacao, String altura, String largura,
			String... valor) {
		super(posicao);
		this.tipoFonte = tipoFonte;
		this.rotacao = rotacao;
		this.altura = altura;
		this.largura = largura;
		this.valor = valor;
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
		
		int margemY = 0;
		int margemX = 0;
		
		int proximoY = getPosicao().getVertical();
		for (String linha : valor) {
			int proximoX = getPosicao().getHorizontal();
			for (int i = 0; i < linha.length(); i++) {
				String x = linha.charAt(i)+"";
				registra(new CampoAlfanumerico(new Posicao(proximoX, proximoY), tipoFonte, rotacao, altura, largura, x) );
				
				proximoX += getPosicao().getHorizontal() ;
			}
			proximoY +=getPosicao().getVertical();
			if(proximoX>margemX) {
				margemX = proximoX;
			}
		}
		margemY = proximoY;
		
		registra(
				new Moldura(new Posicao(getPosicao().getHorizontal()-2, getPosicao().getVertical()-2),margemX,margemY,0,"B" ) 
		);

	}


}
