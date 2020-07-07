package com.werner.playwiththreads.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {

	private JPanel jpanel = new JPanel(new GridBagLayout());
	private JLabel label1 = new JLabel("Time Thread 1");
	private JLabel label2 = new JLabel("Time Thread 2");
	private JTextField text1 = new JTextField();
	private JTextField text2 = new JTextField();
	private JButton button1 = new JButton("Start");
	private JButton button2 = new JButton("Stop");

	private Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			while (true) { /* always run*/

				text1.setText(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				//text2.setText(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(Calendar.getInstance().getTime())); Poderia fazer isso
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	};

	private Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			while (true) {

				text2.setText(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(Calendar.getInstance().getTime()));

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	};
	
	

	private Thread thread1Time;
	private Thread thread2Time;

	public TelaTimeThread() { /* executes what is inside when opening */

		this.setTitle("My Thread Program");
		this.setSize(new Dimension(240, 240));
		this.setLocationRelativeTo(null); /* Position the screen depending on another component (screen) */
		this.setResizable(false); /* Windows´size cant increase or decrease */

		GridBagConstraints gridBagConstraints = new GridBagConstraints(); /* Position´s Controller of components */
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2; // Tamanho de componente
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5); // Distanciamento

		label1.setPreferredSize(new Dimension(200, 25));
		jpanel.add(label1, gridBagConstraints);

		text1.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		jpanel.add(text1, gridBagConstraints);

		label2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		jpanel.add(label2, gridBagConstraints);

		text2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		jpanel.add(text2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		button1.setPreferredSize(new Dimension(100, 25));
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		jpanel.add(button1, gridBagConstraints);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thread1Time = new Thread(thread1);
				thread1Time.start();
				
				thread2Time = new Thread(thread2);
				thread2Time.start();
				
				button2.setEnabled(true);
				button1.setEnabled(false);
			}
		});

		button2.setPreferredSize(new Dimension(100, 25));
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		jpanel.add(button2, gridBagConstraints);

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thread1Time.stop();
				thread2Time.stop();
				
				button1.setEnabled(true);
				button2.setEnabled(false);

			}
		});

		text1.setEditable(false);
		text2.setEditable(false);
		button2.setEnabled(false);
		
		
		add(jpanel, BorderLayout.WEST);
		setVisible(true); /* turns window visible and is always the last command */

	}

}
