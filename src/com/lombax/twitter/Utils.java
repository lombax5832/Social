package com.lombax.twitter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import twitter4j.auth.AccessToken;

public class Utils {

	public static int TwitterPanelToShow = 0;
	
	public static String serializeToken(AccessToken token){
		try {
		     ByteArrayOutputStream bo = new ByteArrayOutputStream();
		     ObjectOutputStream so = new ObjectOutputStream(bo);
		     so.writeObject(token);
		     so.flush();
		     return bo.toString();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		return null;
	}
	public static AccessToken deserializeToken(String tokenString){
		AccessToken accessToken = null;
		try {
//			Social.log("Deserializing: "+tokenString);
			byte b[] = tokenString.getBytes(); 
			ByteArrayInputStream bi = new ByteArrayInputStream(b);
			ObjectInputStream si = new ObjectInputStream(bi);
			accessToken = (AccessToken) si.readObject();
		 } catch (Exception e) {
			 System.out.println(e);
		 }
		return accessToken;
	}
}
