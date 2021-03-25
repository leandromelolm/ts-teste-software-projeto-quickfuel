package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import main.java.CartaoCredito;
import main.java.CartaoCreditoNegocio;
import main.java.CartaoCreditoRepositorio;
import main.java.Usuario;
import main.java.UsuarioNegocio;
import main.java.UsuarioRepositorio;

public class CartaoCreditoNegocioTest {
	
	/* Teste Cadastro Cartao Credito*/
	@Test
	public void adicionarCartaoCreditoTest() {
		CartaoCredito c = new CartaoCredito("VISA","1234123412341234",2025,9);
		CartaoCreditoRepositorio cardRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cardRepo);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertTrue(ret);
	}
	
	/* Teste Cartao já cadastrado*/
	@Test
	public void adicionarCartaoExistenteTest() {
		CartaoCredito c = new CartaoCredito("VISA","1234123412341234",2025,9);
		CartaoCreditoRepositorio cardRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cardRepo);
		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	
	/* Teste Cartao número inválido*/
	@Test
	public void adicionarCartaoNumeroInvalido() {
		CartaoCredito c = new CartaoCredito("MASTERCARD","123412341",2025,9);
		CartaoCreditoRepositorio cardRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cardRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	/* Teste Cartao Bandeira inválido*/
	@Test
	public void adicionarCartaoBandeiraInválida() {
		CartaoCredito c = new CartaoCredito("Ticket","3333333333333333",2024,3);
		CartaoCreditoRepositorio cardRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cardRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
	/* Teste Cartao Ano inválido*/
	@Test
	public void adicionarCartaoAnoInválida() {
		CartaoCredito c = new CartaoCredito("VISA","1234123412341239",2019,9);
		CartaoCreditoRepositorio cardRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cardRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
//		System.out.println(ret);
	}
	@Test
	public void adicionarCartaoNumeroNulo() {
		CartaoCredito c = new CartaoCredito("VISA",null,2023,1);
		CartaoCreditoRepositorio cardRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cardRepo);
//		cn.adicionarCartaoCredito(c);
		
		boolean ret = cn.adicionarCartaoCredito(c);
		assertFalse(ret);
	}
		
		/* Teste deletar cartão de credito*/
		@Test
		public void deletarCartaoCreditoioTest() {
		CartaoCredito c = new CartaoCredito("VISA","5555555555555555",2022,1);
		CartaoCreditoRepositorio cardRepo = new CartaoCreditoRepositorio();
		CartaoCreditoNegocio cn = new CartaoCreditoNegocio(cardRepo);
			boolean ret = cn.adicionarCartaoCredito(c);
			if (ret) {
				ret = cn.deletarCartaoCredito("5555555555555555a");
			}
			assertTrue(ret);
			verify(cardRepo, times(1)).addCartaoCredito(c);
	}
	
}
