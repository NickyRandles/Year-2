package lab06_exercise01;

import java.applet.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

public class question01 extends JFrame implements ActionListener
{		
	
	public static void main(String[] args)
	{
		question01 question = new question01();
	}
	
	Container c = getContentPane();		
	JButton playButton;
	public AudioClip Clip;
	String sound = "/Sounds/hello.wav";

	question01()
	{
		Clip = Applet.newAudioClip(question01.class.getResource(sound));
		playButton = new JButton("Click to play!");
		playButton.addActionListener(this);
		
		c.add(playButton);
		
		setVisible(true);
		setSize(200, 200);
	}
	
	public void  actionPerformed(ActionEvent e)
	{
		if(e.getSource() == playButton)
		{
			Clip.play();
		}
	}


}
