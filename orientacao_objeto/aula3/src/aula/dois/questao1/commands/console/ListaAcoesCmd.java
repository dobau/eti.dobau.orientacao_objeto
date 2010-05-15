package aula.dois.questao1.commands.console;

import org.apache.commons.lang.StringUtils;

import aula.dois.questao1.Acao;
import aula.dois.questao1.BolsaValores;
import eti.dobau.ConsoleUtil;

public class ListaAcoesCmd extends AbstractConsoleAcaoCmd {

	public ListaAcoesCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		System.out.println("Lista de ações: ");
		Acao[] acoes = bolsa.getAll();
		
		for (Acao acao : acoes) {
			detalharAcao(acao);
			System.out.println(StringUtils.repeat("-", ConsoleUtil.TAMANHO_LINHA));
		}
	}

}
