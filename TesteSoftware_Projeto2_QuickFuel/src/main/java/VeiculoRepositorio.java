package main.java;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepositorio {
	
	private List<Veiculo> veiculos;

	public VeiculoRepositorio() {
		this.veiculos = new ArrayList<Veiculo>();
	}

	public boolean addUVeiculo(Veiculo v) {
		try {
			this.veiculos.add(v);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public Veiculo buscarPorPlaca(String placaveiculo) {
		Veiculo v = null;
		for (Veiculo auto : this.veiculos) {
			if (auto.getPlacaveiculo().equals(placaveiculo)) {
				v = auto;
			}
		}
		return v;
	}

	public List<Veiculo> buscarTodos() {
		return this.veiculos;
	}

	public boolean delVeiculo(String placaveiculo) {
		Veiculo v = this.buscarPorPlaca(placaveiculo);
		
		try {
			this.veiculos.remove(v);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}

