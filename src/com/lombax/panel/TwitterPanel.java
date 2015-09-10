package com.lombax.panel;

import javax.swing.JPanel;

import com.lombax.panel.layout.TwitterNotSignedInLayout;

public class TwitterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3555503530933392484L;
	
	/**
	 * Create the panel.
	 */
	public TwitterPanel() {
		TwitterNotSignedInLayout.layout(this);
	}
	
//	public static setLayout(){
//		
//	}

}
