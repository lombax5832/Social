package com.lombax.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import net.miginfocom.swing.MigLayout;

import com.lombax.frame.component.SocialButton;
import com.lombax.frame.component.SocialToolBar;

public class MainPanel extends JPanel implements KeyListener{

	private static final long serialVersionUID = 6960418247115894552L;
	
	private JButton btnEnter;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JToolBar toolBar;
	
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		
		setLayout(new MigLayout("nogrid,flowy,wrap 1,fill"));
		
		// Create swing components
		
		textField = new JTextField();
		textField.setMargin(new Insets(10,10,10,10));
		textField.setFont(new Font("Comic Sans MS", 0, 30));
		textField.setFocusable(true);
		textField.addKeyListener(this);
		
		textArea = new JTextArea();
		textArea.setMargin(new Insets(10,10,10,10));
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.CYAN);
		textArea.setFont(new Font("Comic Sans MS", 0, 30));
		textArea.setFocusable(false);
		textArea.setSize(textArea.getPreferredSize());
		
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
		btnEnter.setFocusable(false);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setFocusable(false);
		
		toolBar = new SocialToolBar("Tool Bar");
		toolBar.setFocusable(false);
		toolBar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//				toolBar.add(new SocialButton("Clear",new ButtonClearListener()));
		
		// Add components to pane
		
		add(toolBar,"span,center, growx 100, gap 0 0 0 0");
		add(textField, "span,center,growx 100,gap 0 0 0 0");
		add(scrollPane, "span,center,grow 100 100,gap 0 0 0 0");		
		add(btnEnter, "span,center,growx 100, gap 0 0 0 0");
	
		// Set default focus
		textField.requestFocusInWindow();

	}
	
	public void clearTextArea(){
		textArea.setText(null);
	}
	
	public JTextArea getTextArea(){
		return textArea;
	}
	
	public void setTextArea(String text){
		textArea.setText(text);
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
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
