package aula.quatro.questao1.commands;

import aula.quatro.questao1.BolsaValores;
import eti.dobau.Command;

public abstract class AbstractAcaoCmd implements Command {

	protected final BolsaValores bolsa;
	
	public AbstractAcaoCmd(BolsaValores bolsa) {
		this.bolsa = bolsa;
	}
	
}
