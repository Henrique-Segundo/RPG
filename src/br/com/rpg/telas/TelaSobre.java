package br.com.rpg.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class TelaSobre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaSobre() {
		setResizable(false);
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nome = new JLabel("Sistema de banco de dados para Tormenta 20 RPG");
		nome.setBounds(63, 11, 340, 14);
		contentPane.add(nome);
		
		JLabel desenvolvedores = new JLabel("<html>Prototipo para POO 26.01 <br>Alunos:<br>Ântonio Pedro<br>Henrique Segundo<br>João Amauri</html>");
		desenvolvedores.setBounds(65, 81, 164, 92);
		contentPane.add(desenvolvedores);
		
		JLabel disciplina = new JLabel("Desenvolvido para a disciplina de Programação Orientada a Objetos");
		disciplina.setBounds(63, 184, 332, 14);
		contentPane.add(disciplina);

	}

}
