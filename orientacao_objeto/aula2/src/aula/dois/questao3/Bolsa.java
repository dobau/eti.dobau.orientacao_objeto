package aula.dois.questao3;

import java.util.ArrayList;

import eti.dobau.KeyboardUtil;

/**
 * Classe utilizada para representar a bolsa de valores
 * 
 * @author dobau
 *
 */
public class Bolsa {
	
	private static ArrayList<Acao> cache = new ArrayList<Acao>();

	public void consultar() {
		String codigo = pedirCodigo();
		
		Acao acao = cache.get(cache.indexOf(new Acao(codigo)));
		
		System.out.println("Código: "+acao.getCodigo());
		System.out.println("Descrição: " + acao.getDescricao());
		System.out.println("Valor: " + acao.getValorCompra());
	}

	public void listarAcoes() {
		System.out.println("Lista de ações: ");
		for (Acao acao : cache) {
			System.out.println("Código: "+acao.getCodigo());
			System.out.println("Descrição: " + acao.getDescricao());
			System.out.println("Valor: " + acao.getValorCompra());
		}
	}

	public void comprarAcao() {
		String codigo = pedirCodigo();
		
		Acao acao = cache.get(cache.indexOf(new Acao(codigo)));
		
		if (acao != null) {
			acao.comprarAcao();
		} else {
			System.out.println("** Ação não encontrada **");
		}
	}

	public void alterarValorVenda() {
		String codigo = pedirCodigo();
		
		Acao acao = cache.get(cache.indexOf(new Acao(codigo)));
		
		if (acao != null) {
			System.out.print("Digite o novo valor de venda: ");
			Double valorVenda = KeyboardUtil.nextDouble();
			acao.setValorVenda(valorVenda);
		} else {
			System.out.println("** Ação não encontrada **");
		}
	}

	public void disponibilizarAcao() {
		String codigo = pedirCodigo();
		
		Acao acao = cache.get(cache.indexOf(new Acao(codigo)));
		
		if (acao != null) {
			System.out.print("Digite o valor de venda: ");
			Double valorVenda = KeyboardUtil.nextDouble();
			acao.disponibilizarVenda(valorVenda);
		} else {
			System.out.println("** Ação não encontrada **");
		}
	}

	public void removerAcao() {
		String codigo = pedirCodigo();
		
		cache.remove(new Acao(codigo));
		System.out.println("** Ação removida com sucesso **");
	}
	
	public void cadastrarAcao() {
		System.out.println("Digite as informações da ação");
		System.out.print("Código: ");
		String codigo = KeyboardUtil.nextLine();
		System.out.print("Descrição: ");
		String descricao = KeyboardUtil.nextLine();
		System.out.print("Venda: ");
		Double venda = KeyboardUtil.nextDouble();
		System.out.print("Compra: ");
		Double compra = KeyboardUtil.nextDouble();
		System.out.println();
		
		cache.add(new Acao(codigo, venda, compra, descricao));
		System.out.println("** Ação cadastrada com sucesso **");
	}
	
	protected String pedirCodigo() {
		System.out.print("Digite o código da ação: ");
		String codigo = KeyboardUtil.nextLine();
		System.out.println();
		
		return codigo;
	}

}
