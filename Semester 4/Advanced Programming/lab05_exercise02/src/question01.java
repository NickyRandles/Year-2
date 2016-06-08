
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class question01 extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		question01 question = new question01();
	}
	
	Container c = getContentPane();
	JPanel panel;
	JButton button;
	JComboBox<String> languageBox = new JComboBox<String>();
	JTextArea textArea;
	JScrollPane scrollPane;
	
	public question01()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		button = new JButton("List All Locales");
		button.addActionListener(this);
		
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		
		languageBox.addItem("English");
		languageBox.addItem("French");
		languageBox.addActionListener(this);
		

		panel.add(button, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(languageBox, BorderLayout.SOUTH);
		c.add(panel);
		
		setSize(350,350);
		setVisible(true);	
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(languageBox.getSelectedIndex() == 0)
		{
			Locale loc = new Locale("en");
			ResourceBundle res = ResourceBundle.getBundle("ProgramProperties", loc);
			
			button.setText(res.getString("tag1"));
			
			languageBox.removeAllItems();
			languageBox.addItem(res.getString("tag2"));	
			languageBox.addItem(res.getString("tag3"));	
		}
		
		else if(languageBox.getSelectedIndex() == 1)
		{
			Locale loc = new Locale("fr");
			ResourceBundle res = ResourceBundle.getBundle("ProgramProperties", loc);
			
			button.setText(res.getString("tag1"));
			
			languageBox.removeAllItems();
			languageBox.addItem(res.getString("tag2"));	
			languageBox.addItem(res.getString("tag3"));	
			languageBox.setSelectedItem(res.getString("tag3"));
		}
		
		if(e.getSource() == button && languageBox.getSelectedIndex() == 0)
		{
			Locale locale[] = SimpleDateFormat.getAvailableLocales();

			for (int i = 0; i < locale.length; i++)
			{
				String lines = locale[i].toString() + locale[i].getDisplayName(Locale.ENGLISH);
				textArea.append(lines +"\n"); 
			}
		}
		
		
		else if(e.getSource() == button && languageBox.getSelectedItem().equals("Francais"))
		{
			
			Locale locale[] = SimpleDateFormat.getAvailableLocales();

			for (int i = 0; i < locale.length; i++)
			{
				String lines = locale[i].toString() + locale[i].getDisplayName(Locale.FRENCH);
				textArea.append(lines +"\n"); 
			}
		}


	}
	
}
