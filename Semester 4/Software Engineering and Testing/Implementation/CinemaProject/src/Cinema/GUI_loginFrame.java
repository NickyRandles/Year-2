package Cinema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GUI_loginFrame implements ActionListener {
	
	static JInternalFrame loginFrame = new JInternalFrame();
	JPanel center, centerTop, centerMiddle, centerMiddleGrid, centerBottom;
	JLabel intro01, intro02, signIn, username, password, empty, register, firstName, lastName, createUsername, createPassword, emailAddress, contactNumber, address, registerHeader;
	JTextField usernameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton login, signUp;
	static String [] loginInfo = new String[2];
	
	public void loginFrame()
	{
		
		
		loginFrame.setLayout(new BorderLayout());
		loginFrame.setBackground(Color.cyan);
		loginFrame.setBorder(new LineBorder(Color.blue, 2));
		
		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBackground(Color.cyan);
		centerTop = new JPanel();
		centerTop.setLayout(new GridLayout(2, 1));;
		
		intro01 = new JLabel("Welcome to Dublin Cinema's website.");
		intro02 = new JLabel("You can book now!");
		intro01.setHorizontalAlignment(SwingConstants.CENTER);
		intro02.setHorizontalAlignment(SwingConstants.CENTER);
		Font introFont = new Font("Serif", Font.BOLD, 16);
		intro01.setFont(introFont);
		intro02.setFont(introFont);
		centerTop.add(intro01);
		centerTop.add(intro02);
		center.add(centerTop, BorderLayout.NORTH);
		
		centerMiddle = new JPanel();
		centerMiddle.setLayout(new BorderLayout());
		signIn = new JLabel("Sign in!");
		Font signInFont = new Font("Serif", Font.BOLD, 16);
		signIn.setFont(signInFont);
		signIn.setHorizontalAlignment(SwingConstants.CENTER);
		centerMiddleGrid = new JPanel();
		centerMiddleGrid.setLayout(new GridLayout(3, 3));
		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		empty = new JLabel();
		login = new JButton("Login");
		login.addActionListener(this);
		
		centerMiddle.add(signIn, BorderLayout.NORTH);
		centerMiddleGrid.add(username);
		centerMiddleGrid.add(usernameField);
		centerMiddleGrid.add(password);
		centerMiddleGrid.add(passwordField);
		centerMiddleGrid.add(empty);
		centerMiddleGrid.add(login);
		centerMiddle.add(centerMiddleGrid, BorderLayout.CENTER);
		centerMiddle.setBorder(new LineBorder(Color.cyan, 20));
		center.add(centerMiddle, BorderLayout.CENTER);
		
		centerBottom = new JPanel();
		centerBottom.setLayout(new BorderLayout());
		register = new JLabel("Register!");
		signUp = new JButton("Click here to sign up");
		signUp.addActionListener(this);
		Font registerFont = new Font("Serif", Font.BOLD, 16);
		register.setFont(registerFont);
		signUp.setFont(registerFont);
		register.setHorizontalAlignment(SwingConstants.CENTER);
		centerBottom.add(register, BorderLayout.NORTH);
		centerBottom.add(signUp, BorderLayout.SOUTH);
		centerBottom.setBorder(new LineBorder(Color.cyan, 20));
		center.add(centerBottom, BorderLayout.SOUTH);
		
		
		loginFrame.add(center, BorderLayout.CENTER);
		GUITemplate.header(loginFrame);
		GUITemplate.footer(loginFrame);
		
		GUI.desktop.add(loginFrame);
		
		loginFrame.setSize(484, 462);
		loginFrame.setLocation(150, 0);
		loginFrame.setVisible(true);
		
	}
	
	public void retrieveDate()
	{
		Connection connect;
		String host = "jdbc:mysql://localhost/cinema";
		String username = "root";
		String password = "";
		
		try
		{
			connect = DriverManager.getConnection(host, username, password);
			PreparedStatement statement;
			ResultSet result;
			
			statement = connect.prepareStatement("Select username, password from register");
			result = statement.executeQuery();
		
			while(result.next())
			{
				if(usernameField.getText().equals("admin") && passwordField.getText().equals("secret"))
				{
					loginFrame.setVisible(false);
					GUI_maintenanceFrame.maintenanceFrame.setVisible(true);
				}
				
				else if(usernameField.getText().equals(result.getString(1)) && passwordField.getText().equals(result.getString(2)))
				{
					loginInfo[0] = result.getString(1);
					loginInfo[1] = result.getString(2);
					loginFrame.setVisible(false);
					
					GUI_shoppingFrame.shoppingFrame.setVisible(true);
				}
				
				else
				{
				}
			}
		
			
		}
		
		catch(SQLException e)
		{
			// System.out.println("Not all user slots are filled in");
		}
		
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == login)
		{
			retrieveDate();
		}
		
		else if(e.getSource() == signUp)
		{
			loginFrame.setVisible(false);
			GUI_registerFrame.registerFrame.setVisible(true);
			
		}
	}
	
		
}
	

