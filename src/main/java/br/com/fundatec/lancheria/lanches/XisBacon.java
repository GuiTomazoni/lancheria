package br.com.fundatec.lancheria.lanches;

import br.com.fundatec.lancheria.factory.Xis;

public class XisBacon extends Xis{
	
	public XisBacon() {
		
	}
	
	public static BuilderBacon builder() {
		return new XisBacon().new BuilderBacon();
	}
	
	public class BuilderBacon {
		XisBacon xis;
		
		public BuilderBacon() {
			this.xis = new XisBacon();
		}
		
		public BuilderBacon hamburguerDe(Hamburguer hamburguer) {
			xis.hamburguer = hamburguer;
			return this;
		}
		
		public BuilderBacon comOvo(boolean ovo) {
			xis.ovo = ovo;
			return this;
		}
		
		public BuilderBacon comMaionese(boolean maionese) {
			xis.maionese = maionese;
			return this;
		}
		
		public BuilderBacon comPresunto(boolean presunto) {
			xis.presunto = presunto;
			return this;
		}
		
		public BuilderBacon comQueijo(boolean queijo) {
			xis.queijo = queijo;
			return this;
		}
		
		public XisBacon build() throws Exception {
			if(xis.hamburguer == null && xis.ovo == false && xis.maionese == false && xis.presunto == false && xis.queijo == false) {
				throw new Exception("Xis deve conter algum item");
			}
			return xis;
		}
	}

	@Override
	public void preparar() {
		if(hamburguer != null) {
			if(hamburguer == Hamburguer.CARNE) {
				System.out.println("Colocando seu hamburguer de carne na chapa");
			} else if(hamburguer == Hamburguer.FRANGO) {
				System.out.println("Colocando seu hamburguer de frango na chapa");
			}
		}
		if(ovo) {
			System.out.println("Ovo sendo frito");
		}
		System.out.println("Colocando o bacon na chapa");
	}

	@Override
	public void montar() {
		System.out.println("Cortando seu pão");
		if(hamburguer != null) {
			System.out.println("Colocando a carne no pão");
		}
		if(ovo) {
			System.out.println("Ovo adicionado");
		}
		if(presunto) {
			System.out.println("Presunto vindo por cima");
		}
		if(queijo) {
			System.out.println("queijo sendo colocado agora");
		}
		if(maionese) {
			System.out.println("Adicionando maionese");
		}
		System.out.println("Bacon sendo colocado por cima");
	}

	@Override
	public String getName() {
		return "Xis Bacon";
	}

}
