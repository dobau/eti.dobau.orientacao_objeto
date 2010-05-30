package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;

public class RealizarInvestimento extends AbstractConsoleBolsaValoresCmd {

	public RealizarInvestimento(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		try {
			bolsa.realizarInvestimento(codigo);
			
			ConsoleUtil.alerta("Investimento realizado com sucesso");
		} catch (Exception e) {
			ConsoleUtil.error(e.getMessage());
		}
	}

}
