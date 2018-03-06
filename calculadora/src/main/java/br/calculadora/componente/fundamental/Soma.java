package br.calculadora.componente.fundamental;

import java.math.BigDecimal;

import br.calculadora.MemoriaDeValor;

public class Soma extends FundamentalBase {
	
	MemoriaDeValor valor1, valor2;
    
    public Soma(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor valor) {
    	
        super(memoriaDoResultado);
        
        this.valor1 = memoriaDoResultado;
        this.valor2 = valor;
    }

    public Soma(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor valor,
        int scala,
        int modoDeArredondamento) {
        super(memoriaDoResultado, scala, modoDeArredondamento);
        
        this.valor1 = memoriaDoResultado;
        this.valor2 = valor;
    }

    

    public void doAplica() {
    	BigDecimal valor1 = this.valor1.getValor();
    	BigDecimal valor2 = this.valor2.getValor();
    	
    	armazenaValor(
    			
    			valor1.add(valor2)
    			
    			
       );
    	
    	
    }
}