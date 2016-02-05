package com.lombax.social.panel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class SocialFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4289026019420733006L;
	
	private JTextField txtField;
	private JScrollPane scrollPane;
	
	public JLabel labelSignedInAs;
	public JTextArea txtrTextAreaTimeline;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SocialFrame frame = new SocialFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SocialFrame() {
		setTitle("Social");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{14, 247, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		labelSignedInAs = new JLabel("Signed in as: ");
		GridBagConstraints gbc_labelSignedInAs = new GridBagConstraints();
		gbc_labelSignedInAs.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelSignedInAs.anchor = GridBagConstraints.NORTH;
		gbc_labelSignedInAs.insets = new Insets(0, 0, 5, 0);
		gbc_labelSignedInAs.gridx = 0;
		gbc_labelSignedInAs.gridy = 0;
		getContentPane().add(labelSignedInAs, gbc_labelSignedInAs);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		txtrTextAreaTimeline = new JTextArea();
		scrollPane.setViewportView(txtrTextAreaTimeline);
		txtrTextAreaTimeline.setLineWrap(true);
		txtrTextAreaTimeline.setWrapStyleWord(true);
		txtrTextAreaTimeline.setEditable(false);
		
		txtField = new JTextField();
		txtField.setText("Field");
		GridBagConstraints gbc_txtField = new GridBagConstraints();
		gbc_txtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtField.insets = new Insets(0, 0, 0, 0);
		gbc_txtField.gridx = 0;
		gbc_txtField.gridy = 2;
		getContentPane().add(txtField, gbc_txtField);
		txtField.setColumns(10);
	}
	
	/*
	 * sets value of the text area
	 */
	public void setTxtrTextAreaTimeline(String string){
		txtrTextAreaTimeline.setText(string);
	}

}
