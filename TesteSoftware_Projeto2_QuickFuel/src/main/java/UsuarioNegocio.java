package main.java;

import java.util.List;

public class UsuarioNegocio {

	private UsuarioRepositorio userRepo;

	public UsuarioNegocio(UsuarioRepositorio usRepo) {
		this.userRepo = usRepo;
	}

	public boolean adicionarUsuario(Usuario u) {
		boolean adicionado = false;
	
		int numeroddd = u.getDdd();
		String d = Integer.toString(numeroddd);

		if (	u.getNomeCompleto() != null 
			&&	u.getEmail() != null  
			&&	u.getEmail().contains("@")
			&&	u.getCpf() != null 
			&&	u.getCpf().length() == 11 
			&&	d.length() == 2
			&& 	u.getTelefone() != null
			&&	u.getTelefone().length() == 9
			/* 
			 * getTelefone().matches("[0-9]+") contém um regex que verifica se a String passada contém apenas números. */
			&&	u.getTelefone().matches("[0-9]+")
			/* 
			 * getSenha().matches("(?=.*\\p{Digit})(?=.*\\p{Upper})(?=.*\\p{Lower})(?=.*\\p{Punct}).{8,12}") 
			 * contém  um regex que verifica se a String senha passada contem, pelo menos: 
			 * 1 Numero, 1 caractere de pontuação, 1 letra minúscula e 1 maiúscula */
			&& 	u.getSenha().matches("(?=.*\\p{Digit})(?=.*\\p{Upper})(?=.*\\p{Lower})(?=.*\\p{Punct}).{8,12}") 
			&& 	u.getTelefone().contains("-") == false
			&&	this.userRepo.buscarPorCPF(u.getCpf()) == null){	
			adicionado = this.userRepo.addUsuario(u);
		}
		return adicionado;
	}

	public boolean deletarUsuario(String cpf) {
		boolean ret = false;
		if(cpf != null) {
			ret = this.userRepo.deleteUsuario(cpf);
		}
		return ret;	
	}
	
	public boolean alterarUsuario(String nomecompleto, String cpf, String email, int ddd, String telefone, String senha) {
		boolean ret = false;
		
		int numeroddd = ddd;
		String d = Integer.toString(numeroddd);
		
		if (	cpf != null 
				&&	email != null  
				&&	email.contains("@")
				&&	cpf != null 
				&&	cpf.length() == 11 
				&&	d.length() == 2
				&& 	telefone != null
				&&	telefone.length() == 9
				/* 
				 * getTelefone().matches("[0-9]+") contém um regex que verifica se a String passada contém apenas números. */
				&&	telefone.matches("[0-9]+")
				/* 
				 * getSenha().matches("(?=.*\\p{Digit})(?=.*\\p{Upper})(?=.*\\p{Lower})(?=.*\\p{Punct}).{8,12}") 
				 * contém  um regex que verifica se a String senha passada contem, pelo menos: 
				 * 1 Numero, 1 caractere de pontuação, 1 letra minúscula e 1 maiúscula */
				&& 	senha.matches("(?=.*\\p{Digit})(?=.*\\p{Upper})(?=.*\\p{Lower})(?=.*\\p{Punct}).{8,12}") 
				&& 	telefone.contains("-") == false
				&&	this.userRepo.buscarPorCPF(cpf) != null) {
			ret = this.userRepo.AlteraDadosUsuario(nomecompleto, cpf, email, ddd, telefone, senha);
		}
		return ret;
	}
	
	public List<Usuario> relatorioUsuariosDados() {
		return this.userRepo.buscarTodos();
	}

	public List<Usuario> relatorioUsuariosPorNomeParcial(String nomeParcial) {
		return null;
	}
}
