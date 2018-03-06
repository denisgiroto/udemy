package br.calculadora.componente.fracao;

import br.calculadora.Fracao;
import br.calculadora.MemoriaDeValor;

public class MultiplicacaoDeFracao extends FracaoBase {
    

    public MultiplicacaoDeFracao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2) {
        super(memoriaDoResultado ,memoriaDoValor1,memoriaDoValor2);

    }
    
    public Fracao multiplicaFracao(Fracao fracao1, Fracao fracao2){
       
        int numerador1 = fracao1.getNumerador().intValue();
        int numerador2 = fracao2.getNumerador().intValue();
        int denominador1 = fracao1.getDenominador().intValue();
        int denominador2 = fracao2.getDenominador().intValue();
        int numeradorComum = numerador1*numerador2;
        int denominadorComum = denominador1*denominador2;
        String fracao =  numeradorComum+"/"+denominadorComum;
        return new Fracao(fracao);
    }
    public void doAplica() {
        Fracao fracao = multiplicaFracao(getMemoriaDoValor1().getFracao(),getMemoriaDoValor2().getFracao());
        armazenaResultado(getFracaoInteirosSimplificada(fracao.getNumerador().intValue(), fracao.getDenominador().intValue()));
    }
}