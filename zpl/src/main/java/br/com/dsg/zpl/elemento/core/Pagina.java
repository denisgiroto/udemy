package br.com.dsg.zpl.elemento.core;

import br.com.dsg.zpl.elemento.Moldura;
import br.com.dsg.zpl.elemento.Posicao;
import br.com.dsg.zpl.elemento.conversor.ConversorMilimetrosParaPontos;

/**
 * @author denisgiroto
 *
 */
public class Pagina extends ElementoComposto{


	
	private Boolean margem = Boolean.FALSE;
	
	public Pagina() {
		super();
	}
	
	public Pagina(Parametros parametros) {
		super(parametros);
	}
	
	public Pagina comMargem() {
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
			new ComandoGeral(
					"^LL", 
					new Valor(
							this.getParametros().getDimensao().getLargura() , 
							true
							) 
					)
		);
		
		if(margem) {
			
			registra(
				new Moldura(
						new Posicao(1, 1), 
						this.getParametros().getDimensao(), 
						1)
			);
		}
			
	}
	
	public void test() {
		String zpl = escrever();
		System.out.println(zpl.replace("^", "\n^"));
		Browser.get(this.getParametros().getDensidade(), zpl);
	}

}
