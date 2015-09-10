package com.lombax.worker;

import javax.swing.SwingWorker;

import twitter4j.ResponseList;
import twitter4j.Status;

import com.lombax.Social;

public class TwitterGetTimelineWorker extends SwingWorker<ResponseList<Status>, ResponseList<Status>>{

	@Override
	protected ResponseList<Status> doInBackground() throws Exception {
		return Social.twitter.getHomeTimeline();
	}
	
	protected void done(){
		
	}

}
