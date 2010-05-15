package aula.quatro.questao1.model;

public class AcaoPNA extends AcaoPN {
	
	private static Integer sequencial = 0;
	
	public AcaoPNA(String descricao) {
		super(generateCodigo(), descricao);
	}

	public AcaoPNA(Double vc, Double vv, Status s, String d) {
		super(generateCodigo(), vc, vv, s, d);
	}

	public AcaoPNA(Double vc, Double vv, String d) {
		super(generateCodigo(), vc, vv, d);
	}

	public void realizarInvestimento() {
		Double valorVenda = getValorVenda();
		Double valorCompra = getValorCompra();
		
		// Lucro de compra é 10% do valor de compra da ação
		Double valorLucro = (valorCompra * 10/100) + valorCompra;
		
		if (valorVenda > valorLucro) {
			disponibilizarVenda(valorVenda);
		} else {
			disponibilizarVenda(valorLucro);
		}
	}
	
	public static String generateCodigo() {
		return String.valueOf(++sequencial);
	}
	
}
