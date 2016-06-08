// Student name: Nicky Randles
// Student number: B00058026
// Assignment: 1

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class assignment01 extends JFrame implements ActionListener
{

	public static void main(String[] args)
	{
		assignment01 assignment = new assignment01();
	} //end of method

	//declaring content pane, JPanel, JLabel, JButton, and Icon
	Container c = getContentPane();
	JPanel boardPanel, buttonPanel, topLetterPanel, sideNumberPanel;
	JLabel topLeftLabel, topRightLabel, bottomLeftLabel, bottomRightLabel, ALabel, BLabel, oneLabel, twoLabel;
	JButton northWestButton, northButton, northEastButton, westButton, refreshButton, eastButton, southWestButton, southButton, southEastButton;
	Icon whitePawnIcon = new ImageIcon("whitePawn.jpg"), blackPawnIcon = new ImageIcon("blackPawn.jpg"), northEastIcon, northIcon, northWestIcon, westIcon, refreshIcon, eastIcon, southEastIcon, southIcon, southWestIcon;

	assignment01()
	{
		//calling panel method
		panel();
		//calling label method
		label();
		//calling button method
		button();

		//setting size, location and visibility
		setSize(400,600);
		setLocation(300,50);
		setVisible(true);

	} //end of constructor


	public void panel()
	{
		//initiating letter panel
		topLetterPanel = new JPanel();
		//assigning layout to letter panel
		topLetterPanel.setLayout(new GridLayout(1,2));

		//initiating number panel
		sideNumberPanel = new JPanel();
		//assigning layout to letter panel
		sideNumberPanel.setLayout(new GridLayout(2,1));

		//initiating board panel
		boardPanel = new JPanel();
		//asigning layout to board panel
		boardPanel.setLayout(new GridLayout(2,2));

		//initiating button panel
		buttonPanel = new JPanel();
		//asigning layout to button panel
		buttonPanel.setLayout(new GridLayout(3,3));

		//adding panels to content pane and assigning them
		//their posistions in the border layout
		c.add(topLetterPanel, BorderLayout.NORTH);
		c.add(sideNumberPanel, BorderLayout.WEST);
		c.add(boardPanel, BorderLayout.CENTER);
		c.add(buttonPanel, BorderLayout.SOUTH);

	} //end of panel method

	public void label()
	{
		//initiating top left label
		topLeftLabel = new JLabel();
		//assigning pawn icon to label
		topLeftLabel.setIcon(whitePawnIcon);

		//initiating top right label
		topRightLabel = new JLabel();
		//setting background colour
		topRightLabel.setBackground(Color.black);
		topRightLabel.setOpaque(true);

		//initiating bottom left label
		bottomLeftLabel = new JLabel();
		//setting background colour
		bottomLeftLabel.setBackground(Color.black);
		bottomLeftLabel.setOpaque(true);

		//initiating bottom right label
		bottomRightLabel = new JLabel();

		//initiating A label and adding text
		ALabel = new JLabel("                                A");
		//adding A label to top letter panel
		topLetterPanel.add(ALabel);

		//initiating B label and adding text
		BLabel = new JLabel("                                B");
		//adding B label to top letter panel
		topLetterPanel.add(BLabel);

		//initiating one label and adding text
		oneLabel = new JLabel("1");
		//adding one label to side number panel
		sideNumberPanel.add(oneLabel);

		//initiating two label and adding text
		twoLabel = new JLabel("2");
		//adding two label to side number panel
		sideNumberPanel.add(twoLabel);

		//adding labels to board panel.
		boardPanel.add(topLeftLabel);
		boardPanel.add(topRightLabel);
		boardPanel.add(bottomLeftLabel);
		boardPanel.add(bottomRightLabel);

	} //end of label method

	public void button()
	{
		//initiating north west button
		northWestButton = new JButton();
		//initiating north west icon
		northWestIcon = new ImageIcon("northWest.jpg");
		//adding north west icon to north west button
		northWestButton.setIcon(northWestIcon);

		//initiating north button
		northButton = new JButton();
		//initiating north icon
		northIcon = new ImageIcon("north.jpg");
		//adding north icon to north button
		northButton.setIcon(northIcon);

		//initiating north east button
		northEastButton = new JButton();
		//initiating north east icon
		northEastIcon = new ImageIcon("northEast.jpg");
		//adding north east icon to north east button
		northEastButton.setIcon(northEastIcon);

		//initiating west button
		westButton = new JButton();
		//initiating west button
		westIcon = new ImageIcon("west.jpg");
		//adding west icon to west button
		westButton.setIcon(westIcon);

		//initiating refresh button
		refreshButton = new JButton();
		//initiating refresh icon
		refreshIcon = new ImageIcon("refresh.jpg");
		//adding refresh icon to refresh button
		refreshButton.setIcon(refreshIcon);

		//initiating east button
		eastButton = new JButton();
		//initiating east icon
		eastIcon = new ImageIcon("east.jpg");
		//adding east icon to east button
		eastButton.setIcon(eastIcon);

		//initiating south west button
		southWestButton = new JButton();
		//initiating south west icon
		southWestIcon = new ImageIcon("southWest.jpg");
		//adding south west icon to south west button
		southWestButton.setIcon(southWestIcon);

		//initiating south button
		southButton = new JButton();
		//initiating south icon
		southIcon = new ImageIcon("south.jpg");
		//adding south icon to south button
		southButton.setIcon(southIcon);

		//initiating south east button
		southEastButton = new JButton();
		//initiating south east icon
		southEastIcon = new ImageIcon("southEast.jpg");
		//adding south east icon to south east button
		southEastButton.setIcon(southEastIcon);

		//adding buttons to button panel
		buttonPanel.add(northWestButton);
		buttonPanel.add(northButton);
		buttonPanel.add(northEastButton);
		buttonPanel.add(westButton);
		buttonPanel.add(refreshButton);
		buttonPanel.add(eastButton);
		buttonPanel.add(southWestButton);
		buttonPanel.add(southButton);
		buttonPanel.add(southEastButton);

		//Adding event listeners to the components
		northWestButton.addActionListener(this);
		northButton.addActionListener(this);
		northEastButton.addActionListener(this);
		westButton.addActionListener(this);
		northButton.addActionListener(this);
		eastButton.addActionListener(this);
		southWestButton.addActionListener(this);
		southButton.addActionListener(this);
		southEastButton.addActionListener(this);
		refreshButton.addActionListener(this);

		//if statement to enable and disable certain buttons
		if(topLeftLabel.getIcon()!=null)
		{
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(true);
			southEastButton.setEnabled(true);
		} //end of if statement

	} //end of button method

	public void actionPerformed(ActionEvent e)
	{
		//actions performed when the top left label contains an icon
		if(e.getSource() == eastButton && topLeftLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			topLeftLabel.setIcon(null);
			topRightLabel.setIcon(blackPawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(true);
			eastButton.setEnabled(false);
			southWestButton.setEnabled(true);
			southButton.setEnabled(true);
			southEastButton.setEnabled(false);
		} //end of if statement

		else if(e.getSource() == southButton && topLeftLabel.getIcon() != null)
		{
			//removing icon from label and assigning icon to another label
			topLeftLabel.setIcon(null);
			bottomLeftLabel.setIcon(blackPawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(true);
			northEastButton.setEnabled(true);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(false);
			southEastButton.setEnabled(false);
		} //end of if statement

		else if(e.getSource()== southEastButton && topLeftLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			topLeftLabel.setIcon(null);
			bottomRightLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(true);
			northButton.setEnabled(true);
			northEastButton.setEnabled(false);
			westButton.setEnabled(true);
			eastButton.setEnabled(false);
			southWestButton.setEnabled(false);
			southButton.setEnabled(false);
			southEastButton.setEnabled(false);
		} //end of if statement

		//actions performed when the top right label contains an icon
		else if(e.getSource()== westButton && topRightLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			topRightLabel.setIcon(null);
			topLeftLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(true);
			southEastButton.setEnabled(true);
		} //end of if statement

		else if(e.getSource()== southButton && topRightLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			topRightLabel.setIcon(null);
			bottomRightLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(true);
			northButton.setEnabled(true);
			northEastButton.setEnabled(false);
			westButton.setEnabled(true);
			eastButton.setEnabled(false);
			southWestButton.setEnabled(false);
			southButton.setEnabled(false);
			southEastButton.setEnabled(false);
		} //end of if statement

		else if(e.getSource()== southWestButton && topRightLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			topRightLabel.setIcon(null);
			bottomLeftLabel.setIcon(blackPawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(true);
			northEastButton.setEnabled(true);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(false);
			southEastButton.setEnabled(false);
		} //end of if statement

		//actions performed when the bottom left label contains an icon
		else if(e.getSource()== northButton && bottomLeftLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			bottomLeftLabel.setIcon(null);
			topLeftLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(true);
			southEastButton.setEnabled(true);
		} //end of if statement

		else if(e.getSource()== northEastButton && bottomLeftLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			bottomLeftLabel.setIcon(null);
			topRightLabel.setIcon(blackPawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(true);
			eastButton.setEnabled(false);
			southWestButton.setEnabled(true);
			southButton.setEnabled(true);
			southEastButton.setEnabled(false);
		} //end of if statement

		else if(e.getSource()== eastButton && bottomLeftLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			bottomLeftLabel.setIcon(null);
			bottomRightLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(true);
			northButton.setEnabled(true);
			northEastButton.setEnabled(false);
			westButton.setEnabled(true);
			eastButton.setEnabled(false);
			southWestButton.setEnabled(false);
			southButton.setEnabled(false);
			southEastButton.setEnabled(false);
		} //end of if statement

		//actions performed when the bottom right label contains an icon
		else if(e.getSource()== northButton && bottomRightLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			bottomRightLabel.setIcon(null);
			topRightLabel.setIcon(blackPawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(true);
			eastButton.setEnabled(false);
			southWestButton.setEnabled(true);
			southButton.setEnabled(true);
			southEastButton.setEnabled(false);
		} //end of if statement

		else if(e.getSource()== westButton && bottomRightLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			bottomRightLabel.setIcon(null);
			bottomLeftLabel.setIcon(blackPawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(true);
			northEastButton.setEnabled(true);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(false);
			southEastButton.setEnabled(false);
		} //end of if statement

		else if(e.getSource()== northEastButton && bottomRightLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			bottomRightLabel.setIcon(null);
			topLeftLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(true);
			southEastButton.setEnabled(true);
		} //end of if statement

		//actions performed when then refresh button is clicked
		else if(e.getSource()== refreshButton && topRightLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			topRightLabel.setIcon(null);
			topLeftLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(true);
			southEastButton.setEnabled(true);
		} //end of if statement

		else if(e.getSource()== refreshButton && bottomLeftLabel.getIcon()!=null)
		{	//removing icon from label and assigning icon to another label
			bottomLeftLabel.setIcon(null);
			topLeftLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(true);
			southEastButton.setEnabled(true);
		} //end of if statement

		else if(e.getSource()== refreshButton && bottomRightLabel.getIcon()!=null)
		{
			//removing icon from label and assigning icon to another label
			bottomRightLabel.setIcon(null);
			topLeftLabel.setIcon(whitePawnIcon);

			//enabling and disabling certain buttons
			northWestButton.setEnabled(false);
			northButton.setEnabled(false);
			northEastButton.setEnabled(false);
			westButton.setEnabled(false);
			eastButton.setEnabled(true);
			southWestButton.setEnabled(false);
			southButton.setEnabled(true);
			southEastButton.setEnabled(true);
		} //end of if statement

	} //end of action performed method

} //end of class