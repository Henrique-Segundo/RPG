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
		lblID.setBounds(10, 32, 22, 14);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 66, 54, 14);
		
		JLabel lblPre = new JLabel("Preço");
		lblPre.setBounds(10, 100, 27, 14);
		
		JLabel lblEsp = new JLabel("Espaços");
		lblEsp.setBounds(10, 134, 39, 14);
		
		JLabel lblDes = new JLabel("Descrição");
		lblDes.setBounds(10, 167, 46, 14);
		
		textId = new JTextField();
		textId.setBounds(135, 29, 86, 20);
		textId.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(135, 63, 86, 20);
		textNome.setColumns(10);
		
		textPre = new JTextField();
		textPre.setBounds(135, 97, 86, 20);
		textPre.setColumns(10);
		
		textEsp = new JTextField();
		textEsp.setBounds(135, 131, 86, 20);
		textEsp.setColumns(10);
		
		textDes = new JTextField();
		textDes.setBounds(135, 164, 86, 20);
		textDes.setColumns(10);
		
		JButton btnAdi = new JButton("Adicionar");
		btnAdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//clicar no botão adicionar-cadastrar	
			Armadura add = new Armadura();
			add.ID = Integer.parseInt(textId.getText());
			add.nome = textNome.getText();
			add.preco = Integer.parseInt(textPre.getText());
			add.espacos = Integer.parseInt(textEsp.getText());
			add.descricao = textDes.getText();
			add.facilidadeUso = textFac.getText();
			add.bonus = Integer.parseInt(textBon.getText());
			add.penalidade = Integer.parseInt(textPen.getText());
			armaduraDAO.adicionar(add);
			}
		});
		btnAdi.setBounds(486, 28, 79, 23);
		
		JButton btnPes = new JButton("Pesquisar");
		btnPes.setBounds(486, 62, 79, 23);
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
		btnEdi.setBounds(486, 96, 79, 23);
		
		JButton btnExc = new JButton("Excluir");
		btnExc.setBounds(486, 130, 79, 23);
		
		JLabel lblUso = new JLabel("Facilidade de uso");
		lblUso.setBounds(10, 223, 82, 14);
		
		textFac = new JTextField();
		textFac.setBounds(135, 220, 86, 20);
		textFac.setColumns(10);
		
		JLabel lblBon = new JLabel("Bônus");
		lblBon.setBounds(10, 251, 47, 14);
		
		textBon = new JTextField();
		textBon.setBounds(135, 251, 86, 20);
		textBon.setColumns(10);
		
		textPen = new JTextField();
		textPen.setBounds(135, 282, 86, 20);
		textPen.setColumns(10);
		
		JLabel lblPen = new JLabel("Penalidade");
		lblPen.setBounds(13, 283, 52, 14);
		getContentPane().setLayout(null);
		getContentPane().add(lblID);
		getContentPane().add(textId);
		getContentPane().add(btnAdi);
		getContentPane().add(lblNome);
		getContentPane().add(textNome);
		getContentPane().add(btnPes);
		getContentPane().add(lblPre);
		getContentPane().add(textPre);
		getContentPane().add(btnEdi);
		getContentPane().add(lblEsp);
		getContentPane().add(textEsp);
		getContentPane().add(btnExc);
		getContentPane().add(lblDes);
		getContentPane().add(textDes);
		getContentPane().add(lblUso);
		getContentPane().add(lblBon);
		getContentPane().add(lblPen);
		getContentPane().add(textBon);
		getContentPane().add(textFac);
		getContentPane().add(textPen);

	}

}
