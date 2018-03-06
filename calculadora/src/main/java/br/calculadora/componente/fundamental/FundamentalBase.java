package br.calculadora.componente.fundamental;

import java.math.BigDecimal;

import br.calculadora.Decorator;
import br.calculadora.MemoriaDeValor;


public abstract class FundamentalBase extends Decorator{
	
    private MemoriaDeValor memoriaDoValor1;
    private MemoriaDeValor memoriaDoValor2;
    private int scala;
    private int modoDeArredondamento;

    public FundamentalBase(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2,
        int scala,
        int modoDeArredondamento) {
        setMemoriaDoResultado(memoriaDoResultado);
        setMemoriaDoValor1(memoriaDoValor1);
        setMemoriaDoValor2(memoriaDoValor2);
        setScala(scala);
        setModoDeArredondamento(modoDeArredondamento);
    }


    public FundamentalBase(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2) {
        setMemoriaDoResultado(memoriaDoResultado);
        setMemoriaDoValor1(memoriaDoValor1);
        setMemoriaDoValor2(memoriaDoValor2);
        setScala(6);
        setModoDeArredondamento(BigDecimal.ROUND_HALF_EVEN);
    }

    public MemoriaDeValor getMemoriaDoValor1() {
    	return this.memoriaDoValor1;
    }
    
    public void setMemoriaDoValor1(MemoriaDeValor memoriaDoValorASerAplicado) {
    	this.memoriaDoValor1 = memoriaDoValorASerAplicado;
    }
    
    public BigDecimal recuperaValor1() {
    	return getMemoriaDoValor1().getValor();
    }
    
    public BigDecimal recuperaValor2() {
    	return getMemoriaDoValor2().getValor();
    }
    
    public MemoriaDeValor getMemoriaDoValor2() {
        return this.memoriaDoValor2;
    }

    public void setMemoriaDoValor2(MemoriaDeValor memoriaDoValor2) {
        this.memoriaDoValor2 = memoriaDoValor2;
    }

    public int getScala() {
        return this.scala;
    }

    public void setScala(int scala) {
        this.scala = scala;
    }

    public int getModoDeArredondamento() {
        return this.modoDeArredondamento;
    }

    public void setModoDeArredondamento(int modoDeArredondamento) {
        this.modoDeArredondamento = modoDeArredondamento;
    }
	
	
}
