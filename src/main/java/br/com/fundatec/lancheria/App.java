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
		BuilderHamburguer xisBuilder = XisHamburguer.builder(); //Builder do hamburguer estanciado
		XisHamburguer hamburguer = xisBuilder.hamburguerDe(Hamburguer.CARNE) //construindo o hamburguer com o builder
				.comMaionese(true)
				.comOvo(true)
				.comPresunto(true)
				.comQueijo(true)
				.build();
		
		BuilderBacon baconBuilder = XisBacon.builder(); //estanciando o builder do xisBacon
		XisBacon bacon = baconBuilder.hamburguerDe(Hamburguer.FRANGO) //builder sendo usando passando apenas os itens desejados
				.comMaionese(true)
				.comQueijo(true)
				.build();
		
		
		PedidoBuilder pedidoBuilder = Pedido.builder(); // builder do pedido estanciado
		
		Pedido pedido = pedidoBuilder.comBebida(Bebida.COCA_COLA) //pedido sendo montado com o builder passando o hamburguer
				.comLanche(hamburguer)
				.formaPagamento(Pagamento.DINHEIRO)
				.build();
		
		Pedido novoPedido = pedidoBuilder.comBebida(Bebida.GUARANA_ANTARTICA) //pedido do bacon sendo montado
				.comLanche(bacon)
				.formaPagamento(Pagamento.CARTAO_CREDITO)
				.build();
		
		//os dois pedidos sendo mostrados com as suas respectivas funções
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
	
	public static void mostrar(Pedido pedido) { // fiz essa função pra não ter código sobrando tipo bebida: sem bebida / null
		if(pedido.getLanche() != null) {
			System.out.println("Seu pedido é um " + pedido.getLanche());
		}
		if(pedido.getBebida() != null) {
			System.out.println("Bebida: " + pedido.getBebida());
		}
		System.out.println("Sua forma de pagamento é: " + pedido.getPagamento());
		
	}
}
