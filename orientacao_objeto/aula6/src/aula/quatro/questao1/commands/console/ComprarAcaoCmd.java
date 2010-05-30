package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;

public class ComprarAcaoCmd extends AbstractConsoleBolsaValoresCmd {

	public ComprarAcaoCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		try {
			bolsa.comprarAcao(codigo);
			
			ConsoleUtil.alerta("Ação comprada com sucesso");
		} catch (Exception e) {
			ConsoleUtil.error(e.getMessage());
		}
	}

}
