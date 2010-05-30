package aula.quatro.questao1;

import aula.quatro.questao1.repository.BolsaValoresFactory;
import aula.quatro.questao1.repository.Repository;
import aula.quatro.questao1.view.BolsaValoresView;
import eti.dobau.ConsoleUtil;


/**
 * Aplicação da bolsa de valores
 * 
 * @author dobau
 * @since 02/05/2010
 */
public class Questao1 {

	/**
	 * Método principal utilizado para fazer as operações na bolsa.
	 */
	public static void main(String[] args) {
		try {
			BolsaFileConfiguration bolsaConfig = new BolsaFileConfiguration("config.properties");
			Repository bolsa = BolsaValoresFactory.getInstance(bolsaConfig.getType());
			
			BolsaValoresView view = new BolsaValoresView(bolsa);
			while (true) {
				view.showMenu();
				view.waitAndDo();
			}
		} catch (Exception e) {
			ConsoleUtil.error(e.getMessage());
		}
	}

}
