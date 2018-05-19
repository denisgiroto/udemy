package br.com.dsg.zpl.elemento.core;

/**
 * @author denisgiroto
 *
 */
public abstract class Elemento {

	
	private Parametros parametros = new Parametros(8, 70);
	
	
	public Elemento() {
		super();
	}


	public Elemento(Parametros parametros ) {
		this.parametros = parametros;
	}
	
	
	public String escrever() {
		//System.out.println("Elemento::escrever");
		return escrever(this.parametros);
	}
	
	
	public abstract String escrever(Parametros parametros);
}
