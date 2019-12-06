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

	//Aqui faço um teste pra ver se um pedido completo está recebendo corretamente todos os itens
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
	
	//Aqui eu realizo um pedido sem lanche e verifico se foi aceito
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
	
	//Este teste espera uma falha ao tentar realizar um pedido sem forma de pagamento informada
	//Testando assim a validação de regra de negócio do Builder de pedido
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
	
	//Neste teste foi usado a classe Mock para montar um pedido fake
	@Test
	public void deveMockarPedido() throws Exception {
		//crio um Xis usando o builder como sempre, passando as variaveis que eu quero
		BuilderHamburguer xisBuilder = XisHamburguer.builder();
		XisHamburguer xis = xisBuilder.hamburguerDe(Hamburguer.CARNE)
				.comMaionese(true)
				.comOvo(true)
				.comPresunto(true)
				.comQueijo(true)
				.build();
		
		//Mocko a classe pedido e digo os retornos que ele deve ter caso tais funções sejam chamadas
		Pedido pedido = Mockito.mock(Pedido.class);
		when(pedido.getBebida()).thenReturn("Budweiser");
		when(pedido.getPagamento()).thenReturn("VR");
		when(pedido.getLanche()).thenReturn(xis.getName());
	
		//as opções de bebida e pagamento não constam no Enum mas são aceitas pois foram mockadas
		assertEquals("Budweiser", pedido.getBebida());
		assertEquals("VR", pedido.getPagamento());
		assertEquals("Xis Hamburguer", pedido.getLanche());
		
	}
	
	//Aqui eu tento pedir maionese extra, sem ter um lanche, lançando assim uma exception 
	//pois não se pode pedir maionese extra sem um lanche no pedido.
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
	
	//Aqui eu tento montar um xis sem itens, caindo na regra de negócio do Builder que não permite
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
