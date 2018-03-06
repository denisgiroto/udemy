package br.calculadora.componente.fracao;

import br.calculadora.Fracao;
import br.calculadora.MemoriaDeValor;

public class DivisaoDeFracao extends FracaoBase {
    

    public DivisaoDeFracao(
        MemoriaDeValor memoriaDoResultado,
        MemoriaDeValor memoriaDoValor1,
        MemoriaDeValor memoriaDoValor2) {
        super(memoriaDoResultado ,memoriaDoValor1,memoriaDoValor2);

    }
    
    public Fracao divideFracao(Fracao fracao1, Fracao fracao2){
        int numerador = fracao1.getNumerador().intValue() * fracao2.getDenominador().intValue();
        int denominador=fracao1.getDenominador().intValue() * fracao2.getNumerador().intValue();
        return new Fracao(numerador+"/"+denominador);
    }
    
    public void doAplica() {
        Fracao fracao = divideFracao(getMemoriaDoValor1().getFracao(),getMemoriaDoValor2().getFracao());
        armazenaResultado(getFracaoInteirosSimplificada(fracao.getNumerador().intValue(), fracao.getDenominador().intValue()));
    }
}