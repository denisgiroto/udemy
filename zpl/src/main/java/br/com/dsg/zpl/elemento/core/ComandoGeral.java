package br.com.dsg.zpl.elemento.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author denisgiroto
 *
 */
public class ComandoGeral extends Elemento {

	private String comando = "";
	private List<Valor> valores = null;
	
	public ComandoGeral(String comando, Valor... valores) {
		this.comando = comando;
		this.valores = Arrays.asList(valores);
	}
	
	public ComandoGeral(String comando) {
		this.comando = comando;
	}

	
	public ComandoGeral comValor(String valor, Conversor conversor) {
		if(valores == null) {
			this.valores = new ArrayList<Valor>();
		}
		this.valores.add(new Valor(valor, conversor));
		return this;
	}
	
	public ComandoGeral comValor(String valor) {
		if(valores == null) {
			this.valores = new ArrayList<Valor>();
		}
		this.valores.add(new Valor(valor));
		return this;
	}
	
	public ComandoGeral comValor(Valor valor) {
		if(valores == null) {
			this.valores = new ArrayList<Valor>();
		}
		this.valores.add(valor);
		return this;
	}

	@Override
	public String escrever(Parametros parametros) {
		
		//System.out.println("ComandoGeral::escrever(parametros)");
		String elemento = "";
		elemento += this.comando;
		if(valores!=null) {
			for (int i = 0; i < valores.size(); i++) {
				String valor = valores.get(i).get(parametros);
				elemento += valor;
				if( i < valores.size()-1 )
					elemento += ",";
			}
		}
		return elemento;
	}
	

}