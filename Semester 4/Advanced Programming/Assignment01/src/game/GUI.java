package game;

/**
 * 
 * @author Nicky Randles
 *
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI
{

	public static void main(String[] args)
	{
		GameLogic logic = new GameLogic();
		logic.setTitle("Tic-Tac-Toe");
		logic.setSize(300,450);
		logic.setVisible(true);
		logic.setLocation(550,150);
		
	} //end of main		
	

}
