// Student name: Nicky Randles
// Student number: B00058026
// Lab: 9
// Task: 2

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class question02 extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		question02 internalFrame = new question02();
	} //end of main

	//creating content pane and frame
	Container c = getContentPane();
	JFrame frame;
	question02()
	{
		//seting title
		super("Option dialog");

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
		if (e.getActionCommand().equals("Click button"))
		{
			//creating show confirm dialog
			JOptionPane.showConfirmDialog(frame, "Do you like java?", "Question 2", JOptionPane.YES_NO_OPTION);
		}

	} //end of action performed method


} //end of class