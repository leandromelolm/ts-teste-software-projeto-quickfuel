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
//			System.out.println("Usuário  adicionado : " + u.getNomecompleto() + "  " + u.getEmail() + "  " + u.hashCode());
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public Usuario buscarPorCPF(String cpf) {
		Usuario u = null;
		for (Usuario user : this.usuarios) {	
			System.out.println("Usuario Buscado : " + user.getNomecompleto() + "  " + user.getEmail() + "  " + user.hashCode());
			if (user.getCpf().equals(cpf)) {
				u = user;
			}
		}
		return u;
	}

	public List<Usuario> buscarTodos() {
		return this.usuarios;
	}

	/*
	public boolean atualizarUsuario(String cpf) {
		Usuario u = this.buscarPorCPF(cpf);
		
		try {
			this.usuarios.remove(u);
			this.addUsuario(u);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}		
	*/
	
	
	public boolean AlteraDadosUsuario(String nomecompleto, String cpf, String email, int ddd, String telefone, String senha) {
		
		try {
			for (Usuario u2 : usuarios) {
		         if (u2.getCpf().equals(cpf)) {
		              u2.setNomecompleto(nomecompleto);
		              u2.setEmail(email);
		              u2.setDdd(ddd);
		              u2.setTelefone(telefone);
		              u2.setSenha(senha);
		              
		  			System.out.println("Usuário alterado : " + u2.nomecompleto + "  " + u2.getEmail());
		         }
			}	    
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
		
	public boolean deleteUsuario(String cpf) {
		Usuario u = this.buscarPorCPF(cpf);
		
		try {
			this.usuarios.remove(u);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}	
}
