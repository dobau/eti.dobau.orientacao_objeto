package aula.dois.questao1;

/**
 * Status da ação.
 */
enum Status {
	DISPONIVEL, 
	INDISPONIVEL
}

/**
 * Classe acao para questão 1.
 * 
 * @author dobau
 *
 */
public class Acao {

	/**
	 * Código da ação.
	 */
	private String codigo;
	
	/**
	 * Descrição da ação.
	 */
	private String descricao;
	
	/**
	 * Valor de compra da ação.
	 */
	private Double valorCompra;
	
	/**
	 * Valor de venda da ação.
	 */
	private Double valorVenda;
	
	/**
	 * Status atual da ação.
	 */
	private Status status = Status.DISPONIVEL;

	/**
	 * Cria uma ação, configurando apenas o código da mesma.
	 * 
	 * Por padrão a ação está dispónivel para venda.
	 * 
	 * @param codigo
	 */
	public Acao(String codigo) {
		this.codigo = codigo;
	}

	public Acao(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * Construtor full, configurando todas as informações da ação.
	 * 
	 * @param c Código da ação.
	 * @param vc Valor de compra
	 * @param vv Valor de venda
	 * @param s Status
	 * @param d Descrição
	 */
	public Acao(String c, Double vc, Double vv, Status s, String d) {
		this(c, vc, vv, d);
		this.status = s;
	}

	/**
	 * Cria uma ação.
	 * 
	 * Por padrão a ação está dispónivel para venda.
	 * 
	 * @param c
	 * @param vc
	 * @param vv
	 * @param d
	 */
	public Acao(String c, Double vc, Double vv, String d) {
		this(c);
		this.valorCompra = vc;
		this.valorVenda = vv;
		this.descricao = d;
	}

	/**
	 * Disponibiliza a ação para venda.
	 * 
	 * @param valorVenda Valor de venda da ação.
	 */
	public void disponibilizarVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
		this.status = Status.DISPONIVEL;
	}

	/**
	 * Compra a ação, tornando a mesma indisponível.
	 */
	public void comprarAcao() {
		this.status = Status.INDISPONIVEL;
		this.valorCompra = this.valorVenda;
		this.valorVenda = 0.0;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Acao) {
			Acao tmp = (Acao) obj;
			return tmp.getCodigo().equals(tmp.getCodigo());
		} else {
			return false;
		}
	}
	
}
