// Student name: Nicky Randles
// Student number: B00058026
// Lab: 7
// Task: 3

import javax.swing.*;
import java.awt.*;

public class question03 extends JFrame
{
	question03()
	{
		//declaring and initiating desktop pane and innerframe
		JDesktopPane desktop = new JDesktopPane();

		for(int i = 0; i < 5; i++)
		{
			JInternalFrame innerFrame = new JInternalFrame("Frame: " + (i + 1));

			//setting resizability, size, location and visibility
			innerFrame.setResizable(false);
			innerFrame.setSize(300,300);
			innerFrame.setVisible(true);
			innerFrame.setLocation(10 * 8 * i, 10 * 8 * i);

			//adding innerframe to desktop
			desktop.add(innerFrame);
		} //end of for loop

		//setting desktop as content pane
		setContentPane(desktop);

		//setting size and visibility
		setSize(900, 700);
		setVisible(true);

	} //end of constructor

	public static void main(String[] args)
	{
		question03 internalFrame = new question03();
	} //end of main

} //end of class
