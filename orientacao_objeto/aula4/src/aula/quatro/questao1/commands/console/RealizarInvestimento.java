package aula.quatro.questao1.commands.console;

import eti.dobau.ConsoleUtil;
import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.model.Acao;
import aula.quatro.questao1.model.AcaoPN;

public class RealizarInvestimento extends AbstractConsoleAcaoCmd {

	public RealizarInvestimento(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		Acao acao = bolsa.find(codigo);
		
		if (acao == null) {
			System.out.println("Ação não encontrada");
		} else {
			if (acao instanceof AcaoPN) {
				
				((AcaoPN) acao).realizarInvestimento();
				
				ConsoleUtil.alerta("Investimento realizado com sucesso");
				
			} else {
				System.out.println("Ação não é do tipo PN");
			}
		}
	}

}
