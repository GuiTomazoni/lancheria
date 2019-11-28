package br.com.fundatec.lancheria;

import br.com.fundatec.lancheria.Pedido.PedidoBuilder;
import br.com.fundatec.lancheria.lanches.Hamburguer;
import br.com.fundatec.lancheria.lanches.XisHamburguer;
import br.com.fundatec.lancheria.lanches.XisHamburguer.Builder;

public class App {
	public static void main(String[] args) {
		
		Builder xisBuilder = XisHamburguer.builder();
		XisHamburguer hamburguer = xisBuilder.bifeDe(Hamburguer.CARNE)
				.comMaionese(true)
				.comOvo(true)
				.comPresunto(true)
				.comQueijo(true)
				.build();
		
		
		PedidoBuilder pedidoBuilder = Pedido.builder();
		try {
		Pedido pedido = pedidoBuilder.comBebida(Bebida.COCA_COLA)
				.comLanche(hamburguer)
				.formaPagamento(Pagamento.DINHEIRO)
				.build();
		
		if(pedido.getLanche() != null) {
			System.out.println("Seu pedido é um " + pedido.getLanche());
		}
		if(pedido.getBebida() != null) {
			System.out.println("Bebida: " + pedido.getBebida());
		}
		System.out.println("Sua forma de pagamento é: " + pedido.getPagamento());
		
		System.out.println("========================================================");
		
		hamburguer.preparar();
		hamburguer.montar();
		hamburguer.entregar();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
