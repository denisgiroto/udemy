package br.calculadora.componente.fracao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.calculadora.Calculadora;
import br.calculadora.Fracao;
import br.calculadora.MemoriaDeValor;



public class FracaoBase extends Calculadora {
    
    private MemoriaDeValor memoriaDoValor1;
    private MemoriaDeValor memoriaDoValor2;
    
    public MemoriaDeValor getMemoriaDoValor1() {
        if (this.memoriaDoValor1 == null) {
            this.memoriaDoValor1 = new MemoriaDeValor();	
        }
        return this.memoriaDoValor1;
    }

    public MemoriaDeValor getMemoriaDoValor2() {
        if (this.memoriaDoValor2 == null) {
            this.memoriaDoValor2 = new MemoriaDeValor();	
        }
        return this.memoriaDoValor2;
    }
    
    public void setMemoriaDoValor1(MemoriaDeValor memoriaDoValorASerAplicado) {
        this.memoriaDoValor1 = memoriaDoValorASerAplicado;
        if(this.memoriaDoValor1.getFracao()==null){
            this.memoriaDoValor1.setFracao(new Fracao());
            this.memoriaDoValor1.getFracao().setDenominador(new Integer(1));
            this.memoriaDoValor1.getFracao().setNumerador(new Integer(memoriaDoValorASerAplicado.getValor().intValue()));
        }

    }

    public void setMemoriaDoValor2(MemoriaDeValor memoriaDoValor2) {
        this.memoriaDoValor2 = memoriaDoValor2;
        if(this.memoriaDoValor2.getFracao()==null){
            this.memoriaDoValor2.setFracao(new Fracao());
            this.memoriaDoValor2.getFracao().setDenominador(new Integer(1));
            this.memoriaDoValor2.getFracao().setNumerador(new Integer(memoriaDoValor2.getValor().intValue()));
        }
    }
    
    
    public void setMemoriaDoValor1(Fracao memoriaDoValorASerAplicado) {
        if(memoriaDoValorASerAplicado!=null){
            getMemoriaDoValor1().setFracao(memoriaDoValorASerAplicado);
        }
        
    }
    
    public void setMemoriaDoValor2(Fracao memoriaDoValorASerAplicado) {
        if(memoriaDoValorASerAplicado!=null){
            getMemoriaDoValor2().setFracao(memoriaDoValorASerAplicado);
        }
        
    }
    
    public Fracao recuperaFracao1() {
        return getMemoriaDoValor1().getFracao();
    }

    public Fracao recuperaFracao2() {
        return getMemoriaDoValor2().getFracao();
    }
    
    public void setMemoriaDoResultado(Fracao memoriaDeCalculo) {
        super.getResultado().setFracao(memoriaDeCalculo);
    }
    
    public void armazenaResultado(Fracao valor) {
        getResultado().setFracao(valor); 
    }
    
    public FracaoBase(MemoriaDeValor memoriaDoResultado,
              MemoriaDeValor memoriaDoValor1) {
                   
        setMemoriaDoValor1(memoriaDoValor1.getFracao());
        setMemoriaDoValor1(memoriaDoValor1);
        super.setMemoriaDoResultado(memoriaDoResultado);
    }
    
    public FracaoBase(MemoriaDeValor memoriaDoResultado,
              MemoriaDeValor memoriaDoValor1,
              MemoriaDeValor memoriaDoValor2) {
        
        setMemoriaDoValor1(memoriaDoValor1.getFracao());
        setMemoriaDoValor2(memoriaDoValor2.getFracao());
        setMemoriaDoValor1(memoriaDoValor1);
        setMemoriaDoValor2(memoriaDoValor2);
        super.setMemoriaDoResultado(memoriaDoResultado);
       
    }
    
    protected Fracao getFracaoInteirosSimplificada(int numerador, int denominador){
        Fracao fracao = new Fracao();
        fracao.setNumerador( new Integer((int)numerador) );
        fracao.setDenominador( new Integer((int)denominador) );
        return fracao;
    }

    public void doAplica() {
        Fracao fracao = getFracaoInteirosSimplificada(
            recuperaFracao1().getNumerador().intValue(),
            recuperaFracao1().getDenominador().intValue());
        armazenaResultado(fracao);
    }
    
    private List<Integer> getDivisoresDoMMC(int divisor, int[] dividendos) {
        List<Integer>  listaDeDivisores = new ArrayList<Integer>();
        while (isTodosDividendosDiferentesDeUm(dividendos)){
            boolean flag = false;
            for (int i=0; i < dividendos.length; i++){
                if (dividendos[i] != 0 && dividendos[i]%divisor == 0){
                    dividendos[i] = dividendos[i]/divisor;
                    flag = true;
                }
            }
            
            if (!flag){
                divisor++;
            }else{
                listaDeDivisores.add(new Integer(divisor));
            }
        }
        return listaDeDivisores;
    }
    
    private boolean isTodosDividendosDiferentesDeUm(int[] dividendos) {
        for (int i=0; i < dividendos.length; i++){
            if (dividendos[i] != 1 && dividendos[i] != 0){
                return true;
            }
        }       
        return false;
    }
    
    public int calculaMMC(int denominador1, int denominador2) {
        int[] denominadores = {denominador1, denominador2};
        int divisor = 2;
        int[] dividendos = (int[]) denominadores.clone();       
        Iterator<Integer> it = getDivisoresDoMMC(divisor, dividendos).iterator();
        Integer inteiro;
        int mmc = 1;
        while (it.hasNext()){
            inteiro = (Integer)it.next();
            mmc = mmc * inteiro.intValue();
        }
        return mmc;
    }
}