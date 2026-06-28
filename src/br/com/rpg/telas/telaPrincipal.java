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
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;

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
		setBounds(100, 100, 745, 486);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 729, 22);
		getContentPane().add(menuBar);
		
		JMenu MenCad = new JMenu("Cadastro");
		menuBar.add(MenCad);
		
		JMenuItem MenCadArmas = new JMenuItem("Armas");
		MenCadArmas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
		MenCad.add(MenCadArmas);
		
		JMenuItem MenCadArmaduras = new JMenuItem("Armaduras");
		MenCadArmaduras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
		MenCad.add(MenCadArmaduras);
		
		JMenuItem MenCadItensGerais = new JMenuItem("Itens Gerais");
		MenCadItensGerais.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
		MenCad.add(MenCadItensGerais);
		
		JMenuItem MenCadItensSueriores = new JMenuItem("Itens superiores");
		MenCadItensSueriores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));
		MenCad.add(MenCadItensSueriores);
		
		JMenu MenAju = new JMenu("Ajuda");
		menuBar.add(MenAju);
		
		JMenuItem MenAjuSobre = new JMenuItem("Sobre");
		MenAju.add(MenAjuSobre);
		
		JMenu MenOpc = new JMenu("Opções");
		menuBar.add(MenOpc);
		
		JMenuItem MenOpcSair = new JMenuItem("Sair");
		MenOpcSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		MenOpc.add(MenOpcSair);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 33, 709, 403);
		getContentPane().add(desktopPane);

	}
}
