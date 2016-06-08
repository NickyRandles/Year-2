// Student name: Nicky Randles
// Student number: B00058026
// Assignment: 2

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;

class assignment02 extends JFrame implements ActionListener, MouseInputListener
{
	public static void main(String[] args)
	{
		assignment02 assignment = new assignment02();
	} //end of main

	//declaring varibles
	JDesktopPane desktop;
	JMenuBar mb, menuBar;
	JMenu fileMenu, selectMenu, helpMenu, optionMenu;
	JMenuItem exitItem, mouseItem, languageItem, informationItem, refreshItem;
	JInternalFrame mouseEventFrame, languageCountFrame, helpFrame;
	JPanel mousePanel, actionPanel, gamePanel, numberPanel, comboPanel, helpPanel;
	JLabel mouseLabel, midLabel, titleLabel;
	JTextArea gameInfo;
	int [] numbers;
	JLabel[] label;
	String nums[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "un", "deux", "trois", "quatre", "cinq", "síx", "sept", "huit", "neuf", "dix", "amháin", "dhá", "trí", "ceithre", "cúig", "sé", "seacht", "ocht", "naoi", "deich", };
	String languages[] = {"English", "French", "Irish"};
	JComboBox <String> languageBox;
	int i, j, l, n;
	int [] clicked = new int[30];
	JFrame frame;
	Object[] options = {"Try again", "Leave"};
	Icon congratsIcon = new ImageIcon("congrats.gif");
	Icon sorryIcon = new ImageIcon("sorry.jpg");

	assignment02()
	{
		//initiating desktop pane
		desktop = new JDesktopPane();
		//setting desktop as content pane
		setContentPane(desktop);

		//calling menu bar method
		menuBar();
		//calling mouse event method
		mouseEvent();
		//calling language count method
		languageCount();
		//calling help information method
		helpInformaton();

		//setting size, location and visibility
		setSize(800,450);
		setLocation(175,150);
		setVisible(true);

	} //end of constructor

	public void menuBar()
	{
		//initiating menu bar
		mb = new JMenuBar();
		//initiating file menu, select menu, and help menu
		fileMenu = new JMenu("File", true);
		selectMenu = new JMenu("Select", true);
		helpMenu = new JMenu("Help", true);

		//initiating exit menu item
		exitItem = new JMenuItem("Exit");
		//setting mnemonic and acceleraor
		exitItem.setMnemonic(KeyEvent.VK_E);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		//adding action listener to exit menu item
		exitItem.addActionListener(this);
		//adding exit menu item to file menu
		fileMenu.add(exitItem);

		//initiating mouse menu item
		mouseItem = new JMenuItem("Mouse Window");
		//setting mnemonic and acceleraor
		mouseItem.setMnemonic(KeyEvent.VK_M);
		mouseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		//adding action listener to mouse menu item
		mouseItem.addActionListener(this);
		//adding mouse menu item to select menu
		selectMenu.add(mouseItem);

		//initiating language menu item
		languageItem = new JMenuItem("Language Counting 1 - 10");
		//setting mnemonic and acceleraor
		languageItem.setMnemonic(KeyEvent.VK_L);
		languageItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		//adding action listener to language menu item
		languageItem.addActionListener(this);
		//adding language menu item to select menu
		selectMenu.add(languageItem);

		//initiating information menu item
		informationItem = new JMenuItem("Information");
		//setting mnemonic and acceleraor
		informationItem.setMnemonic(KeyEvent.VK_I);
		informationItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
		//adding action listener to information menu item
		informationItem.addActionListener(this);
		//adding information menu item to help menu
		helpMenu.add(informationItem);

		//adding menus to menu bar
		mb.add(fileMenu);
		mb.add(selectMenu);
		mb.add(helpMenu);

		//setting the menu bar as mb
		setJMenuBar(mb);
	} //end of menuBar method

	public void mouseEvent()
	{
		//initiating mouse event internal frame
		mouseEventFrame = new JInternalFrame("Mouse Event demo");

		//setting size, location, resizability, closability and the maximize and minimize abitlities of mouseEventFrame
		mouseEventFrame.setSize(220,220);
		mouseEventFrame.setLocation(20,50);
		mouseEventFrame.setResizable(true);
		mouseEventFrame.setClosable(true);
		mouseEventFrame.setMaximizable(true);
		mouseEventFrame.setIconifiable(true);

		//adding mouse event frame to desktop
		desktop.add(mouseEventFrame);

		//initiating mouse panel and action panel
		mousePanel = new JPanel();
		actionPanel = new JPanel();
		//setting layouts of panels
		actionPanel.setLayout(new BorderLayout());
		mousePanel.setLayout(new BorderLayout());
		//setting border of action panel
		actionPanel.setBorder(BorderFactory.createLineBorder(Color.white, 35));

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
		//adding mouse panel to mouse event frame
		mouseEventFrame.add(mousePanel);

		//adding mouse listener and mouse motiion listener to mouse panel
		mousePanel.addMouseListener(this);
		mousePanel.addMouseMotionListener(this);
	} //end of mouseEvent method

