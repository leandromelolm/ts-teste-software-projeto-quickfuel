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

		if (u.getNomeCompleto() != null && 
				u.getEmail() != null  && 
				u.getCpf() != null &&
				u.getCpf().length() == 11 &&
				u.getDdd() > 10  &&
				u.getDdd() < 100 &&
				d.length() == 2 &&
				u.getTelefone() != null &&
				u.getTelefone().length() == 9 &&
				this.userRepo.buscarPorCPF(u.getCpf()) == null) {
			adicionado = this.userRepo.addUsuario(u);
		}
		return adicionado;
	}

	public List<Usuario> relatorioUsuariosDados() {
		return this.userRepo.buscarTodos();
	}

	public boolean deletarUsuario(String cpf) {
		return false;
	}

	public boolean atualizarUsuario(Usuario u) {
		return false;
	}

	public List<Usuario> relatorioUsuariosPorNomeParcial(String nomeParcial) {
		return null;
	}
}
