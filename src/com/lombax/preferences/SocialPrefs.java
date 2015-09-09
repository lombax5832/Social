package com.lombax.preferences;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import com.lombax.Social;


public class SocialPrefs {
	
	private static Preferences prefs = Preferences.userNodeForPackage(com.lombax.Social.class);
	
	//Value Names
	private static final String TEXT_AREA_NAME = "TEXT_AREA";
	
	private static final String TWITTER_ACCESS_TOKEN_NAME = "TWITTER_ACCESS_TOKEN";
	private static final String TWITTER_ACCESS_SECRET_NAME = "TWITTER_ACCESS_SECRET";
	
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
	public static void saveTwitterAccessTokens(String token, String secret){
		prefs.put(TWITTER_ACCESS_TOKEN_NAME, token);
		prefs.put(TWITTER_ACCESS_SECRET_NAME, secret);
	};
	public static String getTwitterAccessToken(){
		return prefs.get(TWITTER_ACCESS_TOKEN_NAME, null);
	};
	public static String getTwitterAccessSecret(){
		return prefs.get(TWITTER_ACCESS_SECRET_NAME, null);
	};
	
	public static void clearPrefs(){
		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}
	
}
