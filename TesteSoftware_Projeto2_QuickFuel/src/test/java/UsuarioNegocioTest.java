package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.Usuario;
import main.java.UsuarioNegocio;
import main.java.UsuarioRepositorio;

public class UsuarioNegocioTest {

	@Test
	public void adicionarUsuarioTest() {

		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,999999999);
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		boolean ret = un.adicionarUsuario(u);
		assertTrue(ret);
	}

	@Test
	public void adicionarUsuarioExistenteTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,999999999);
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		un.adicionarUsuario(u);
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	@Test
	public void adicionarUsuarioEmailNuloTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", null, 80 ,999999999);
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	@Test
	public void adicionarUsuarioCPFINuloTest() {
		Usuario u = new Usuario("Usuario Teste", null, "testequickfuel2@gmail.com", 80 ,999999999);
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}


}
