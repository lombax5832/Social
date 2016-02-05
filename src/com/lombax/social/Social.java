package com.lombax.social;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lombax.social.panel.SocialFrame;
import com.lombax.social.panel.SocialLoginPopup;
import com.lombax.social.worker.TwitterLoginWorker;

public class Social {
	
	private SocialFrame socialFrame;
	private SocialLoginPopup socialLoginPopup;
	
	private TwitterLoginWorker twitLoginWorker;
	
	private Social(String[] args){
		
	}
	
	//Pass args to constructor
	public static void main(String[] args) {
		new Social(args).Run();
	}
	
	//Start the program
	private void Run(){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException exception) {
			exception.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					socialFrame = new SocialFrame();
					socialLoginPopup = new SocialLoginPopup();
					socialFrame.setVisible(true);
					socialLoginPopup.setVisible(false);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				twitLoginWorker = new TwitterLoginWorker(socialFrame.txtrTextAreaTimeline, socialFrame.labelSignedInAs, socialLoginPopup);
				twitLoginWorker.execute();
			}
		});	
		
	}
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SocialFrame2 frame = new SocialFrame2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
