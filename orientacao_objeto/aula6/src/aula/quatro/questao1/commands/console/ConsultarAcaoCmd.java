package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.model.Acao;
import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;

public class ConsultarAcaoCmd extends AbstractConsoleBolsaValoresCmd {

	public ConsultarAcaoCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		Acao acao = bolsa.find(codigo);
		
		if (acao != null) {
			detalharAcao(acao);
		} else {
			ConsoleUtil.alerta("Ação não encontrada");
		}
	}

}
