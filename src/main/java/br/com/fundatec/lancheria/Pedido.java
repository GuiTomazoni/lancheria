package br.com.fundatec.lancheria;

import br.com.fundatec.lancheria.factory.Xis;

public class Pedido {

	private Bebida bebida;
	private Xis lanche;
	private Pagamento pagamento;
	
	public Pedido() {
		
	}
	//builder criado pois Pedido pode ou não conter bebida ou lanche e evita que o pagamento seja nulo
	//sendo assim evita o uso de mais de um construtor e faz uma validação de pagamento
	public static PedidoBuilder builder() {
		return new Pedido().new PedidoBuilder();
	}
	
	public class PedidoBuilder{
		Pedido pedido;
		
		public PedidoBuilder() {
			this.pedido = new Pedido();
		}
		
		public PedidoBuilder comBebida(Bebida bebida) {
			pedido.bebida = bebida;
			return this;
		}
		
		public PedidoBuilder comLanche(Xis lanche) {
			pedido.lanche = lanche;
			return this;
		}
		
		public PedidoBuilder formaPagamento(Pagamento pagamento) {
			pedido.pagamento = pagamento;
			return this;
		}
		//a única regra de negócio é que o pagamento seja informado no pedido
		public Pedido build() throws Exception{
			if(pedido.pagamento == null) {
				throw new Exception("forma de pagamento não informada");
			}
			return pedido;
		}
	}
	//opção de maionese extra criada para apresentar o uso do mockito nos testes
	public String maioneseExtra() throws Exception {
		if(lanche == null) {
			throw new Exception("Não pode ser fornecido maionese extra sem um lanche");
		}
		return "Entregando copinho com maionese extra";
	}

	public String getBebida() {
		if(bebida == null) {
			return "null";
		}
		return bebida.getTitulo();
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	public String getLanche() {
		if(lanche == null) {
			return "null";
		}
		return lanche.getName();
	}

	public void setLanche(Xis lanche) {
		this.lanche = lanche;
	}

	public String getPagamento() {
		if(pagamento == null) {
			return "null";
		}
		return pagamento.getTitulo();
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	
}
