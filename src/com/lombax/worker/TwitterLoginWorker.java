package com.lombax.worker;

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

import com.lombax.Social;
import com.lombax.panel.TwitterPanel;
import com.lombax.panel.TwitterPanel.Display;
import com.lombax.panel.layout.TwitterEnterPinLayout;
import com.lombax.preferences.SocialPrefs;
import com.lombax.twitter.Storage;

public class TwitterLoginWorker extends SwingWorker<AccessToken, AccessToken>{

	@Override
	protected AccessToken doInBackground() throws Exception {
		AccessToken accessToken = null;
		String pin = TwitterEnterPinLayout.getPin();
	      try{
	         if(pin.length() > 0){
	           accessToken = Social.twitter.getOAuthAccessToken(Storage.requestToken, pin);
	         }else{
	           accessToken = Social.twitter.getOAuthAccessToken();
	         }
	         Social.log("Got it!");
	         Social.twitter.setOAuthAccessToken(accessToken);
	         Social.log("Logged in as: @"+Social.twitter.getScreenName());
	      } catch (TwitterException te) {
	        if(401 == te.getStatusCode()){
	          System.out.println("Unable to get the access token.");
	        }else{
	          te.printStackTrace();
	        }
	      }
		return accessToken;
	}
	
	@Override
	protected void done(){
		AccessToken accessToken;
		try {
			accessToken = get();
			SocialPrefs.saveTwitterAccessTokens(accessToken);
			TwitterPanel.panelToRender(Display.LOGGED_IN, Social.window.getTwitPanel());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
