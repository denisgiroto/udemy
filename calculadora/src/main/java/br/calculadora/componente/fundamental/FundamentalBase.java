package br.calculadora.componente.fundamental;

import java.math.BigDecimal;

import br.calculadora.Calculadora;
import br.calculadora.Fracao;
import br.calculadora.MemoriaDeValor;


public abstract class FundamentalBase extends Calculadora{
	
    
    private int scala;
    private int modoDeArredondamento;

    public FundamentalBase(
        MemoriaDeValor memoriaDoResultado,
        int scala,
        int modoDeArredondamento) {
        setMemoriaDoResultado(memoriaDoResultado);
        setScala(scala);
        setModoDeArredondamento(modoDeArredondamento);
    }


    public FundamentalBase(
        MemoriaDeValor memoriaDoResultado) {
        setMemoriaDoResultado(memoriaDoResultado);
        setScala(6);
        setModoDeArredondamento(BigDecimal.ROUND_HALF_EVEN);
    }

    public final int getScala() {
        return this.scala;
    }

    public final void setScala(int scala) {
        this.scala = scala;
    }

    public final int getModoDeArredondamento() {
        return this.modoDeArredondamento;
    }

    public final void setModoDeArredondamento(int modoDeArredondamento) {
        this.modoDeArredondamento = modoDeArredondamento;
    }
	
    protected final void armazenaValor( BigDecimal valor ) {
    	getResultado().setValor( valor.setScale( scala , modoDeArredondamento) );
    }
    
    protected final void armazenaFracao( Fracao fracao ) {
    	getResultado().setFracao( fracao );
    }
	
}
