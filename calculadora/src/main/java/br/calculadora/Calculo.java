package br.calculadora;

import java.util.ArrayList;
import java.util.List;



public abstract class Calculo extends Decorator {
	
	private List<ComponenteCalculo> componentes;
	
	public List<ComponenteCalculo> getComponentes() {
		if (this.componentes == null) {
            this.componentes = novaFuncoes();
            montaCalculo();
        }
		return componentes;
	}
	
	protected ArrayList<ComponenteCalculo> novaFuncoes() {
        return new ArrayList<ComponenteCalculo>();
    }
	
	public abstract void montaCalculo();

	public void registraComponente(ComponenteCalculo componente){
		componentes.add(componente);
	}
	
	public void doAplica() {
		calcula();
  }
	
	public void calcula(){
		for(ComponenteCalculo comp:getComponentes()){
			comp.aplica();
		}
	}
	
}
