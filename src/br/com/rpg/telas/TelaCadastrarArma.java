package br.com.rpg.telas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Dimension;

public class TelaCadastrarArma extends JInternalFrame {

	private static final long serialVersionUID = 1L;

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
		
		setBorder(null);
		setPreferredSize(new Dimension(640, 480));
		setBounds(0, 0, 640, 480);

	}

}