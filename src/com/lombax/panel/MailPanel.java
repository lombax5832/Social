package com.lombax.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import com.lombax.Social;
import com.lombax.frame.component.SocialButton;

public class MailPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3884626573533469831L;

	private JLabel lEmail;
	
	private JTextField tfEmail;
	
	private JTextArea taMessage;
	
	private JButton btnSend;
	/**
	 * Create the panel.
	 */
	public MailPanel() {
		
		lEmail = new JLabel("Email: ");
		tfEmail = new JTextField();
		taMessage = new JTextArea();
		btnSend = new SocialButton("Send",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Social.log("Send Clicked.");
			}
		});
		
		setLayout(new MigLayout("fill","[]","[][100%][]"));
		
		add(lEmail, "alignx left,aligny center,split 2");
		add(tfEmail, "growx,aligny center,wrap");
		add(taMessage, "grow,center,wrap");
		add(btnSend,"growx,center");
	}

}
