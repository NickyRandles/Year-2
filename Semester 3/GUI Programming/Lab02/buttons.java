// Student name: Nicky Randles
// Student number: B00058026
// Lab: 2
// Task: 3
import javax.swing.*;
import java.awt.*;

class buttons extends JFrame
{
	public buttons()
	{
		//creating title, content pane and panel
		super("Task 2-3");
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();

		//creating first button
		JButton firstButton = new JButton("My first Button");
		firstButton.setEnabled(true);

		//creating second button
		JButton secondButton = new JButton("My second Button");
		secondButton.setEnabled(true);
		//editing font of button 2
		Font secondButtonFont = new Font("Ariel", Font.BOLD, 12);
		secondButton.setFont(secondButtonFont);

		//creating third button
		JButton thirdButton = new JButton("My third Button");
		thirdButton.setEnabled(false);
		//editing font of button 3
		Font thirdButtonFont = new Font("Serif", Font.ITALIC, 14);
		thirdButton.setFont(thirdButtonFont);

		//adding buttons to panel
		panel.add(firstButton);
		panel.add(secondButton);
		panel.add(thirdButton);
		//adding panel to content panel
		contentPane.add(panel);

		//setting size and visibilty
		setSize(200,200);
		setVisible(true);


	}

	public static void main(String[] args)
	{
		buttons frame = new buttons();
	}
}

