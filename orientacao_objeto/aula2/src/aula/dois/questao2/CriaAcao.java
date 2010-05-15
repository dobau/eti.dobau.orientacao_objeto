package aula.dois.questao2;

import java.util.ArrayList;
import java.util.Collections;

import eti.dobau.KeyboardUtil;


public class CriaAcao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Cache utilizado para armazenar as ações
		ArrayList<Acao> cache = new ArrayList<Acao>();

		// Recupera todas as informações das ações e armazena em um cache
		for (int i = 0; i < 5; i++) {
			System.out.println(String.format("Digite as informações da acao: %d", i + 1));
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
		}

		// Ordena as ações do cache por ordem decrescente do valor de venda
		Collections.sort(cache, Collections.reverseOrder(new AcaoOrderValorVenda()));

		// Lista todas as ações do cache
		for (Acao acao : cache) {
			System.out.println(String.format("Código: %s", acao.getCodigo()));
			System.out.println(String.format("Descrição: %s", acao.getDescricao()));
			System.out.println(String.format("Valor: %,.2f", acao.getValorCompra()));
			System.out.println();
		}
	}

}
