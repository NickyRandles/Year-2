import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author Nicky Randles
 *
 */

public class assignment02 extends JFrame implements ActionListener
{
	public static void main(String [] args)
	{
		assignment02 gui = new assignment02();
	}
	
	Container c = getContentPane();
	JPanel panel, languagePanel, imagePanel, buttonPanel;
	JLabel setLanguage;
	String [] languages = {"English", "Spanish", "French"};
	JComboBox<String> languageBox = new JComboBox<String>(languages);	
	ImageIcon [] image = new ImageIcon[5];
	JLabel [] imageLabel = new JLabel[5];
	JButton [] button = new JButton[5];
	String [] names = {"Cat", "Dog", "Plane", "Car", "Kite"};
	
	
	assignment02()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		languagePanel = new JPanel();
		languagePanel.setLayout(new GridLayout(1,2));
		languagePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		imagePanel = new JPanel();
		imagePanel.setLayout(new GridLayout(1, 5));
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,5));
		
		setLanguage = new JLabel("Please select a language:");
		setLanguage.setHorizontalAlignment(SwingConstants.CENTER);
		setLanguage.setFont(new Font("Ariel", Font.ITALIC, 24));
		setLanguage.setForeground(Color.blue);
		
		languageBox.addActionListener(this);
		
		languagePanel.add(setLanguage);
		languagePanel.add(languageBox);
		
		for(int i = 0; i < 5; i++)
		{
			image[i] = new ImageIcon("Images/image" + (i+1) + ".jpg");
			imageLabel[i] = new JLabel(image[i]);
			imagePanel.add(imageLabel[i]);
		}
		
		for(int i = 0; i < 5; i++)
		{
			button[i] = new JButton();
			button[i].setText(names[i]);
			button[i].setPreferredSize(new Dimension(40, 80));
			button[i].addActionListener(this);
			buttonPanel.add(button[i]);
		}
		
		panel.add(languagePanel, BorderLayout.NORTH);
		panel.add(imagePanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		c.add(panel);
		setSize(800, 400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(languageBox.getSelectedIndex() == 0)
		{
			Locale loc = new Locale("en");
			ResourceBundle res = ResourceBundle.getBundle("ProgramProperties", loc);
			
			button[0].setText(res.getString("tag1"));
			button[1].setText(res.getString("tag2"));
			button[2].setText(res.getString("tag3"));
			button[3].setText(res.getString("tag4"));
			button[4].setText(res.getString("tag5"));
		}
		
		else if(languageBox.getSelectedIndex() == 1)
		{
			Locale loc = new Locale("sp");
			ResourceBundle res = ResourceBundle.getBundle("ProgramProperties", loc);
			
			button[0].setText(res.getString("tag1"));
			button[1].setText(res.getString("tag2"));
			button[2].setText(res.getString("tag3"));
			button[3].setText(res.getString("tag4"));
			button[4].setText(res.getString("tag5"));
		}
		
		else if(languageBox.getSelectedIndex() == 2)
		{
			Locale loc = new Locale("fr");
			ResourceBundle res = ResourceBundle.getBundle("ProgramProperties", loc);
			
			button[0].setText(res.getString("tag1"));
			button[1].setText(res.getString("tag2"));
			button[2].setText(res.getString("tag3"));
			button[3].setText(res.getString("tag4"));
			button[4].setText(res.getString("tag5"));
		}
		

		if(languageBox.getSelectedIndex() == 0 && e.getSource() == button[0])
		{
			audio.english_sound1.play();
		}
		
		else if(languageBox.getSelectedIndex() == 0 && e.getSource() == button[1])
		{
			audio.english_sound2.play();
		}
		
		else if(languageBox.getSelectedIndex() == 0 && e.getSource() == button[2])
		{
			audio.english_sound3.play();
		}
		
		else if(languageBox.getSelectedIndex() == 0 && e.getSource() == button[3])
		{
			audio.english_sound4.play();
		}
		
		else if(languageBox.getSelectedIndex() == 0 && e.getSource() == button[4])
		{
			audio.english_sound5.play();
		}
		
		else if(languageBox.getSelectedIndex() == 1 && e.getSource() == button[0])
		{
			audio.spanish_sound1.play();
		}
		
		else if(languageBox.getSelectedIndex() == 1 && e.getSource() == button[1])
		{
			audio.spanish_sound2.play();
		}
		
		else if(languageBox.getSelectedIndex() == 1 && e.getSource() == button[2])
		{
			audio.spanish_sound3.play();
		}
		
		else if(languageBox.getSelectedIndex() == 1 && e.getSource() == button[3])
		{
			audio.spanish_sound4.play();
		}
		
		else if(languageBox.getSelectedIndex() == 1 && e.getSource() == button[4])
		{
			audio.spanish_sound5.play();
		}
		
		else if(languageBox.getSelectedIndex() == 2 && e.getSource() == button[0])
		{
			audio.french_sound1.play();
		}
		
		else if(languageBox.getSelectedIndex() == 2 && e.getSource() == button[1])
		{
			audio.french_sound2.play();
		}
		
		else if(languageBox.getSelectedIndex() == 2 && e.getSource() == button[2])
		{
			audio.french_sound3.play();
		}
		
		else if(languageBox.getSelectedIndex() == 2 && e.getSource() == button[3])
		{
			audio.french_sound4.play();
		}
		
		else if(languageBox.getSelectedIndex() == 2 && e.getSource() == button[4])
		{
			audio.french_sound5.play();
		}
		
	}
	
}
