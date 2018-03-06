package util;

import java.math.BigDecimal;

public class UtilMatematica {

	public static BigDecimal fatorial(BigDecimal num){
		if (num.longValueExact() == 0){ 
			return new BigDecimal(1);
		}
		return num.multiply(fatorial(num.subtract(new BigDecimal(1))));
	}
	
	public static BigDecimal numeroBinomial(BigDecimal qtdElementosExitente, BigDecimal numElementosGrupo){
		BigDecimal fatElementosExitente = fatorial(qtdElementosExitente);
		BigDecimal fatElementosGrupo = fatorial(numElementosGrupo);
		return fatElementosExitente
				.divide(fatElementosGrupo
						.multiply(fatorial(qtdElementosExitente.subtract(numElementosGrupo)))
						);
	}
	
	public static void main(String[] args) {
		BigDecimal numElementos = new BigDecimal(8);
		BigDecimal numFixo = new BigDecimal(6);		
		
		System.out.println(numeroBinomial(numElementos,numFixo));
	
	}
}
