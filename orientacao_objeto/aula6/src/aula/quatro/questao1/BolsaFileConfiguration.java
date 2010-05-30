package aula.quatro.questao1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe responsável por carregar o arquivo de configuração da bolsa de valores.
 * 
 * @author Rafael Alves
 * @since 29/05/2010
 */
public class BolsaFileConfiguration {

	/**
	 * Propriedades do arquivo
	 */
	private Properties prop;

	/**
	 * Carrega o arquivo nas propriedades
	 * 
	 * @param file Nome do arquivo
	 * @throws IOException Excessão lançada caso algum erro ocorra ao abrir o arquivo
	 */
	public BolsaFileConfiguration(String file) throws IOException {
		prop = new Properties();
		
		InputStream stream = ClassLoader.getSystemResourceAsStream(file);
		prop.load(stream);
	}

	/**
	 * @return Retorna o tipo de repositório utilizado
	 */
	public String getType() {
		return prop.getProperty("bolsa.tipo");
	}

}
