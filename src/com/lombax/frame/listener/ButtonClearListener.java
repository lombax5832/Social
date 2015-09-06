package com.lombax.frame.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import com.lombax.frame.MainFrame;

public class ButtonClearListener implements ActionListener{
	
	private JTextArea textArea;
	
	public ButtonClearListener(JTextArea textArea){
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.clearTextArea(textArea);
	}
}
