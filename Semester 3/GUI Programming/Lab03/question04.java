// Student name: Nicky Randles
// Student number: B00058026
// Lab: 3
// Task: 4
import javax.swing.*;
import java.awt.*;

class question04 extends JFrame
{
	question04()
	{
		//seting title
		super("Logon");
		//creating content pane and panel
		Container c = getContentPane();
		JPanel panel = new JPanel();

		//creating text field and password field
		JTextField username = new JTextField(20);
		JPasswordField password = new JPasswordField(20);

		//creating buttons
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");

		//adding fields to panel
		panel.add(username);
		panel.add(password);
		//adding buttons to panel
		panel.add(okButton);
		panel.add(cancelButton);
		//adding panel to content pane
		c.add(panel);

		//setting size and visibility
		setSize(250,150);
   		setVisible(true);

	}

	public static void main(String[] args)
	{
		question04 login = new question04();
	}
}