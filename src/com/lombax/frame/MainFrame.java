package com.lombax.frame;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;

import com.lombax.Social;
import com.lombax.panel.MailPanel;
import com.lombax.panel.MainPanel;
import com.lombax.preferences.SocialPrefs;

/**
 * @author Alexei
 *
 * Creates the frame and all components within
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = -3784362640059427003L;
	
	private JTabbedPane tabbedPane;
	
	private Container c = getContentPane();
	
	private MainPanel mainPanel = new MainPanel();
	private MailPanel mailPanel = new MailPanel();
	
	public MainFrame(String title){
		super(title);
		
		Social.log("MainFrame started.");
		
		setVisible(true);
		setBounds(100,100,1000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000,800));
		setMinimumSize(new Dimension(500,400));
		
		c.setLayout(new MigLayout("fill"));
		Social.log("MainFrame layout set to MigLayout.");
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Main", mainPanel);
		tabbedPane.addTab("Mail", mailPanel);
		tabbedPane.setFocusable(false);
		mainPanel.requestFocus();
		c.add(tabbedPane,"span,grow");
		Social.log("TabbedPane added to container.");
	}
	
	public MainPanel getMainPanel(){
		return mainPanel;
	}
	
	public MailPanel getMailPanel(){
		return mailPanel;
	}

}
