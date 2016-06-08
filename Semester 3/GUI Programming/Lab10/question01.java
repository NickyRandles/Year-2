// Student name: Nicky Randles
// Student number: B00058026
// Lab: 9
// Task: 1

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class question01 extends JFrame
{
	public static void main(String[] args)
	{
		question01 question = new question01();
	} //end of main

	question01()
	{
		//setting title
		super("Draw line, rectangle and polygon");

		//setting size and visibility
		setSize(325,350);
		setVisible(true);

	} //end of constructor

	public void paint(Graphics g)
	{
		// call superclass's paint method
		super.paint(g);

		//setting color to green
		g.setColor(Color.green);
		//drawing line and setting co-ordinates
		g.drawLine(0, 40, 325, 40);

		//setting color to blue
		g.setColor(Color.blue);
		//drawing rectangle and setting co-ordinates
		g.drawRect(60, 50, 200, 100);
		//filling triangle
		g.fillRect(60, 50, 200, 100);

		//creating arrays containing the axis values
		int xValues[] = {120, 200, 260, 200, 120, 60 , 120};
		int yValues[] = {170, 170, 250, 330, 330, 250, 170};
		//setting color to orange
		g.setColor(Color.orange);
		//filling polygon and adding array values to the x and y axis
		g.fillPolygon(xValues, yValues, 7);

	} //end of paint method

} //end of class