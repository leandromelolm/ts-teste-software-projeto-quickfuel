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
		CartaoCredito c = new CartaoCredito("VISA","1234123412341234",2025,"04");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertTrue(ret);
	}
	@Test
	public void adicionarCartaoCreditoAno2021Test() {
		CartaoCredito c = new CartaoCredito("VISA","9999000099990000",2021,"05");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
				
		boolean ret = cn.adicionarCartaoCredito(c);

		if(ret == false) {			
			System.out.println(" Resultado do teste adicionarCartaoCreditoAno2021Test foi " + ret + ". A validade do cartão expirou!");			
		}
		assertTrue(ret);
	}
	
	/* Teste Cartao já cadastrado*/
	@Test
	public void adicionarCartaoExistenteTest() {
		CartaoCredito c = new CartaoCredito("VISA","8888999988889999",2025,"02");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	
	/* Teste Cartao número inválido*/
	@Test
	public void adicionarCartaoNumeroInvalido() {
		CartaoCredito c = new CartaoCredito("MASTERCARD","123412341",2025,"09");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	
	/* Teste Cartao número inválido*/
	@Test
	public void adicionarCartaoCreditoComLetra() {
		CartaoCredito c = new CartaoCredito("MASTERCARD","8888222244446WX6",2025,"12");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	
	/* Teste Cartao Bandeira inválido*/
	@Test
	public void adicionarCartaoBandeiraInválida() {
		CartaoCredito c = new CartaoCredito("TICKET","3333333333333333",2025,"08");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	/* Teste Cartao Expirado*/
	@Test
	public void adicionarCartaoExpirado() {
		CartaoCredito c = new CartaoCredito("VISA","1234123412341239",2021,"02");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
//		System.out.println(ret);
	}
	/* Teste Cartao Número Nulo*/
	@Test
	public void adicionarCartaoNumeroNulo() {
		CartaoCredito c = new CartaoCredito("VISA",null,2025,"01");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
		
	/* Teste deletar cartão de credito*/		
	@Test		
	public void deletarCartaoCreditoTest() {
		CartaoCredito c = new CartaoCredito("VISA","5555666677778888",2025,"01");
		CartaoCreditoRepositorio cartRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cartRepo);
		
			boolean ret = cn.adicionarCartaoCredito(c);
			if (ret) {
				ret = cn.deletarCartaoCredito("5555666677778888");
			}
			assertTrue(ret);
//			System.out.println("Teste DeletarCartaoCredito(): Numero Cartão:" + c.getNumero());
	}
	
}
