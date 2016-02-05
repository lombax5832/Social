package com.lombax.panel;

import javax.swing.JPanel;

import twitter4j.auth.AccessToken;

import com.lombax.panel.layout.TwitterEnterPinLayout;
import com.lombax.panel.layout.TwitterHomeLayout;
import com.lombax.panel.layout.TwitterNotSignedInLayout;
import com.lombax.preferences.SocialPrefs;
import com.lombax.twitter.Storage;

public class TwitterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3555503530933392484L;
	
	private static AccessToken accessToken;
	
	public static enum Display{
		LOGIN_BUTTON,
		LOGIN_PAGE,
		LOGGED_IN
	}
	
	/**
	 * Create the panel.
	 */
	public TwitterPanel() {
		//Load the access token
		accessToken=SocialPrefs.loadTwitterAccessTokens();
		if(accessToken==null&&Storage.requestToken==null){
			panelToRender(Display.LOGIN_BUTTON,this);
		}else{
			panelToRender(Display.LOGGED_IN,this);
		}
			
	}
	
	public static void panelToRender(Display toDisp, JPanel panel){
		panel.removeAll();
		switch(toDisp){
		case LOGIN_BUTTON:TwitterNotSignedInLayout.layout(panel);
			break;
		case LOGIN_PAGE:TwitterEnterPinLayout.layout(panel);
			break;
		case LOGGED_IN:TwitterHomeLayout.layout(panel);
			break;
		default:
			break;
		}
		panel.repaint();
		panel.revalidate();
	}
	
//	public static setLayout(){
//		
//	}

}
