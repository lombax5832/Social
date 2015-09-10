package com.lombax.panel.layout;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lombax.preferences.SocialPrefs;

import net.miginfocom.swing.MigLayout;

public class TwitterHomeLayout {
	
	private static JLabel userName;
	
	private static final Font pageFont = new Font("Arial", 0, 30);
	
	public static void layout(JPanel p){
		p.setLayout(new MigLayout("nogrid,flowx,fill","[]","[]"));
		userName = new JLabel("Logged in as: "+SocialPrefs.loadTwitterAccessTokens().getScreenName());
		userName.setFont(pageFont);
		
		p.add(userName,"alignx center, aligny top");
	}
}
