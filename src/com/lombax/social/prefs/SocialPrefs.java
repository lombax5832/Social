package com.lombax.social.prefs;

import java.util.prefs.Preferences;

public class SocialPrefs {
	
	/**
	 * Used for storing information
	 */
	private static Preferences prefs = Preferences.userNodeForPackage(com.lombax.social.Social.class);
	
	/**
	 * Name access tokens are saved under
	 */
	public static final String ACCESS_TOKEN_NAME = "TWITTER_ACCESS_TOKEN";
	public static final String ACCESS_TOKEN_SECRET_NAME = "TWITTER_ACCESS_TOKEN_SECRET";
	public static final String ACCESS_TOKEN_SCREENNAME_NAME = "TWITTER_ACCESS_TOKEN_SCREENNAME";
	
	/**
	 * Saves given string under name 
	 * @param name identifier
	 * @param string string to be saved
	 */
	public static void save(String name, String string){
		prefs.put(name, string);
	}
	
	public static String load(String name){
		return prefs.get(name, null);
	}
}
