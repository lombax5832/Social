package com.lombax.frame.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import com.lombax.frame.MainFrame;
import com.lombax.frame.SocialPrefs;
import com.lombax.frame.listener.ButtonClearListener;

public class SocialToolBar extends JToolBar {

	private static final long serialVersionUID = -8345972107639260969L;

	private JButton btnClear;
	private JButton btnSave;
	private JButton btnLoad;
	
//	private Container c = getRootPane();
	
	public SocialToolBar(String name){
		super(name);
		
		btnSave = new SocialButton(" Save ",new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SocialPrefs.savePrefs();
			}
			
		});
		
		btnLoad = new SocialButton(" Load ",new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SocialPrefs.loadPrefs();
			}
			
		});
		

		btnClear = new SocialButton(" Clear ",new ButtonClearListener(MainFrame.getTextArea()));
		btnClear.setFocusable(false);
		add(btnClear);
		addSeparator();
		
		btnSave.setFocusable(false);
		add(btnSave);
		
		btnLoad.setFocusable(false);
		add(btnLoad);
	}
	
}
