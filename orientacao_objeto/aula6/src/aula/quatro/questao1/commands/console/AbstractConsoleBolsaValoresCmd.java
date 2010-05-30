package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.commands.AbstractBolsaValoresCmd;
import aula.quatro.questao1.model.Acao;
import aula.quatro.questao1.repository.Repository;
import eti.dobau.KeyboardUtil;

/**
 * Abstract Command para Console
 *
 * @author Rafael Alves
 * @since 29/05/2010
 */
public abstract class AbstractConsoleBolsaValoresCmd extends AbstractBolsaValoresCmd {

	public AbstractConsoleBolsaValoresCmd(Repository bolsa) {
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
		System.out.println("Valor Venda: " + acao.getValorVenda());
		System.out.println("Valor Compra: " + acao.getValorCompra());
	}

}
