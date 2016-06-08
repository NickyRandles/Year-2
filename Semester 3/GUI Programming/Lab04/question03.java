// Student name: Nicky Randles
// Student number: B00058026
// Lab: 4
// Task: 3
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class question03 extends JFrame implements ActionListener
{
	question03()
	{
		//seting title
		super("Ireland capital");
		//creating content pane and panel
		Container c = getContentPane();
		JPanel panel = new JPanel();

		//creating JLabel
		JLabel question = new JLabel("What is the capital of Ireland?");

		//creating button group
		ButtonGroup group = new ButtonGroup();

		//creating radio buttons
		JRadioButton cork = new JRadioButton("Cork");
		JRadioButton dublin = new JRadioButton("Dublin");
		JRadioButton tralee = new JRadioButton("tralee");
		JRadioButton donegal = new JRadioButton("Donegal");


		//adding action listeners to  radio buttons
		cork.addActionListener(this);
		dublin.addActionListener(this);
		tralee.addActionListener(this);
		donegal.addActionListener(this);

		//adding question to panel
		panel.add(question);
		//adding radio buttons to group
		group.add(cork);
		group.add(dublin);
		group.add(tralee);
		group.add(donegal);
		//adding radio buttons to panel
		panel.add(cork);
		panel.add(dublin);
		panel.add(tralee);
		panel.add(donegal);
		//adding panel to content pane
    	c.add(panel);

		//setting size and visibility
		setSize(200,200);
   		setVisible(true);

	}

	public static void main(String[] args)
	{
		question03 irelandCapital = new question03();
	}

	public void actionPerformed(ActionEvent e)
	{
		String message = "";

		if (e.getActionCommand().equals("Dublin") ) message = "That's correct!";
		else message = "Sorry";

		JOptionPane.showMessageDialog(null, message, "Answer", JOptionPane.ERROR_MESSAGE);
	}

}