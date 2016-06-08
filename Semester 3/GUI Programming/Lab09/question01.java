// Student name: Nicky Randles
// Student number: B00058026
// Lab: 9
// Task: 1

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class question01 extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		question01 internalFrame = new question01();
	} //end of main

	//creating content pane and frame
	JFrame frame;
	Container c = getContentPane();
	question01()
	{
		//seting title
		super("Message dialog");

		//adding press button to content pane
		JButton press = new JButton("Click button");
		press.addActionListener(this);

		//adding press button to content pane
		c.add(press);

		//setting size, location and visibility
       	setSize(250,250);
       	setLocation(275,275);
        setVisible(true);
	} //end of constructor

	public void actionPerformed(ActionEvent e)
	{
		//creating icon
		Icon icon = new ImageIcon("thumb.png");
		if (e.getActionCommand().equals("Click button"))
		{
			//creating show message dialog
			JOptionPane.showMessageDialog(frame, "Thank you for clicking the button", "Question 1", JOptionPane.INFORMATION_MESSAGE, icon);
		}

	} //end of action performed method


} //end of class