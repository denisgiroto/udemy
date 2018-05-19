package br.com.dsg.zpl.elemento.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author denisgiroto
 *
 */
public abstract class ElementoComposto extends Elemento{

	private List<Elemento> componentes;
	
	public ElementoComposto() {
		super();
	}

	public List<Elemento> getComponentes() {
		if (this.componentes == null) {
			this.componentes = new ArrayList<Elemento>();
			montaElemento();
		}
		return componentes;
	}

	protected abstract void montaElemento();
	

	public ElementoComposto registra(Elemento componente) {
		System.out.println(this.getClass().getSimpleName()+"::registra(componente) "+componente.getClass().getName());
		getComponentes().add(componente);
		return this;
	}


	public String escrever(Parametros parametros) {
		//System.out.println("ElementoComposto::escrever(parametros)");
		String str = new String();
		for (Elemento comp : getComponentes()) {
			//System.out.println(comp.getClass().getName());
			str+=comp.escrever(parametros);
			//System.out.println(str);
		}
		//System.out.println(str);
		return str;
	}
}
