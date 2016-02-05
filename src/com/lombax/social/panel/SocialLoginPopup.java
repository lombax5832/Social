package com.lombax.social.panel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SocialLoginPopup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6634982137518897528L;
	private JPanel contentPane;
	public JTextField txtPin;
	public JButton btnSignInWithPIN;
	public JButton btnGetPin;
	public JButton btnExistingUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SocialLoginPopup frame = new SocialLoginPopup();
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
	public SocialLoginPopup() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 118);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtPin = new JTextField();
		txtPin.setHorizontalAlignment(SwingConstants.CENTER);
		txtPin.setFont(new Font("Dialog", Font.PLAIN, 37));
		txtPin.setText("PIN");
		GridBagConstraints gbc_txtPin = new GridBagConstraints();
		gbc_txtPin.gridwidth = 3;
		gbc_txtPin.fill = GridBagConstraints.BOTH;
		gbc_txtPin.gridx = 0;
		gbc_txtPin.gridy = 0;
		contentPane.add(txtPin, gbc_txtPin);
		txtPin.setColumns(10);
		
		btnExistingUser = new JButton("Existing User");
		GridBagConstraints gbc_btnExistingUser = new GridBagConstraints();
		gbc_btnExistingUser.fill = GridBagConstraints.BOTH;
		gbc_btnExistingUser.anchor = GridBagConstraints.WEST;
		gbc_btnExistingUser.gridx = 0;
		gbc_btnExistingUser.gridy = 1;
		contentPane.add(btnExistingUser, gbc_btnExistingUser);
		
		btnGetPin = new JButton("Get Pin");
		GridBagConstraints gbc_btnGetPin = new GridBagConstraints();
		gbc_btnGetPin.fill = GridBagConstraints.BOTH;
		gbc_btnGetPin.gridx = 1;
		gbc_btnGetPin.gridy = 1;
		contentPane.add(btnGetPin, gbc_btnGetPin);
		
		btnSignInWithPIN = new JButton("Sign in with PIN");
		GridBagConstraints gbc_btnSignInWithPIN = new GridBagConstraints();
		gbc_btnSignInWithPIN.fill = GridBagConstraints.BOTH;
		gbc_btnSignInWithPIN.anchor = GridBagConstraints.EAST;
		gbc_btnSignInWithPIN.gridx = 2;
		gbc_btnSignInWithPIN.gridy = 1;
		contentPane.add(btnSignInWithPIN, gbc_btnSignInWithPIN);
	}

}
