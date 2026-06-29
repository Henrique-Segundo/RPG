package br.com.rpg.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import br.com.rpg.repositories.ItemGeralRepository;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rpg.ItemGeral;


public class TelaCadastrarItemGeral extends JInternalFrame {

	//Instanciação da ligação com o banco
	ItemGeralRepository itemGeralDAO = new ItemGeralRepository();
	
	private static final long serialVersionUID = 1L;
	private JTextField textId;
	private JTextField textNome;
	private JTextField textPre;
	private JTextField textEsp;
	private JTextField textDes;
	private JTextField textEfe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarItemGeral frame = new TelaCadastrarItemGeral();
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
	public TelaCadastrarItemGeral() {
		setPreferredSize(new Dimension(640, 480));
		setTitle("Item geral");
		setBounds(0, 0, 640, 480);
		
		JLabel lblID = new JLabel("Id");
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblPre = new JLabel("Preço");
		
		JLabel lblEsp = new JLabel("Espaços");
		
		JLabel lblDes = new JLabel("Descrição");
		
		textId = new JTextField();
		textId.setColumns(10);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		
		textPre = new JTextField();
		textPre.setColumns(10);
		
		textEsp = new JTextField();
		textEsp.setColumns(10);
		
		textDes = new JTextField();
		textDes.setColumns(10);
		
		JButton btnAdi = new JButton("Adicionar");
		btnAdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//clicar no botão adicionar-cadastrar	
			ItemGeral add = new ItemGeral();
			add.ID = Integer.parseInt(textId.getText());
			add.nome = textNome.getText();
			add.preco = Integer.parseInt(textPre.getText());
			add.espacos = Integer.parseInt(textEsp.getText());
			add.descricao = textDes.getText();
			add.efeito = textEfe.getText();
			itemGeralDAO.adicionar(add);
			}
		});
		
		JButton btnPes = new JButton("Pesquisar");
		btnPes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//clique no botão pesquisar
			ItemGeral resultado = itemGeralDAO.listarPorId(Integer.parseInt(textId.getText()));
			textNome.setText(resultado.nome);
			textPre.setText(Integer.toString(resultado.preco));
			textEsp.setText(Integer.toString(resultado.espacos));
			textDes.setText(resultado.descricao);
			textEfe.setText(resultado.efeito);
			}
		});
		
		JButton btnEdi = new JButton("Editar");
		btnEdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//clicar no botão editar
				ItemGeral att = new ItemGeral();
				att.ID = Integer.parseInt(textId.getText());
				att.nome = textNome.getText();
				att.preco = Integer.parseInt(textPre.getText());
				att.espacos = Integer.parseInt(textEsp.getText());
				att.descricao = textDes.getText();
				att.efeito = textEfe.getText();
				itemGeralDAO.editar(att.ID, att);
			}
		});
		
		JButton btnExc = new JButton("Excluir");
		
		JLabel lblEfe = new JLabel("Efeito");
		
		textEfe = new JTextField();
		textEfe.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(103)
							.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(265)
							.addComponent(btnAdi, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(265)
							.addComponent(btnPes, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPre, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(98)
							.addComponent(textPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(265)
							.addComponent(btnEdi, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEsp, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addComponent(textEsp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(265)
							.addComponent(btnExc, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDes)
								.addComponent(lblEfe))
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textEfe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblID))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAdi))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNome))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPes))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblPre))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnEdi))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblEsp))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textEsp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnExc))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDes))
						.addComponent(textDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEfe)
						.addComponent(textEfe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(214, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
