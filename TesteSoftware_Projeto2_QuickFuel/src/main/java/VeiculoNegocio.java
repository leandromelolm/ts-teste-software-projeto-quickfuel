package main.java;

import java.util.List;

public class VeiculoNegocio {
	private VeiculoRepositorio autoRepo;

	public VeiculoNegocio(VeiculoRepositorio auRepo) {
		this.autoRepo = auRepo;
	}

	public boolean adicionarVeiculo(Veiculo v) {
		boolean adicionado = false;

		if (
				   v.getPlacaveiculo().length() == 7
				&& v.getEstado().length() == 2
				&& v.getCor() != null
				&& v.getMarca() != null
				&& v.getVersao() != null
				&& v.getCidade() !=null
				&& v.getModelo() != null
				&& v.getAnomodelo().length() == 4
				&& v.getAnofabricacao() > 1950
				&& v.getAnofabricacao() <= 2021 
				&& this.autoRepo.buscarPorPlaca(v.getPlacaveiculo()) == null){
			if(
			   v.getEstado().contains("AC")
			|| v.getEstado().contains("AP")
			|| v.getEstado().contains("AM")
			|| v.getEstado().contains("BA")
			|| v.getEstado().contains("CE")
			|| v.getEstado().contains("DF")
			|| v.getEstado().contains("ES")
			|| v.getEstado().contains("GO")
			|| v.getEstado().contains("MA")
			|| v.getEstado().contains("MT")
			|| v.getEstado().contains("MS")
			|| v.getEstado().contains("MG")
			|| v.getEstado().contains("PA")
			|| v.getEstado().contains("PE")
			|| v.getEstado().contains("PB")
			|| v.getEstado().contains("PR")
			|| v.getEstado().contains("PE")
			|| v.getEstado().contains("PI")
			|| v.getEstado().contains("RN")
			|| v.getEstado().contains("RS")
			|| v.getEstado().contains("RJ")
			|| v.getEstado().contains("RO")
			|| v.getEstado().contains("RR")
			|| v.getEstado().contains("SC")
			|| v.getEstado().contains("SP")
			|| v.getEstado().contains("SE")
			|| v.getEstado().contains("TO") == true){
				adicionado = this.autoRepo.addUVeiculo(v);
			}	
		}
		return adicionado;
	}

	public List<Veiculo> relatorioVeiculosDados() {
		return this.autoRepo.buscarTodos();
	}

	public boolean deletarVeiculo(String placaveiculo) {
		boolean ret = false;
		if(placaveiculo != null) {
			ret = this.autoRepo.delVeiculo(placaveiculo);
		}
		return ret;	
	}


	public boolean atualizarVeiculo(Veiculo v) {
		return false;
	}
}

