package com.lombax.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.lombax.frame.component.SocialButton;
import com.lombax.worker.TwitterLoginWorker;

import net.miginfocom.swing.MigLayout;

public class TwitterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3555503530933392484L;

	private JButton signIn;
	
	/**
	 * Create the panel.
	 */
	public TwitterPanel() {
		setLayout(new MigLayout("nogrid,flowy,wrap 1,fill"));
		
		signIn = new SocialButton("Sign in with Twitter!",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TwitterLoginWorker().execute();
			}
		});
		add(signIn,"grow");
	}

}
