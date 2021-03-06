package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.model.Acao;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class DisponibilizarAcaoCmd extends AbstractConsoleAcaoCmd {

	public DisponibilizarAcaoCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		Acao acao = bolsa.find(codigo);
		
		if (acao != null) {
			System.out.print("Digite o valor de venda: ");
			Double valorVenda = KeyboardUtil.nextDouble();
			acao.disponibilizarVenda(valorVenda);
		} else {
			ConsoleUtil.alerta("Ação não encontrada");
		}

	}

}
