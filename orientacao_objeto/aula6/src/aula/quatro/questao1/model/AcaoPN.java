package aula.quatro.questao1.model;

public abstract class AcaoPN extends Acao {
	
	public AcaoPN() {
	}
	
	public AcaoPN(String codigo) {
		super(codigo);
	}

	public AcaoPN(String codigo, String descricao) {
		super(codigo, descricao);
	}

	public AcaoPN(String c, Double vc, Double vv, Status s, String d) {
		super(c, vc, vv, s, d);
	}

	public AcaoPN(String c, Double vc, Double vv, String d) {
		super(c, vc, vv, d);
	}

}
