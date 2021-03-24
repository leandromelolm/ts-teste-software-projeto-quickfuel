package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.Usuario;
import main.java.UsuarioNegocio;
import main.java.UsuarioRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioNegocioMockTest {

	@Mock
	private UsuarioRepositorio userRepo;

	@Test
	public void adicionarUsuarioTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,999999999);
		when(userRepo.buscarPorCPF("12345678901")).thenReturn(null);
		when(userRepo.addUsuario(u)).thenReturn(true);

		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		boolean ret = un.adicionarUsuario(u);
		assertTrue(ret);
	}

	@Test
	public void adicionarUsuarioExistenteTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,999999999);
		when(userRepo.buscarPorCPF("12345678901")).thenReturn(u);

		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	@Test
	public void adicionarUsuarioVerifyTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,999999999);
		when(userRepo.buscarPorCPF("12345678901")).thenReturn(null);
		when(userRepo.addUsuario(u)).thenReturn(true);

		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		boolean ret = un.adicionarUsuario(u);
		assertTrue(ret);
		verify(userRepo, times(1)).addUsuario(u);
	}

	@Test
	public void adicionarUsuarioExistenteVerifyTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,999999999);
		when(userRepo.buscarPorCPF("12345678901")).thenReturn(u);

		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
		verify(userRepo, times(0)).addUsuario(u);
	}
}
