package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.BolsaValores;
import eti.dobau.ConsoleUtil;

public class RemoverAcaoCmd extends AbstractConsoleAcaoCmd {

	public RemoverAcaoCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		int quantidade = bolsa.remove(codigo);
		ConsoleUtil.alerta(String.format("Foram removidas %d ações", quantidade));
	}

}
