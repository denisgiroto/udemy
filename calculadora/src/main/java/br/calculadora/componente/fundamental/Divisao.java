package br.calculadora.componente.fundamental;

import java.math.BigDecimal;

import br.calculadora.MemoriaDeValor;


public class Divisao extends FundamentalBase {

	private MemoriaDeValor divisor;
	private MemoriaDeValor dividendo;
    
    public Divisao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor divisor) {
        
    	super(memoriaDoResultado );
        
        this.divisor = divisor;
        this.dividendo = memoriaDoResultado;
    }

    public Divisao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor divisor,
        int scala,
        int modoDeArredondamento) {
        
    	super(memoriaDoResultado, scala, modoDeArredondamento);
        
        this.divisor = divisor;
        this.dividendo = memoriaDoResultado;
    }

    public void doAplica() {
    	
    	BigDecimal dividendo 	= this.dividendo.getValor();
    	BigDecimal divisor 		= this.divisor.getValor();
    	
    	armazenaValor(
    			
    			dividendo.divide(divisor )
    	
    	);
    }
}