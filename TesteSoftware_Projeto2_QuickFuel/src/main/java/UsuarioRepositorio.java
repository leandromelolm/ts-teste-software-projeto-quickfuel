package main.java;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {

	private List<Usuario> usuarios;

	public UsuarioRepositorio() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public boolean addUsuario(Usuario u) {
		try {
			this.usuarios.add(u);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public Usuario buscarPorCPF(String cpf) {
		Usuario u = null;
		for (Usuario user : this.usuarios) {
			if (user.getCpf().equals(cpf)) {
				u = user;
			}
		}
		return u;
	}

	public List<Usuario> buscarTodos() {
		return this.usuarios;
	}

	public boolean delUsuario(String cpf) {
		Usuario u = this.buscarPorCPF(cpf);
		
		try {
			this.usuarios.remove(u);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}	
}
