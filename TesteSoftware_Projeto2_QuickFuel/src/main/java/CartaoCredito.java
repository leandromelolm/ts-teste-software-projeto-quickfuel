package main.java;

public class CartaoCredito {
	
	private Usuario nome;
	private String bandeira;
	private String numero;
	private int dataExpiracaoAno;
	private String dataExpiracaoMes;
		
	public CartaoCredito(
			String bandeira, 
			String numero, 
			int dataExpiracaoAno,
			String dataExpiracaoMes) {
		this.bandeira = bandeira;
		this.numero = numero;
		this.dataExpiracaoAno = dataExpiracaoAno;
		this.dataExpiracaoMes = dataExpiracaoMes;
	}
	
	public CartaoCredito(String numero, String bandeira) {
		this.numero = numero;
		this.bandeira = bandeira;
	}
	

	public Usuario getNome() {
		return nome;
	}
	
	public void setNome(Usuario nome) {
		this.nome = nome;
	}
	
	public String getBandeira() {
		return bandeira;
	}
	
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public int getDataExpiracaoAno() {
		return dataExpiracaoAno;
	}
	
	public void setDataExpiracaoAno(int dataExpiracaoAno) {
		this.dataExpiracaoAno = dataExpiracaoAno;
	}

	public String getDataExpiracaoMes() {
		return dataExpiracaoMes;
	}

	public void setDataExpiracaoMes(String dataExpiracaoMes) {
		this.dataExpiracaoMes = dataExpiracaoMes;
	}
	

}
