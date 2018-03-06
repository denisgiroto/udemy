package br.calculadora.componente.fracao;

import br.calculadora.Fracao;
import br.calculadora.MemoriaDeValor;

public class SomaDeFracao extends FracaoBase {

	public SomaDeFracao(MemoriaDeValor memoriaDoResultado,
			MemoriaDeValor memoriaDoValor1, MemoriaDeValor memoriaDoValor2) {
		super(memoriaDoResultado, memoriaDoValor1, memoriaDoValor2);

	}

	public Fracao somaFracao(Fracao fracao1, Fracao fracao2) {
		int mmcDenominadores = calculaMMC(fracao1.getDenominador().intValue(),
				fracao2.getDenominador().intValue());
		int numerador1 = (mmcDenominadores / fracao1.getDenominador()
				.intValue())
				* fracao1.getNumerador().intValue();
		int numerador2 = (mmcDenominadores / fracao2.getDenominador()
				.intValue())
				* fracao2.getNumerador().intValue();
		int soma = numerador1 + numerador2;
		String fracao = soma + "/" + mmcDenominadores;
		return new Fracao(fracao);
	}

	public void doAplica() {
		Fracao fracao = somaFracao(getMemoriaDoValor1().getFracao(),
				getMemoriaDoValor2().getFracao());
		armazenaResultado(getFracaoInteirosSimplificada(fracao.getNumerador()
				.intValue(), fracao.getDenominador().intValue()));
	}
}