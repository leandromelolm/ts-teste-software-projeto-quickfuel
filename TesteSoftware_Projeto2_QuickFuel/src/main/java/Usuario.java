package main.java;

import java.util.Date;
import java.util.List;

public class Usuario {

	private String nomecompleto;
	private String cpf;
	private String email;
	private Date nasc;
	private List<placaveiculo> placaveiculos;
	private String senha;
	private String telefone;
	private int ddd;

	public Usuario(String nomecompleto, String cpf, String email, int ddd, String telefone) {
		this.nomecompleto = nomecompleto;
		this.email = email;
		this.cpf = cpf;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public String getNomeCompleto() {
		return nomecompleto;
	}

	public void setNomeCompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public List<placaveiculo> getPlacaveiculos() {
		return placaveiculos;
	}

	public void setPlacaveiculos(List<placaveiculo> placaveiculos) {
		this.placaveiculos = placaveiculos;
	}

}
