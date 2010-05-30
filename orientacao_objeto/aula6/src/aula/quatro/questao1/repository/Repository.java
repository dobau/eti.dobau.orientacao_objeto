package aula.quatro.questao1.repository;

import java.util.List;

import aula.quatro.questao1.exception.AcaoNotFoundException;
import aula.quatro.questao1.exception.TypeAcaoException;
import aula.quatro.questao1.model.Acao;

public interface Repository {
	public void add(Acao acao);
	public Acao find(String codigo);
	public List<Acao> getAll();
	public int remove(Acao acao);
	public int remove(String codigo);
	public void addPerToAll(Double per);
	public void alterarDividendo(Double valor);
	public void alterarValorVenda(String codigo, Double valorVenda) throws AcaoNotFoundException;
	public void comprarAcao(String codigo) throws AcaoNotFoundException;
	public void realizarInvestimento(String codigo) throws AcaoNotFoundException, TypeAcaoException;
	public void votar(String codigo, Boolean voto) throws AcaoNotFoundException, TypeAcaoException;
	public void disponibilizarVenda(String codigo, Double valorVenda) throws AcaoNotFoundException;
}
