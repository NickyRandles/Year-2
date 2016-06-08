// Student name: Nicky Randles
// Student number: B00058026
// Lab: 7
// Task: 1

import javax.swing.*;
import java.awt.*;

public class question01 extends JFrame
{
	question01()
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

		//setting size and visibility
		setSize(900,700);
		setVisible(true);

	} //end of constructor

	public static void main(String[] args)
	{
		question01 internalFrame = new question01();
	} //end of main

} //end of class
