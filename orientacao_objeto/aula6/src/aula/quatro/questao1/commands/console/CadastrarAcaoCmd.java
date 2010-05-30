package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.model.AcaoON;
import aula.quatro.questao1.model.AcaoPNA;
import aula.quatro.questao1.model.AcaoPNB;
import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class CadastrarAcaoCmd extends AbstractConsoleBolsaValoresCmd {

	public CadastrarAcaoCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.println();
		System.out.println("Digite as informações da ação");
		System.out.print("Digite o tipo [1 - AcaoON, 2 - AcaoPNA, 3 - AcaoPNB] (1): ");
		String tipo = KeyboardUtil.nextLine();

		try {
			if ("3".equals(tipo)) {
				cadastrarAcaoPNB();
			} else if ("2".equals(tipo)) {
				cadastrarAcaoPNA();
			} else if ("1".equals(tipo) || "".equals(tipo)) {
				cadastrarAcaoON();
			} else {
				throw new Exception("Tipo de ação inválida");
			}
			
			ConsoleUtil.alerta("Ação cadastrada com sucesso");
		} catch(Exception e) {
			ConsoleUtil.error(e.getMessage());
		}
	}
	
	private void cadastrarAcaoON() {
		String codigo = recuperarCodigo();
		String descricao = recuperarDescricao();
		System.out.println();

		bolsa.add(new AcaoON(codigo, descricao));
	}

	private void cadastrarAcaoPNA() {
		String descricao = recuperarDescricao();
		System.out.println();

		bolsa.add(new AcaoPNA(descricao));
	}

	private void cadastrarAcaoPNB() {
		String codigo = recuperarCodigo();
		String descricao = recuperarDescricao();
		System.out.println();

		bolsa.add(new AcaoPNB(codigo, descricao));
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
