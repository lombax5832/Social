package com.lombax.social.worker;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import com.lombax.social.twitter.TwitterSocial;

/**
 * 
 * @author Alexei
 *
 */
public class TwitterBackgroundWorker extends SwingWorker<Integer, String>{

	private TwitterSocial twitter;
	
	private JTextArea txtrTextAreaTimeline;
	
	private JLabel labelSignedInAs;
	
	public TwitterBackgroundWorker(JTextArea txtrTextAreaTimeline, JLabel labelSignedInAs, TwitterSocial twitter){
		this.txtrTextAreaTimeline = txtrTextAreaTimeline;
		this.labelSignedInAs = labelSignedInAs;
		this.twitter = twitter;
	}

	@Override
	protected Integer doInBackground() throws Exception {
//		twitter = new TwitterSocial(TwitterKeys.TWITTER_OAUTH_CONSUMER_KEY, TwitterKeys.TWITTER_OAUTH_CONSUMER_SECRET);
//		try {
//			twitter.login();
//		} catch (IllegalStateException | TwitterException | URISyntaxException exception) {
//			exception.printStackTrace();
//		}
		
		txtrTextAreaTimeline.setText(twitter.getTimelineString(twitter.getMentionsTimeline()));
		labelSignedInAs.setText("Signed in as: @" + twitter.getScreenName());
		
		return 1;
	}
	
	@SuppressWarnings("unused")
	private static void failIfInterrupted() throws InterruptedException{
		throw new InterruptedException("Interrupted while communicating with twitter");
	}

}