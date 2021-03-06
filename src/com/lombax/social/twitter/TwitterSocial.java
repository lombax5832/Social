package com.lombax.social.twitter;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.lombax.social.panel.SocialLoginPopup;
import com.lombax.social.prefs.SocialPrefs;
import com.lombax.social.util.GetInputString;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterSocial {
	
	private Twitter twitter;
	
	private RequestToken reqToken;
	
	private String pin;
	
	private AccessToken accToken;
	
	private String screenName = null;
	
	/**
	 * Creates new twitter object with given consumer keys
	 * @param consumerKey
	 * @param consumerSecret
	 */
	public TwitterSocial(String consumerKey, String consumerSecret){
		resetTwitter();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
	}
	
	/**
	 * Logs the user in and saves keys
	 * @throws TwitterException 
	 * @throws IllegalStateException 
	 * @throws URISyntaxException 
	 */
	public void login() throws IllegalStateException, TwitterException, URISyntaxException{
		
		if(keysSaved()&&GetInputString.getInputString("Sign in as existing user( y for yes ): ").equals("y")){
			accToken = loadToken();
			twitter.setOAuthAccessToken(accToken);
		}else{
			getRequestToken();
			openURL(getAuthURI());
			pin = getPin();
			accToken = twitter.getOAuthAccessToken(reqToken, pin);
		}
		System.out.println("User: @"+twitter.getScreenName()+" successfully logged in!");
		
		screenName = twitter.getScreenName();
		
		saveToken(accToken);
	}
	
	/**
	 * Logs the user in and saves keys
	 * @throws TwitterException 
	 * @throws IllegalStateException 
	 * @throws URISyntaxException 
	 */
	public void login(SocialLoginPopup socialLoginPopup, boolean existingUser) throws IllegalStateException, TwitterException, URISyntaxException{
		
		if(keysSaved()&&existingUser){
			accToken = loadToken();
			twitter.setOAuthAccessToken(accToken);
		}else{
		pin = socialLoginPopup.txtPin.getText();
		accToken = twitter.getOAuthAccessToken(reqToken, pin);
		}
		System.out.println("User: @"+twitter.getScreenName()+" successfully logged in!");
		
		screenName = twitter.getScreenName();
		
		saveToken(accToken);
	}
	
	/**
	 * Prints all the statuses from the given list
	 * @param list List to print statuses from
	 */
	public void listTimeline(ResponseList<Status> list){
		for(int i=0;i<list.size();i++){
			Status status = list.get(i);
			System.out.println("@"+status.getUser().getScreenName()+": "+status.getText());
		}
	}
	
	/**
	 * Returns all the statuses from the given list as a string
	 * @param list List to print statuses from
	 */
	public String getTimelineString(ResponseList<Status> list){
		StringBuilder strBldr = new StringBuilder("");
			for(int i=0;i<list.size();i++){
				Status status = list.get(i);
				if(i>0)
					strBldr.append("\n\n");
				
				strBldr.append("@"+status.getUser().getScreenName()+": "+status.getText());
				
			}
		return strBldr.toString();
	}
	
	/**
	 * Gets the OAuthRequestToken from twitter
	 * @throws TwitterException
	 */
	public void getRequestToken() throws TwitterException{
		reqToken = twitter.getOAuthRequestToken();
	}
	
	/**Generates the Url from the OAuthRequestToken
	 * @return URI
	 * @throws URISyntaxException
	 */
	public URI getAuthURI() throws URISyntaxException{
		return new URI(reqToken.getAuthorizationURL());
	}
	
	/**
	 * Opens the URL with the default browser
	 * @param uri The URI to be opened
	 */
	public void openURL(URI uri){
		//Check for isDesktopSupported first
		if(Desktop.isDesktopSupported()){
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Turns the Twitter object into the default instance
	 */
	private void resetTwitter(){
		twitter = TwitterFactory.getSingleton();
	}
	
	/**
	 * Gets the user's pin given to them by twitter
	 */
	private String getPin(){
		return GetInputString.getInputString("Enter your pin here: ");
	}
	
	/**
	 * Saves keys for use in later sessions
	 * @param accToken Token to save keys from
	 */
	private void saveToken(AccessToken accToken){
		SocialPrefs.save(SocialPrefs.ACCESS_TOKEN_NAME, accToken.getToken());
		SocialPrefs.save(SocialPrefs.ACCESS_TOKEN_SECRET_NAME, accToken.getTokenSecret());
	}
	
	/**
	 * Loads token from saved keys
	 * @return loaded AccessToken
	 */
	private AccessToken loadToken(){
		System.out.println("Access Token: "+SocialPrefs.load(SocialPrefs.ACCESS_TOKEN_NAME));
		AccessToken accToken = new AccessToken(SocialPrefs.load(SocialPrefs.ACCESS_TOKEN_NAME),SocialPrefs.load(SocialPrefs.ACCESS_TOKEN_SECRET_NAME));
		return accToken;
	}
	
	/**
	 * Checks to see if any keys are saved
	 * @return
	 */
	private boolean keysSaved(){
		if(SocialPrefs.load(SocialPrefs.ACCESS_TOKEN_NAME)!=null)
			return true;
		return false;
	}
	
	/**
	 * Returns the username in the stored access token
	 * @return Username stored in AccessToken Object
	 */
	public String getScreenName(){
		return screenName;
	}
	
	/**
	 * Returns the user's home page time line
	 * @return
	 */
	public ResponseList<Status> getHomeTimeline(){
		try {
			return twitter.getHomeTimeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ResponseList<Status> getMentionsTimeline(){
		try {
			return twitter.getMentionsTimeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return null;
	}
}
