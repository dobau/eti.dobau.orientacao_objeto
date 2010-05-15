package aula.dois.questao2;

import java.util.Comparator;

public class AcaoOrderValorVenda implements Comparator<Acao> {

	@Override
	public int compare(Acao a1, Acao a2) {
		// Utiliza a comparação de double
		return Double.compare(a1.getValorVenda(), a2.getValorVenda());
	}

}
