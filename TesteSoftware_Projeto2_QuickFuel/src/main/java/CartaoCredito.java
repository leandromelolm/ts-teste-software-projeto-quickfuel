package main.java;

public class CartaoCredito {
	
	private Usuario dono;
	private String bandeira;
	private String numero;
	private int dataExpiracaoAno;
	private int dataExpiracaoMes;
		
	public CartaoCredito(
			String bandeira, 
			String numero, 
			int dataExpiracaoAno,
			int dataExpiracaoMes) {
		this.bandeira = bandeira;
		this.numero = numero;
		this.dataExpiracaoAno = dataExpiracaoAno;
		this.dataExpiracaoMes = dataExpiracaoMes;
	}
	

	public Usuario getDono() {
		return dono;
	}
	
	public void setDono(Usuario dono) {
		this.dono = dono;
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

	public int getDataExpiracaoMes() {
		return dataExpiracaoMes;
	}

	public void setDataExpiracaoMes(int dataExpiracaoMes) {
		this.dataExpiracaoMes = dataExpiracaoMes;
	}
	

}
