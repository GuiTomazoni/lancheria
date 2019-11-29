package br.com.fundatec.lancheria.factory;

import br.com.fundatec.lancheria.lanches.Hamburguer;

public abstract class Xis {

	public abstract void preparar();
	public abstract void montar();
	public void entregar() {
		System.out.println("Colocando seu xis em um saquinho");
	}
	public abstract String getName();
	
	
	protected Hamburguer hamburguer;
	protected boolean ovo;
	protected boolean maionese;
	protected boolean presunto;
	protected boolean queijo;
}
