package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.commands.AbstractAcaoCmd;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class AtualizarValorVendaTodasCmd extends AbstractAcaoCmd {

	public AtualizarValorVendaTodasCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.println("Digite o a porcentagem a ser adicionada: ");
		Double valor = KeyboardUtil.nextDouble();

		bolsa.addPerToAll(valor);
		
		ConsoleUtil.alerta("Valores atualizados com sucesso");
	}

}
