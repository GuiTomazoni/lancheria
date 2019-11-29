package br.com.fundatec.lancheria;

import br.com.fundatec.lancheria.Pedido.PedidoBuilder;
import br.com.fundatec.lancheria.lanches.Hamburguer;
import br.com.fundatec.lancheria.lanches.XisBacon;
import br.com.fundatec.lancheria.lanches.XisBacon.BuilderBacon;
import br.com.fundatec.lancheria.lanches.XisHamburguer;
import br.com.fundatec.lancheria.lanches.XisHamburguer.BuilderHamburguer;

public class App {
	public static void main(String[] args) {
		
		try {
		BuilderHamburguer xisBuilder = XisHamburguer.builder();
		XisHamburguer hamburguer = xisBuilder.hamburguerDe(Hamburguer.CARNE)
				.comMaionese(true)
				.comOvo(true)
				.comPresunto(true)
				.comQueijo(true)
				.build();
		
		BuilderBacon baconBuilder = XisBacon.builder();
		XisBacon bacon = baconBuilder.hamburguerDe(Hamburguer.FRANGO)
				.comMaionese(true)
				.comQueijo(true)
				.build();
		
		
		PedidoBuilder pedidoBuilder = Pedido.builder();
		
		Pedido pedido = pedidoBuilder.comBebida(Bebida.COCA_COLA)
				.comLanche(hamburguer)
				.formaPagamento(Pagamento.DINHEIRO)
				.build();
		
		Pedido novoPedido = pedidoBuilder.comBebida(Bebida.GUARANA_ANTARTICA)
				.comLanche(bacon)
				.formaPagamento(Pagamento.CARTAO_CREDITO)
				.build();
		
		mostrar(pedido);
		hamburguer.preparar();
		hamburguer.montar();
		hamburguer.entregar();
		System.out.println("========================================================");
		mostrar(novoPedido);
		bacon.preparar();
		bacon.montar();
		bacon.entregar();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void mostrar(Pedido pedido) {
		if(pedido.getLanche() != null) {
			System.out.println("Seu pedido é um " + pedido.getLanche());
		}
		if(pedido.getBebida() != null) {
			System.out.println("Bebida: " + pedido.getBebida());
		}
		System.out.println("Sua forma de pagamento é: " + pedido.getPagamento());
		
	}
}
