// Student name: Nicky Randles
// Student number: B00058026
// Lab: 3
// Task: 1
import javax.swing.*;
import java.awt.*;

class question01 extends JFrame
{
	question01()
	{
		//seting title
		super("Logon");
		//creating content pane and panel
		Container c = getContentPane();
		JPanel panel = new JPanel();

		//creating text field and password field
		JTextField username = new JTextField(20);
		JPasswordField password = new JPasswordField(20);

		//adding fields to panel
		panel.add(username);
		panel.add(password);
		//adding panel to content pane
		c.add(panel);

		//setting size and visibility
		setSize(250,200);
   		setVisible(true);

	}

	public static void main(String[] args)
	{
		question01 login = new question01();
	}
}