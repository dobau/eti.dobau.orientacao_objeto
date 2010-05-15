package aula.dois.questao3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import eti.dobau.Do;
import eti.dobau.KeyboardUtil;

public class BolsaView {

	final Bolsa bolsa;
	private List<Opcao> opcoes;

	public BolsaView(Bolsa bolsa) {
		this.bolsa = bolsa;
		configurarOpcoesMenu(getDefaultOpcoesMenu());
	}
	
	public List<Opcao> getDefaultOpcoesMenu() {
		List<Opcao> opcoes = new ArrayList<Opcao>();
		opcoes.add(new Opcao(1, "Cadastrar uma ação", new Do() {
			public void execute() {
				bolsa.cadastrarAcao();
			}
		}));
		opcoes.add(new Opcao(2, "Remover uma ação", new Do() {
			public void execute() {
				bolsa.removerAcao();
			}
		}));
		opcoes.add(new Opcao(3, "Disponibilizar uma ação para venda", new Do() {
			public void execute() {
				bolsa.disponibilizarAcao();
			}
		}));
		opcoes.add(new Opcao(4, "Alterar o valor de venda de uma ação", new Do() {
			public void execute() {
				bolsa.alterarValorVenda();
			}
		}));
		opcoes.add(new Opcao(5, "Comprar ação", new Do() {
			public void execute() {
				bolsa.comprarAcao();
			}
		}));
		opcoes.add(new Opcao(6, "Listar ações cadastradas", new Do() {
			public void execute() {
				bolsa.listarAcoes();
			}
		}));
		opcoes.add(new Opcao(7, "Consultar dados de uma determinada ação", new Do() {
			public void execute() {
				bolsa.consultar();
			}
		}));
		opcoes.add(new Opcao(8, "Sair", new Do() {
			public void execute() {
				System.exit(0);
			}
		}));
		
		return opcoes;
	}
	
	public void configurarOpcoesMenu(List<Opcao> opcoes) {
		this.opcoes = opcoes;
		Collections.sort(opcoes);
	}

	public void showMenu() {
		int tamanhoLinha = 80;
		
		String linha = StringUtils.repeat("=", tamanhoLinha);
		System.out.println(linha);
		System.out.println(String.format("%s%s%s", "==", StringUtils.center("MENU", tamanhoLinha - 4), "=="));
		System.out.println(linha);

		for (Opcao opcao : opcoes) {
			String valor = StringUtils.rightPad(opcao.getValor().toString(), 2);
			String mensagem = StringUtils.rightPad(opcao.getMensagem(), tamanhoLinha - (2 + 1 + 2 + 3 + 3));
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
			System.out.println("Opção inexistente.");
			System.out.println();
		}
	}

	public Bolsa getBolsa() {
		return bolsa;
	}

	public List<Opcao> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}
	
}
