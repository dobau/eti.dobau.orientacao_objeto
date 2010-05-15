package aula.quatro.questao1;

import java.util.Hashtable;

public class BolsaValoresFactory {

	private static Hashtable<String, Class<?>> tipos = new Hashtable<String, Class<?>>();

	static {
		tipos.put("array",  BolsaValoresArray.class);
		tipos.put("vector", BolsaValoresVector.class);
		tipos.put("hash",   BolsaValoresHash.class);
	}

	public static BolsaValores getInstance(String key) {
		Class<BolsaValores> classe = (Class<BolsaValores>) BolsaValoresFactory.tipos.get(key);
		
		if (classe == null) {
			throw new RuntimeException(String.format("Tipo %s não encontrado.", classe));
		} else {
			try {
				return classe.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(String.format("Erro ao instanciar a classe %s.", classe));
			}
		}
	}

}
