package com.lombax;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lombax.frame.MainFrame;
import java.awt.Toolkit;

public class Social {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame window = new MainFrame("Social");
					window.setIconImage(Toolkit.getDefaultToolkit().getImage(Social.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
					window.getContentPane().setEnabled(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
