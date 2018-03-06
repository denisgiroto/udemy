package br.calculadora;

import java.math.BigDecimal;

public class Fracao {

    private Integer numerador;
    private Integer denominador;
    private int modoDeArredontamento = BigDecimal.ROUND_HALF_EVEN;
    private int numeroDeCasasDecimais = 5;

    public Fracao () {
        super();
    }
    
    public Fracao(String representacaoFracionaria) {
        setValorFracionario(representacaoFracionaria);
    }

    public Fracao(String representacaoFracionaria, int modoDeArredondamento) {
        setValorFracionario(representacaoFracionaria);
        setModoDeArredontamento(modoDeArredondamento);
    }

    public Integer getDenominador() {
        return this.denominador;
    }

    public void setDenominador(Integer denominador) {
        this.denominador = denominador;
    }

    public Integer getNumerador() {
        return this.numerador;
    }

    public void setNumerador(Integer numerador) {
        this.numerador = numerador;
    }

    public void setValorFracionario(String representacaoFracionaria) {
        String[] elementosDaFracao = getElementosDaFracao(representacaoFracionaria);
        	if(elementosDaFracao!=null && elementosDaFracao.length==2){
        	    setNumerador(converteParaInteiro(getNumeradorDaFracao(elementosDaFracao)));
        	    setDenominador(converteParaInteiro(getDenominadorDaFracao(elementosDaFracao)));
        	}
    }

    protected String[] getElementosDaFracao(String representacaoFracionaria) {
        String elementos[] = null;
        if (representacaoFracionaria != null && representacaoFracionaria.indexOf("/") >= 0) {
            elementos = representacaoFracionaria.split("/");
        }
        return elementos;
    }

    protected String getNumeradorDaFracao(String[] elementosDaFracao) {
       return elementosDaFracao[0].trim();
    }

    protected Integer converteParaInteiro(String valor) {
        Integer inteiro = null;
        try {
            inteiro = Integer.valueOf(valor);
        } catch (NumberFormatException e) {
            //
        }
        return inteiro;
    }

    protected String getDenominadorDaFracao(String[] elementosDaFracao) {
        return elementosDaFracao[1].trim();
    }

    public String toString() {
        return getNumerador() + "/" + getDenominador();
    }

    public BigDecimal getDecimal() {
        BigDecimal numeradorDecimal = null;
        BigDecimal denominadorDecimal = null;
        BigDecimal decimal = new BigDecimal(1);
        if (isFracaoFormada()) {
            numeradorDecimal = new BigDecimal(getNumerador().toString());
            denominadorDecimal = new BigDecimal(getDenominador().toString());
            decimal = numeradorDecimal.divide(denominadorDecimal, getNumeroDeCasasDecimais(),getModoDeArredontamento());
        }
        return decimal;
    }
    
    public int getNumeroDeCasasDecimais() {
        return this.numeroDeCasasDecimais;
    }

    protected boolean isFracaoFormada() {
        return getNumerador() != null && getDenominador() != null;
    }

    public int getModoDeArredontamento() {
        return this.modoDeArredontamento;
    }

    public void setModoDeArredontamento(int modoDeArredontamento) {
        this.modoDeArredontamento = modoDeArredontamento;
    }

    public void setNumeroDeCasasDecimais(int numeroDeCasasDecimais) {
        this.numeroDeCasasDecimais = numeroDeCasasDecimais;
    }
    
}
