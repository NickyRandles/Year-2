package lab07_exercise03;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delay extends JFrame {

	public static void main(String[] args) {
		
		Delay Seconds = new Delay();
		Seconds.run();
	}

	JLabel loading, ready;

	public Delay() {
		super();
		
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 388, 118);
		getContentPane().add(panel);
		
		loading = new JLabel("Loading...");
		ready = new JLabel();
		panel.add(ready);
		panel.add(loading);
		
		
		setVisible(true);
		setResizable(false);
		setSize(392, 145);
		
	}

	public void run() {
		
		int i = 0;
		while (true) {
			
			
			try
			{
				Thread.sleep(10000);
			}
			catch (Exception e)
			{
			}
			
			i++;
			
			loading.setText("");
			ready.setText("Ready!");

			try 
			{
				Thread.sleep(10000);
			} 
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			i++;
	
		}
		
	}


}