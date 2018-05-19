package br.com.dsg.zpl.elemento.core;

import br.com.dsg.zpl.elemento.conversor.ConversorMilimetrosParaPontos;

/**
 * @author denisgiroto
 *
 */
public class Pagina extends ElementoComposto{


	private Parametros parametros = new Parametros(8,70);
	
	public Pagina() {
		super();
	}
	
	public Pagina(Parametros parametros) {
		super();
		this.parametros = parametros;
	}


	@Override
	public String escrever(Parametros parametros) {
		return "^XA"
				+super.escrever(parametros)
			   +"^XZ";
	}

	@Override
	protected void montaElemento() {
		registra(
				new ComandoGeral("^LL", 
						new Valor(this.parametros.getLarguraLinha() , new ConversorMilimetrosParaPontos()) )
			);
	}

}
