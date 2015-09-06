package com.lombax.frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import net.miginfocom.swing.MigLayout;

import com.lombax.frame.component.SocialButton;
import com.lombax.frame.component.SocialToolBar;

/**
 * @author Alexei
 *
 * Creates the frame and all components within
 */
public class MainFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = -3784362640059427003L;

	private JButton btnEnter;
	private JTextField textField;
	private static JTextArea textArea;
	private JScrollPane scrollPane;
	private JToolBar toolBar;
	private Container c = getContentPane();
	
	public MainFrame(String title){
		super(title);
		setVisible(true);
		setBounds(100,100,1000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,400));
		
		// Set layout manager
		c.setLayout(new MigLayout("nogrid,flowy,wrap 1,fill"));
		
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
//		toolBar.add(new SocialButton("Clear",new ButtonClearListener()));
		
		// Add components to pane
		
		c.add(toolBar,"span,center, growx 100, gap 0 0 0 0");
		c.add(textField, "span,center,growx 100,gap 0 0 0 0");
		c.add(scrollPane, "span,center,grow 100 100,gap 0 0 0 0");		
		c.add(btnEnter, "span,center,growx 100, gap 0 0 0 0");
	
		// Set default focus
		textField.requestFocusInWindow();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if(key.getKeyCode()==KeyEvent.VK_ENTER){
			btnEnter.doClick();
			System.out.println("Enter Pressed.");
		}
	}
	
	public static void clearTextArea(JTextArea textArea){
		textArea.setText(null);
	}
	
	public static JTextArea getTextArea(){
		return textArea;
	}
	
	public static void setTextArea(String text){
		textArea.setText(text);
	}

	@Override
	public void keyReleased(KeyEvent key) {
	}

	@Override
	public void keyTyped(KeyEvent key) {}

}
