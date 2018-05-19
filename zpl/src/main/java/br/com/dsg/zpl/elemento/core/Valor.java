package br.com.dsg.zpl.elemento.core;

/**
 * @author denisgiroto
 *
 */
public class Valor {

	private String valor;
	private Conversor conversor;

	public Valor(Integer valor) {
		this(valor.toString());
	}
	
	public Valor(String valor) {
		this(valor, new Conversor() {
			public String converter(Valor valor, Parametros parametros) {
				return valor.valor;
			}
		});
	}
	
	public Valor(Integer valor, Conversor conversor) {
		this(valor.toString(),conversor);
	}
	
	
	public Valor(String valor, Conversor conversor) {
		super();
		this.valor = valor;
		this.conversor = conversor;
	}
	
	public String getValor() {
		return valor;
	}

	protected String get(Parametros parametros) {
		return conversor.converter(this, parametros);
	}
	
	
}
