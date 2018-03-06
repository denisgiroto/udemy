package br.calculadora.componente.fundamental;

import br.calculadora.MemoriaDeValor;


public class Divisao extends FundamentalBase {

    public Divisao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2) {
        super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2);
    }

    public Divisao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2,
        int scala,
        int modoDeArredondamento) {
        super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2, scala, modoDeArredondamento);
    }

    public void doAplica() {
        armazenaResultado(
        	divide(recuperaValor1(), recuperaValor2())
        	.setScale(getScala(),getModoDeArredondamento())
        );
    }
}