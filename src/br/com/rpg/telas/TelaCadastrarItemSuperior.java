package br.com.rpg.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import br.com.rpg.repositories.ItemGeralRepository;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import rpg.ItemSuperior;
import br.com.rpg.repositories.ItemSuperiorRepository;

public class TelaCadastrarItemSuperior extends JInternalFrame {

		//Instanciação da ligação com o banco
		ItemSuperiorRepository itemSuperiorDAO = new ItemSuperiorRepository();
	
	private static final long serialVersionUID = 1L;
	private JTextField textId;
	private JTextField textEfe;
	private JTextField textDes;
	private JTextField textMod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarItemSuperior frame = new TelaCadastrarItemSuperior();
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
	public TelaCadastrarItemSuperior() {
		setPreferredSize(new Dimension(640, 480));
		setTitle("Item superior");
		setBounds(0, 0, 640, 480);
		
		JLabel lblID = new JLabel("Id");
		
		textId = new JTextField();
		textId.setColumns(10);
		
		JLabel lblEfe = new JLabel("Efeito");
		
		textEfe = new JTextField();
		textEfe.setColumns(10);
		
		JButton btnAdi = new JButton("Adicionar");
		btnAdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//clicar no botão adicionar-cadastrar
			ItemSuperior add = new ItemSuperior();
			add.id = Integer.parseInt(textId.getText());
			add.modificacao =  textMod.getText();
			add.efeito =  textEfe.getText();
			add.descricao = textDes.getText();
			itemSuperiorDAO.adicionar(add);
			}
		});
		
		JButton btnPes = new JButton("Pesquisar");
		btnPes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//clique no botão pesquisar
			ItemSuperior resultado = itemSuperiorDAO.listarPorId(Integer.parseInt(textId.getText()));
			textMod.setText(resultado.modificacao);
			textEfe.setText(resultado.efeito);
			textDes.setText(resultado.descricao);
			
			}
		});
		
		JButton btnEdi = new JButton("Editar");
		
		JButton btnExc = new JButton("Excluir");
		
		JLabel lblDes = new JLabel("Descrição");
		
		textDes = new JTextField();
		textDes.setColumns(10);
		
		textMod = new JTextField();
		textMod.setColumns(10);
		
		JLabel lblMod = new JLabel("Modificação");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDes)
						.addComponent(lblEfe, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMod))
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEfe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdi, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnPes, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEdi, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnExc, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
					.addGap(91))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdi)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(11)
								.addComponent(btnPes))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnEdi)
								.addGap(11)
								.addComponent(btnExc)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblID)
								.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMod))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEfe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEfe))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDes))))
					.addContainerGap(297, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
