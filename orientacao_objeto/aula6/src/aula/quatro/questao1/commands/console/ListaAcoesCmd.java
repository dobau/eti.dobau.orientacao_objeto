package aula.quatro.questao1.commands.console;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import aula.quatro.questao1.model.Acao;
import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;

public class ListaAcoesCmd extends AbstractConsoleBolsaValoresCmd {

	public ListaAcoesCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.println();
		System.out.println("Lista de ações");
		List<Acao> acoes = bolsa.getAll();
		
		for (Acao acao : acoes) {
			detalharAcao(acao);
			System.out.println(StringUtils.repeat("-", ConsoleUtil.TAMANHO_LINHA));
		}
	}

}
