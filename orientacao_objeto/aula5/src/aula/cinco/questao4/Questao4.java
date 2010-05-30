package aula.cinco.questao4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Questao4 extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel lbNumero;
	private JLabel lbResultado;
	private JTextField txNumero;
	private JTextField txResultado;
	private JButton btCalcular;
	private JButton btLimpar;

	public Questao4() {
		panel = new JPanel();
		lbNumero = new JLabel("Número:");
		lbResultado = new JLabel("Resultado:");
		txNumero = new JTextField();
		txResultado = new JTextField();
		btCalcular = new JButton("Calcular");
		btLimpar = new JButton("Limpar");

		this.add(panel);

		panel.add(lbNumero);
		panel.add(lbResultado);
		panel.add(txNumero);
		panel.add(txResultado);
		panel.add(btCalcular);
		panel.add(btLimpar);

		panel.setLayout(null);

		lbNumero.setSize(80, 20);
		lbNumero.setLocation(10, 10);

		txNumero.setSize(80, 20);
		txNumero.setLocation(100, 10);

		lbResultado.setSize(80, 20);
		lbResultado.setLocation(10, 50);

		txResultado.setSize(150, 20);
		txResultado.setLocation(100, 50);

		btCalcular.setSize(80, 20);
		btCalcular.setLocation(10, 100);

		btLimpar.setSize(80, 20);
		btLimpar.setLocation(100, 100);

		btCalcular.addActionListener(this);
		btLimpar.addActionListener(this);

		this.setTitle("Questão 1");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btCalcular)) {
			calcular();
		}

		if (e.getSource().equals(btLimpar)) {
			limpar();
		}
	}

	private void limpar() {
		txNumero.setText("");
		txResultado.setText("");
	}

	private void calcular() {
		String valor = txNumero.getText();
		int num = Integer.parseInt(valor);

		if ((num % 5 == 0) && (num % 7 == 0)) {
			txResultado.setText("fizzbuzz");
		} else if (num % 5 == 0) {
			txResultado.setText("fizz");
		} else if (num % 7 == 0) {
			txResultado.setText("buzz");
		}
	}

	public static void main(String[] args) {
		new Questao4();
	}

}
