package br.com.rpg.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import br.com.rpg.repositories.ArmaRepository;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rpg.Arma;

public class TelaCadastrarArma extends JInternalFrame {

	ArmaRepository armaDAO = new ArmaRepository();
	
	private static final long serialVersionUID = 1L;
	private JTextField textId;
	private JTextField textNome;
	private JTextField textPre;
	private JTextField textEsp;
	private JTextField textDes;
	private JTextField textFac;
	private JTextField textPro;
	private JTextField textDan;
	private JTextField textCri;
	private JTextField textAlc;
	private JTextField textTip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarArma frame = new TelaCadastrarArma();
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
	public TelaCadastrarArma() {
		setTitle("Armas");
		
		setBorder(null);
		setPreferredSize(new Dimension(640, 480));
		setBounds(0, 0, 640, 480);
		
		JLabel lblID = new JLabel("Id");
		
		JLabel lblNome = new JLabel("Nome");
		
		JLabel lblPre = new JLabel("Preço");
		
		JLabel lblEsp = new JLabel("Espaços");
		
		JLabel lblDes = new JLabel("Descrição");
		
		JLabel lbluso = new JLabel("Facilidade de uso");
		
		JLabel lblPro = new JLabel("Proposito");
		
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
		
		textFac = new JTextField();
		textFac.setColumns(10);
		
		textPro = new JTextField();
		textPro.setColumns(10);
		
		JLabel lblDan = new JLabel("Dano");
		
		textDan = new JTextField();
		textDan.setColumns(10);
		
		textCri = new JTextField();
		textCri.setColumns(10);
		
		JLabel lblCri = new JLabel("Critico");
		
		textAlc = new JTextField();
		textAlc.setColumns(10);
		
		JLabel lblAlc = new JLabel("Alcance");
		
		textTip = new JTextField();
		textTip.setColumns(10);
		
		JLabel lblTip = new JLabel("Tipo");
		
		JButton btnAdi = new JButton("Adicionar");
		
		JButton btnPes = new JButton("Pesquisar");
		btnPes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Ao clicar no botão pesquisar
			Arma resultado = armaDAO.listarPorId(Integer.parseInt(textId.getText()));
			textNome.setText(resultado.nome);
			textPre.setText(Integer.toString(resultado.preco));
			textEsp.setText(Integer.toString(resultado.espacos));
			textDes.setText(resultado.descricao);
			textFac.setText(resultado.facilidadeUso);
			textPro.setText(resultado.proposito);
			textDan.setText(resultado.dano);
			textCri.setText(resultado.critico);
			textAlc.setText(resultado.alcance);
			textTip.setText(resultado.tipo);
			}
		});
		
		JButton btnEdi = new JButton("Editar");
		
		JButton btnExc = new JButton("Excluir");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPro)
						.addComponent(lblDan)
						.addComponent(lbluso)
						.addComponent(lblDes)
						.addComponent(lblEsp)
						.addComponent(lblPre)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCri)
						.addComponent(lblAlc)
						.addComponent(lblTip))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAlc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEsp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnPes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAdi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEdi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdi))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(btnPes))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPre)
						.addComponent(btnEdi))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEsp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEsp)
						.addComponent(btnExc))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDes))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbluso))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPro))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDan))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCri))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textAlc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlc))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textTip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTip))
					.addGap(87))
		);
		getContentPane().setLayout(groupLayout);

	}
}