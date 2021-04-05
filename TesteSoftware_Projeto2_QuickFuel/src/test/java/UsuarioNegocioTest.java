package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.CartaoCredito;
import main.java.Usuario;
import main.java.UsuarioNegocio;
import main.java.UsuarioRepositorio;

public class UsuarioNegocioTest {
	
	@Test // Teste de cadastro de usuário com cartão
	public void adicionarUsuarioComCartaodeCredito() {

		CartaoCredito numerocartao = new CartaoCredito("1111111111111111", "VISA");
		Usuario u = new Usuario("Usuario Teste 18","12345678907","teste1@gmail.com",80 ,"999999999","Senha!4321@",numerocartao);
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);

		boolean ret = un.adicionarUsuario(u);
		assertTrue(ret);
	}
	
	@Test // Teste de cadastro e remoção de usuário com cartão
	public void removerUsuarioComCartaodeCredito() {

		CartaoCredito numerocartao = new CartaoCredito("1111111111111111", "VISA");
		Usuario u = new Usuario("Usuario Teste 19","55555555555","teste1@gmail.com",80 ,"999999999","Senha!4321@",numerocartao);
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		if (ret) {
			ret = un.deletarUsuario("55555555555");
		}
		assertTrue(ret);
	}
	
	/* Teste de cadastro de usuário*/
	@Test
	public void adicionarUsuarioTest() {
		
		Usuario u = new Usuario("Usuario Teste 01", "12345678901", "teste1@gmail.com", 80 ,"999999999", "Senha!4321@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);

		boolean ret = un.adicionarUsuario(u);
		
		assertTrue(ret);
	}
	
	/* Teste de usuário já cadastrado (CPF repetido)*/
	@Test
	public void adicionarUsuarioExistenteTest() {
		Usuario u1 = new Usuario("Usuario Teste 02", "12345678988", "teste2adicionado@gmail.com", 80 ,"999999999", "Senha!1234@");
		Usuario u2 = new Usuario("Usuario Teste 92", "12345678988", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@"); // CPF igual ao usuario teste 2
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		un.adicionarUsuario(u1); 
		
		boolean ret = un.adicionarUsuario(u2); // tentando adcionar usuario existente
		assertFalse(ret);
	}
	
	/* Teste de Email Nulo*/
	@Test
	public void adicionarUsuarioEmailNuloTest() {
		Usuario u = new Usuario("Usuario Teste 03", "11111111111", null, 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de CPF nulo*/
	@Test
	public void adicionarUsuarioCPFINuloTest() {
		Usuario u = new Usuario("Usuario Teste 04", null, "testequickfuel2@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de CPF com quantidade de números inválidos*/
	@Test
	public void adicionarUsuarioCPFInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste 05", "123456", "testequickfuel2@gmail.com", 80 ,"999999999", "Senha!1234@"); // CPF com caracteres < 11
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	
	/* Teste de telefone nulo*/
	@Test 
	public void adicionarUsuarioTelefoneNuloTest() {
		Usuario u = new Usuario("Usuario Teste 06", "22222222222", "testequickfuel2@gmail.com", 80 , null, "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de telefone com 8 números*/
	@Test
	public void adicionarUsuarioTelefoneFormatoInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste 07", "33333333333", "testequickfuel2@gmail.com", 80 ,"87654321", "Senha!1234@"); // Telefone exige 9 números
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}
	/* Teste de telefone com  "-" números*/
	@Test 
	public void adicionarUsuarioTelefoneFormatoInvalido2Test() {
		Usuario u = new Usuario("Usuario Teste 08", "33333333333", "testequickfuel2@gmail.com", 80 ,"8765-4321", "Senha!1234@"); // Telefone só aceita números
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);
		assertFalse(ret);
	}

	/* Teste de DDD com 3 números*/
	@Test
	public void adicionarUsuarioDDDFormatoInvalidoTest() {
		Usuario u = new Usuario("Usuario Teste 09", "44444444444", "testequickfuel2@gmail.com", 801 ,"987654321", "Senha!1234@");
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
		Usuario u = new Usuario("Usuario Teste 13", "12345678900", "testedeletarusuario@gmail.com", 80 ,"999999999", "Senha!1234@");
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
		Usuario u = new Usuario("Usuario Teste 14", "12345678900", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);	
		
		boolean ret = un.adicionarUsuario(u);

		if (ret) {
			ret = un.deletarUsuario(null);
//			System.out.println("Usuário Não deletado");
		}
//		System.out.println("Resultado do Teste:" + ret + "\n");
		assertFalse(ret);
	}
	
	/* Teste alterar dados de usuário cadastrado Resultado = True*/	
	@Test
	public void alterarDadosUsuarioTest() {
		Usuario u = new Usuario("Usuario Teste 15", "81111111199", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);	
		
		System.out.println("\n---Teste AlterarDadosUsuario---\n");
		System.out.println("*Usuário Adicionado*");
		System.out.println(
				  "CPF: " + u.getCpf() + "\n"
				+ "Nome: " + u.getNomecompleto() + "\n" 
				+ "Email: " + u.getEmail() + "\n"
				+ "DDD: " + u.getDdd() + "\n"
				+ "Telefone: " + u.getTelefone() + "\n"
				+ "HashCode: " + u.hashCode() + "\n");
		if (ret) {
			ret = un.alterarUsuario("Usuario Teste Quinze Editado", "81111111199", "emailNovo@gmail.com", 80 ,"991919191", "Senha!1234@");//Alterado Nome, Email e Telefone
//			System.out.println("\n*Usuário Editado*");
//			System.out.println(
//					  "CPF: " + u.getCpf() + "\n"
//					+ "Nome: " + u.getNomecompleto() + "\n" 
//					+ "Email: " + u.getEmail() + "\n"
//					+ "DDD: " + u.getDdd() + "\n"
//					+ "Telefone: " + u.getTelefone() + "\n");
		}
//		System.out.println("Resultado do Teste:" + ret + "\n");
		assertTrue(ret);
	}
	
	/* Teste alterar CPF do usuário cadastrado - Alteração de CPF não é efetuada no repositorio - Resultado = False*/	
	@Test
	public void alterarDadosUsuarioCPFTest() {
		Usuario u = new Usuario("Usuario Teste 16", "11111111111", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);	

		if (ret) {
			ret = un.alterarUsuario("Usuario Teste dezesseis", "11111111100", "emailNovo@gmail.com", 80 ,"991919191", "Senha!1234@"); //CPF e Nome alterados
		}
		assertFalse(ret); // ret = Falso
	}
	
	/* Teste alterar dados do telefone do usuário cadastrado como nulo - Resultado = False*/	
	@Test
	public void alterarDadosUsuarioTelefoneNullTest() {
		Usuario u = new Usuario("Usuario Teste 17", "11111111199", "testequickfuel@gmail.com", 80 ,"999999999", "Senha!1234@");
		UsuarioRepositorio userRepo = new UsuarioRepositorio();
		UsuarioNegocio un = new UsuarioNegocio(userRepo);
		
		boolean ret = un.adicionarUsuario(u);	

		if (ret) {
			ret = un.alterarUsuario("Usuario Teste dezessete", "11111111199", "emailNovo@gmail.com", 80 ,null, "Senha!1234@"); //Telefone nulo
		}
		assertFalse(ret); // ret = Falso
	}
	
}
