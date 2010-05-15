package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.model.Acao;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class AlterarVVAcaoCmd extends AbstractConsoleAcaoCmd {

	public AlterarVVAcaoCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		Acao acao = bolsa.find(codigo);
		
		if (acao != null) {
			System.out.print("Digite o novo valor de venda: ");
			Double valorVenda = KeyboardUtil.nextDouble();
			acao.setValorVenda(valorVenda);
			ConsoleUtil.alerta("Valor da ação alterada com sucesso");
		} else {
			ConsoleUtil.alerta("Ação não encontrada");
		}

	}

}
