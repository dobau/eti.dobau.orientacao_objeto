package aula.quatro.questao1.commands.console;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.model.Acao;
import eti.dobau.ConsoleUtil;

public class ListaAcoesCmd extends AbstractConsoleAcaoCmd {

	public ListaAcoesCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.println("Lista de ações: ");
		List<Acao> acoes = bolsa.getAll();
		
		for (Acao acao : acoes) {
			detalharAcao(acao);
			System.out.println(StringUtils.repeat("-", ConsoleUtil.TAMANHO_LINHA));
		}
	}

}
