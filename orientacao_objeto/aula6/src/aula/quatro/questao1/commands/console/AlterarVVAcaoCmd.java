package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class AlterarVVAcaoCmd extends AbstractConsoleBolsaValoresCmd {

	public AlterarVVAcaoCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();

		System.out.print("Digite o novo valor de venda: ");
		Double valorVenda = KeyboardUtil.nextDouble();
		System.out.println();
		
		try {
			bolsa.alterarValorVenda(codigo, valorVenda);
			
			ConsoleUtil.alerta("Valor da ação alterada com sucesso");
		} catch (Exception e) {
			ConsoleUtil.error("Ação não encontrada");
		}
	}

}
