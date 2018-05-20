package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.core.Dimensao;

/**
 * @author denisgiroto
 *
 */
public class CaixaTexto extends ComandoSimples {


	private String tipoFonte;
	private String rotacao;
	private Dimensao dimensaoCaractere;
	private String[] valor;

	

	/**
	 * @param posicao
	 * @param tipoFonte  A,B,C,D,E,F,G,H
	 * @param rotacao  N,R,I e B
	 * @param altura
	 * @param largura
	 * @param valor
	 */
	public CaixaTexto(Posicao posicao, Dimensao dimensaoCaractere, String tipoFonte, String rotacao,
			String... valor) {
		super(posicao);
		this.tipoFonte = tipoFonte;
		this.rotacao = rotacao;
		this.dimensaoCaractere = dimensaoCaractere;
		this.valor = valor;
	}

	

	@Override
	protected void montaCampo() {

		
		int margemY = 0;
		int margemX = 0;
		
		int proximoY = getPosicao().getVertical();
		for (int index = 0; index < valor.length; index++) {
			
			String linha = valor[index];
			int proximoX = getPosicao().getHorizontal();
			
			for (int i = 0; i < linha.length(); i++) {
				String caractere = linha.charAt(i)+"";
				
				
				registra(new CampoAlfanumerico(
							new Posicao(proximoX, proximoY), 
							dimensaoCaractere, tipoFonte, rotacao, caractere) );
				
				
				if(i<linha.length()-1)
					proximoX += getPosicao().getHorizontal() ;
			}
			if(proximoX>margemX) {
				margemX = proximoX;
			}
			
			if(index< valor.length-1)
				proximoY +=getPosicao().getVertical();
		}
		margemY = proximoY ;
		
		registra(
				new Moldura(
						new Posicao(getPosicao().getHorizontal()-2, getPosicao().getVertical()-2),
						new Dimensao( margemX, margemY ),
						1) 
		);

	}


}
