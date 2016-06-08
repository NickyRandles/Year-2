// Student name: Nicky Randles
// Student number: B00058026
// Lab: 3
// Task: 3
import javax.swing.*;
import java.awt.*;

class question03 extends JFrame
{
	question03()
	{
		//seting title
		super("Ireland capital");
		//creating content pane and panel
		Container c = getContentPane();
		JPanel panel = new JPanel();

		//creating label
		JLabel question = new JLabel("What is the capital of Ireland?");
		//creating button group
		ButtonGroup group = new ButtonGroup();

		//creating radio buttons
		JRadioButton cork = new JRadioButton("Cork");
		JRadioButton dublin = new JRadioButton("Dublin");
		JRadioButton tralee = new JRadioButton("tralee");
		JRadioButton donegal = new JRadioButton("Donegal");

		//adding question to panel
		panel.add(question);
		//adding buttons to button group
		group.add(cork);
		group.add(dublin);
		group.add(tralee);
		group.add(donegal);
		//adding buttons to panel
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
}