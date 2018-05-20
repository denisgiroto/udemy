package br.com.dsg.zpl;

import br.com.dsg.zpl.elemento.core.Pagina;
import br.com.dsg.zpl.elemento.core.Parametros;

public class ZPL  {

	public static Pagina novaPagina(int densidade, int largura, int altura) {
		return new Pagina(new Parametros( densidade,  largura, altura)) ;
	}
}
