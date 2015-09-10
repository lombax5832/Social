package com.lombax.panel.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import twitter4j.auth.AccessToken;

import com.lombax.Social;
import com.lombax.frame.component.SocialButton;
import com.lombax.panel.TwitterPanel;
import com.lombax.preferences.SocialPrefs;
import com.lombax.worker.TwitterLoginURLWorker;

public class TwitterNotSignedInLayout {
	
	private static JButton signIn;
	
	private static TwitterLoginURLWorker twitLoginURLWorker;
	
	public static void layout(final JPanel p){
		p.setLayout(new MigLayout("nogrid,flowy,fill"));
		signIn = new SocialButton("Sign in with Twitter!",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AccessToken accessTokens = SocialPrefs.loadTwitterAccessTokens();
				if(accessTokens==null||accessTokens.getToken().length()==0){
					Social.log("Authenticating with Twitter");
					twitLoginURLWorker = new TwitterLoginURLWorker();
					twitLoginURLWorker.execute();
					TwitterPanel.panelToRender(TwitterPanel.Display.LOGIN_PAGE, p);
				}else{
					Social.log("Key is already: "+SocialPrefs.loadTwitterAccessTokens().getToken());
				}
			}
		});
		p.add(signIn,"grow");	
	}
	
	public static TwitterLoginURLWorker getTwitLoginWorker(){
		return twitLoginURLWorker;
	}
}
