package aula.quatro.questao1.commands.console;

import eti.dobau.KeyboardUtil;
import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.commands.AbstractAcaoCmd;
import aula.quatro.questao1.model.Acao;

public abstract class AbstractConsoleAcaoCmd extends AbstractAcaoCmd {

	public AbstractConsoleAcaoCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	protected String pedirCodigo() {
		System.out.print("Digite o código da ação: ");
		String codigo = KeyboardUtil.nextLine();
		System.out.println();
		
		return codigo;
	}
	
	protected void detalharAcao(Acao acao) {
		System.out.println("Código: " + acao.getCodigo());
		System.out.println("Descrição: " + acao.getDescricao());
		System.out.println("Valor: " + acao.getValorCompra());
	}
	
}
