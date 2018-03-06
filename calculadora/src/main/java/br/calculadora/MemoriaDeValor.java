package br.calculadora;

import java.math.BigDecimal;

public class MemoriaDeValor {
	
	private BigDecimal valor;
	private Fracao fracao;


	public MemoriaDeValor(BigDecimal valor) {
		super();
		setValor(valor);
	}
    
    public MemoriaDeValor(Fracao valor) {
        super();
        setFracao(valor);
    }

	
	public MemoriaDeValor() {
		super();
		setValor(BigDecimal.ZERO);
	}

	public Fracao getFracao() {
        return this.fracao;
    }
    
    public void setFracao(Fracao fracao) {
        this.fracao = fracao;
    }

    public BigDecimal getValor() {
		
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return getValor().toString();
	}

	
}
