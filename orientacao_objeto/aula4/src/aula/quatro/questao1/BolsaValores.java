package aula.quatro.questao1;

import java.util.Iterator;
import java.util.List;

import aula.quatro.questao1.model.Acao;

public abstract class BolsaValores {
	public abstract void add(Acao acao);
	public abstract Acao find(String codigo);
	public abstract List<Acao> getAll();
	public abstract int remove(Acao acao);
	public abstract int remove(String codigo);
	
	public void addPerToAll(Double per) {
		Iterator<Acao> it = getAll().iterator();
		while (it.hasNext()) {
			Acao acao = it.next();
			Double valorAtual = acao.getValorVenda();
			acao.setValorVenda(valorAtual + (valorAtual * per)/100);
		}
	}
}
