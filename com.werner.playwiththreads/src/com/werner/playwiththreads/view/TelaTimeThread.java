package com.werner.playwiththreads.view;

import java.awt.Dimension;

import javax.swing.JDialog;

public class TelaTimeThread extends JDialog {
	
	public TelaTimeThread() { /* executes what is inside when opening */ 
		
		this.setTitle("My Thread Program");
		this.setSize(new Dimension(240, 240));
		this.setLocationRelativeTo(null); /* Position the screen depending on another component (screen) */
		this.setResizable(false); /* Windows´size cant  increase or decrease*/
		
		
		setVisible(true); /*turns window visible and is always the last command*/
		
	}
	
	
	
	

}
