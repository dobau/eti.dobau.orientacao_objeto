package aula.quatro.questao1;

import java.util.Arrays;
import java.util.List;

import aula.quatro.questao1.model.Acao;

/**
 * Classe utilizada para representar a bolsa de valores
 * 
 * @author dobau
 * 
 */
public class BolsaValoresArray extends BolsaValores {

	/**
	 * Array contendo todas as ações
	 */
	private Acao[] acoes = new Acao[50];
	private int tamanho = 0;
	
	/**
	 * Procura uma acao
	 * 
	 * @param codigo
	 * @return
	 */
	public Acao find(String codigo) {
		for (int i = 0; i < tamanho; i++) {
			Acao acao = acoes[i];
			if (acao.getCodigo().equals(codigo)) {
				return acao;
			}
		}

		return null;
	}

	/**
	 * @return Retorna a quantidade de acoes válidas.
	 */
	public List<Acao> getAll() {
		return Arrays.asList(Arrays.copyOf(acoes, tamanho));
	}

	/**
	 * Remove uma acao de acordo com o código
	 * 
	 * @param codigo
	 * @return
	 */
	public int remove(String codigo) {
		int countRemoved = 0;
		
		for (int i = 0; i < tamanho; i++) {
			Acao acao = acoes[i];
			if (acao.getCodigo().equals(codigo)) {
				removeByIndex(i);
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
	public int remove(Acao acao) {
		return remove(acao.getCodigo());
	}

	/**
	 * Adiciona uma ação na bolsa
	 * 
	 * @param acao Acao
	 */
	public void add(Acao acao) {
		if (isFull()) {
			expand();
		}

		acoes[tamanho++] = acao;
	}

	/**
	 * Duplica o tamanho
	 */
	private void expand() {
		acoes = Arrays.copyOf(acoes, acoes.length * 2);
	}

	/**
	 * @return Retorna true se a bolsa de valores está lotada, caso contrário
	 *         retorna false.
	 */
	private boolean isFull() {
		return tamanho >= acoes.length;
	}

	/**
	 * Remove uma acao de acordo com o índice.
	 * 
	 * @param index Posição da ação a ser removida
	 */
	private void removeByIndex(int index) {
		for (int i = index; i <= tamanho; i++) {
			if (i == acoes.length) {
				acoes[i] = null;
			} else {
				acoes[i] = acoes[i + 1];
			}
		}
	
		tamanho--;
	}

}
