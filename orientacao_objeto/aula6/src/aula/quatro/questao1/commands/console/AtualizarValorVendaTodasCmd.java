package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.commands.AbstractBolsaValoresCmd;
import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class AtualizarValorVendaTodasCmd extends AbstractBolsaValoresCmd {

	public AtualizarValorVendaTodasCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.print("Digite o a porcentagem a ser adicionada: ");
		Double valor = KeyboardUtil.nextDouble();
		System.out.println();

		bolsa.addPerToAll(valor);
		
		ConsoleUtil.alerta("Valores atualizados com sucesso");
	}

}
