package aula.dois.questao1;

import eti.dobau.Command;

public class Opcao implements Comparable<Opcao> {

	private Integer valor;
	private String mensagem;
	private Command call;
	
	public Opcao(Integer valor, String mensagem, Command call) {
		this.valor = valor;
		this.mensagem = mensagem;
		this.call = call;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void execute() {
		call.execute();
	}

	@Override
	public int compareTo(Opcao o) {
		return valor.compareTo(o.getValor());
	}

}
