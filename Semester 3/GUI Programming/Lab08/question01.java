// Student name: Nicky Randles
// Student number: B00058026
// Lab: 8
// Task: 1

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.*;

public class question01 extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		question01 question = new question01();
	} //end of main

	//declaring variables
	static private final String newline = "\n";
	JButton openButton, saveButton;
	JTextArea log;
	JFileChooser fc;

	question01()
	{
		//seting title
		super("File Chooser");

		//declaring and initiating content pane
		Container c = getContentPane();

		//initiating text area and setting its size
		log = new JTextArea(5,20);

		//initiating file chooser
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		//initiating open button and adding action listener
		openButton = new JButton("Open File");
		openButton.addActionListener(this);

		//initiating save button and adding action listener
		saveButton = new JButton("Save File");
		saveButton.addActionListener(this);

		//creating button panel and assigning it a grid layout
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));

		//adding buttons to button panel
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		//adding button panel to the north of the content pane
		c.add(buttonPanel, BorderLayout.NORTH);

		//setting size and visibility of frame
		setSize(300,300);
		setVisible(true);
	} //end of constructor

	public void actionPerformed(ActionEvent e)
	{
		//If statement for open button
        if (e.getSource() == openButton)
        {
            int returnVal = fc.showOpenDialog(question01.this);

            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + newline);
            }
            else
            {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
		} //end of open button if statement

		//If statement for save button
         else if (e.getSource() == saveButton)
         {
            int returnVal = fc.showSaveDialog(question01.this);

            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." + newline);
            }
            else
            {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        } //end of save button if statement

	} //end of action performed method

} //end of class