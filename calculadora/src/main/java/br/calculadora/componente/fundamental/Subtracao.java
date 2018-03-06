package br.calculadora.componente.fundamental;

import br.calculadora.MemoriaDeValor;

public class Subtracao extends FundamentalBase {

    public Subtracao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2,
        int scala,
        int modoDeArredondamento) {
        super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2, scala, modoDeArredondamento);
    }

    public Subtracao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2) {
        super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2);
    }

    public void doAplica() {
        armazenaResultado(
        		subtrai(recuperaValor1(), recuperaValor2())
        		.setScale(getScala(),getModoDeArredondamento())
        );
    }
}