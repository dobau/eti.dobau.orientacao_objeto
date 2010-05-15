package aula.dois.questao1.commands.console;

import aula.dois.questao1.Acao;
import aula.dois.questao1.BolsaValores;
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
