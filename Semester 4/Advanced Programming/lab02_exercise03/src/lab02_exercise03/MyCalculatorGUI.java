package lab02_exercise03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyCalculatorGUI extends JFrame implements ActionListener
{
	public static void main(String [] args)
	{
		MyCalculatorGUI gui = new MyCalculatorGUI();
		MathHelper math = new MathHelper();
	}
	
	JTextField input, output;
	JButton doubleButton, tripleButton;

	MyCalculatorGUI()
	{
		Container c = getContentPane();
		JPanel contents = new JPanel();
		contents.setLayout(new BorderLayout());
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,1));
		
		
		doubleButton = new JButton("Double");
		tripleButton = new JButton("Triple");
		
		input = new JTextField(20);
		output = new JTextField(20);
		output.setEditable(false);
		
		doubleButton.addActionListener(this);
		tripleButton.addActionListener(this);
		
		contents.add(input, BorderLayout.NORTH);
		buttons.add(doubleButton);
		buttons.add(tripleButton);
		contents.add(buttons, BorderLayout.CENTER);
		contents.add(output, BorderLayout.SOUTH);
		
		c.add(contents);
		
		
		
		setSize(250,250);
		setVisible(true);
	
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		int myInt = Integer.parseInt(input.getText());
		
		if(e.getSource() == doubleButton)
		{
			String newString = Integer.toString(MathHelper.doubleInt(myInt));
			output.setText("The number doubled is : " + newString);
		}
		
		else if(e.getSource() == tripleButton)
		{
			String newString = Integer.toString(MathHelper.tripleInt(myInt));
			output.setText("The number triple is : " + newString);
		}
		
		
	
	}
	
}