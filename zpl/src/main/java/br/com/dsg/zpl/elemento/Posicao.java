package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.core.ComandoGeral;
import br.com.dsg.zpl.elemento.core.ElementoComposto;
import br.com.dsg.zpl.elemento.core.Valor;

/**
 * ^FO x,y : Este comando define as coordenadas de início dos campos 
 * (texto,códigos de barras e imagem) na etiqueta
 * @author denisgiroto
 *
 */
public class Posicao extends ElementoComposto{
	
	private int horizontal;
	private int vertical;
	
	public Posicao( int horizontal,int vertical) {
		this.horizontal=horizontal;
		this.vertical=vertical;
	}

	@Override
	protected void montaElemento() {
		registra(
				new ComandoGeral("^FO", 
						new Valor(horizontal, true),
						new Valor(vertical,   true ))
				);
	}

	public int getHorizontal() {
		return horizontal;
	}

	public int getVertical() {
		return vertical;
	}
	
	
}
