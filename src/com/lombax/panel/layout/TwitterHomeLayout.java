package com.lombax.panel.layout;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import twitter4j.auth.AccessToken;

import com.lombax.panel.TwitterHomePanel;
import com.lombax.preferences.SocialPrefs;

public class TwitterHomeLayout {
	
	private static JLabel userName;
	private static JScrollPane scrollPane;
	private static JPanel homePanel;
	
	private static final Font pageFont = new Font("Arial", 0, 30);
	
	private static AccessToken accessToken = SocialPrefs.loadTwitterAccessTokens();
	
	public static void layout(JPanel p){
		p.setLayout(new MigLayout("nogrid,flowy,fill","[]","[][100%]"));
		userName = new JLabel("Logged in as: "+accessToken.getScreenName());
		userName.setFont(pageFont);
		
		homePanel = new TwitterHomePanel();
		
		scrollPane = new JScrollPane(homePanel);
		
		p.add(userName,"alignx center");
		p.add(scrollPane,"grow");
	}
}
