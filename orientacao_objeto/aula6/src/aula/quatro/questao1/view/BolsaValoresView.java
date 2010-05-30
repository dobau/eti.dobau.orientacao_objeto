package aula.quatro.questao1.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import aula.quatro.questao1.commands.console.AlterarVVAcaoCmd;
import aula.quatro.questao1.commands.console.AlterarValorDividendoCmd;
import aula.quatro.questao1.commands.console.AtualizarValorVendaTodasCmd;
import aula.quatro.questao1.commands.console.CadastrarAcaoCmd;
import aula.quatro.questao1.commands.console.ComprarAcaoCmd;
import aula.quatro.questao1.commands.console.ConsultarAcaoCmd;
import aula.quatro.questao1.commands.console.DisponibilizarAcaoCmd;
import aula.quatro.questao1.commands.console.ExitApplicationCmd;
import aula.quatro.questao1.commands.console.ListaAcoesCmd;
import aula.quatro.questao1.commands.console.RealizarInvestimento;
import aula.quatro.questao1.commands.console.RemoverAcaoCmd;
import aula.quatro.questao1.commands.console.VotarCmd;
import aula.quatro.questao1.model.Opcao;
import aula.quatro.questao1.repository.BolsaValoresArray;
import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

/**
 * Classe que representa a camada de apresentação.
 * 
 * @author dobau
 * @since 05/05/2010
 *
 */
public class BolsaValoresView {

	private final static int TAMANHO_LINHA = 80;
	
	final Repository bolsa;
	private List<Opcao> opcoes;

	public BolsaValoresView(Repository bolsa, List<Opcao> opcoes) {
		if (bolsa != null) {
			this.bolsa = bolsa;
		} else {
			this.bolsa = new BolsaValoresArray(); 
		}
		
		if (opcoes == null) {
			initMenu();
		} else {
			initMenu(opcoes);
		}
	}
	
	public BolsaValoresView(Repository bolsa) {
		this(bolsa, null);
	}

	public BolsaValoresView(List<Opcao> opcoes) {
		this(null, opcoes);
	}

	public BolsaValoresView() {
		this(null, null);
	}
	
	protected void initMenu(List<Opcao> opcoes) {
		setOpcoes(opcoes);
		configuraOpcoesMenu();
	}

	protected void initMenu() {
		initMenu(getDefaultOpcoesMenu());
	}
	
	protected void configuraOpcoesMenu() {
		Collections.sort(opcoes);
	}

	public void showMenu() {
		String linha = StringUtils.repeat("=", TAMANHO_LINHA);
		System.out.println(linha);
		System.out.println(String.format("%s%s%s", "==", StringUtils.center("MENU", TAMANHO_LINHA - 4), "=="));
		System.out.println(linha);

		for (Opcao opcao : opcoes) {
			String valor = StringUtils.rightPad(opcao.getValor().toString(), 2);
			String mensagem = opcao.getMensagem();
			
			int tamSemMensagem = (2 + 1 + 2 + 3 + 3);
			int tamanhoMensagem = (TAMANHO_LINHA - tamSemMensagem);

			// Fazer tratamento quando a linha for maior q 80
			List<String> mensagensPart = new ArrayList<String>();
			String mensagemAux = mensagem;
			while (mensagemAux.length() > tamanhoMensagem || mensagensPart.size() == 0 || (mensagensPart.size() != 0 && !"".equals(mensagemAux.trim()))) {
				int fim = mensagemAux.length();

				String mensagemTry = "";
				if (fim < tamanhoMensagem) {
					mensagemTry = mensagemAux;
					mensagemAux = "";
				} else {
					mensagemTry = mensagemAux.substring(0, tamanhoMensagem);
					int index = mensagemTry.lastIndexOf(" ");
					mensagemTry = mensagemAux.substring(0, index);
					mensagemAux = mensagemAux.substring(index + 1);
				}
				
				mensagensPart.add(mensagemTry);
			}
			
			boolean showedFirst = false;
			for (String msg: mensagensPart) {
				String mensagemFormatada = StringUtils.rightPad(msg, TAMANHO_LINHA - tamSemMensagem);
				
				// 2 + 1 + 2 + 3 + X + 3
				String line = "";
				if (!showedFirst) {
					line = String.format("%s %s - %s %s", "==", valor, mensagemFormatada, "==");
					showedFirst = true;
				} else {
					line = String.format("%s     %s  %s", "==", mensagemFormatada, "==");
				}
				
				System.out.println(line);
			}
		}
		
		System.out.println(linha);
	}

	public void waitAndDo() {
		System.out.print("Digite a opção: ");
		Integer o = KeyboardUtil.nextInt();

		boolean executed = false;
		for (Opcao opcao : opcoes) {
			if (opcao.getValor().equals(o)) {
				opcao.execute();
				System.out.println();
				executed = true;
			}
		}

		if (!executed) {
			ConsoleUtil.alerta("Opção inexistente.");
			System.out.println();
		}
	}

	public Repository getBolsa() {
		return bolsa;
	}

	public List<Opcao> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}

	private List<Opcao> getDefaultOpcoesMenu() {
		List<Opcao> opcoes = new ArrayList<Opcao>();
		opcoes.add(new Opcao(1, "Cadastrar uma ação (AcaoON, AcaoPNA ou AcaoPNB)", new CadastrarAcaoCmd(bolsa)));
		opcoes.add(new Opcao(2, "Remover uma ação", new RemoverAcaoCmd(bolsa)));
		opcoes.add(new Opcao(3, "Disponibilizar uma ação para venda", new DisponibilizarAcaoCmd(bolsa)));
		opcoes.add(new Opcao(4, "Alterar o valor de venda de uma ação", new AlterarVVAcaoCmd(bolsa)));
		opcoes.add(new Opcao(5, "Comprar ação", new ComprarAcaoCmd(bolsa)));
		opcoes.add(new Opcao(6, "Listar ações cadastradas", new ListaAcoesCmd(bolsa)));
		opcoes.add(new Opcao(7, "Consultar dados de uma determinada ação", new ConsultarAcaoCmd(bolsa)));
		opcoes.add(new Opcao(8, "Alterar o valor do Dividendo Fixo (variável de classe dividendoFixo)", new AlterarValorDividendoCmd(bolsa)));
		opcoes.add(new Opcao(9, "Realizar Investimento", new RealizarInvestimento(bolsa)));
		opcoes.add(new Opcao(10, "Votar", new VotarCmd(bolsa)));
		opcoes.add(new Opcao(11, "Atualizar o valor de venda de todas as ações cadastradas " +
				"(existentes) em x%, onde x é um valor fornecido pelo usuário", new AtualizarValorVendaTodasCmd(bolsa)));
		opcoes.add(new Opcao(12, "Sair", new ExitApplicationCmd()));
		
		return opcoes;
	}
	
}
