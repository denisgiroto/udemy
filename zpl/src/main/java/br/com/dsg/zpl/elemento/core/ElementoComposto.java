package br.com.dsg.zpl.elemento.core;

/**
 * @author denisgiroto
 *
 */
public abstract class ElementoComposto extends Elemento{

//	private List<Elemento> componentes;
	
	private GerenciadorElemento gerenciador = null;
	
	public ElementoComposto() {
		super();
	}
	
	public ElementoComposto(Parametros parametros) {
		super(parametros);
	}

//	public List<Elemento> getComponentes() {
//		if (this.componentes == null) {
//			this.componentes = new ArrayList<Elemento>();
//			montaElemento();
//		}
//		return componentes;
//	}

	protected abstract void montaElemento(GerenciadorElemento cadastro);
	

//	public ElementoComposto registra(Elemento componente) {
//		//System.out.println(this.getClass().getSimpleName()+"::registra(componente) "+componente.getClass().getName());
//		if(componente!=null) {
//			componente.setParametro(getParametros());
//			getComponentes().add(componente);
//		}
//		return this;
//	}


	protected String escrever(Parametros parametros) {
		this.gerenciador = new GerenciadorElemento(parametros);
		montaElemento(gerenciador);
		
		//System.out.println("ElementoComposto::escrever(parametros)");
		String str = new String();
		for (Elemento comp : gerenciador.getComponentes()) {
			//System.out.println(comp.getClass().getName());
			str+=comp.escrever(parametros);
			//System.out.println(str);
		}
		//System.out.println(str);
		return str;
	}
}
