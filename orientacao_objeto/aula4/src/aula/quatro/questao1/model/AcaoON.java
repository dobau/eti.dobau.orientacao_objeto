package aula.quatro.questao1.model;

public class AcaoON extends Acao {
	
	private Boolean resultadoVoto;

	public AcaoON(String codigo) {
		super(codigo);
	}

	public AcaoON(String codigo, String descricao) {
		super(codigo, descricao);
	}

	public AcaoON(String c, Double vc, Double vv, Status s, String d) {
		super(c, vc, vv, s, d);
	}

	public AcaoON(String c, Double vc, Double vv, String d) {
		super(c, vc, vv, d);
	}

	public void votar(Boolean voto) {
		this.resultadoVoto = voto;
	}
	
	public Boolean getResultadoVoto() {
		return this.resultadoVoto;
	}

}
