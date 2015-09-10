package com.lombax.panel.layout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

import com.lombax.frame.component.SocialButton;
import com.lombax.image.Images;
import com.lombax.worker.TwitterLoginWorker;

public class TwitterEnterPinLayout {
	
	private static JButton submitPin;
	private static JTextArea pin;
	private static JLabel enterPinLabel;
	private static final Font pageFont = new Font("FF Din", 0, 40);
	
	public static void layout(JPanel p){
		p.setLayout(new MigLayout("nogrid,flowx,fill","[]","[100%][]"));
		
		pin = new JTextArea();
		
		enterPinLabel = new JLabel("Enter the pin from twitter: ");
		
		submitPin = new SocialButton("Submit Pin", new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TwitterLoginWorker().execute();
			}
		});
		pin.setFont(pageFont);
		enterPinLabel.setFont(pageFont);
		submitPin.setFont(pageFont);
		
		p.add(new JLabel(new ImageIcon(Images.TWITTER_ICON_256)),"wrap,align center");
		p.add(enterPinLabel,"split 3,cell 0 1,aligny center");
		p.add(pin,"growx");
		p.add(submitPin,"aligny center");
	}
	
	public static String getPin(){
		return pin.getText();
	}
}
