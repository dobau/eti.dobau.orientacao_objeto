package aula.quatro.questao1;

import java.util.List;
import java.util.Vector;

import aula.quatro.questao1.model.Acao;

/**
 * Classe utilizada para representar a bolsa de valores
 * 
 * @author dobau
 * 
 */
public class BolsaValoresVector extends BolsaValores {

	/**
	 * Array contendo todas as ações
	 */
	private Vector<Acao> acoes = new Vector<Acao>();
	
	/**
	 * Procura uma acao
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public Acao find(String codigo) {
		int pos = acoes.indexOf(new Acao(codigo){});
		
		if (pos < 0) {
			return null;
		} else {
			return acoes.elementAt(pos);
		}
	}

	/**
	 * @return Retorna a quantidade de acoes válidas.
	 */
	@Override
	public List<Acao> getAll() {
		return acoes;
	}

	/**
	 * Remove uma acao de acordo com o código
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public int remove(String codigo) {
		int countRemoved = 0;
		
		int tamanho = acoes.size();
		for (int i = 0; i < tamanho; i++) {
			Acao acao = acoes.get(i);
			if (acao.getCodigo().equals(codigo)) {
				acoes.remove(i);
				countRemoved++;
				i--;
			}
		}
		
		return countRemoved;
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
		acoes.add(acao);
	}

}
