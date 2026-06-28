package br.com.rpg.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import rpg.Arma;
import rpg.Armadura;
import br.com.rpg.repositories.ArmaduraRepository;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class TelaCadastrarArmadura extends JInternalFrame {

	//instanciação da ligação com o banco
	ArmaduraRepository armaduraDAO = new ArmaduraRepository();
	
	private static final long serialVersionUID = 1L;
	private JTextField textId;
	private JTextField textNome;
	private JTextField textPre;
	private JTextField textEsp;
	private JTextField textDes;
	private JTextField textFac;
	private JTextField textBon;
	private JTextField textPen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarArmadura frame = new TelaCadastrarArmadura();
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
	public TelaCadastrarArmadura() {
		setNormalBounds(new Rectangle(0, 0, 640, 480));
		setPreferredSize(new Dimension(640, 480));
		setTitle("Armaduras e escudos");
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
		
		JButton btnPes = new JButton("Pesquisar");
		btnPes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clique no botão de pesquisa
				Armadura resultado = armaduraDAO.listarPorId(Integer.parseInt(textId.getText()));
				textNome.setText(resultado.nome);
				textPre.setText(Integer.toString(resultado.preco));
				textEsp.setText(Integer.toString(resultado.espacos));
				textDes.setText(resultado.descricao);
				textFac.setText(resultado.facilidadeUso);
				textBon.setText(Integer.toString(resultado.bonus));
				textPen.setText(Integer.toString(resultado.penalidade));
			}
		});
		
		JButton btnEdi = new JButton("Editar");
		
		JButton btnExc = new JButton("Excluir");
		
		JLabel lblUso = new JLabel("Facilidade de uso");
		
		textFac = new JTextField();
		textFac.setColumns(10);
		
		JLabel lblBon = new JLabel("Bônus");
		
		textBon = new JTextField();
		textBon.setColumns(10);
		
		textPen = new JTextField();
		textPen.setColumns(10);
		
		JLabel lblPen = new JLabel("Penalidade");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(103)
							.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(265)
							.addComponent(btnAdi, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(265)
							.addComponent(btnPes))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblPre)
							.addGap(98)
							.addComponent(textPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(265)
							.addComponent(btnEdi, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblEsp)
							.addGap(86)
							.addComponent(textEsp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(265)
							.addComponent(btnExc, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblDes)
							.addGap(79)
							.addComponent(textDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblUso))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblBon, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(13)
									.addComponent(lblPen)))
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textBon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
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
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblUso))
						.addComponent(textFac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textBon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBon))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textPen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPen)))
					.addGap(148))
		);
		getContentPane().setLayout(groupLayout);

	}

}
