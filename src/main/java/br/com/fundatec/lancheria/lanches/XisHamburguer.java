package br.com.fundatec.lancheria.lanches;

import br.com.fundatec.lancheria.factory.Xis;

public class XisHamburguer extends Xis {
	
	public XisHamburguer() {
		
	}
	
	//Builder do hamburguer segue o mesmo princípio do XisBacon
	public static BuilderHamburguer builder() {
		return new XisHamburguer().new BuilderHamburguer();
	}
	
	public class BuilderHamburguer {
		XisHamburguer xis;
		
		public BuilderHamburguer() {
			this.xis = new XisHamburguer();
		}
		
		public BuilderHamburguer hamburguerDe(Hamburguer hamburguer) {
			xis.hamburguer = hamburguer;
			return this;
		}
		
		public BuilderHamburguer comOvo(boolean ovo) {
			xis.ovo = ovo;
			return this;
		}
		
		public BuilderHamburguer comMaionese(boolean maionese) {
			xis.maionese = maionese;
			return this;
		}
		
		public BuilderHamburguer comPresunto(boolean presunto) {
			xis.presunto = presunto;
			return this;
		}
		
		public BuilderHamburguer comQueijo(boolean queijo) {
			xis.queijo = queijo;
			return this;
		}
		
		//Valida se não foi pedido um Xis vazio, ou seja, só o pão sem itens
		public XisHamburguer build() throws Exception {
			if(xis.hamburguer == null && xis.ovo == false && xis.maionese == false && xis.presunto == false && xis.queijo == false) {
				throw new Exception("Xis deve conter algum item");
			}
			return xis;
		}
	}
	
	
	//Os métodos abaixo seguem a mesma lógica do XisBacon, apenas foram implementados de maneira correspondente ao Xis Hamburguer
	//As validações são as mesmas, os retornos, ou seja, os Sysouts no caso dessa aplicação, são referentes ao tipo de Xis.
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
	}

	@Override
	public String getName() {
		return "Xis Hamburguer";
	}

	public String getHamburguer() {
		if(hamburguer == null) {
			return "null";
		}
		return hamburguer.getTitulo();
	}

	public void setHamburguer(Hamburguer hamburguer) {
		this.hamburguer = hamburguer;
	}

	public boolean temOvo() {
		return ovo;
	}

	public void setOvo(boolean ovo) {
		this.ovo = ovo;
	}

	public boolean temMaionese() {
		return maionese;
	}

	public void setMaionese(boolean maionese) {
		this.maionese = maionese;
	}

	public boolean temPresunto() {
		return presunto;
	}

	public void setPresunto(boolean presunto) {
		this.presunto = presunto;
	}

	public boolean temQueijo() {
		return queijo;
	}

	public void setQueijo(boolean queijo) {
		this.queijo = queijo;
	}
	
}
