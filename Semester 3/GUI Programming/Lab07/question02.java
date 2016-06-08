// Student name: Nicky Randles
// Student number: B00058026
// Lab: 7
// Task: 2

import javax.swing.*;
import java.awt.*;

public class question02 extends JFrame
{
	public static void main(String[] args)
	{
		question02 question = new question02();
	} //end of main

	question02()
	{
		//declaring and initiating desktop pane and innerframe
		JDesktopPane desktop = new JDesktopPane();
		JInternalFrame innerFrame = new JInternalFrame("My First Internal Frame");

		//setting resizability, size, location and visibility
		innerFrame.setResizable(false);
		innerFrame.setSize(640,480);
		innerFrame.setLocation(10,10);
		innerFrame.setVisible(true);

		//adding innerframe to desktop
		desktop.add(innerFrame);
		//setting desktop as content pane
		setContentPane(desktop);

		//declaring and initiating menu bar and file menu
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File", true);

		//adding menu items to file menu
		fileMenu.add(new JMenuItem("New"));
		fileMenu.add(new JMenuItem("Save"));
		fileMenu.add(new JMenuItem("Close"));

		//adding file menu to menu bar
		mb.add(fileMenu);
		//setting menu bar in innerframe
		innerFrame.setJMenuBar(mb);

		//setting size and visibility
		setSize(900,700);
		setVisible(true);
	} //end of constructor
} //end of class