package br.calculadora.componente.outras;

import java.math.BigDecimal;

import br.calculadora.Decorator;
import br.calculadora.MemoriaDeValor;




public class Fatorial extends Decorator {
	private MemoriaDeValor memoriaDoFatorial;

	public MemoriaDeValor getMemoriaDoFatorial() {
		return this.memoriaDoFatorial;
	}

	public void setMemoriaDoFatorial(MemoriaDeValor percentual) {
		this.memoriaDoFatorial = percentual;
	}

	public Fatorial(
		MemoriaDeValor memoriaDoResultado,
		MemoriaDeValor fatorial) {
		super();
		setMemoriaDoResultado(memoriaDoResultado);
		setMemoriaDoFatorial(fatorial);
	}
	
	public BigDecimal fatorial(BigDecimal num){
		if (num.longValueExact() == 0){ 
			return new BigDecimal(1);
		}
		return num.multiply(fatorial(num.subtract(new BigDecimal(1))));
	}
	
	public BigDecimal fatorial2(BigDecimal num){
		BigDecimal resposta = new BigDecimal(1);
		for (long i = 1; i <= num.longValue(); i++) {
			resposta = resposta.multiply(new BigDecimal(i));
		}
		return resposta;
	}
	
	public void doAplica() {
		if(getMemoriaDoFatorial().getValor().intValue()<20 && getMemoriaDoFatorial().getValor().intValue()>-20){
			armazenaResultado(fatorial(getMemoriaDoFatorial().getValor()));
		}else{
			armazenaResultado(fatorial2(getMemoriaDoFatorial().getValor()));
		}
	}
	

}