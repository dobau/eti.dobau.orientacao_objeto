package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.repository.Repository;
import eti.dobau.ConsoleUtil;
import eti.dobau.KeyboardUtil;

public class VotarCmd extends AbstractConsoleBolsaValoresCmd {

	public VotarCmd(Repository bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		try {
			String codigo = pedirCodigo();
			
			System.out.print("Digite seu voto [y - sim, n - não] (y): ");
			String voto = KeyboardUtil.next();
			System.out.println();
			
			if ("".equals(voto) || voto == null) {
				voto = "y";
			}
	
			if ("y".equalsIgnoreCase(voto)) {
				bolsa.votar(codigo, Boolean.TRUE);
			} else if ("n".equalsIgnoreCase(voto)) {
				bolsa.votar(codigo, Boolean.FALSE);
			} else {
				throw new Exception("Opção inválida");
			}
			
			ConsoleUtil.alerta("Voto realizado com sucesso");
			
		} catch(Exception e) {
			ConsoleUtil.error(e.getMessage());
		}
	}

}
