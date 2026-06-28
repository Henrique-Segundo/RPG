package br.com.rpg.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.Box;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class telaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal frame = new telaPrincipal();
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
	public telaPrincipal() {
		setResizable(false);
		setTitle("Tela principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 565);
		getContentPane().setLayout(null);
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(10, 35, 640, 480);
		getContentPane().add(desktop);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 664, 22);
		getContentPane().add(menuBar);
		
		JMenu menCad = new JMenu("Cadastro");
		menuBar.add(menCad);
		
		JMenuItem menCadArmas = new JMenuItem("Armas");
		menCadArmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//tela cadastrar arma
				TelaCadastrarArma arma = new TelaCadastrarArma();
				arma.setVisible(true);
				desktop.add(arma);
				
			}
		});
		menCadArmas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
		menCad.add(menCadArmas);
		
		JMenuItem menCadArmaduras = new JMenuItem("Armaduras");
		menCadArmaduras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//tela cadsatrar armaduras e escudos
				TelaCadastrarArmadura armadura = new TelaCadastrarArmadura();
				armadura.setVisible(true);
				desktop.add(armadura);
			}
		});
		menCadArmaduras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
		menCad.add(menCadArmaduras);
		
		JMenuItem menCadItensGerais = new JMenuItem("Itens Gerais");
		menCadItensGerais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Tela cadastrar Itens Gerais
				TelaCadastrarItemGeral geral = new TelaCadastrarItemGeral();
				geral.setVisible(true);
				desktop.add(geral);
			}
		});
		menCadItensGerais.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
		menCad.add(menCadItensGerais);
		
		JMenuItem menCadItensSueriores = new JMenuItem("Itens superiores");
		menCadItensSueriores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Abrir tela Intens superiores
				TelaCadastrarItemSuperior superior = new TelaCadastrarItemSuperior();
				superior.setVisible(true);
				desktop.add(superior);
			}
		});
		menCadItensSueriores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));
		menCad.add(menCadItensSueriores);
		
		JMenu menAju = new JMenu("Ajuda");
		menuBar.add(menAju);
		
		JMenuItem menAjuSobre = new JMenuItem("Sobre");
		menAjuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Pagina de sobre
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
			}
		});
		menAju.add(menAjuSobre);
		
		JMenu menOpc = new JMenu("Opções");
		menuBar.add(menOpc);
		
		JMenuItem menOpcSair = new JMenuItem("Sair");
		menOpcSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//codigo para fechar o programa
				int sair = JOptionPane.showConfirmDialog(null,"Sair do programa?","Fechar",JOptionPane.YES_NO_OPTION);
				if(sair == JOptionPane.YES_OPTION) {
					System.exit(0);	
				}
			}
		});
		menOpcSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		menOpc.add(menOpcSair);

	}
}
