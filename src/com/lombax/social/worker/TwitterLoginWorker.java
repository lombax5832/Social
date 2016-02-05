/**
 * 
 */
package com.lombax.social.worker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import com.lombax.social.panel.SocialLoginPopup;
import com.lombax.social.twitter.TwitterKeys;
import com.lombax.social.twitter.TwitterSocial;

import twitter4j.TwitterException;

/**
 * @author Alexei
 *
 */
public class TwitterLoginWorker extends SwingWorker<Integer, String> {

	private TwitterSocial twitter;
	
	private JTextArea txtrTextAreaTimeline;
	
	private JLabel labelSignedInAs;
	
	private SocialLoginPopup socialLoginPopup;
	
	private TwitterBackgroundWorker twitBgWorker;
	
	public TwitterLoginWorker(JTextArea txtrTextAreaTimeline, JLabel labelSignedInAs, SocialLoginPopup socialLoginPopup){
		this.txtrTextAreaTimeline = txtrTextAreaTimeline;
		this.labelSignedInAs = labelSignedInAs;
		this.socialLoginPopup = socialLoginPopup;
	}
	
	@Override
	protected Integer doInBackground() throws Exception {
		socialLoginPopup.setVisible(true);
		twitter = new TwitterSocial(TwitterKeys.TWITTER_OAUTH_CONSUMER_KEY, TwitterKeys.TWITTER_OAUTH_CONSUMER_SECRET);
		try {
			
			socialLoginPopup.btnGetPin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						twitter.getRequestToken();
						twitter.openURL(twitter.getAuthURI());
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					} catch (TwitterException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			socialLoginPopup.btnSignInWithPIN.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						try {
							twitter.login(socialLoginPopup, false);
							twitBgWorker = new TwitterBackgroundWorker(txtrTextAreaTimeline, labelSignedInAs, twitter);
							twitBgWorker.execute();
							socialLoginPopup.setVisible(false);
						} catch (IllegalStateException | TwitterException | URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			
			socialLoginPopup.btnExistingUser.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						try {
							twitter.login(socialLoginPopup, true);
							twitBgWorker = new TwitterBackgroundWorker(txtrTextAreaTimeline, labelSignedInAs, twitter);
							twitBgWorker.execute();
							socialLoginPopup.setVisible(false);
						} catch (IllegalStateException | TwitterException | URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			
		} catch (IllegalStateException exception) {
			exception.printStackTrace();
		}
		
		return null;
	}

}
