package br.com.fundatec.lancheria;


//Pagamento foi usado um enum também pois igual bebida, possui apenas estas opções e não precisa ser digitado como string
public enum Pagamento {

	DINHEIRO("Dinheiro"),
	CARTAO_CREDITO("Cartão de crédito"),
	CARTAO_DEBITO("Cartão de débito");
	
	private String titulo;
	
	Pagamento(String titulo){
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
}
