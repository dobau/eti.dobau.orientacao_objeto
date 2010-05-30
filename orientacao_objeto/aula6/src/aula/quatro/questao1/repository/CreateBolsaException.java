package aula.quatro.questao1.repository;

/**
 * Lançada quando algum erro ocorre ao instanciar a Bolsa de Valores.
 *
 * @author Rafael Alves
 * @sicne 29/05/2010
 */
public class CreateBolsaException extends Exception {

	private static final long serialVersionUID = 422756928105503560L;

	public CreateBolsaException(String classe, Exception e) {
		super(String.format("Erro ao criar %s", classe));
	}

}
