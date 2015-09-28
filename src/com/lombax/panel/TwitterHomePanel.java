package com.lombax.panel;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import twitter4j.ResponseList;
import twitter4j.Status;

public class TwitterHomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5030155021796958821L;

	/**
	 * Create the panel.
	 */
	public TwitterHomePanel() {
		
		setLayout(new MigLayout("nogrid,flowx,fill","[]","[]"));
		
	}
	
	@SuppressWarnings("unused")
	public static void refreshData(ResponseList<Status> list){
		for(Status each : list){
			
		}
	}

}
