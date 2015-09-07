package com.lombax.frame.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import com.lombax.Social;

public class ButtonClearListener implements ActionListener{
	
	public ButtonClearListener(JTextArea textArea){
		try{
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Social.window.getMainPanel().clearTextArea();
	}
}
