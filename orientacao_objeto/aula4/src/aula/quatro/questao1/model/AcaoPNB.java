package aula.quatro.questao1.model;

public class AcaoPNB extends AcaoPN {
	
	private static Double dividendoFixo;
	
	public AcaoPNB(String codigo) {
		super(codigo);
	}

	public AcaoPNB(String codigo, String descricao) {
		super(codigo, descricao);
	}

	public AcaoPNB(String c, Double vc, Double vv, Status s, String d) {
		super(c, vc, vv, s, d);
	}

	public AcaoPNB(String c, Double vc, Double vv, String d) {
		super(c, vc, vv, d);
	}

	public void realizarInvestimento() {
		disponibilizarVenda(dividendoFixo);
	}

	public static void atualizarDividendo(Double valor) {
		dividendoFixo = valor;
	}

	public static Double getDividendo() {
		return dividendoFixo; 
	}
	
}
