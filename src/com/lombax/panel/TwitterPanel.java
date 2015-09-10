package com.lombax.panel;

import javax.swing.JPanel;

import com.lombax.panel.layout.TwitterNotSignedInLayout;
import com.lombax.preferences.SocialPrefs;

import twitter4j.auth.AccessToken;

public class TwitterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3555503530933392484L;
	
	private static AccessToken accessToken;
	
	private static enum Display{
		LOGIN_BUTTON,
		LOGIN_PAGE
	}
	
	/**
	 * Create the panel.
	 */
	public TwitterPanel() {
		//Load the access token
		accessToken=SocialPrefs.loadTwitterAccessTokens();
		
		if(accessToken==null)
			TwitterNotSignedInLayout.layout(this);
		
	}
	
//	public static setLayout(){
//		
//	}

}
