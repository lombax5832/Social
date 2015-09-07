package com.lombax.preferences;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import com.lombax.Social;


public class SocialPrefs {
	
	private static Preferences prefs = Preferences.userNodeForPackage(com.lombax.Social.class);
	
	//Value Names
	private static final String TEXT_AREA_NAME = "TEXT_AREA";
	
	//Default Values
	private static final String TEXT_AREA_DEFAULT = "";
	
	public static void savePrefs(){
		String textArea = Social.window.getMainPanel().getTextArea().getText();
		prefs.put(TEXT_AREA_NAME, textArea);
	};
	
	public static void loadPrefs(){
		Social.window.getMainPanel().setTextArea(prefs.get(TEXT_AREA_NAME, TEXT_AREA_DEFAULT));
	};
	
	public static void clearPrefs(){
		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}
	
}
