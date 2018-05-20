package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.core.ComandoGeral;
import br.com.dsg.zpl.elemento.core.ElementoComposto;
import br.com.dsg.zpl.elemento.core.Parametros;

/**
 * @author denisgiroto
 *
 */
public abstract class ComandoSimples extends ElementoComposto{

	private Posicao posicao;
	private ComandoGeral comando;
	
	public ComandoSimples( Posicao posicao, ComandoGeral comando) {
		this.posicao = posicao;
		this.comando = comando;
	}
	
	public ComandoSimples( Posicao posicao ) {
		this.posicao = posicao;
	}
	
	public ComandoSimples(int vertical, int horizontal, ComandoGeral comando ) {
		this(new Posicao(vertical, horizontal), comando );
	}
	
	@Override
	protected void montaElemento() {
		registra(posicao);
		
		if(this.comando!=null) {
			
			registra(this.comando);
		}
		
		montaCampo();
	}
	
	protected abstract void montaCampo();
	
	@Override
	public String escrever(Parametros parametros) {
		//System.out.println("ComandoSimples::escrever(parametros)");
		String elemento = super.escrever(parametros);
		//System.out.println("elemento "+this.valor+ "^FS");
		return elemento+ "^FS";
	}

	protected Posicao getPosicao() {
		return posicao;
	}
	
	

}
