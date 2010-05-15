package aula.quatro.questao1;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import aula.quatro.questao1.model.Acao;

/**
 * Classe utilizada para representar a bolsa de valores
 * 
 * @author dobau
 * 
 */
public class BolsaValoresHash extends BolsaValores {

	/**
	 * Array contendo todas as ações
	 */
	private Hashtable<String,Acao> acoes = new Hashtable<String,Acao>();
	
	/**
	 * Procura uma acao
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public Acao find(String codigo) {
		return acoes.get(codigo);
	}

	/**
	 * @return Retorna a quantidade de acoes válidas.
	 */
	@Override
	public List<Acao> getAll() {
		List<Acao> lista = new ArrayList<Acao>();
		
		Enumeration<Acao> en = acoes.elements();
		while(en.hasMoreElements()) {
			Acao acao = en.nextElement();
			lista.add(acao);
		}
		
		return lista;
	}

	/**
	 * Remove uma acao de acordo com o código
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public int remove(String codigo) {
		
		if (acoes.remove(codigo) == null) {
			return 0;
		} else {
			return 1;
		}
		
	}

	/**
	 * Remove a acao passada como parâmetro
	 * @param acao
	 * @return
	 */
	@Override
	public int remove(Acao acao) {
		return remove(acao.getCodigo());
	}

	/**
	 * Adiciona uma ação na bolsa
	 * 
	 * @param acao Acao
	 */
	@Override
	public void add(Acao acao) {
		if (acao == null) {
			throw new NullPointerException("Ação inválida");
		}
		
		acoes.put(acao.getCodigo(), acao);
	}

}
