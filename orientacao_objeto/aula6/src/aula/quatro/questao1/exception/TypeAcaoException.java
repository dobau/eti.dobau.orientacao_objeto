package aula.quatro.questao1.exception;


public class TypeAcaoException extends Exception {

	private static final long serialVersionUID = 117828815791383527L;

	public TypeAcaoException(String codigo, String tipo) {
		super(String.format("Ação (%s) não é do tipo %s", codigo, tipo));
	}

}
