package aula.dois.questao1.commands.console;

import aula.dois.questao1.BolsaValores;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class CadastrarAcaoCmd extends AbstractConsoleAcaoCmd {

	public CadastrarAcaoCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.println("Digite as informações da ação");
		System.out.print("Código: ");
		String codigo = KeyboardUtil.nextLine();
		System.out.print("Descrição: ");
		String descricao = KeyboardUtil.nextLine();
		System.out.println();
		
		bolsa.add(codigo, descricao);
		ConsoleUtil.alerta("Ação cadastrada com sucesso");
	}

}