	public void languageCount()
	{
		//initiating language count internal frame
		languageCountFrame = new JInternalFrame("Language Count 1 - 10");

		//setting size, location, resizability, closability and the maximize and minimize abitlities of languageCountFrame
		languageCountFrame.setSize(500,220);
		languageCountFrame.setLocation(260,50);
		languageCountFrame.setResizable(true);
		languageCountFrame.setClosable(true);
		languageCountFrame.setMaximizable(true);
		languageCountFrame.setIconifiable(true);

		//adding language count frame to desktop
		desktop.add(languageCountFrame);

		//initiating menu bar
		menuBar = new JMenuBar();
		//initiating option menu
		optionMenu = new JMenu("Options");

		//initiating refresh menu item
		refreshItem = new JMenuItem("Refresh");
		//setting mnemonic and acceleraor
		refreshItem.setMnemonic(KeyEvent.VK_R);
		refreshItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		//adding action listener to refresh item
		refreshItem.addActionListener(this);
		//adding refresh menu item to option menu
		optionMenu.add(refreshItem);

		//setting menuBar as the menu bar for the language count frame
		languageCountFrame.setJMenuBar(menuBar);

		//adding option menu to the menubar
		menuBar.add(optionMenu);

		//initiating game panel and giving it a border layout
		gamePanel = new JPanel(new BorderLayout());

		//initiating numbers array and giving it a size of 30
		numbers = new int[30];

		//initiating number panel and giving it a grid layout
		numberPanel = new JPanel(new GridLayout(5,6));

		//initiating label array and giving it a size of 30
		label = new JLabel[30];

		for(i = 0; i < 30; i++)
		{
			//initiating labels
			label[i] = new JLabel();
			//setting borders of labels
			label[i].setBorder(new LineBorder(Color.BLACK));
			//adding labels to number panel
			numberPanel.add(label[i]);
			//adding mouse listener to the labels
			label[i].addMouseListener(this);
		} //end of for loop

		//adding the number panel to the center of the game panel
		gamePanel.add(numberPanel, BorderLayout.CENTER);

		//initiating combo panel and giving it a border layout
		comboPanel = new JPanel(new BorderLayout());

		//initiating language combo box and adding language strings to combo box
		languageBox = new JComboBox<String>(languages);
		//adding language box to combo panel
		comboPanel.add(languageBox);

		//adding combo panel to the south of the game panel
		gamePanel.add(comboPanel, BorderLayout.SOUTH);

		//adding game panel to the language count frame
		languageCountFrame.add(gamePanel);

	} //end of languageCount method

	public void helpInformaton()
	{
		//initiating help frame
		helpFrame = new JInternalFrame("Help Information");

		//setting size, closability and the maximize and minimize abitlities of help frame
		helpFrame.setSize(250,200);
		helpFrame.setClosable(true);
		helpFrame.setMaximizable(true);
		helpFrame.setIconifiable(true);

		//initiating help panel with a border layout
		helpPanel = new JPanel(new BorderLayout());

		//initiating title label
		titleLabel = new JLabel("How to play the game");
		//initiating  game info text area
		gameInfo = new JTextArea();
		//setting text of game info
		gameInfo.setText("First you need to choose the language\n you want to play with. There a three\n languages you can choose from. They\n are French, English and Irish. After you\n have done that you will have to search\n the boxes and find the numbers in that\n language. Your objective is to find one\n to ten in the language you have chosen.\n If you select a number from a different\n language, a message will appear\n telling you that you have lost. You will\n then be given the option to try again or\n leave. If you get all numbers from one\n to ten in your chosen language, a\n message will appear congratulating\n you.");
		//setting editablity
		gameInfo.setEditable(false);
		//declaring scrollpane
		JScrollPane scrollPane = new JScrollPane(gameInfo);

		//adding title label to the north of help panel
		helpPanel.add(titleLabel, BorderLayout.NORTH);
		//adding scrollPane to the south of help panel
		helpPanel.add(scrollPane, BorderLayout.CENTER);

		//adding help panel to help frame
		helpFrame.add(helpPanel);

		//adding help frame to desktop
		desktop.add(helpFrame);
	} //end of help information method

	public void refresh()
	{
		for(j = 0; j < 30; j++)
		{
			//setting label text
			label[j].setText(null);
			//enabling label
			label[j].setEnabled(true);
			//setting clicked value
			clicked[j] = 0;
		} //end of for loop

		//setting the selected item of the language box
		languageBox.setSelectedItem(languages[0]);
	} //end of refresh method

