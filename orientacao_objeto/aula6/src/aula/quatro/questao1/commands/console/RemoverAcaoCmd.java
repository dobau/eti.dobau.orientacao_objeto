package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;

public class RemoverAcaoCmd extends AbstractConsoleBolsaValoresCmd {

	public RemoverAcaoCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		try {
			int quantidade = bolsa.remove(codigo);
			ConsoleUtil.alerta(String.format("Foram removidas %d ações", quantidade));
		} catch(Exception e){
			ConsoleUtil.error(e.getMessage());
		}
	}

}
