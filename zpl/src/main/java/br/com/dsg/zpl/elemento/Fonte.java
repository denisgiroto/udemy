package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.conversor.ConversorMilimetrosParaPontos;
import br.com.dsg.zpl.elemento.core.ComandoGeral;
import br.com.dsg.zpl.elemento.core.ElementoComposto;
import br.com.dsg.zpl.elemento.core.Valor;

/**
 * @author denisgiroto
 *
 */
public class Fonte extends ElementoComposto{
	

	int tamanho;
	public Fonte(int tamanho) {
		this.tamanho=tamanho;
	}

	@Override
	protected void montaElemento() {
		registra(
				new ComandoGeral("^CF", 
						new Valor("0"),
						new Valor(tamanho, new ConversorMilimetrosParaPontos()) )
				);
	}
	
	
}
