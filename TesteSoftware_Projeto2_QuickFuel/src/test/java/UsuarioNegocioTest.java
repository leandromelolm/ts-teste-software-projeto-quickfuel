package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.Usuario;
import main.java.UsuarioNegocio;
import main.java.UsuarioRepositorio;

public class UsuarioNegocioTest {
	
	/* Teste de cadastro de usuário*/
	@Test
	public void adicionarUsuarioTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,"999999999");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertTrue(ret);
	}
	
	/* Teste de usuário já cadastrado*/
	@Test
	public void adicionarUsuarioExistenteTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,"999999999");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		un.adicionarUsuario(u);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de Email Nulo*/
	@Test
	public void adicionarUsuarioEmailNuloTest() {
		Usuario u = new Usuario("Usuario Teste", "11111111111", null, 80 ,"999999999");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de CPF nulo*/
	@Test
	public void adicionarUsuarioCPFINuloTest() {
		Usuario u = new Usuario("Usuario Teste", null, "testequickfuel2@gmail.com", 80 ,"999999999");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de CPF com quantidade de números inválidos*/
	@Test
	public void adicionarUsuarioCPFInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste", "123456", "testequickfuel2@gmail.com", 80 ,"999999999");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de telefone nulo*/
	@Test
	public void adicionarUsuarioTelefoneNuloTest() {
		Usuario u = new Usuario("Usuario Teste", "22222222222", "testequickfuel2@gmail.com", 80 , null);
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de telefone com 8 números*/
	@Test
	public void adicionarUsuarioTelefoneFormatoInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste", "33333333333", "testequickfuel2@gmail.com", 80 ,"87654321");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de DDD com 3 números*/
	@Test
	public void adicionarUsuarioDDDFormatoInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste", "33333333333", "testequickfuel2@gmail.com", 801 ,"987654321");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

}
