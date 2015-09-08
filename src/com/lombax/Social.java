package com.lombax;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lombax.frame.MainFrame;
import com.lombax.preferences.SocialPrefs;

public class Social {

	/**
	 * Launch the application.
	 */
	
	public static MainFrame window;
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainFrame("Social");
					window.setIconImage(Toolkit.getDefaultToolkit().getImage(Social.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
					window.getContentPane().setEnabled(false);
					SocialPrefs.loadPrefs();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void log(String log){
		System.out.println(log);
	}

}
