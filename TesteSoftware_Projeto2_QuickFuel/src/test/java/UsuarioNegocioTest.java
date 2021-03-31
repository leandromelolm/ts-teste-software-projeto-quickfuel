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
		
		Usuario u = new Usuario("Usuario Teste 1", "12345678901", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!4321@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		boolean ret = un.adicionarUsuario(u);
		
		assertTrue(ret);
	}
	
	/* Teste de usuário já cadastrado*/
	@Test
	public void adicionarUsuarioExistenteTest() {
		Usuario u = new Usuario("Usuario Teste 2", "12345678901", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@");
		Usuario u2 = new Usuario("Usuario Teste 2.1", "12345678901", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@"); // CPF igual ao usuario teste 2
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		un.adicionarUsuario(u); 
		
		boolean ret = un.adicionarUsuario(u2); // tentando adcionar usuario existente
		assertFalse(ret);
	}
	
	/* Teste de Email Nulo*/
	@Test
	public void adicionarUsuarioEmailNuloTest() {
		Usuario u = new Usuario("Usuario Teste 3", "11111111111", null, 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de CPF nulo*/
	@Test
	public void adicionarUsuarioCPFINuloTest() {
		Usuario u = new Usuario("Usuario Teste 4", null, "testequickfuel2@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de CPF com quantidade de números inválidos*/
	@Test
	public void adicionarUsuarioCPFInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste 5", "123456", "testequickfuel2@gmail.com", 80 ,"999999999", "Senha!1234@"); // CPF com caracteres < 11
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de telefone nulo*/
	@Test 
	public void adicionarUsuarioTelefoneNuloTest() {
		Usuario u = new Usuario("Usuario Teste 6", "22222222222", "testequickfuel2@gmail.com", 80 , null, "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de telefone com 8 números*/
	@Test
	public void adicionarUsuarioTelefoneFormatoInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste 7", "33333333333", "testequickfuel2@gmail.com", 80 ,"87654321", "Senha!1234@"); // Telefone exige 9 números
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	/* Teste de telefone com  "-" números*/
	@Test 
	public void adicionarUsuarioTelefoneFormatoInvalido2Test() {
		Usuario u = new Usuario("Usuario Teste 8", "33333333333", "testequickfuel2@gmail.com", 80 ,"8765-4321", "Senha!1234@"); // Telefone só aceita números
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de DDD com 3 números*/
	@Test
	public void adicionarUsuarioDDDFormatoInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste 9", "44444444444", "testequickfuel2@gmail.com", 801 ,"987654321", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de Email sem @ que é obrigatório*/	
	@Test
	public void adicionarUsuarioEmailInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste 10", "55555555555", "testequickfuel2.gmail.com", 80 ,"987654321", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de telefone com  Letras*/
	@Test 
	public void adicionarUsuarioTelefoneComLetras() {
		Usuario u = new Usuario("Usuario Teste 11", "66666666666", "testequickfuel2@.gmail.com", 80 ,"BT7654321", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de Senha Fraca*/
	@Test 
	public void adicionarUsuarioSenhaFraca() {
		Usuario u = new Usuario("Usuario Teste 12", "77777777777", "testequickfuel2@.gmail.com", 80 ,"987654321", "12345678");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste deletar usuário*/
	@Test
	public void deletarUsuarioTest() {
		Usuario u = new Usuario("Usuario Teste 13 DeletarUsuario", "12345678900", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);		
		
		boolean ret = un.adicionarUsuario(u);
//		System.out.println("Teste *deletarUsuarioTest()*");
//		System.out.println("CPF: " + u.getCpf() + " Nome: " + u.getNomecompleto());
		if (ret) {
			ret = un.deletarUsuario("12345678900");
//			System.out.println("Usuário Deletado com Sucesso!");
		}
//		System.out.println("Resultado do Teste:" + ret + "\n");
		assertTrue(ret);
	}
	
	/* Teste deletar usuário cpf nulo*/
	@Test
	public void deletarUsuarioNuloTest() {
		Usuario u = new Usuario("Usuario Teste 14 DeletarUsuario passando cpf null", "12345678900", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);	
		
		boolean ret = un.adicionarUsuario(u);
//		System.out.println("Teste *deletarUsuarioNuloTest()*");
//		System.out.println("CPF: " + u.getCpf() + " Nome: " + u.getNomecompleto());
		if (ret) {
			ret = un.deletarUsuario(null);
//			System.out.println("Usuário Não deletado");
		}
//		System.out.println("Resultado do Teste:" + ret + "\n");

		assertFalse(ret);
	}
	
	@Test
	public void editarUsuarioTest() {
		Usuario u = new Usuario("Usuario Teste 15 EditarUsuario", "12345678900", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);	
		
		System.out.println("\n---Teste EditarUsuario---\n");
		System.out.println("*Usuário Adicionado*");
		System.out.println("CPF: " + u.getCpf() + "\n"
				+ "Nome: " + u.getNomecompleto() + "\n" 
				+ "Email: " + u.getEmail() + "\n"
				+ "Telefone: " + u.getTelefone() + "\n");
		if (ret) {
			ret = un.alterarUsuario("Usuario Teste Quinze Editado", "12345678900", "emailNovo@gmail.com", 80 ,"991919191", "Senha!1234@");
			System.out.println("\n*Usuário Editado*");
			System.out.println("CPF: " + u.getCpf() + "\n"
					+ "Nome: " + u.getNomecompleto() + "\n" 
					+ "Email: " + u.getEmail() + "\n"
					+ "Telefone: " + u.getTelefone() + "\n");
		}
		System.out.println("Resultado do Teste:" + ret + "\n");
		assertTrue(ret);
	}
	
}
