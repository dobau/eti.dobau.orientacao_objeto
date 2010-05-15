package aula.dois.questao1.commands;

import aula.dois.questao1.Acao;
import aula.dois.questao1.BolsaValores;
import eti.dobau.Command;
import eti.dobau.KeyboardUtil;

public abstract class AbstractAcaoCmd implements Command {

	protected final BolsaValores bolsa;
	
	public AbstractAcaoCmd(BolsaValores bolsa) {
		this.bolsa = bolsa;
	}
	
}
