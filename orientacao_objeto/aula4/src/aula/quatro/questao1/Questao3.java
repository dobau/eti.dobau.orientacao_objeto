package aula.quatro.questao1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import aula.quatro.questao1.view.InterBolsaValores;


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

		Properties prop = new Properties();
		try {
			URL url = ClassLoader.getSystemResource("config.properties");
			prop.load(url.openStream());
			
			BolsaValores bolsa = BolsaValoresFactory.getInstance(prop.getProperty("bolsa.tipo"));
			
			InterBolsaValores view = new InterBolsaValores(bolsa);
			while (true) {
				// Mostra o menu
				view.showMenu();
				// Espera o usuário digitar alguma opção e executa o comando
				view.waitAndDo();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
