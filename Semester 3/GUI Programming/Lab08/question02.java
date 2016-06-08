// Student name: Nicky Randles
// Student number: B00058026
// Lab: 8
// Task: 2

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.MouseInputListener;
import javax.swing.border.LineBorder;

public class question02 extends JFrame implements MouseInputListener
{
	//declaring variables
	Container c = getContentPane();
	JPanel mousePanel, actionPanel;
	JLabel mouseLabel, midLabel;


	question02()
	{
		//initiating mouse panel and action panel
		mousePanel = new JPanel();
		actionPanel = new JPanel();
		//setting layouts of panels
		actionPanel.setLayout(new BorderLayout());
		mousePanel.setLayout(new BorderLayout());
		//setting border of action panel
		actionPanel.setBorder(BorderFactory.createLineBorder(Color.white, 70));

		//initiating mouse label
		mouseLabel = new JLabel();
		//setting foreground color, border, and text of mouse label
		mouseLabel.setForeground(Color.RED);
		mouseLabel.setBorder(new LineBorder(Color.BLACK));
		mouseLabel.setText("Current Mouse Action Listed Here");
		//adding mouse label to the south of mouse panel
		mousePanel.add(mouseLabel,BorderLayout.SOUTH);

		//initiating midLabel
		midLabel = new JLabel();
		//setting border of midLabel
		midLabel.setBorder(new LineBorder(Color.BLACK));
		//adding mouse listener to mid label
		midLabel.addMouseListener(this);
		//adding midLabel to the center of action panel
		actionPanel.add(midLabel, BorderLayout.CENTER);

		//adding action panel to mouse panel
		mousePanel.add(actionPanel);
		//adding mouse panel to content pane
		c.add(mousePanel);

		//adding mouse listener and mouse motiion listener to mouse panel
		mousePanel.addMouseListener(this);
		mousePanel.addMouseMotionListener(this);

		//setting size and visibility
		setSize(300,300);
		setVisible(true);

	} //end of constructor

	public static void main(String[] args)
	{
		question02 internalFrame = new question02();
	} //end of main


	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() == midLabel)
		{
			//setting text of mouse label
			mouseLabel.setText("Mouse Click Event");
			//setting text of mid label
			midLabel.setText("Click\n" + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());
		}
	} //end of mouse clicked method

	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource() == midLabel)
		{
			//setting text of mouse label
			mouseLabel.setText("Mouse Entered Event");
			//setting text of mid label
			midLabel.setText("Enter");
		}
	} //end of mouse entered method

	public void mouseExited(MouseEvent e)
	{
		if(e.getSource() == midLabel)
		{
			//setting text of mouse label
			mouseLabel.setText("Mouse Exit Event");
			//setting text of mid label
			midLabel.setText("Exit");
		}
	} //end of mouse exited method

	public void mousePressed(MouseEvent e)
	{
		if(e.getSource() == midLabel)
		{
			//setting text of mouse label
			mouseLabel.setText("Mouse Pressed Event");
			//setting text of mid label
			midLabel.setText("Pressed");
		}
	} //end of mouse pressed method

	public void mouseReleased(MouseEvent e)
	{
		if(e.getSource() == midLabel)
		{
			//setting text of mouse label
			mouseLabel.setText("Mouse Released Event");
			//setting text of mid label
			midLabel.setText("Release");
		}
	} //end of mouse released method

	public void mouseDragged(MouseEvent e)
	{
		//setting text of mouse label
		mouseLabel.setText("Mouse Dragged " + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());
		if(e.getSource() == midLabel)
		{
			//setting text of mid label
			midLabel.setText("Drag");
		}
	} //end of mouse dragged method

	public void mouseMoved(MouseEvent e)
	{
		//setting text of mouse label
		mouseLabel.setText("Mouse Move " + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());
		if(e.getSource() == midLabel)
		{
			//setting text of mid label
			midLabel.setText("Move");
		}
	} //end of mouse moved method

} //end of class
