package aula.dois.questao1;


/**
 * Utiliza a bolsa.
 * 
 * @author dobau
 * @since 02/05/2010
 */
public class Questao3 {

	/**
	 * Método principal utilizado para fazer as operações na bolsa.
	 */
	public static void main(String[] args) {

		InterBolsaValores view = new InterBolsaValores();

		while (true) {
			// Mostra o menu
			view.showMenu();
			// Espera o usuário digitar alguma opção e executa o comando
			view.waitAndDo();
		}

	}

}
