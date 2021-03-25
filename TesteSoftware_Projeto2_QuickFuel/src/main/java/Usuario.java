package main.java;


import java.util.Date;

public class Usuario {

	protected String nomecompleto;
	protected String cpf;
	protected String email;
	protected Date nasc;
	protected Veiculo veiculo;
	protected String senha;
	protected String telefone;
	protected int ddd;
	protected CartaoCredito cartaocredito;

	public Usuario(
			String nomecompleto,
			String cpf, 
			String email, 
			int ddd, 
			String telefone, 
			String senha) {
		this.nomecompleto = nomecompleto;
		this.email = email;
		this.cpf = cpf;
		this.ddd = ddd;
		this.telefone = telefone;
		this.senha =  senha;
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

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public CartaoCredito getCartaocredito() {
		return cartaocredito;
	}

	public void setCartaocredito(CartaoCredito cartaocredito) {
		this.cartaocredito = cartaocredito;
		this.cartaocredito.setDono(this);
	}
	

}
