package eti.dobau;

import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe utilitária utilizada para recuperar os dados do teclado.
 * 
 * @author dobau
 * 
 */
public class KeyboardUtil {
	
	private static final Integer MAX_QTD_TENTATIVAS = 3;

	/**
	 * Scanner utilizado como singleton.
	 */
	private static Scanner scanner = getScannerDefault();

	/**
	 * Configura o scanner utilizado.
	 * 
	 * @param scanner
	 */
	public static void setScanner(Scanner scanner) {
		KeyboardUtil.scanner = scanner;
	}

	/**
	 * Retorna o scanner utilizado no momento, caso nenhum seja usado então é retornado
	 * o default.
	 * 
	 * @return Scanner
	 */
	public static Scanner getScanner() {
		return scanner;
	}
	
	/**
	 * Retorna o Scanner(System.in) utilizado como default.
	 * 
	 * @return Scanner
	 */
	public static Scanner getScannerDefault() {
		return new Scanner(System.in);
	}

	/**
	 * Retorna toda a string digitada na linha
	 * 
	 * @return String
	 */
	public static String nextLine() {
		return (String) execute("nextLine");
	}

	/**
	 * Retorna o valor digitado do tipo double
	 * 
	 * @return Double
	 */
	public static Double nextDouble() {
		return (Double) execute("nextDouble");
	}

	/**
	 * Retorna o valor digitado do tipo Integer
	 * 
	 * @return Integer
	 */
	public static Integer nextInt() {
		return (Integer) execute("nextInt");
	}
	
	/**
	 * Retorna o valor digitado do tipo String
	 * 
	 * @return String
	 */
	public static String next() {
		return (String) execute("next");
	}

	/**
	 * 
	 * @param metodo
	 * @return
	 */
	private static Object execute(String nomeMetodo) {

		int qtdTentativas = 0;
		
		// Enquanto um valor válido não for digitado o valor será requisitado
		while (true) {
			try {

				// Executa o método next*
				try {
					qtdTentativas++;
					
					Method metodo = Scanner.class.getMethod(nomeMetodo, new Class[]{});
					
					Object retorno = metodo.invoke(getScanner());
					
					// Descarta o que foi digitado, pela lógica deveria ser usado o método reset,
					// porém nesse link {http://forums.sun.com/thread.jspa?threadID=5339871} é
					// explicado o porque do uso do método nextLine.
					if (!"nextLine".equals(nomeMetodo)) {
						getScanner().nextLine();
					}
					
					return retorno;
				} catch (Exception e) {
					// Verifica se o tipo de excessão ocorrida foi devido ao formato do texto digitado
					// se foi então ele é tratado posteriormente
					if (e.getCause() instanceof InputMismatchException) {
						throw (InputMismatchException) e.getCause();
					} else {
						throw new RuntimeException(e);
					}
				}

			} catch (InputMismatchException e) {
				
				// Caso o número de tentativas tenha sido maior ou igual a
				// MAX_QTD_TENTATIVAS, então não é permitido retentar
				if (qtdTentativas <= MAX_QTD_TENTATIVAS) {

					// Dá um "flush" no texto digitado pois alguma exceção ocorreu então não foi executado
					// o nextLine anterior
					getScanner().nextLine();
	
					System.out.print("Valor invalido, repita: ");
				} else {
					// Lança uma excessão informando que o usuário já tentou mais de 3 vezes
					throw new RuntimeException(
							String.format("Você digitou um valor inválido mais de %d vezes",
									MAX_QTD_TENTATIVAS));
				}
			}
		}

	}

}