	public void congratDialog()
	{
		//creating dialog and assigning values to it
		n = JOptionPane.showOptionDialog(frame, "Congratulations, you have won!", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, congratsIcon, options, options[0]);

 		if(n == JOptionPane.YES_OPTION)
		{
			//calling refresh method
			refresh();
		}

		else
		{
			languageCountFrame.dispose(); //disposing language count frame
		}
	} //end of congrats dialog method

	public void sorryDialog()
	{
		//creating dialog and assigning values to it
		n = JOptionPane.showOptionDialog(frame, "Sorry, better luck next time!", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, sorryIcon, options, options[0]);

		if(n == JOptionPane.YES_OPTION)
		{
			//calling refresh method
			refresh();
		}

		else
		{
			languageCountFrame.dispose(); //disposing language count frame
		}
	} //end of sorry dialog method

		public void actionPerformed(ActionEvent e)
		{
			if(exitItem.equals(e.getSource()))
			{
				System.exit(0); //closes program
			}

			else if(mouseItem.equals(e.getSource()))
			{
				//setting visibility of mouse event frame
				mouseEventFrame.setVisible(true);
			}

			else if(languageItem.equals(e.getSource()))
			{
				//setting visibility of language count frame
				languageCountFrame.setVisible(true);
			}

			else if(informationItem.equals(e.getSource()))
			{
				//setting visibility of help frame
				helpFrame.setVisible(true);
			}

			else if(refreshItem.equals(e.getSource()))
			{
				//calling refresh method
				refresh();
			}
		} //end of action performed method

		public void mouseClicked(MouseEvent e)
		{
			if(e.getSource() == midLabel)
			{
				//setting text of mouse label
				mouseLabel.setText("Mouse Click Event");
				//setting text of mid label
				midLabel.setText("Click\n" + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());
			}

			for(j = 0; j < 30; j++)
			{
				if(e.getSource() == label[j])
				{
					//setting text of labels
					label[j].setText(nums[j]);
					//disabling labels
					label[j].setEnabled(false);
					//setting clicked value
					clicked[j] = 1;
				}
			} //end of for loop

			//if statements for English language selection
			if(clicked[0] == 1 && clicked[1] == 1 && clicked[2] == 1 && clicked[3] == 1 && clicked[4] == 1 && clicked[5] == 1 && clicked[6] == 1 && clicked[7] == 1 && clicked[8] == 1 && clicked[9] == 1 && languageBox.getSelectedItem().equals("English"))
			{
				//calling congrats dialog method
				congratDialog();
			}

			for(l = 10; l < 30; l++)
			{
				if(e.getSource() == label[l] && languageBox.getSelectedItem().equals("English"))
				{
					//calling sorry dialog method
					sorryDialog();
				}
			} //end of for loop

			//if statements for French language selection
			if(clicked[10] == 1 && clicked[11] == 1 && clicked[12] == 1 && clicked[13] == 1 && clicked[14] == 1 && clicked[15] == 1 && clicked[16] == 1 && clicked[17] == 1 && clicked[18] == 1 && clicked[19] == 1 && languageBox.getSelectedItem().equals("French"))
			{
				//calling congrats dialog method
				congratDialog();
			}

			for(l = 0; l < 10; l++)
			{
				if(e.getSource() == label[l] && languageBox.getSelectedItem().equals("French"))
				{
					//calling sorry dialog method
					sorryDialog();
				}
			} //end of for loop

			for(l = 20; l < 30; l++)
			{
				if(e.getSource() == label[l] && languageBox.getSelectedItem().equals("French"))
				{
					//calling sorry dialog method
					sorryDialog();
				}
			} //end of for loop

			//if statements for Irish language selection
			if(clicked[20] == 1 && clicked[21] == 1 && clicked[22] == 1 && clicked[23] == 1 && clicked[24] == 1 && clicked[25] == 1 && clicked[26] == 1 && clicked[27] == 1 && clicked[28] == 1 && clicked[29] == 1 && languageBox.getSelectedItem().equals("Irish"))
			{
				//calling congrats dialog method
				congratDialog();
			}

			for(l = 0; l < 20; l++)
			{
				if(e.getSource() == label[l] && languageBox.getSelectedItem().equals("Irish"))
				{
					//calling sorry dialog method
					sorryDialog();
				}
			} //end of for loop
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

			for(j = 0; j < 30; j++)
			{
				if(e.getSource() == label[j])
				{
					//setting text of labels
					label[j].setText(nums[j]);
				}
			} //end of for loop
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

			for(j = 0; j < 30; j++)
			{
				if(e.getSource() == label[j])
				{
					//setting text of labels
					label[j].setText(null);

					if(clicked[j] == 1)
					{
						//setting text of labels
						label[j].setText(nums[j]);
					}
				}
			} //end of for loop
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