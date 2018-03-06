package br.calculadora.componente.fundamental;

import java.math.BigDecimal;

import br.calculadora.MemoriaDeValor;


public class Multiplicacao extends FundamentalBase {

	MemoriaDeValor fator1, fator2;
    
    public Multiplicacao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor fator) {
    	
        super(memoriaDoResultado);
        
        this.fator1 = memoriaDoResultado;
        this.fator2 = fator;
    }

    public Multiplicacao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor fator,
        int scala,
        int modoDeArredondamento) {
        super(memoriaDoResultado, scala, modoDeArredondamento);
        
        this.fator1 = memoriaDoResultado;
        this.fator2 = fator;
    }

    public void doAplica() {
    	
    	BigDecimal fator1 = this.fator1.getValor();
    	BigDecimal fator2 = this.fator2.getValor();
    	
    	armazenaValor(
    			
    			fator1.multiply(fator2)
    			
    			
       );
    	
        
    }
}