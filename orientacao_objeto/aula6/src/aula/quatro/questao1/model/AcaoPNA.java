package aula.quatro.questao1.model;

/**
 * O código é o sequencial.
 * 
 * @author Rafael Alves
 *
 */
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

	public AcaoPNA() {
	}
	
	public static String generateCodigo() {
		return String.valueOf(++sequencial);
	}
	
}
