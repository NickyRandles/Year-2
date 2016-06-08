package Cinema;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.border.LineBorder;

public class GUI extends JFrame implements ActionListener
{

	
	public static GUI_loginFrame GUI_Login = new GUI_loginFrame();
	public static GUI_registerFrame GUI_register = new GUI_registerFrame();
	public static GUI_shoppingFrame GUI_shopping = new GUI_shoppingFrame();
	public static GUI_maintenanceFrame GUI_maintenance = new GUI_maintenanceFrame();
	public static GUI_checkoutFrame GUI_checkout = new GUI_checkoutFrame();
	public static GUI_invoiceFrame GUI_invoice = new GUI_invoiceFrame();
	
	static JDesktopPane desktop = new JDesktopPane();
	JInternalFrame registerFrame = new JInternalFrame(), shoppingFrame = new JInternalFrame(), maintenanceFrame = new JInternalFrame(), checkoutFrame = new JInternalFrame();
	JLabel intro01, intro02, signIn, username, password, empty, register, firstName, lastName, createUsername, createPassword, emailAddress, contactNumber, address, registerHeader;
	JPanel center, centerTop, centerMiddle, centerMiddleGrid, centerBottom;
	JTextField usernameField = new JTextField() , firstNameField, lastNameField, createUsernameField, emailAddressField, contactNumberField, addressField;
	JPasswordField passwordField = new JPasswordField(), createPasswordField;
	JButton login, signUp, registerButton;
	
	public static void main(String[] args)
	{
		GUI gui = new GUI();
		desktop.setBackground(Color.cyan);
		gui.setContentPane(desktop);
		
		gui.connect();
		
		GUI_Login.loginFrame();
		
		GUI_register.registerFrame();
		
		GUI_shopping.shoppingFrame();
		
		GUI_maintenance.maintenanceFrame();
				
		gui.setSize(800, 500);
		gui.setLocation(250, 150);
		gui.setVisible(true);
	}
	
	
	public void connect()
	{
		try
		{
			Class.forName ("com.mysql.jdbc.Driver");
		}
		
		catch(ClassNotFoundException e)
		{
			System.out.println("Sorry class not found");
		}
	}
		
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == login)
		{
			try{
			}
			
			catch(Exception f)
			{
				System.out.println("An error occured while trying to add data to database");
			}
			
			

		}
		
	}

	
}
