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
			&&	u.getTelefone().matches("[0-9]+")// Regex "[0-9]+" verifica se contém apenas números.
			&& 	u.getTelefone().contains("-") == false
			&&	this.userRepo.buscarPorCPF(u.getCpf()) == null) {
			if (	u.getSenha().contains("@") 
				 || u.getSenha().contains("#")
				 || u.getSenha().contains("$")
				 || u.getSenha().contains("&")
				 || u.getSenha().contains("*")
				 || u.getSenha().contains("?")
				 || u.getSenha().contains("!") == true){
			adicionado = this.userRepo.addUsuario(u);
			}
		}
		return adicionado;
	}

	public List<Usuario> relatorioUsuariosDados() {
		return this.userRepo.buscarTodos();
	}

	public boolean deletarUsuario(String cpf) {
		boolean ret = false;
		if(cpf != null) {
			ret = this.userRepo.delUsuario(cpf);
		}
		return ret;	
	}
	
	public boolean atualizarUsuario(Usuario u) {
		return false;
	}

	public List<Usuario> relatorioUsuariosPorNomeParcial(String nomeParcial) {
		return null;
	}
}
