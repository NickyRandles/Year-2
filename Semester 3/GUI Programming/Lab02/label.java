// Student name: Nicky Randles
// Student number: B00058026
// Lab: 2
// Task: 2
import javax.swing.*;
import java.awt.*;

class label extends JFrame
{
	public label()
	{
		//seting title
		super("Task 2-2");
		//creating content pane and panel
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();

		//creating labels
		JLabel label01 = new JLabel("My first label");
		JLabel label02 = new JLabel("My second label");

		//creating fonts
		Font firstFont = new Font("Ariel", Font.ITALIC, 14);
		Font secondFont = new Font("Times", Font.BOLD, 12);

		//adding fonts to label
		label01.setFont(firstFont);
		label02.setFont(secondFont);

		//adding labels to panel
		panel.add(label01);
		panel.add(label02);
		//adding panel to content pane
		contentPane.add(panel);

		//setting size and visibility
		setSize(250,100);
		setVisible( true );

	}

	public static void main(String[] args)
	{
		label frame = new label();

	}
}