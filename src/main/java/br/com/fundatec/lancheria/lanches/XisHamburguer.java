package br.com.fundatec.lancheria.lanches;

import br.com.fundatec.lancheria.factory.Xis;

public class XisHamburguer extends Xis {
	
	private Hamburguer hamburguer;
	private boolean ovo;
	private boolean maionese;
	private boolean presunto;
	private boolean queijo;
	
	public XisHamburguer() {
		
	}
	
	public static Builder builder() {
		return new XisHamburguer().new Builder();
	}
	
	public class Builder {
		XisHamburguer xis;
		
		public Builder() {
			this.xis = new XisHamburguer();
		}
		
		public Builder bifeDe(Hamburguer hamburguer) {
			xis.hamburguer = hamburguer;
			return this;
		}
		
		public Builder comOvo(boolean ovo) {
			xis.ovo = ovo;
			return this;
		}
		
		public Builder comMaionese(boolean maionese) {
			xis.maionese = maionese;
			return this;
		}
		
		public Builder comPresunto(boolean presunto) {
			xis.presunto = presunto;
			return this;
		}
		
		public Builder comQueijo(boolean queijo) {
			xis.queijo = queijo;
			return this;
		}
		
		public XisHamburguer build() {
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
	public void entregar() {
		System.out.println("Colocando seu xis em um saquinho");
		System.out.println("Xis Hamburguer à caminho");
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
