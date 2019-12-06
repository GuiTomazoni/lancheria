package br.com.fundatec.lancheria.factory;

import br.com.fundatec.lancheria.lanches.Hamburguer;


//classe abstrata xis criada representando o factory method
//foi usado apenas métodos de apresentar no console para servir de exemplo de como é usada a factory
//ciente de que em aplicações reais existem com certeza funções reais e não apenas Sysouts
public abstract class Xis {

	public abstract void preparar();
	public abstract void montar();
	//método entregar é igual pra todas classes que usarem Xis, sendo assim foi criado como estático
	public void entregar() {
		System.out.println("Colocando seu xis em um saquinho");
	}
	public abstract String getName();
	
	//atributos comuns para as demais classes que extenderão xis foram colocados na classe abstrata pra deixar um código mais limpo
	protected Hamburguer hamburguer;
	protected boolean ovo;
	protected boolean maionese;
	protected boolean presunto;
	protected boolean queijo;
}
