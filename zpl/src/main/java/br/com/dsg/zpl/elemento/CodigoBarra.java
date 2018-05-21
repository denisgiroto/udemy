package br.com.dsg.zpl.elemento;

import br.com.dsg.zpl.elemento.core.ComandoGeral;
import br.com.dsg.zpl.elemento.core.Dimensao;
import br.com.dsg.zpl.elemento.core.GerenciadorElemento;
import br.com.dsg.zpl.elemento.core.Rotacao;

public class CodigoBarra extends ComandoSimples {
	
	private ComandoGeral codigoBarra = new ComandoGeral("^BQ");
	
	private PadraoCodigoBarra padrao;
	private Rotacao rotacao = Rotacao.N;
	private String interprtacao = "S";
	private Boolean interprtacaoEmCima = Boolean.FALSE;
	private String valor = null;
	

	private Dimensao dimensao;
	
	public CodigoBarra(Posicao posicao, Dimensao dimensao, String valor) {
		super(posicao);
		this.dimensao = dimensao;
		this.valor = valor;
	}
	
	public CodigoBarra comPadrao(PadraoCodigoBarra padrao) {
		
		this.padrao = padrao;
		return this;
	}
	

	@Override
	protected void montaCampo(GerenciadorElemento gerenciador) {
		
		codigoBarra.comValor( this.padrao.getPadrao()+""+this.rotacao.name() );
		codigoBarra.comValor( this.dimensao.getAltura(), true );
		
		codigoBarra.comValor( this.interprtacao );
		if(interprtacaoEmCima) {
			codigoBarra.comValor( "S" );
		}else {
			codigoBarra.comValor( "N" );
		}
		
		gerenciador.registra(codigoBarra);
		
		
		gerenciador.registra( new Texto(this.valor ));
	}

}
