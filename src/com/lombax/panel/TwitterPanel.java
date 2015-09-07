package com.lombax.panel;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class TwitterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3555503530933392484L;

	/**
	 * Create the panel.
	 */
	public TwitterPanel() {
		setLayout(new MigLayout("nogrid,flowy,wrap 1,fill"));
	}

}
