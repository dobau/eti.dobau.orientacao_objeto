package aula.quatro.questao1.exception;

import aula.quatro.questao1.model.AcaoType;

/**
 * Excessão lançada quando o tipo de repositório não foi encontrado.
 *
 * @author Rafael Alves
 * @since 29/05/2010
 */
public class RepositoryNotFoundException extends Exception {

	private static final long serialVersionUID = -3015935427472463828L;

	public RepositoryNotFoundException(String tipo) {
		super(String.format("Tipo %s não encontrado.", tipo));
	}

	public RepositoryNotFoundException(AcaoType tipo) {
		super(tipo.name());
	}

}
