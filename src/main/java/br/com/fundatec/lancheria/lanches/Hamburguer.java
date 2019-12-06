package br.com.fundatec.lancheria.lanches;

//Enum que seta as opções de hamburguer disponiveis para o Xis, segue o mesmo motivo dos demais
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
