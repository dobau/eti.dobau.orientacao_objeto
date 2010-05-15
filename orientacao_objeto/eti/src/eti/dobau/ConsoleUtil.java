package eti.dobau;

import org.apache.commons.lang.StringUtils;

public class ConsoleUtil {

	public final static Integer TAMANHO_LINHA = 80;
	
	public static void alerta(String mensagem) {
		alerta(mensagem, TAMANHO_LINHA);
	}
	
	public static void alerta(String mensagem, Integer tamanho) {
		StringUtils.center("** "+ mensagem + " **", tamanho);
	}

	public static void error(String mensagem) {
		StringUtils.center("!! [ERRO] "+ mensagem + " **", TAMANHO_LINHA);
	}
	
}
