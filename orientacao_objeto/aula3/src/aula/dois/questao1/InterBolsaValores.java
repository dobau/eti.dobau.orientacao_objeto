package aula.dois.questao1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import aula.dois.questao1.commands.console.AlterarVVAcaoCmd;
import aula.dois.questao1.commands.console.CadastrarAcaoCmd;
import aula.dois.questao1.commands.console.ComprarAcaoCmd;
import aula.dois.questao1.commands.console.ConsultarAcaoCmd;
import aula.dois.questao1.commands.console.DisponibilizarAcaoCmd;
import aula.dois.questao1.commands.console.ExitApplicationCmd;
import aula.dois.questao1.commands.console.ListaAcoesCmd;
import aula.dois.questao1.commands.console.RemoverAcaoCmd;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

/**
 * Classe que representa a camada de apresentação.
 * 
 * @author dobau
 * @since 05/05/2010
 *
 */
public class InterBolsaValores {

	private final static int TAMANHO_LINHA = 80;
	
	final BolsaValores bolsa;
	private List<Opcao> opcoes;

	public InterBolsaValores(BolsaValores bolsa, List<Opcao> opcoes) {
		if (bolsa == null) {
			this.bolsa = bolsa;
		} else {
			this.bolsa = new BolsaValores(); 
		}
		
		if (opcoes == null) {
			initMenu();
		} else {
			initMenu(opcoes);
		}
	}
	
	public InterBolsaValores(BolsaValores bolsa) {
		this(bolsa, null);
	}

	public InterBolsaValores(List<Opcao> opcoes) {
		this(null, opcoes);
	}

	public InterBolsaValores() {
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
			String mensagem = StringUtils.rightPad(opcao.getMensagem(), TAMANHO_LINHA - (2 + 1 + 2 + 3 + 3));
			// 2 + 1 + 2 + 3 + X + 3
			String line = String.format("%s %s - %s %s", "==", valor, mensagem, "==");
			System.out.println(line);
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

	public BolsaValores getBolsa() {
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
		opcoes.add(new Opcao(1, "Cadastrar uma ação", new CadastrarAcaoCmd(bolsa)));
		opcoes.add(new Opcao(2, "Remover uma ação", new RemoverAcaoCmd(bolsa)));
		opcoes.add(new Opcao(3, "Disponibilizar uma ação para venda", new DisponibilizarAcaoCmd(bolsa)));
		opcoes.add(new Opcao(4, "Alterar o valor de venda de uma ação", new AlterarVVAcaoCmd(bolsa)));
		opcoes.add(new Opcao(5, "Comprar ação", new ComprarAcaoCmd(bolsa)));
		opcoes.add(new Opcao(6, "Listar ações cadastradas", new ListaAcoesCmd(bolsa)));
		opcoes.add(new Opcao(7, "Consultar dados de uma determinada ação", new ConsultarAcaoCmd(bolsa)));
		opcoes.add(new Opcao(8, "Sair", new ExitApplicationCmd(bolsa)));
		
		return opcoes;
	}
	
}
