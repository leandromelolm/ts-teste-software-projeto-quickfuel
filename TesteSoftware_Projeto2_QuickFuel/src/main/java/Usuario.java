package main.java;


import java.util.Date;

public class Usuario {
	private int id;
	protected String nomecompleto;
	protected String cpf;
	protected String email;
	protected Date nasc;
	protected String senha;
	protected String telefone;
	protected int ddd;
	protected CartaoCredito cartaocredito;
	protected Veiculo veiculo;

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

	public Usuario (String nomecompleto,
			String cpf,
			String email, 
			int ddd, 
			String telefone, 
			String senha,
			CartaoCredito cartaocredito) {		
		this.nomecompleto = nomecompleto;
		this.email = email;
		this.cpf = cpf;
		this.ddd = ddd;
		this.telefone = telefone;
		this.senha =  senha;		
		this.cartaocredito = cartaocredito;	
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
		this.cartaocredito.setNome(this);
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}
