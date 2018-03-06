package br.calculadora.componente.fundamental;

import br.calculadora.MemoriaDeValor;


public class Multiplicacao extends FundamentalBase {

    public Multiplicacao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2) {
        super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2);
    }

    public Multiplicacao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2,
        int scala,
        int modoDeArredondamento) {
        super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2, scala, modoDeArredondamento);
    }

    public void doAplica() {
        armazenaResultado(
        		multiplica(recuperaValor1(), recuperaValor2())
        		.setScale(getScala(),getModoDeArredondamento())
        );
    }
}