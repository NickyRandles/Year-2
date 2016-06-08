// Student name: Nicky Randles
// Student number: B00058026
// Lab: 3
// Task: 2
import javax.swing.*;
import java.awt.*;

class question02 extends JFrame
{
	question02()
	{
		//seting title
		super("Animals");
		//creating content pane
		Container c = getContentPane();

		//creating string, list and scroll pane
		String animals[] = {"Lion", "Monkey", "Elephant", "Kangaroo", "Polar Bear", "Penguin", "Ostrich"};
		JList<String> animalList = new JList<String>(animals);
		JScrollPane pane = new JScrollPane(animalList);

		//adding pane to content pane
		c.add(pane);

		//setting size and visibility
		setSize(300,300);
   		setVisible(true);

	}

	public static void main(String[] args)
	{
		question02 animalList = new question02();
	}
}