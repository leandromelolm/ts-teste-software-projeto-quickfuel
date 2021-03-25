package main.java;

public class Veiculo {
	private String placaveiculo;
	private String marca;
	private String modelo;
	private String versao;
	private int anofabricacao;
	private String anomodelo;
	private String cor;
	private String cidade;
	private String estado;
	
	public Veiculo(String placaveiculo,
			String marca, 
			String modelo, 
			String versao, 
			int anofabricacao, 
			String anomodelo, 
			String cor, 
			String cidade, 
			String estado){
		this.placaveiculo = placaveiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.versao = versao;
		this.anofabricacao = anofabricacao;
		this.anomodelo = anomodelo;
		this.cor =  cor;
		this.cidade = cidade;
		this.estado = estado;
		
	}

	public String getPlacaveiculo() {
		return placaveiculo;
	}

	public void setPlacaveiculo(String placaveiculo) {
		this.placaveiculo = placaveiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public int getAnofabricacao() {
		return anofabricacao;
	}

	public void setAnofabricacao(int anofabricacao) {
		this.anofabricacao = anofabricacao;
	}

	public String getAnomodelo() {
		return anomodelo;
	}

	public void setAnomodelo(String anomodelo) {
		this.anomodelo = anomodelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
