package aula.quatro.questao1.commands.console;

import eti.dobau.Command;

public class ExitApplicationCmd implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}

}
