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
			System.out.println("Usuário  adcionado : " + user.nomecompleto);
			if (user.getCpf().equals(cpf)) {
				u = user;
			}
		}
		return u;
	}

	public List<Usuario> buscarTodos() {
		return this.usuarios;
	}
	
//	public boolean updateUsuario(Usuario usur) {
//		boolean ret = false;
//		for (Usuario aux: this.usuarios) {
//			if (aux.getCpf() == usur.getCpf()) {
//				aux.setNomecompleto(usur.getNomecompleto());
//				aux.setTelefone(usur.getTelefone());
//				return ret;
//			}
//		}
//		return true;
//	}
	
	
//	public boolean updateUsuario(String cpf) {
//		boolean ret = false;
//		Usuario u = this.buscarPorCPF(cpf);
//		if (u != null) {
//			this.usuarios.indexOf(u);
//			this.usuarios.remove(u);
//		}
//		return ret;
//	}


		public boolean atualizarUsuario(String cpf) {
			
			Usuario u = this.buscarPorCPF(cpf);
			
				if (u.getCpf().equals(cpf)) {
//					usuarios.remove(usuario1);
//					usuarios.add(usuario1);
					String cpf2 = u.getCpf();
					int cpfInt = Integer.parseInt(cpf2);
					usuarios.get(cpfInt).setCpf(cpf2);
					usuarios.get(cpfInt).setNomecompleto(cpf2);

				}
						return true;
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
