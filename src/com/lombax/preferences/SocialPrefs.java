package com.lombax.preferences;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import twitter4j.auth.AccessToken;

import com.lombax.Social;
import com.lombax.twitter.Utils;


public class SocialPrefs {
	
	private static Preferences prefs = Preferences.userNodeForPackage(com.lombax.Social.class);
	
	//Value Names
	private static final String TEXT_AREA_NAME = "TEXT_AREA";
	
//	private static final String TWITTER_ACCESS_TOKEN_NAME = "TWITTER_ACCESS_TOKEN";
//	private static final String TWITTER_ACCESS_SECRET_NAME = "TWITTER_ACCESS_SECRET";
	private static final String TWITTER_ACCESS_TOKENS_NAME = "TWITTER_ACCESS_TOKENS";
	
	//Default Values
	private static final String TEXT_AREA_DEFAULT = "";
	
	//Text Area
	public static void saveTextArea(){
		String textArea = Social.window.getMainPanel().getTextArea().getText();
		prefs.put(TEXT_AREA_NAME, textArea);
	};
	public static void loadTextArea(){
		Social.window.getMainPanel().setTextArea(prefs.get(TEXT_AREA_NAME, TEXT_AREA_DEFAULT));
	};
	
	//Twitter Keys
	public static void saveTwitterAccessTokens(AccessToken accessTokens){
		prefs.put(TWITTER_ACCESS_TOKENS_NAME, Utils.serializeToken(accessTokens));
	}
	public static AccessToken loadTwitterAccessTokens(){
		String tokenString = prefs.get(TWITTER_ACCESS_TOKENS_NAME, "");
		AccessToken accessTokens = null;
		if(tokenString!="")
			accessTokens = Utils.deserializeToken(tokenString);
		return accessTokens;
	}

	public static void clearPrefs(){
		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}
	
}
