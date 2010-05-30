package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.commands.AbstractBolsaValoresCmd;
import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class AlterarValorDividendoCmd extends AbstractBolsaValoresCmd {

	public AlterarValorDividendoCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.print("Digite o valor do dividendo: ");
		Double valor = KeyboardUtil.nextDouble();
		System.out.println();
		
		try {
			bolsa.alterarDividendo(valor);
			ConsoleUtil.alerta("Valor do dividendo atualizado com sucesso");
		} catch(Exception e) {
			ConsoleUtil.error(e.getMessage());
		}
	}

}
