package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.CartaoCredito;
import main.java.CartaoCreditoNegocio;
import main.java.CartaoCreditoRepositorio;


public class CartaoCreditoNegocioTest {
	
	/* Teste Cadastro Cartao Credito*/
	@Test
	public void adicionarCartaoCreditoTest() {
		CartaoCredito c = new CartaoCredito("VISA","1234123412341234",2025,4);
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertTrue(ret);
	}
	
	/* Teste Cartao já cadastrado*/
	@Test
	public void adicionarCartaoExistenteTest() {
		CartaoCredito c = new CartaoCredito("VISA","1234123412341234",2025,9);
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	
	/* Teste Cartao número inválido*/
	@Test
	public void adicionarCartaoNumeroInvalido() {
		CartaoCredito c = new CartaoCredito("MASTERCARD","123412341",2025,2);
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	
	/* Teste Cartao número inválido*/
	@Test
	public void adicionarCartaoCreditoComLetra() {
		CartaoCredito c = new CartaoCredito("MASTERCARD","8888222244446WX6",2025,2);
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	
	/* Teste Cartao Bandeira inválido*/
	@Test
	public void adicionarCartaoBandeiraInválida() {
		CartaoCredito c = new CartaoCredito("TICKET","3333333333333333",2025,9);
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	/* Teste Cartao Expirado*/
	@Test
	public void adicionarCartaoExpirado() {
		CartaoCredito c = new CartaoCredito("VISA","1234123412341239",2021,2);
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
//		System.out.println(ret);
	}
	@Test
	public void adicionarCartaoNumeroNulo() {
		CartaoCredito c = new CartaoCredito("VISA",null,2025,1);
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
		
		/* Teste deletar cartão de credito*/
		
	@Test
		
	public void deletarCartaoCreditoioTest() {
		CartaoCredito c = new CartaoCredito("VISA","5555555555555555",2025,1);
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
			boolean ret = cn.adicionarCartaoCredito(c);
			if (ret) {
				ret = cn.deletarCartaoCredito("55555");
			}
			assertTrue(ret);
			
	}
	
}
