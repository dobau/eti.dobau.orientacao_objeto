package aula.dois.questao1.commands.console;

import aula.dois.questao1.BolsaValores;

public class ExitApplicationCmd extends AbstractConsoleAcaoCmd {

	public ExitApplicationCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.exit(0);
	}

}
