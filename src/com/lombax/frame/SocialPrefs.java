package com.lombax.frame;

import java.util.prefs.Preferences;


public class SocialPrefs {
	
	private static Preferences prefs = Preferences.userNodeForPackage(com.lombax.Social.class);
	
	//Value Names
	private static final String TEXT_AREA_NAME = "TEXT_AREA";
	
	//Default Values
	private static final String TEXT_AREA_DEFAULT = "";
	
	//Values
	private static String textArea;
	
	public static void savePrefs(){
		textArea = MainFrame.getTextArea().getText();
		prefs.put(TEXT_AREA_NAME, textArea);
	};
	
	public static void loadPrefs(){
		MainFrame.setTextArea(prefs.get(TEXT_AREA_NAME, TEXT_AREA_DEFAULT));
	};
	
}
