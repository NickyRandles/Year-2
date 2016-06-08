package lab05_exercise01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class question01 extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		question01 question = new question01();
	}
	
	Container c = getContentPane();
	Locale locale[] = SimpleDateFormat.getAvailableLocales();
	JPanel panel;
	JButton button;
	JTextArea textArea;
	JScrollPane scrollPane;
	String [] text;
	
	public question01()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		button = new JButton("List All Locales");
		button.addActionListener(this);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		scrollPane = new JScrollPane(textArea);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(button, BorderLayout.NORTH);
		c.add(panel);
		
		setSize(350,350);
		setVisible(true);	
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == button)
		{
			for (int i = 0; i < locale.length; i++)
			{
				String lines = locale[i].toString() + locale[i].getDisplayName();
				textArea.append(lines +"\n"); 
			}
		}
	}
	
	
}
