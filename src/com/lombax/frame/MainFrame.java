package com.lombax.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.lombax.frame.component.SocialButton;

/**
 * @author Alexei
 *
 * Creates the frame
 */
public class MainFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3784362640059427003L;

	private JButton btnEnter;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	public MainFrame(String title){
		super(title);
		setVisible(true);
		setBounds(100,100,500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,400));
		
		// Set layout manager
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		// Create swing components
		textField = new JTextField();
		textField.setMargin(new Insets(10,10,10,10));
		textField.setFont(new Font("Arial", 0, 30));
		textField.setFocusable(true);
		textField.addKeyListener(this);
		
		textArea = new JTextArea();
		textArea.setMargin(new Insets(10,10,10,10));
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.CYAN);
		textArea.setFont(new Font("Arial", 0, 30));
		textArea.setFocusable(false);
//		textArea.setDragEnabled(true);
//		textArea.setFocusable(true);
//		textArea.setAutoscrolls(true);
		
		btnEnter = new SocialButton("Enter",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().length()>0){
					if(textArea.getText().length()>0)
						textArea.append("\n");
						
					textArea.append(textField.getText());
					textField.setText(null);
				}
			}
			
		});
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setFocusable(true);
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setPreferredSize(new Dimension(400,500));
		
		// Add components to pane
		getContentPane().add(textField, BorderLayout.NORTH);
//		getContentPane().add(textArea, BorderLayout.CENTER);
		getContentPane().add(btnEnter, BorderLayout.SOUTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void keyPressed(KeyEvent key) {
//		System.out.println(key.getKeyCode());
		if(key.getKeyCode()==KeyEvent.VK_ENTER){
			btnEnter.doClick();
			System.out.println("Enter Pressed.");
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
	}

	@Override
	public void keyTyped(KeyEvent key) {}

}
