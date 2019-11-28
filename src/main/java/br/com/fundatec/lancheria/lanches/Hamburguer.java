package br.com.fundatec.lancheria.lanches;

public enum Hamburguer {

	CARNE("Carne"),
	FRANGO("Frango");
	
private String titulo;
	
	Hamburguer(String titulo){
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
}
