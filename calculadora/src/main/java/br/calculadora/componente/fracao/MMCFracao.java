package br.calculadora.componente.fracao;

import br.calculadora.Fracao;
import br.calculadora.MemoriaDeValor;

public class MMCFracao extends FracaoBase {
    

    public MMCFracao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2) {
        super(memoriaDoResultado ,memoriaDoValor1,memoriaDoValor2);

    }

    public Fracao mmcFracao(Fracao fracao1, Fracao fracao2){
        int mmcDenominadores = calculaMMC(fracao1.getDenominador().intValue(),fracao2.getDenominador().intValue());
        int numerador1 = (mmcDenominadores/fracao1.getDenominador().intValue())*fracao1.getNumerador().intValue();
        String fracao =  numerador1+"/"+mmcDenominadores;
        return new Fracao(fracao);
    }
    public void doAplica() {
        Fracao fracao = mmcFracao(getMemoriaDoValor1().getFracao(),getMemoriaDoValor2().getFracao());
        armazenaResultado(getFracaoInteirosSimplificada(fracao.getNumerador().intValue(), fracao.getDenominador().intValue()));
    }
}