package com.lombax.frame.component;

import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SocialButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7591942584962866696L;

	public SocialButton(String title, ActionListener listener){
		setText(title);
		addActionListener(listener);
//		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setMargin(new Insets(10, 10, 10, 10));
	}
}