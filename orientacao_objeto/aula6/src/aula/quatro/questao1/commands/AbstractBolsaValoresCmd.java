package aula.quatro.questao1.commands;

import aula.quatro.questao1.repository.Repository;
import eti.dobau.Command;

/**
 * Command genérico para Bolsa de Valores.
 *
 * @author Rafael Alves
 * @since 29/05/2010
 */
public abstract class AbstractBolsaValoresCmd implements Command {

	/**
	 * Repositório utilizado nos commands.
	 */
	protected final Repository bolsa;

	/**
	 * Configura a bolsa de valores para os commands.
	 * @param bolsa
	 */
	public AbstractBolsaValoresCmd(Repository bolsa) {
		this.bolsa = bolsa;
	}

}
