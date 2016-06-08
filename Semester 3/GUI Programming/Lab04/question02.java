// Student name: Nicky Randles
// Student number: B00058026
// Lab: 4
// Task: 2
import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class question02 extends JFrame implements ListSelectionListener
{
	//declaring list and string
	JList list;
	String animals[] = {"Lion", "Monkey", "Elephant", "Kangaroo", "Polar Bear", "Penguin", "Ostrich"};

	question02()
	{
		//seting title
		super("List");
		//creating content pane
		Container c = getContentPane();

		//creating list
		list = new JList(animals);
		//adding selection listener
		list.addListSelectionListener(this);
		//adding scroll pane
		JScrollPane pane = new JScrollPane(list);

		//adding scroll pane to content pane
		c.add(pane);

		//setting size and visibility
		setSize(250,250);
   		setVisible(true);

	}

	public static void main(String[] args)
	{
		question02 list = new question02();
	}

	public void valueChanged(ListSelectionEvent e)
	{
		Object source = e.getSource();
		if(source == list)
		{
			int selectionNum = 0;
			String message = "The index number for the animal you selected is: ";
			selectionNum = list.getSelectedIndex();
			message = message + selectionNum;


			JOptionPane.showMessageDialog(null, message, "Idex number", JOptionPane.ERROR_MESSAGE);

		}
	}
}