package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameLogic extends JFrame implements ActionListener
{
		
	Container c = getContentPane();
	static JFrame frame;
	JPanel gamePanel, boardPanel, playerPanel;
	static JTextField [] text = new JTextField[9];
	String [] input = new String[9];
	JRadioButton player1Button, player2Button;
	JButton resetButton;
	ButtonGroup group = new ButtonGroup();
	Font font = new Font("Ariel", Font.BOLD, 26);
	char playerOneValue = 0, playerTwoValue = 0; 
	int move = 0;
	boolean value = false;
	static JTextField player1Selection;
	static JTextField player2Selection;
	

	

	GameLogic()
	{
		gamePanel = new JPanel();
		gamePanel.setLayout(new BorderLayout());
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3,3));
		playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(2,2));
		
		
		
		for(int i = 0; i < 9; i++ )
		{
			text[i] = new JTextField();
			text[i].addActionListener(this);
			text[i].setHorizontalAlignment(text[i].CENTER);
			text[i].setFont(font);
			text[i].addActionListener(this);
			boardPanel.add(text[i]);
		}
		
		player1Button = new JRadioButton("Player 1");
		player2Button = new JRadioButton("Player 2");	
		group = new ButtonGroup();
		group.add(player1Button);
		group.add(player2Button);
		

		playerPanel.add(player1Button);
		player1Selection = new JTextField();
		player1Selection.addActionListener(this);
		playerPanel.add(player1Selection);
		player2Selection = new JTextField();
		player2Selection.addActionListener(this);
		playerPanel.add(player2Button);
		playerPanel.add(player2Selection);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		gamePanel.add(resetButton, BorderLayout.SOUTH);
		
		gamePanel.add(boardPanel, BorderLayout.CENTER);
		gamePanel.add(playerPanel, BorderLayout.NORTH);
		c.add(gamePanel);
					
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(player1Button.isSelected() && e.getSource() == player1Selection)
		{
			if(player1Selection.getText().equals("x"))
			{	
				playerOneValue = 'x';
				playerTwoValue = 'o';
				player1Selection.setEnabled(false);
				player2Selection.setText("o");
				player2Selection.setEnabled(false);
			}
			
			else if(player1Selection.getText().equals("o"))
			{	
				playerOneValue = 'o';
				playerTwoValue = 'x';
				player1Selection.setEnabled(false);
				player2Selection.setText("x");
				player2Selection.setEnabled(false);
			}
			
			
			
			else
			{
				JOptionPane.showMessageDialog(frame, "Please enter an x or an o");
				player1Selection.setText("");
			}

		}
			
		else if(player2Button.isSelected() && e.getSource() == player2Selection)
		{
			if(player2Selection.getText().equals("x"))
			{	
				playerOneValue = 'o';
				playerTwoValue = 'x';
				player2Selection.setEnabled(false);
				player1Selection.setText("o");
				player1Selection.setEnabled(false);
			}
			
			else if(player2Selection.getText().equals("o"))
			{	
				playerOneValue = 'x';
				playerTwoValue = 'o';
				player2Selection.setEnabled(false);
				player1Selection.setText("x");
				player1Selection.setEnabled(false);
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame, "Please enter an x or an o");
				player2Selection.setText("");
			}

		}
		
			
		if(text[0].getText().equals("x") && player1Button.isSelected())
		{
			if(text[3].getText().equals("x") && player1Button.isSelected())
			{
				if(text[6].getText().equals("x") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
			
		if(text[0].getText().equals("x") && player1Button.isSelected())
		{
			if(text[4].getText().equals("x") && player1Button.isSelected())
			{
				if(text[8].getText().equals("x") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[0].getText().equals("x") && player1Button.isSelected())
		{
			if(text[1].getText().equals("x") && player1Button.isSelected())
			{
				if(text[2].getText().equals("x") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[2].getText().equals("x") && player1Button.isSelected())
		{
			if(text[4].getText().equals("x") && player1Button.isSelected())
			{
				if(text[6].getText().equals("x") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[2].getText().equals("x") && player1Button.isSelected())
		{
			if(text[5].getText().equals("x") && player1Button.isSelected())
			{
				if(text[8].getText().equals("x") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[6].getText().equals("x") && player1Button.isSelected())
		{
			if(text[7].getText().equals("x") && player1Button.isSelected())
			{
				if(text[8].getText().equals("x") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[3].getText().equals("x") && player1Button.isSelected())
		{
			if(text[4].getText().equals("x") && player1Button.isSelected())
			{
				if(text[5].getText().equals("x") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[1].getText().equals("x") && player1Button.isSelected())
		{
			if(text[4].getText().equals("x") && player1Button.isSelected())
			{
				if(text[7].getText().equals("x") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[0].getText().equals("o") && player1Button.isSelected())
		{
			if(text[3].getText().equals("o") && player1Button.isSelected())
			{
				if(text[6].getText().equals("o") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
			
		if(text[0].getText().equals("o") && player1Button.isSelected())
		{
			if(text[4].getText().equals("o") && player1Button.isSelected())
			{
				if(text[8].getText().equals("o") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[0].getText().equals("o") && player1Button.isSelected())
		{
			if(text[1].getText().equals("o")&& player1Button.isSelected())
			{
				if(text[2].getText().equals("o") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[2].getText().equals("o") && player1Button.isSelected())
		{
			if(text[4].getText().equals("o") && player1Button.isSelected())
			{
				if(text[6].getText().equals("o") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[2].getText().equals("o") && player1Button.isSelected())
		{
			if(text[5].getText().equals("o") && player1Button.isSelected())
			{
				if(text[8].getText().equals("o") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[6].getText().equals("o") && player1Button.isSelected())
		{
			if(text[7].getText().equals("o") && player1Button.isSelected())
			{
				if(text[8].getText().equals("o") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[3].getText().equals("o") && player1Button.isSelected())
		{
			if(text[4].getText().equals("o") && player1Button.isSelected())
			{
				if(text[5].getText().equals("o") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(text[1].getText().equals("o") && player1Button.isSelected())
		{
			if(text[4].getText().equals("o") && player1Button.isSelected())
			{
				if(text[7].getText().equals("o") && player1Button.isSelected())
				{
					player1WinDialog();
				}
			}
		}
		
		if(player2Button.isSelected() && e.getSource() == player1Selection)
		{
			if(player1Selection.getText().equals("x"))
			{	
				playerOneValue = 'x';
				playerTwoValue = 'o';
				player1Selection.setEnabled(false);
				player2Selection.setText("o");
				player2Selection.setEnabled(false);
			}
			
			else if(player1Selection.getText().equals("o"))
			{	
				playerOneValue = 'o';
				playerTwoValue = 'x';
				player1Selection.setEnabled(false);
				player2Selection.setText("x");
				player2Selection.setEnabled(false);
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame, "Please enter an x or an o");
				player1Selection.setText("");
			}

		}
		
		else if(player2Button.isSelected() && e.getSource() == player2Selection)
		{
			if(player2Selection.getText().equals("x"))
			{	
				playerOneValue = 'o';
				playerTwoValue = 'x';
				player2Selection.setEnabled(false);
				player1Selection.setText("o");
				player1Selection.setEnabled(false);
			}
			
			else if(player2Selection.getText().equals("o"))
			{	
				playerOneValue = 'x';
				playerTwoValue = 'o';
				player2Selection.setEnabled(false);
				player1Selection.setText("x");
				player1Selection.setEnabled(false);
			}
			
			else
			{
				JOptionPane.showMessageDialog(frame, "Please enter an x or an o");
				player2Selection.setText("");
			}

		}
		
			
		if(text[0].getText().equals("x") && player2Button.isSelected())
		{
			if(text[3].getText().equals("x") && player2Button.isSelected())
			{
				if(text[6].getText().equals("x") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
			
		if(text[0].getText().equals("x") && player2Button.isSelected())
		{
			if(text[4].getText().equals("x") && player2Button.isSelected())
			{
				if(text[8].getText().equals("x") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[0].getText().equals("x") && player2Button.isSelected())
		{
			if(text[1].getText().equals("x") && player2Button.isSelected())
			{
				if(text[2].getText().equals("x") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[2].getText().equals("x") && player2Button.isSelected())
		{
			if(text[4].getText().equals("x") && player2Button.isSelected())
			{
				if(text[6].getText().equals("x") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[2].getText().equals("x") && player2Button.isSelected())
		{
			if(text[5].getText().equals("x") && player2Button.isSelected())
			{
				if(text[8].getText().equals("x") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[6].getText().equals("x") && player2Button.isSelected())
		{
			if(text[7].getText().equals("x") && player2Button.isSelected())
			{
				if(text[8].getText().equals("x") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[3].getText().equals("x") && player2Button.isSelected())
		{
			if(text[4].getText().equals("x") && player2Button.isSelected())
			{
				if(text[5].getText().equals("x") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[1].getText().equals("x") && player2Button.isSelected())
		{
			if(text[4].getText().equals("x") && player2Button.isSelected())
			{
				if(text[7].getText().equals("x") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[0].getText().equals("o") && player2Button.isSelected())
		{
			if(text[3].getText().equals("o") && player2Button.isSelected())
			{
				if(text[6].getText().equals("o") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
			
		if(text[0].getText().equals("o") && player2Button.isSelected())
		{
			if(text[4].getText().equals("o") && player2Button.isSelected())
			{
				if(text[8].getText().equals("o") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[0].getText().equals("o") && player2Button.isSelected())
		{
			if(text[1].getText().equals("o")&& player2Button.isSelected())
			{
				if(text[2].getText().equals("o") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[2].getText().equals("o") && player2Button.isSelected())
		{
			if(text[4].getText().equals("o") && player2Button.isSelected())
			{
				if(text[6].getText().equals("o") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[2].getText().equals("o") && player2Button.isSelected())
		{
			if(text[5].getText().equals("o") && player2Button.isSelected())
			{
				if(text[8].getText().equals("o") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[6].getText().equals("o") && player2Button.isSelected())
		{
			if(text[7].getText().equals("o") && player2Button.isSelected())
			{
				if(text[8].getText().equals("o") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[3].getText().equals("o") && player2Button.isSelected())
		{
			if(text[4].getText().equals("o") && player2Button.isSelected())
			{
				if(text[5].getText().equals("o") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(text[1].getText().equals("o") && player2Button.isSelected())
		{
			if(text[4].getText().equals("o") && player2Button.isSelected())
			{
				if(text[7].getText().equals("o") && player2Button.isSelected())
				{
					player2WinDialog();
				}
			}
		}
		
		if(e.getSource() == resetButton)
		{
			reset();
		}
		
		for(int i = 0; i < 9; i++ )
		{
			if(e.getSource() == text[i])
			{
				text[i].setEnabled(false);
			}
		}
	}
			
	public static void reset()
	{
		for(int i = 0; i < 9; i++)
		{
			text[i].setEnabled(true);
			text[i].setText("");
		}
		
		player1Selection.setEnabled(true);
		player1Selection.setText("");
		player2Selection.setEnabled(true);
		player2Selection.setText("");
	
	}
	
	public static void player1WinDialog()
	{
		Object[] options = {"Play agian", "Exit!"};
		int n = (int) JOptionPane.showOptionDialog(frame, "Would you like to play again?", "Player 1 wins", JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
		
		if(n == 0)
		{
			reset();
		}
		
		else
		{
			System.exit(0);
		}
	}
	
	public static void player2WinDialog()
	{
		Object[] options = {"Play agian", "Exit!"};
		int n = (int) JOptionPane.showOptionDialog(frame, "Would you like to play again?", "Player 2 wins", JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
		
		if(n == 0)
		{
			reset();
		}
		
		else
		{
			System.exit(0);
		}
	}
		
}
