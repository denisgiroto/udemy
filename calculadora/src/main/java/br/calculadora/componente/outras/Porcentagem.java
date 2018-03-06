package br.calculadora.componente.outras;

import java.math.BigDecimal;

import br.calculadora.Calculadora;
import br.calculadora.MemoriaDeValor;

public class Porcentagem extends Calculadora {

	private MemoriaDeValor valor;
	private MemoriaDeValor taxa;

	public Porcentagem(MemoriaDeValor memoriaDoResultado, MemoriaDeValor taxa) {

		setMemoriaDoResultado(memoriaDoResultado);
		this.valor = memoriaDoResultado;
		this.taxa = taxa;
	}

	public Porcentagem(MemoriaDeValor memoriaDoResultado, MemoriaDeValor valor, MemoriaDeValor taxa) {
		super();
		setMemoriaDoResultado(memoriaDoResultado);
		this.valor = valor;
		this.taxa = taxa;
	}

	public void doAplica() {
		
		BigDecimal valor = this.valor.getValor();
		double taxa  = this.taxa.getValor().doubleValue();
		
		getResultado().setValor(
		
				valor.multiply( new BigDecimal(fatorMutiplicacao(taxa)) )
		);
		
	}
	
	private double fatorMutiplicacao(double valor) {
		if(valor< 0.0 ) {
			double percentual = (valor * (-1.0))/100;
			return 1 - percentual;
		}else {
			double percentual = valor/100;
			return 1 + percentual;
		}
	}

}