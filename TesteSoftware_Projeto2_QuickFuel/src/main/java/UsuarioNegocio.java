package main.java;

import java.util.List;

public class UsuarioNegocio {
//	Usuario usuario = null;
	private UsuarioRepositorio userRepo;

	public UsuarioNegocio(UsuarioRepositorio usRepo) {
		this.userRepo = usRepo;
	}

	public boolean adicionarUsuario(Usuario u) {
		boolean adicionado = false;

		if (u.getNomeCompleto() != null && 
				u.getEmail() != null  && 
				u.getCpf() != null &&
//				u.getCpf().length() >= 11 &&
//				u.getCpf().length() <= 11 &&
//				u.getDdd() >= 0 &&
//				u.getTelefone().equals(null) != true &&

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
