package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.commands.AbstractAcaoCmd;
import aula.quatro.questao1.model.AcaoPNB;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class AlterarValorDividendoCmd extends AbstractAcaoCmd {

	public AlterarValorDividendoCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.println("Digite o valor do dividendo: ");
		Double valor = KeyboardUtil.nextDouble();
		
		AcaoPNB.atualizarDividendo(valor);
		
		ConsoleUtil.alerta("Valor do dividendo atualizado com sucesso");
	}

}
