package aula.dois.questao3;


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

		BolsaView view = new BolsaView(new Bolsa());

		while (true) {
			view.showMenu();
			view.waitAndDo();
		}

	}

}
