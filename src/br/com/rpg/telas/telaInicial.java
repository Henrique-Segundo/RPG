package br.com.rpg.telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.sql.*;
import br.com.rpg.dal.ModuloConexao;
import javax.swing.ImageIcon;

public class telaInicial extends JFrame {
	
	//variaveis para a conexão com o banco de dados
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	//criação da logica da janela (padrão)
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaInicial frame = new telaInicial();
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
	public telaInicial() {
		setResizable(false);
		setTitle("Tela inicial");
		
		//frave visual (codigo alterado tambem quando modificado a parte visual diretamente)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo = new JLabel("Banco de dados - TormentaRPG");
		Titulo.setBounds(143, 11, 152, 14);
		contentPane.add(Titulo);
		
		JLabel subTitulo = new JLabel("Banco de dados de equipamentos");
		subTitulo.setBounds(139, 36, 161, 14);
		contentPane.add(subTitulo);
		
		JLabel descricao = new JLabel("<html>Prototipo para POO 26.01 <br>"
				+ "Alunos:<br>"
				+ "Henrique Segundo<br>"
				+ "João Amauri</html>");
		descricao.setBounds(57, 97, 152, 70);
		contentPane.add(descricao);
		
		JButton btnConectar = new JButton("Iniciar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ao clicar no botão realiza o metodo
				logar();
			}
		});
		btnConectar.setBounds(175, 203, 89, 23);
		contentPane.add(btnConectar);
		
		JLabel textConexao = new JLabel("conexao");
		textConexao.setIcon(null);
		textConexao.setBounds(57, 169, 198, 23);
		contentPane.add(textConexao);
		
		//conexao com o banco de dados
		conexao = ModuloConexao.conector();
		System.out.println(conexao);
		if(conexao != null) {
			//erro na exibição
			//textConexao.setIcon(new ImageIcon(getClass().getResource("/br/com/rpg/icones/bdok.png")));
			textConexao.setText("Conectado ao banco de dados");
		}else {
			//erro na exibição
			//textConexao.setIcon(new ImageIcon(getClass().getResource("/br/com/rpg/icones/bderro.png")));
			textConexao.setText("Não conectado ao banco de dados");
		}
	}
	
	public void logar() {
		//não é realmente um login, vai apenas passar para a pagina principal
		
		//abrir a tela principal
		telaPrincipal principal = new telaPrincipal();
		principal.setVisible(true);
		
		//fechar a tela atual (login)
		this.dispose();
		
		//fechar a conexao com o banco
		try {
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
