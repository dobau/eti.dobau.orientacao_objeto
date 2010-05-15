package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.model.Acao;
import eti.dobau.ConsoleUtil;

public class ConsultarAcaoCmd extends AbstractConsoleAcaoCmd {

	public ConsultarAcaoCmd(BolsaValores bolsa) {
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
