package br.calculadora;

import java.math.BigDecimal;

public class OperacoesMatematicas {
	
	public BigDecimal soma(BigDecimal valor1, BigDecimal valor2) {
		return valor1.add(valor2);
	}

	public BigDecimal divide(BigDecimal dividendo, BigDecimal divisor, int modoDeArredondamento,int escala) {
		return dividendo.divide(divisor, escala, modoDeArredondamento);
	}

	
	public BigDecimal divide(BigDecimal dividendo, BigDecimal divisor, int modoDeArredondamento) {
		return divide(dividendo, divisor, modoDeArredondamento, 6);
	}

	public BigDecimal divide(BigDecimal dividendo, BigDecimal divisor) {
		return divide(dividendo,divisor,BigDecimal.ROUND_HALF_EVEN);
	}
	
	public BigDecimal multiplica(BigDecimal multiplicando, BigDecimal multiplicador) {
		return multiplicando.multiply(multiplicador);
	}
	
	public BigDecimal subtrai(BigDecimal valor1, BigDecimal valor2) {
		return valor1.subtract(valor2);
	}

	public BigDecimal getValorCEM() {
		return new BigDecimal(100);
	}
	
	public BigDecimal getValorZERO() {
		return new BigDecimal(0);
	}

	public BigDecimal getDiasNoAnoComercial() {
		return new BigDecimal(360);
	}
	
	public BigDecimal getMesesNoAno() {
		return new BigDecimal(12);
	}
	
	public BigDecimal getDiasNoAno() {
		return new BigDecimal(365);
	}
	
	public BigDecimal getDiasNoMesComercial() {
		return new BigDecimal(30);
	}
	
	public BigDecimal getValorUM() {
		return new BigDecimal(1);
	}

	public BigDecimal eleva(BigDecimal base, BigDecimal expoente) {
		BigDecimal bigDecimal;
        try {
            bigDecimal = new BigDecimal(Math.pow(base.doubleValue(), expoente.doubleValue()));
        } catch (java.lang.NumberFormatException e) {
            bigDecimal = new BigDecimal(1);
        }
        return bigDecimal;
	}

	public BigDecimal transformaPercentualEmTaxa(BigDecimal percentualTransformar) {
		return divide(percentualTransformar, getValorCEM(),BigDecimal.ROUND_HALF_EVEN,10);
	}

	public BigDecimal transformaTaxaEmDecimal(BigDecimal percentualTransformar) {
		return soma(percentualTransformar, getValorUM());
	}

	public BigDecimal transformaPercentualEmDecimal(BigDecimal percentualTransformar) {
		return soma(divide(percentualTransformar, getValorCEM(),BigDecimal.ROUND_HALF_EVEN,17),
				getValorUM());
	}
	
	public BigDecimal transformaDecimalEmPercentual(BigDecimal decimalTransformar) {
		return multiplica(subtrai(decimalTransformar,getValorUM()),getValorCEM());
	}
	
	private boolean impressaoLigada = false;

	public void imprime(Object valor) {
		if (this.impressaoLigada) {
			System.out.println(valor);
		}
	}

	public void ligaImpressao() {
		this.impressaoLigada=true;
	}

	public void desligaImpressao() {
		this.impressaoLigada=false;
	}
	
	public BigDecimal getValorDOZE() {
		return new BigDecimal(12);
	}
	
	public boolean isPositivo(BigDecimal valor) {
		return valor.compareTo(getValorZERO())>0;
	}
}

