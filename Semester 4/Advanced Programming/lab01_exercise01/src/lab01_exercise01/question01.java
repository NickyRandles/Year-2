package lab01_exercise01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class question01 extends JFrame implements ActionListener
{
	question01()
	{
		//creating menu bar
		JMenuBar mb = new JMenuBar();

		//creating file menu
		JMenu file = new JMenu("File");

		//creating menu items
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem exitMenuItem = new JMenuItem("Exit");

		//adding menu items to file menu
		file.add(newMenuItem);
		file.add(openMenuItem);
		file.add(exitMenuItem);

		//adding action listener to exit menu item
		exitMenuItem.addActionListener(this);

		//adding file menu to menu bar
		mb.add(file);

		//setting mb as menu bar
		setJMenuBar(mb);

		//setting size and visibility
		setSize(250,250);
		setVisible(true);

	} //end of constructor

	public static void main(String[] args)
	{
		question01 menuBar = new question01();
	} //end of main

	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Exit"))
		{
			 System.exit(0);
		}

	} //end of action performed method

} //end of class