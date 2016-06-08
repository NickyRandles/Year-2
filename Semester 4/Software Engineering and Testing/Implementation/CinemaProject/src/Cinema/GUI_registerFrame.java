package Cinema;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class GUI_registerFrame implements ActionListener {
		
	static JInternalFrame registerFrame = new JInternalFrame();
	JLabel createId, register, firstName, lastName, createUsername, createPassword, emailAddress, contactNumber, address, registerHeader , cardNo;
	JPanel panel, center;
	JTextField createIdField, firstNameField, lastNameField, createUsernameField, emailAddressField, contactNumberField, addressField, cardNoField;
	JPasswordField createPasswordField;
	JButton registerButton;
	JFrame frame;
	int id = 0;
	
	Connection connect;
	String host = "jdbc:mysql://localhost/cinema";
	String username = "root";
	String password = "";

	public void registerFrame()
	{
		GUITemplate.header(registerFrame);
		
		GUITemplate.footer(registerFrame);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(8, 8));
		
		registerHeader = new JLabel("Please fill out the register form");
		
		firstName = new JLabel("First name:");
		lastName = new JLabel("Surname:");
		createUsername = new JLabel("Username:");
		createPassword = new JLabel("Password:");
		emailAddress = new JLabel("Email address:");
		contactNumber = new JLabel("Contact number:");
		address = new JLabel("Address:");
		cardNo = new JLabel("Card No:");
		
		firstNameField = new JTextField();
		lastNameField = new JTextField();
		createUsernameField = new JTextField();
		createPasswordField = new JPasswordField();
		emailAddressField = new JTextField();
		contactNumberField = new JTextField();
		addressField = new JTextField();
		cardNoField = new JTextField();
		
		registerButton = new JButton("Register");
		registerButton.addActionListener(this);
		
		center.add(firstName);
		center.add(firstNameField);
		center.add(lastName);
		center.add(lastNameField);
		center.add(createUsername);
		center.add(createUsernameField);
		center.add(createPassword);
		center.add(createPasswordField);
		center.add(emailAddress);
		center.add(emailAddressField);
		center.add(contactNumber);
		center.add(contactNumberField);
		center.add(address);
		center.add(addressField);
		center.add(cardNo);
		center.add(cardNoField);
		
		panel.add(registerHeader, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
		panel.add(registerButton, BorderLayout.SOUTH);
		registerFrame.add(panel, BorderLayout.CENTER);
		GUI.desktop.add(registerFrame);
		
		registerFrame.setSize(484, 462);
		registerFrame.setLocation(150, 0);
		registerFrame.setVisible(false);
		
		generateID();
	}
	
	public void generateID()
	{
		try{
			connect = DriverManager.getConnection(host, username, password);
			PreparedStatement statement = connect.prepareStatement("Select * from register");
			ResultSet result = statement.executeQuery();
			
			while(result.next())
			{
				id++;
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterData()
	{
		
		try
		{
			connect = DriverManager.getConnection(host, username, password);
			PreparedStatement statement = (PreparedStatement) connect.prepareStatement("INSERT INTO register(id, firstName, surname, username, password, emailAddress, contactNo, address, cardNo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, (id+1));
			statement.setString(2, firstNameField.getText());
			statement.setString(3, lastNameField.getText());
			statement.setString(4, createUsernameField.getText());
			statement.setString(5, createPasswordField.getText());
			statement.setString(6, emailAddressField.getText());
			statement.setString(7, contactNumberField.getText());
			statement.setString(8, addressField.getText());
			statement.setString(9, cardNoField.getText());
			statement.executeUpdate();
			connect.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println("Please do not leave any blanks");
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == registerButton)
		{
			try
			{
				JOptionPane.showMessageDialog(frame, "Thank you for registering!", "Message", JOptionPane.INFORMATION_MESSAGE);
				registerFrame.setVisible(false);
				enterData();
				GUI_loginFrame.loginFrame.setVisible(true);;
			}
			
			catch(Exception a)
			{
				a.printStackTrace();
			}
		}
		
	}
}
