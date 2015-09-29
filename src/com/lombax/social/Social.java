package com.lombax.social;

import java.net.URISyntaxException;

import twitter4j.TwitterException;

import com.lombax.social.twitter.TwitterKeys;
import com.lombax.social.twitter.TwitterSocial;

public class Social {
	
	private TwitterSocial twitter;
	
	private Social(String[] args){
		
	}
	
	//Pass args to constructor
	public static void main(String[] args) {
		new Social(args).Run();
	}
	
	//Start the program
	private void Run(){
		//Create new twitter object
		twitter = new TwitterSocial(TwitterKeys.TWITTER_OAUTH_CONSUMER_KEY, TwitterKeys.TWITTER_OAUTH_CONSUMER_SECRET);
		try {
			twitter.login();
		} catch (IllegalStateException | TwitterException | URISyntaxException e) {
			e.printStackTrace();
		}
		twitter.listTimeline(twitter.getHomeTimeline());
	}
}
