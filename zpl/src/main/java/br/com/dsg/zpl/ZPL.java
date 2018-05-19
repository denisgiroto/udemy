package br.com.dsg.zpl;

import br.com.dsg.zpl.elemento.core.Pagina;
import br.com.dsg.zpl.elemento.core.Parametros;

public class ZPL  {

	private Pagina pagina;


	public static Pagina novaPagina(int densidade, int larguraLinha) {
		return new Pagina(new Parametros( densidade,  larguraLinha)) ;
	}
}
