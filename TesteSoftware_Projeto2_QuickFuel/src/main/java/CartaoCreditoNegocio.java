package main.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public class CartaoCreditoNegocio {

	private CartaoCreditoRepositorio cartRepo;

	public CartaoCreditoNegocio(CartaoCreditoRepositorio caRepo) {
		this.cartRepo = caRepo;
	}

	public boolean adicionarCartaoCredito(CartaoCredito c) {
		boolean adicionado = false;
//		Date dataAtualSistema = new Date(System.currentTimeMillis());
//		System.out.println(dataAtualSistema);
		int ano = LocalDate.now().getYear();
		int mes = LocalDate.now().getMonthValue();
//		int diadomes = LocalDate.now().getDayOfMonth();
//		System.out.println(ano +" " + mes + " ");
//		Month mes2 = LocalDate.now().getMonth();
//		String date = LocalDateTime.now().toString();
//		String data = LocalDate.of(ano, mes, diadomes).toString();		
//		System.out.println(data);
//		System.out.println(date);
//		System.out.println(mes2);
//		int mesInt = Integer.parseInt(mesString);
		int dataExpMesInt = Integer.parseInt(c.getDataExpiracaoMes());

		if (c.getNumero() != null 
				&& c.getNumero().length() == 16 
				&& c.getNumero().matches("[0-9]+") // Verifica se está entre 0 e 9 os números do cartão
				&& c.getBandeira() != null 
				&& this.cartRepo.buscarPorNumero(c.getNumero()) == null) {
			if (
					   c.getBandeira().contains("VISA") 
					|| c.getBandeira().contains("MASTERCARD")
					|| c.getBandeira().contains("ELO") 
					|| c.getBandeira().contains("HIPERCARD")
					|| c.getBandeira().contains("AMERICAN EXPRESS")) {
				if (c.getDataExpiracaoAno() > ano) {
					adicionado = this.cartRepo.addCartaoCredito(c); //se ANO não for MAIOR que o ano atual, a lógica vai para o else

				} else {
					if (c.getDataExpiracaoAno() == ano 
							&& dataExpMesInt >= mes) {
						adicionado = this.cartRepo.addCartaoCredito(c);
					}
				}
			}
		}

		return adicionado;
	}

	public boolean deletarCartaoCredito(String numero) {
		boolean ret = false;
		if (numero != null) {
			ret = this.cartRepo.delCartaoCredito(numero);
		}
		return ret;
	}
}
