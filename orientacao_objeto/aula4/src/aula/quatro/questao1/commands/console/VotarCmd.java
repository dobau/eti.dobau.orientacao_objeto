package aula.quatro.questao1.commands.console;

import aula.quatro.questao1.BolsaValores;
import aula.quatro.questao1.model.Acao;
import aula.quatro.questao1.model.AcaoON;
import eti.dobau.KeyboardUtil;

public class VotarCmd extends AbstractConsoleAcaoCmd {

	public VotarCmd(BolsaValores bolsa) {
		super(bolsa);
	}

	@Override
	public void execute() {
		String codigo = pedirCodigo();
		
		Acao acao = bolsa.find(codigo);
		
		if (acao == null) {
			System.out.println("Ação não encontrada");
		} else {
			if (acao instanceof AcaoON) {
				
				System.out.print("Digite seu voto [y - sim, n - não] (y):");
				String voto = KeyboardUtil.next();
				
				if ("".equals(voto) || voto == null) {
					voto = "y";
				}
	
				if (voto.equalsIgnoreCase("y") || voto.equalsIgnoreCase("n")) {
					((AcaoON)acao).votar(voto.equalsIgnoreCase("y"));
				} else {
					System.out.println("Opção inválida");
				}
				
			} else {
				System.out.println("Ação não é do tipo ON");
			}
		}
	}

}
