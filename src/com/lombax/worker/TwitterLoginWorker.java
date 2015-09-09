package com.lombax.worker;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import com.lombax.Social;
import com.lombax.preferences.SocialPrefs;

import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterLoginWorker extends SwingWorker<AccessToken, AccessToken>{

	@Override
	protected AccessToken doInBackground() throws Exception {
		AccessToken accessToken = null;
		RequestToken requestToken = Social.twitter.getOAuthRequestToken();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (null == accessToken) {
	      System.out.println("Open the following URL and grant access to your account:");
	      System.out.println(requestToken.getAuthorizationURL());
	      if(Desktop.isDesktopSupported())
	      {
	        Desktop.getDesktop().browse(new URI(requestToken.getAuthorizationURL()));
	      }
	      System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
	      String pin = br.readLine();
	      try{
	         if(pin.length() > 0){
	           accessToken = Social.twitter.getOAuthAccessToken(requestToken, pin);
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
	    }
		return accessToken;
	}
	
	protected void done(){
		AccessToken accessToken;
		try {
			accessToken = get();
			SocialPrefs.saveTwitterAccessTokens(accessToken);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
