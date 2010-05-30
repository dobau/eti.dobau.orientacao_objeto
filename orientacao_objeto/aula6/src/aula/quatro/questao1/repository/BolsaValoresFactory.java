package aula.quatro.questao1.repository;

import java.util.HashMap;

import aula.quatro.questao1.exception.RepositoryNotFoundException;

/**
 * Factory de Bolsa de Valores.
 *
 * @author Rafael Alves
 * @since 29/05/2010
 */
public class BolsaValoresFactory {

	/**
	 * Tipos disponíveis.
	 */
	public enum Type {
		ARRAY, VECTOR, HASH, SQL
	}

	/**
	 * Tipos utilizados
	 */
	private static HashMap<Type, Class<?>> map;

	static {
		map = new HashMap<Type, Class<?>>();

		map.put(Type.ARRAY,  BolsaValoresArray.class);
		map.put(Type.VECTOR, BolsaValoresVector.class);
		map.put(Type.HASH,   BolsaValoresHash.class);
		map.put(Type.SQL,    BolsaValoresSQL.class);
	}

	/**
	 * Recupera a instância do repositório de acordo com o tipo que foi passado como parâmetro
	 *
	 * @param type Repository type
	 * @return Retorna a instância do repositório.
	 * @throws RepositoryNotFoundException Erro lançado quando o tipo de repositório não é encontrado.
	 * @throws CreateBolsaException Erro Ao criar a bolsa de valores.
	 */
	public static Repository getInstance(String type) throws RepositoryNotFoundException, CreateBolsaException {
		Class<?> repositoryClass = BolsaValoresFactory.map.get(Type.valueOf(type.toUpperCase()));

		if (repositoryClass == null) {
			throw new RepositoryNotFoundException(type);
		} else {
			try {
				return (Repository) repositoryClass.newInstance();
			} catch (Exception e) {
				throw new CreateBolsaException(repositoryClass.toString(), e);
			}
		}
	}

}
