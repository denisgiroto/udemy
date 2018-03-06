package br.calculadora;

import java.math.BigDecimal;

public class MemoriaDeValor extends OperacoesMatematicas{
	
	private BigDecimal valor;
	private Fracao fracao;

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

	public MemoriaDeValor(BigDecimal valor) {
		super();
		setValor(valor);
	}
    
    public MemoriaDeValor(Fracao valor) {
        super();
        setFracao(valor);
    }

	public String toString() {
		return getValor().toString();
	}

	public MemoriaDeValor() {
		super();
		setValor(new BigDecimal(0));
	}

	public void reseta() {
		setValor(new BigDecimal(0));
	}
	
	public boolean isPositivo() {
		return getValor().compareTo(getValorZERO()) > 0;
	}
	
	public boolean isNegativo() {
		return getValor().compareTo(getValorZERO()) < 0;
	}
	
	public boolean isZERO() {
		return getValor().compareTo(getValorZERO())==0;
	}
	
	public void setScala(int scala,int modoArredondamento) {
		setValor(getValor().setScale(scala,modoArredondamento));
	}
	
	
}
