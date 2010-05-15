package aula.dois.questao3;

import eti.dobau.Do;
import eti.dobau.DynamicCall;

public class Opcao implements Comparable<Opcao> {

	private Integer valor;
	private String mensagem;
	private Do call;
	
//	public Opcao(Integer valor, String mensagem, String metodo) {
//		this(valor, mensagem, new Do(){
//			@Override
//			public void execute() {
//				Bolsa bolsa = new 
//			}
//		});
//	}
	
	public Opcao(Integer valor, String mensagem, Do call) {
		this.valor = valor;
		this.mensagem = mensagem;
		this.call = call;
	}

//	public Opcao(int valor, String mensagem, Do x) {
//		this(valor, mensagem, new DynamicCall(x, "execute"));
//	}

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
