package aula.quatro.questao1.factory;

import aula.quatro.questao1.exception.RepositoryNotFoundException;
import aula.quatro.questao1.model.Acao;
import aula.quatro.questao1.model.AcaoON;
import aula.quatro.questao1.model.AcaoPNA;
import aula.quatro.questao1.model.AcaoPNB;
import aula.quatro.questao1.model.AcaoType;

public class AcaoFactory {

	public static Acao criaAcao(AcaoType tipo) throws RepositoryNotFoundException {
		switch (tipo) {
		case ON:
			return new AcaoON();
		case PNB:
			return new AcaoPNB();
		case PNA:
			return new AcaoPNA();
		default:
			throw new RepositoryNotFoundException(tipo);
		}
	}

}
