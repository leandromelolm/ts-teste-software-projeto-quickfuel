package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.Usuario;
import main.java.UsuarioNegocio;
import main.java.UsuarioRepositorio;
import main.java.Veiculo;
import main.java.VeiculoNegocio;
import main.java.VeiculoRepositorio;

public class VeiculoNegocioTest {
	/* Teste de cadastro de Veiculo*/
	@Test
	public void adicionarVeiculoTest() {
		Veiculo v = new Veiculo("KKK1234", "hyundai", "HB20", "hatch", 2019,"2019", "branco", "Recife", "PE");
		VeiculoRepositorio autoRepo = new VeiculoRepositorio();
		VeiculoNegocio un = new VeiculoNegocio(autoRepo);
		
		boolean ret = un.adicionarVeiculo(v);
		assertTrue(ret);
	}
	
	/* Teste de veiculo já cadastrado*/
	@Test
	public void adicionarVeiculoExistenteTest() {
		Veiculo v = new Veiculo("KKK0002", "hyundai", "HB20", "hatch", 2019,"2019", "branco", "Recife", "PE");
		VeiculoRepositorio autoRepo = new VeiculoRepositorio();
		VeiculoNegocio un = new VeiculoNegocio(autoRepo);
		un.adicionarVeiculo(v);
		
		boolean ret = un.adicionarVeiculo(v);
		assertFalse(ret);
	}
	
	/* Teste de veiculo Estado formato inválido*/
	@Test
	public void adcionarVeiculoEstadoTest() {
		Veiculo v = new Veiculo("KKK0003", "hyundai", "HB20", "hatch", 2019,"2019", "branco", "São Paulo", "SP");
		VeiculoRepositorio autoRepo = new VeiculoRepositorio();
		VeiculoNegocio un = new VeiculoNegocio(autoRepo);
		un.adicionarVeiculo(v);
		
		boolean ret = un.adicionarVeiculo(v);
		assertFalse(ret);
	}
	
	/* Teste de veiculo Ano fabricacao inválido*/
	@Test
	public void adcionarVeiculoAnoFabricacaoInvalidoTest() {
		Veiculo v = new Veiculo("KKK0004", "hyundai", "HB20", "hatch", 2025,"2019", "branco", "Recife", "SP");
		VeiculoRepositorio autoRepo = new VeiculoRepositorio();
		VeiculoNegocio un = new VeiculoNegocio(autoRepo);
		un.adicionarVeiculo(v);
		
		boolean ret = un.adicionarVeiculo(v);
		assertFalse(ret);
	}
	/* Teste de veiculo placa inválida*/
	@Test
	public void adcionarVeiculoPlacaInvalidoTest() {
		Veiculo v = new Veiculo("KKK00055", "hyundai", "HB20", "hatch", 2018,"2019", "branco", "Recife", "PE");
		VeiculoRepositorio autoRepo = new VeiculoRepositorio();
		VeiculoNegocio un = new VeiculoNegocio(autoRepo);
		un.adicionarVeiculo(v);
		
		boolean ret = un.adicionarVeiculo(v);
		assertFalse(ret);
	}
	/* Teste de veiculo modelo nulo*/
	@Test
	public void adcionarVeiculoModeloNuloTest() {
		Veiculo v = new Veiculo("KKK0006", "hyundai", null, "hatch", 2018,"2019", "branco", "Recife", "PE");
		VeiculoRepositorio autoRepo = new VeiculoRepositorio();
		VeiculoNegocio un = new VeiculoNegocio(autoRepo);
		un.adicionarVeiculo(v);
		
		boolean ret = un.adicionarVeiculo(v);
		assertFalse(ret);
	}	
	/* Teste de veiculo ano modelo formato inválido*/
	@Test
	public void adcionarVeiculoAnoModeloNuloTest() {
		Veiculo v = new Veiculo("KKK0007", "Chevrolet", "Onix", null, 2018,"2019", "preto", "Recife", "PE");
		VeiculoRepositorio autoRepo = new VeiculoRepositorio();
		VeiculoNegocio un = new VeiculoNegocio(autoRepo);
		un.adicionarVeiculo(v);
		
		boolean ret = un.adicionarVeiculo(v);
		assertFalse(ret);
	}
	/* Teste Deletar Veiculo*/
	@Test
	public void deletarVeiculoTest() {
		Veiculo v = new Veiculo("KKK0007", "Ford", "KA", "hatch", 2018, "2019", "branco", "Palmas", "TO");
		VeiculoRepositorio autoRepo = new VeiculoRepositorio();
		VeiculoNegocio vn = new VeiculoNegocio(autoRepo);		
		boolean ret = vn.adicionarVeiculo(v);
		System.out.println("Teste *deletarVeiculoTest()*");
		System.out.println("Placa: " + v.getPlacaveiculo() + " Marca: " + v.getMarca());
		if (ret) {
			ret = vn.deletarVeiculo("KKK0007");
			System.out.println("Veiculo deletado com sucesso!");
		}
		System.out.println("Resultado do Teste:" + ret);
		System.out.println("");
		assertTrue(ret);
	}
	
}
