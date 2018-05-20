package br.com.dsg.zpl.elemento.core;

/**
 * @author denisgiroto
 *
 */
public class Parametros {

	private int densidade = 6;
	private int largura = 70;
	private int altura = 70;
	/**
	 * @param densidade 6,8 ou 12
	 * @param largura milimetro
	 */
	public Parametros(int densidade, int largura, int altura) {
		super();
		this.densidade = densidade;
		this.largura = largura;
		this.altura = altura;
	}

	public int getDensidade() {
		return densidade;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	void setDensidade(int densidade) {
		this.densidade = densidade;
	}

	void setLargura(int largura) {
		this.largura = largura;
	}

	void setAltura(int altura) {
		this.altura = altura;
	}

	
}
