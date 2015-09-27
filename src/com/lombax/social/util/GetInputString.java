package com.lombax.social.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetInputString {
	
	
	/**
	 * Gets the input from the console with a message
	 * @param message Message to be displayed
	 * @return
	 */
	public static String getInputString(String message){
		
		String s = null;
		
		if(message.length()>0)
			System.out.print(message);
		
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    s = bufferRead.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * Gets the input from the console
	 * @return
	 */
	public static String getInputString(){
		return getInputString("");
	}
}
