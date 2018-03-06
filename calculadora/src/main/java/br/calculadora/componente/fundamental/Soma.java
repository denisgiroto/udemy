package br.calculadora.componente.fundamental;

import br.calculadora.MemoriaDeValor;

public class Soma extends FundamentalBase {

    public Soma(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2,
        int scala,
        int modoDeArredondamento) {
        super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2, scala, modoDeArredondamento);
    }

    public Soma(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2) {
        super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2);
    }

    public void doAplica() {
        armazenaResultado(
        		soma(recuperaValor1(), recuperaValor2())
        		.setScale(getScala(),getModoDeArredondamento())
        );
    }
}