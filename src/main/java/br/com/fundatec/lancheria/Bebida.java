package br.com.fundatec.lancheria;


//Enum criado pra facilitar o uso de bebida como parâmetro e não ter que receber uma String toda vez
public enum Bebida {

	COCA_COLA("Coca-cola"),
	PEPSI("Pepsi"),
	GUARANA_ANTARTICA("Guaraná Antártica"),
	CERVEJA("Heineken"),
	AGUA_SEM_GAS("Água sem gás"),
	AGUA_COM_GAS("Água com gás");
	
	private String titulo;
	
	Bebida(String titulo){
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
}
