package br.com.dsg.zpl.elemento.core;

/**
 * @author denisgiroto
 *
 */
public class Parametros {

	private int densidade = 6;
	private int larguraLinha = 70;

	/**
	 * @param densidade 6,8 ou 12
	 * @param larguraLinha milimetro
	 */
	public Parametros(int densidade, int larguraLinha) {
		super();
		this.densidade = densidade;
		this.larguraLinha = larguraLinha;
	}

	public int getDensidade() {
		return densidade;
	}

	public int getLarguraLinha() {
		return larguraLinha;
	}

	
	
	
}
