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
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,"999999999", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertTrue(ret);
	}
	
	/* Teste de usuário já cadastrado*/
	@Test
	public void adicionarUsuarioExistenteTest() {
		Usuario u = new Usuario("Usuario Teste", "12345678901", "testequickfuel@gmail.com", 80 ,"999999999", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		un.adicionarUsuario(u);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de Email Nulo*/
	@Test
	public void adicionarUsuarioEmailNuloTest() {
		Usuario u = new Usuario("Usuario Teste", "11111111111", null, 80 ,"999999999", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de CPF nulo*/
	@Test
	public void adicionarUsuarioCPFINuloTest() {
		Usuario u = new Usuario("Usuario Teste", null, "testequickfuel2@gmail.com", 80 ,"999999999", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de CPF com quantidade de números inválidos*/
	@Test
	public void adicionarUsuarioCPFInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste", "123456", "testequickfuel2@gmail.com", 80 ,"999999999", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de telefone nulo*/
	@Test 
	public void adicionarUsuarioTelefoneNuloTest() {
		Usuario u = new Usuario("Usuario Teste", "22222222222", "testequickfuel2@gmail.com", 80 , null, "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de telefone com 8 números*/
	@Test
	public void adicionarUsuarioTelefoneFormatoInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste", "33333333333", "testequickfuel2@gmail.com", 80 ,"87654321", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	/* Teste de telefone com  "-" números*/
	@Test 
	public void adicionarUsuarioTelefoneFormatoInvalido2Test() {
		Usuario u = new Usuario("Usuario Teste", "33333333333", "testequickfuel2@gmail.com", 80 ,"8765-4321", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de DDD com 3 números*/
	@Test
	public void adicionarUsuarioDDDFormatoInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste", "44444444444", "testequickfuel2@gmail.com", 801 ,"987654321", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de Email sem @ que é obrigatório*/	
	@Test
	public void adicionarUsuarioEmailInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste", "55555555555", "testequickfuel2.gmail.com", 80 ,"987654321", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de telefone com  Letras*/
	@Test 
	public void adicionarUsuarioTelefoneComLetras() {
		Usuario u = new Usuario("Usuario Teste", "66666666666", "testequickfuel2@.gmail.com", 80 ,"BT7654321", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	/* Teste de Senha Fraca*/
	@Test 
	public void adicionarUsuarioSenhaFraca() {
		Usuario u = new Usuario("Usuario Teste", "77777777777", "testequickfuel2@.gmail.com", 80 ,"987654321", "12345678");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	/* Teste deletar usuário*/
	@Test
	public void deletarUsuarioTest() {
		Usuario u = new Usuario("Fulano Deleterio", "12345678900", "testequickfuel@gmail.com", 80 ,"999999999", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);		
		boolean ret = un.adicionarUsuario(u);
		System.out.println("Teste *deletarUsuarioTest()*");
		System.out.println("CPF: " + u.getCpf() + " Nome: " + u.getNomecompleto());
		if (ret) {
			ret = un.deletarUsuario("12345678900");
			System.out.println("Usuário Deletado com Sucesso!");
		}
		System.out.println("Resultado do Teste:" + ret);
		System.out.println("");
		assertTrue(ret);
	}
	/* Teste deletar usuário cpf nulo*/
	@Test
	public void deletarUsuarioNuloTest() {
		Usuario u = new Usuario("Beltrano Deleterio", "12345678900", "testequickfuel@gmail.com", 80 ,"999999999", "senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);		
		boolean ret = un.adicionarUsuario(u);
		System.out.println("Teste *deletarUsuarioNuloTest()*");
		System.out.println("CPF: " + u.getCpf() + " Nome: " + u.getNomecompleto());
		if (ret) {
			ret = un.deletarUsuario(null);
			System.out.println("Usuário Não deletado");
		}
		System.out.println("Resultado do Teste:" + ret);
		System.out.println("");
		assertFalse(ret);
	}
}
