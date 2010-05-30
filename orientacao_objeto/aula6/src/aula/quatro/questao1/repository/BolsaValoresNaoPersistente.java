package aula.quatro.questao1.repository;

import java.util.Iterator;

import aula.quatro.questao1.exception.AcaoNotFoundException;
import aula.quatro.questao1.exception.TypeAcaoException;
import aula.quatro.questao1.model.Acao;
import aula.quatro.questao1.model.AcaoON;
import aula.quatro.questao1.model.AcaoPNA;
import aula.quatro.questao1.model.AcaoPNB;
import aula.quatro.questao1.model.Status;

public abstract class BolsaValoresNaoPersistente implements Repository {

	public void addPerToAll(Double per) {
		Iterator<Acao> it = getAll().iterator();
		while (it.hasNext()) {
			Acao acao = it.next();
			Double valorAtual = acao.getValorVenda();
			acao.setValorVenda(valorAtual + (valorAtual * per) / 100);
		}
	}

	@Override
	public void alterarDividendo(Double valor) {
		AcaoPNB.atualizarDividendo(valor);
	}

	@Override
	public void alterarValorVenda(String codigo, Double valorVenda) throws AcaoNotFoundException {
		Acao acao = get(codigo);
		acao.setValorVenda(valorVenda);
	}

	@Override
	public void comprarAcao(String codigo) throws AcaoNotFoundException {
		Acao acao = get(codigo);
		acao.setStatus(Status.INDISPONIVEL);
		acao.setValorCompra(acao.getValorVenda());
		acao.setValorVenda(0.0);
	}

	@Override
	public void disponibilizarVenda(String codigo, Double valorVenda) throws AcaoNotFoundException {
		Acao acao = get(codigo);
		disponibilizarVenda(acao, valorVenda);
	}

	public void disponibilizarVenda(Acao acao, Double valorVenda) throws AcaoNotFoundException {
		acao.setValorVenda(valorVenda);
		acao.setStatus(Status.DISPONIVEL);
	}

	@Override
	public void realizarInvestimento(String codigo) throws AcaoNotFoundException, TypeAcaoException {
		Acao acao = get(codigo);
		
		if (acao instanceof AcaoPNA) {
			AcaoPNA acaoPN = (AcaoPNA) acao;
			
			Double valorVenda = acaoPN.getValorVenda();
			Double valorCompra = acaoPN.getValorCompra();
			
			// Lucro de compra é 10% do valor de compra da ação
			Double valorLucro = (valorCompra * 10/100) + valorCompra;
			
			if (valorVenda > valorLucro) {
				disponibilizarVenda(acao, valorVenda);
			} else {
				disponibilizarVenda(acao, valorLucro);
			}
		} else if (acao instanceof AcaoPNB) {
			AcaoPNB acaoPN = (AcaoPNB) acao;
			disponibilizarVenda(acaoPN, AcaoPNB.getDividendo());
		} else {
			throw new TypeAcaoException(codigo, "PN");
		}
	}

	@Override
	public void votar(String codigo, Boolean voto)
			throws AcaoNotFoundException, TypeAcaoException {
		Acao acao = get(codigo);

		if (acao instanceof AcaoON) {
			((AcaoON) acao).votar(voto);
		} else {
			throw new TypeAcaoException(codigo, "ON");
		}
	}

	public Acao get(String codigo) throws AcaoNotFoundException {
		Acao acao = find(codigo);

		if (acao == null) {
			throw new AcaoNotFoundException(codigo);
		} else {
			return acao;
		}
	}

}
