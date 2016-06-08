// Student name: Nicky Randles
// Student number: B00058026
// Lab: 9
// Task: 3

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class question03 extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		question03 internalFrame = new question03();
	} //end of main

	//creating content pane and frame
	Container c = getContentPane();
	JFrame frame;
	question03()
	{
		//seting title
		super("Input dialog");

		//creating press button and adding action listener
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
			//creating input dialog
			JOptionPane.showInputDialog(frame, "What is your name?", "Question 3", JOptionPane.PLAIN_MESSAGE);
		}

	} //end of action performed method

} //end of class