package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.exception.AcaoNotFoundException;
import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class DisponibilizarAcaoCmd extends AbstractConsoleBolsaValoresCmd {

	public DisponibilizarAcaoCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		System.out.print("Digite o valor de venda: ");
		Double valorVenda = KeyboardUtil.nextDouble();
		System.out.println();
		
		try {
			bolsa.disponibilizarVenda(codigo, valorVenda);
			
			ConsoleUtil.alerta("Ação disponibilizada para venda com sucesso");
		} catch (AcaoNotFoundException e) {
			ConsoleUtil.error("Ação não encontrada");
		}
	}

}
