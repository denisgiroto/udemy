package br.com.dsg.zpl.elemento.core;

import br.com.dsg.zpl.elemento.Moldura;
import br.com.dsg.zpl.elemento.Posicao;
import br.com.dsg.zpl.elemento.conversor.ConversorMilimetrosParaPontos;

/**
 * @author denisgiroto
 *
 */
public class Pagina extends ElementoComposto{


	private Parametros parametros = new Parametros(8,70,150);
	private Boolean margem = Boolean.FALSE;
	
	public Pagina() {
		super();
	}
	
	public Pagina(Parametros parametros) {
		super();
		this.parametros = parametros;
	}
	
	public Pagina comMargem() {
		this.margem = Boolean.TRUE;
		return this;
	}
	
	public Pagina comMargem( int largura, int altura ) {
		this.parametros.setLargura(largura);
		this.parametros.setAltura(altura);
		this.margem = Boolean.TRUE;
		return this;
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
						new Valor(this.parametros.getLargura() , new ConversorMilimetrosParaPontos()) )
			);
		
		if(margem) {
			Moldura margem = new Moldura(new Posicao(1, 1), this.parametros.getLargura(), this.parametros.getAltura(), 0, "B");
			registra(margem);
		}
			
	}
	
	public void test() {
		String zpl = escrever();
		Browser.get(this.parametros.getDensidade(), zpl);
	}

}
