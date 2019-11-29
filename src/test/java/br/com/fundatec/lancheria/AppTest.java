package br.com.fundatec.lancheria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import br.com.fundatec.lancheria.Pedido.PedidoBuilder;
import br.com.fundatec.lancheria.lanches.Hamburguer;
import br.com.fundatec.lancheria.lanches.XisBacon;
import br.com.fundatec.lancheria.lanches.XisHamburguer;
import br.com.fundatec.lancheria.lanches.XisBacon.BuilderBacon;
import br.com.fundatec.lancheria.lanches.XisHamburguer.BuilderHamburguer;

public class AppTest {

	@Test
	public void deveRealizarUmPedidoCompleto() throws Exception {
		BuilderHamburguer xisBuilder = XisHamburguer.builder();
		XisHamburguer hamburguer = xisBuilder.hamburguerDe(Hamburguer.CARNE)
				.comMaionese(true)
				.comOvo(true)
				.comPresunto(true)
				.comQueijo(true)
				.build();
		
		
		PedidoBuilder pedidoBuilder = Pedido.builder();
		Pedido pedido = pedidoBuilder.comBebida(Bebida.COCA_COLA)
				.comLanche(hamburguer)
				.formaPagamento(Pagamento.DINHEIRO)
				.build();
		
		assertEquals("Xis Hamburguer", pedido.getLanche());
		assertTrue(hamburguer.temMaionese());
		assertTrue(hamburguer.temOvo());
		assertTrue(hamburguer.temPresunto());
		assertTrue(hamburguer.temQueijo());
		assertEquals("Coca-cola", pedido.getBebida());
		assertEquals("Dinheiro", pedido.getPagamento());
	}
	
	@Test
	public void deveRealizarUmPedidoSemLanche() throws Exception {
		PedidoBuilder pedidoBuilder = Pedido.builder();
		Pedido pedido = pedidoBuilder.comBebida(Bebida.COCA_COLA)
				.formaPagamento(Pagamento.DINHEIRO)
				.build();
		assertEquals("Coca-cola", pedido.getBebida());
		assertEquals("Dinheiro", pedido.getPagamento());
		assertEquals("null", pedido.getLanche());
	}
	
	@Test
	public void deveFalharAoFazerPedidoSemPagamento(){
		String erro = "";
		String erroEsperado = "forma de pagamento não informada";
		
		try {
			PedidoBuilder pedidoBuilder = Pedido.builder();
			Pedido pedido = pedidoBuilder.comBebida(Bebida.COCA_COLA)
					.build();
		} catch (Exception e) {
			erro = e.getMessage();
		}
		assertEquals(erroEsperado, erro);
	}
	
	@Test
	public void deveMockarPedido() throws Exception {
		BuilderHamburguer xisBuilder = XisHamburguer.builder();
		XisHamburguer xis = xisBuilder.hamburguerDe(Hamburguer.CARNE)
				.comMaionese(true)
				.comOvo(true)
				.comPresunto(true)
				.comQueijo(true)
				.build();
		
		Pedido pedido = Mockito.mock(Pedido.class);
		when(pedido.getBebida()).thenReturn("Budweiser");
		when(pedido.getPagamento()).thenReturn("VR");
		when(pedido.getLanche()).thenReturn(xis.getName());
	
		assertEquals("Budweiser", pedido.getBebida());
		assertEquals("VR", pedido.getPagamento());
		assertEquals("Xis Hamburguer", pedido.getLanche());
		
	}
	
	@Test
	public void deveFalharAoPedirMaioneseExtraSemLanche() {
		String erro = "";
		String erroEsperado = "Não pode ser fornecido maionese extra sem um lanche";
		try {
			
		PedidoBuilder pedidoBuilder = Pedido.builder();
		Pedido pedido = pedidoBuilder.comBebida(Bebida.COCA_COLA)
				.formaPagamento(Pagamento.CARTAO_CREDITO)
				.build();
		pedido.maioneseExtra();
		
		} catch (Exception e) {
			erro = e.getMessage();
		}
		
		assertEquals(erroEsperado, erro);
	}
	
	@Test
	public void deveFalharAoMontarXisVazio() {
		String erro = "";
		String erroEsperado = "Xis deve conter algum item";
		try {
			BuilderBacon xisBuilder = XisBacon.builder();
			XisBacon xis = xisBuilder.build();
		} catch (Exception e) {
			erro = e.getMessage();
		}
		
		assertEquals(erroEsperado, erro);
	}
}
