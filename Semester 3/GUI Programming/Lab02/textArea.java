// Student name: Nicky Randles
// Student number: B00058026
// Lab: 2
// Task: 4
import javax.swing.*;
import java.awt.*;

class textArea extends JFrame
{
	public textArea()
	{
		//seting title
		super("Task 2-4");
		//creating content pane and panel
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();

		//creating text area 1
		JTextArea textArea01 = new JTextArea("This is my first text area");
		textArea01.setEditable(true);

		//creating text area 2
		JTextArea textArea02 = new JTextArea("This is my second text area");
		textArea02.setEditable(false);

		//adding text areas to panel
		panel.add(textArea01);
		panel.add(textArea02);
		//adding panel to content pane
		contentPane.add(panel);

		//setting size and visibility
		setSize(300,300);
		setVisible(true);


	}

	public static void main(String[] args)
	{
		textArea frame = new textArea();
	}
}