// Student name: Nicky Randles
// Student number: B00058026
// Lab: 4
// Task: 1
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class question01 extends JFrame implements ActionListener
{
	question01()
	{
		//seting title
		super("Buttons");
		//creating content pane and panel
		Container c = getContentPane();
		JPanel panel = new JPanel();

		//creating buttons
		JButton button01 = new JButton("Button 1");
		JButton button02 = new JButton("Button 2");
		JButton button03 = new JButton("Button 3");

		//adding action listeners
		button01.addActionListener(this);
		button02.addActionListener(this);
		button03.addActionListener(this);

		//adding icon to button
		Icon buttonIcon = new ImageIcon("bug1.gif");
		button01.setIcon(buttonIcon);

		//setting font of button
		Font buttonFont = new Font("Serif", Font.ITALIC, 12);
		button02.setFont(buttonFont);

		//adding buttons to panel
		panel.add(button01);
		panel.add(button02);
		panel.add(button03);
		//adding panel to content pane
		c.add(panel);

		//setting size and visibility
		setSize(200,200);
   		setVisible(true);

	}

	public static void main(String[] args)
	{
		question01 buttons = new question01();
	}

	public void actionPerformed(ActionEvent e)
	{
		String message = "";

		if (e.getActionCommand().equals("Button 1") )
		{
			message = "You clicked on button 1";
		}

		else if (e.getActionCommand().equals("Button 2") )
		{
			message = "You clicked on button 2";
		}

		else
		{
			message = "You clicked on button 3";
		}

		JOptionPane.showMessageDialog(null, message, "Buttons", JOptionPane.ERROR_MESSAGE);
	}
}