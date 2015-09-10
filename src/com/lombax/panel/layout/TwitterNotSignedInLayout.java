package com.lombax.panel.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.lombax.Social;
import com.lombax.frame.component.SocialButton;
import com.lombax.preferences.SocialPrefs;
import com.lombax.worker.TwitterLoginWorker;

import net.miginfocom.swing.MigLayout;
import twitter4j.auth.AccessToken;

public class TwitterNotSignedInLayout {
	
	private static JButton signIn;
	
	public static void layout(JPanel p){
		
		p.setLayout(new MigLayout("nogrid,flowy,wrap 1,fill"));
		
		signIn = new SocialButton("Sign in with Twitter!",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AccessToken accessTokens = SocialPrefs.loadTwitterAccessTokens();
				if(accessTokens==null||accessTokens.getToken().length()==0){
					Social.log("Authenticating with Twitter");
					new TwitterLoginWorker().execute();
				}else{
					Social.log("Key is already: "+SocialPrefs.loadTwitterAccessTokens().getToken());
				}
			}
		});
		p.add(signIn,"grow");	
	}
}
