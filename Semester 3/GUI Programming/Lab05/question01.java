// Student name: Nicky Randles
// Student number: B00058026
// Lab: 5
// Task: 1
import javax.swing.*;
import java.awt.*;

public class question01 extends JFrame
{
	question01()
	{
		//setting title
		super("Textpad");
		//creating menu bar
		JMenuBar mb = new JMenuBar();
		//creating help menu
		JMenu helpMenu = new JMenu("Help", true);

		//creating menu items and adding to help menu
		helpMenu.add(new JMenuItem("Help Topics"));
		helpMenu.addSeparator(); //adding separator to help menu
		helpMenu.add(new JMenuItem("Technical Support"));
		helpMenu.add(new JMenuItem("Frequently Asked Questions"));
		helpMenu.add(new JMenuItem("TextPad on the Web"));
		helpMenu.add(new JMenuItem("Update Licence..."));
		helpMenu.add(new JMenuItem("Ordering Information"));
		helpMenu.addSeparator(); //adding separator to help menu
		helpMenu.add(new JMenuItem("Tip of the Day"));
		helpMenu.addSeparator(); //adding separator to help menu
		helpMenu.add(new JMenuItem("About TextPad..."));

		//adding help menu to menu bar
		mb.add(helpMenu);

		//setting mb as menu bar
		setJMenuBar(mb);

		//setting size and visbility
		setSize(300,300);
		setVisible(true);

	} //end of constructor

	public static void main(String[] args)
	{
		question01 helpMenu = new question01();
	} //end of main

} //end of class