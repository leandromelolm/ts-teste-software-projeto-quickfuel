package main.java;

import java.time.LocalDate;
import java.util.Date;

public class CartaoCreditoNegocio {

	private CartaoCreditoRepositorio cardRepo;
	
	public CartaoCreditoNegocio(CartaoCreditoRepositorio caRepo) {
		this.cardRepo = caRepo;
	}
	
	public boolean adicionarCartaoCredito(CartaoCredito c) {
		boolean adicionado = false;
//		Date dataAtualSistema = new Date(System.currentTimeMillis());
//		System.out.println(dataAtualSistema);
		int ano = LocalDate.now (). getYear ();
		int mes = LocalDate.now().getMonthValue();
		
		
		if (   c.getNumero() != null
			&& c.getNumero().length() == 16
			&& c.getBandeira() != null	
//			&& c.getDataExpiracaoAno() > ano
			&& 	this.cardRepo.buscarPorNumero(c.getNumero()) == null){
			if (	   c.getDataExpiracaoAno() > ano
//					|| c.getDataExpiracaoAno() == ano 
//					&& c.getDataExpiracaoMes() >= mes 
					){
				if(        c.getBandeira().contains("VISA")
						|| c.getBandeira().contains("MASTERCARD")
						|| c.getBandeira().contains("ELO")
						|| c.getBandeira().contains("HIPERCARD")
						){
					adicionado = this.cardRepo.addCartaoCredito(c);
				}	
			}
		}
			
		return adicionado;
	}
	public boolean deletarCartaoCredito(String numero) {
		boolean ret = false;
		if (numero != null) {
			ret = this.cardRepo.delCartaoCredito(numero);
		}
		return ret;		
	}
}

