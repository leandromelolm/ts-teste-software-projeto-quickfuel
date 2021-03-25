package main.java;

import java.util.ArrayList;
import java.util.List;

public class CartaoCreditoRepositorio {
	
	private List<CartaoCredito> credcartoes;
	
	public CartaoCreditoRepositorio() {
		this.credcartoes = new ArrayList<CartaoCredito>();
	}

	public boolean addCartaoCredito(CartaoCredito c) {
		try {
			this.credcartoes.add(c);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	public CartaoCredito buscarPorNumero(String numero) {
		CartaoCredito c = null;
		for (CartaoCredito cred : this.credcartoes) {
			if (cred.getNumero().equals(numero)) {
				c = cred;
			}
		}
		return c;
	}


	public boolean delCartaoCredito(String numero) {
		CartaoCredito c = this.buscarPorNumero(numero);
			
		try {
			this.credcartoes.remove(c);
		} catch (Exception ex) {
			return false;
		}			
		return true;
	}
}
