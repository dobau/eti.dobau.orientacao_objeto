package aula.quatro.questao1.exception;

public class AcaoNotFoundException extends Exception {

	private static final long serialVersionUID = -6884727271435738392L;

	public AcaoNotFoundException(String codigo) {
		super(String.format("Ação (%s) não encontrada", codigo));
	}
	
}
