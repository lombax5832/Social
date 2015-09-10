package com.lombax.frame.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import com.lombax.Social;
import com.lombax.panel.TwitterPanel;
import com.lombax.panel.TwitterPanel.Display;
import com.lombax.preferences.SocialPrefs;

public class SocialToolBar extends JToolBar {

	private static final long serialVersionUID = -8345972107639260969L;

	//create buttons
	private JButton btnClear;
	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnWipe;
//	private JButton btnMail;
	
	public SocialToolBar(String name){
		super(name);
		
		// Save Button
		btnSave = new SocialButton(" Save ",new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SocialPrefs.saveTextArea();
			}
			
		});
		
		// Load Button
		btnLoad = new SocialButton(" Load ",new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SocialPrefs.loadTextArea();
			}
			
		});
		
		// Clear Button
		try{
			btnClear = new SocialButton(" Clear ",new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Social.window.getMainPanel().clearTextArea();
				}
			});
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		
		// Wipe Button
		btnWipe = new SocialButton(" Wipe ",new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SocialPrefs.clearPrefs();
				Social.resetTwitter();
				Social.window.getTwitPanel();
				TwitterPanel.panelToRender(Display.LOGIN_BUTTON, Social.window.getTwitPanel());
			}
		});
		
//		btnMail = new SocialButton(" Mail ",new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//			
//		});
		
		// Add buttons to toolbar
		try{
		btnClear.setFocusable(false);
		add(btnClear);
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		addSeparator();
		
		btnSave.setFocusable(false);
		add(btnSave);
		
		btnLoad.setFocusable(false);
		add(btnLoad);
		
		addSeparator();
		
		btnWipe.setFocusable(false);
		add(btnWipe);
	}
	
}
