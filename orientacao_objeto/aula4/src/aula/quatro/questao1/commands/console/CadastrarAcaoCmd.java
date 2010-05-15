package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.model.AcaoON;
import aula.quatro.questao1.model.AcaoPNA;
import aula.quatro.questao1.model.AcaoPNB;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class CadastrarAcaoCmd extends AbstractConsoleAcaoCmd {

	public CadastrarAcaoCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.println("Digite as informações da ação");
		System.out.println("Digite o tipo [1 - AcaoON, 2 - AcaoPNA, 3 - AcaoPNB] (1): ");
		String tipo = KeyboardUtil.nextLine();

		boolean resultado = false;
		if ("3".equals(tipo)) {
			resultado = cadastrarAcaoPNB();
		} else if ("2".equals(tipo)) {
			resultado = cadastrarAcaoPNA();
		} else if ("1".equals(tipo) || "".equals(tipo)) {
			resultado = cadastrarAcaoON();
		} else {
			System.out.println("Tipo de ação inválido");
		}
		
		if (resultado) {
			ConsoleUtil.alerta("Ação cadastrada com sucesso");
		}
	}
	
	private boolean cadastrarAcaoON() {
		String codigo = recuperarCodigo();
		String descricao = recuperarDescricao();
		System.out.println();

		bolsa.add(new AcaoON(codigo, descricao));
		
		return true;
	}

	private boolean cadastrarAcaoPNA() {
		String descricao = recuperarDescricao();
		System.out.println();

		bolsa.add(new AcaoPNA(descricao));
		
		return true;
	}

	private boolean cadastrarAcaoPNB() {
		String codigo = recuperarCodigo();
		String descricao = recuperarDescricao();
		System.out.println();

		bolsa.add(new AcaoPNB(codigo, descricao));
		
		return true;
	}

	private String recuperarCodigo() {
		System.out.print("Código: ");
		String codigo = KeyboardUtil.nextLine();
		
		return codigo;
	}
	
	private String recuperarDescricao() {
		System.out.print("Descrição: ");
		String descricao = KeyboardUtil.nextLine();
		
		return descricao;
	}

}
