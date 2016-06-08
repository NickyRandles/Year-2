package Cinema;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class GUI_shoppingFrame implements ActionListener{

	public static GUI_checkoutFrame GUI_checkout = new GUI_checkoutFrame();
	
	static JInternalFrame shoppingFrame = new JInternalFrame();
	JPanel panel, centerPanel;
	JPanel [] panels;
	JLabel [] detail01, detail02, detail03, detail04, detail05, detail06, detail07, detail08;
	JScrollPane scrollPane;
	JButton [] time01, time02, time03;
	JRadioButton [] radio;
	ButtonGroup group;
	JButton [] button;
	JTextField[] quantity;
	int i = 0;	
	int g = 0;
	static int k = 0;
	int [] id = new int[100];
	int convert;
	int [] amount;
	double [] cost;
	double [] total;
	
	Connection connect;
	String host = "jdbc:mysql://localhost/cinema";
	String username = "root";
	String password = "";
	
	
	
	
	public void shoppingFrame()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panels = new JPanel[15];
		detail01 = new JLabel[15];
		detail02 = new JLabel[15];
		detail03 = new JLabel[15];
		detail04 = new JLabel[15];
		detail05 = new JLabel[15];
		detail06 = new JLabel[15];
		detail07 = new JLabel[15];
		detail08 = new JLabel[15];
		quantity = new JTextField[15];
		centerPanel  = new JPanel();
	
		
		radio = new JRadioButton[15];
		ButtonGroup group = new ButtonGroup();
		
		button = new JButton[45];
		time01 = new JButton[15];
		time02 = new JButton[15];
		time03 = new JButton[15];
		
		String [] name = {"Movie: ", " Date: ", " Price: ", " Times: "};
		
		
		try
		{
			connect = DriverManager.getConnection(host, username, password);
			PreparedStatement statement;
			ResultSet result;
			statement = connect.prepareStatement("Select * from movies");
			result = statement.executeQuery();
			
			while(result.next())
			{
				radio[i] = new JRadioButton();
				radio[i].addActionListener(this);
				detail01[i] = new JLabel("Movie:");
				detail01[i].setForeground(Color.red);
				detail02[i] = new JLabel(result.getString(2));
				detail03[i] = new JLabel("Date:");
				detail03[i].setForeground(Color.red);
				detail04[i] = new JLabel(result.getString(3));
				detail05[i] = new JLabel("Price:");
				detail05[i].setForeground(Color.red);
				detail06[i] = new JLabel(result.getString(7));
				detail07[i] = new JLabel("Quantity: :");
				quantity[i] = new JTextField(2);
				detail07[i].setForeground(Color.red);
				detail08[i] = new JLabel("Times:");
				detail08[i].setForeground(Color.red);
				
				time01[i] = new JButton(result.getString(4));
				time02[i] = new JButton(result.getString(5));
				time03[i] = new JButton(result.getString(6));
				
				panels[i] = new JPanel();
				panels[i].setBorder(new LineBorder(Color.blue, 2));
				
				group.add(radio[i]);
				panels[i].add(radio[i]);
				panels[i].add(detail01[i]);
				panels[i].add(detail02[i]);
				panels[i].add(detail03[i]);
				panels[i].add(detail04[i]);
				panels[i].add(detail05[i]);
				panels[i].add(detail06[i]);
				panels[i].add(detail07[i]);
				panels[i].add(quantity[i]);
				panels[i].add(detail08[i]);
				panels[i].add(time01[i]);
				panels[i].add(time02[i]);
				panels[i].add(time03[i]);
				time01[i].addActionListener(this);
				time02[i].addActionListener(this);
				time03[i].addActionListener(this);
				centerPanel.add(panels[i]);
				i++;
				
			}
		
			
			centerPanel.setLayout(new GridLayout(i, 13));
			scrollPane = new JScrollPane(centerPanel);
				
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			// System.out.println("Not all movies slots are filled in");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error");
		}
		
		try
		{
			connect = DriverManager.getConnection(host, username, password);
			PreparedStatement statement = connect.prepareStatement("Select * from movies");
			ResultSet result = statement.executeQuery();
			
			
			
			while(result.next())
			{
				id[g] = result.getInt(1);
				g++;
			}
				
		}
	
		
		catch(SQLException a)
		{
			a.printStackTrace();
			// System.out.println("Not all movies slots are filled in");
		}
		
		catch(Exception a)
		{
			a.printStackTrace();
			System.out.println("Error");
		}	
		
		try
		{
			connect = DriverManager.getConnection(host, username, password);
			PreparedStatement statement = connect.prepareStatement("Select * from transactions");
			ResultSet result = statement.executeQuery();
			
			
			
			while(result.next())
			{
				k++;
			}
							
		}
	
		
		catch(SQLException a)
		{
			a.printStackTrace();
			// System.out.println("Not all movies slots are filled in");
		}
		
		catch(Exception a)
		{
			a.printStackTrace();
			System.out.println("Error");
		}	
		
		

		shoppingFrame.add(scrollPane, BorderLayout.CENTER);
		GUITemplate.header(shoppingFrame);
		GUITemplate.footer(shoppingFrame);
		
		GUI.desktop.add(shoppingFrame);
		
		shoppingFrame.setSize(784, 462);
		shoppingFrame.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		amount = new int[15];
		cost = new double[15];
		total = new double[15];
				
		for(int j = 0; j < i; j++)
		{	
			
			if(radio[j].isSelected() && e.getSource() == time01[j])
			{
			
				try
				{
					connect = DriverManager.getConnection(host, username, password);
					PreparedStatement statement = connect.prepareStatement("Select * from movies where id = " + id[j]);
					ResultSet result = statement.executeQuery();
					
					
					while(result.next())
					{
						
						PreparedStatement statement02 = connect.prepareStatement("INSERT INTO transactions(id, username, password, movie, date, time, tickets, total, paymentStatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
						//ResultSet result02 = statement02.executeQuery();
						amount[j] = Integer.parseInt(quantity[j].getText());
						cost[j] = result.getDouble(7);
						total[j] = cost[j] * amount[j]; 
						
						statement02.setInt(1, k + 1);
						statement02.setString(2, GUI_loginFrame.loginInfo[0]);
						statement02.setString(3, GUI_loginFrame.loginInfo[1]);
						statement02.setString(4, result.getString(2));
						statement02.setString(5, result.getString(3));
						statement02.setString(6, result.getString(4));
						statement02.setInt(7, amount[j]);
						statement02.setDouble(8, total[j]);	
						statement02.setString(9, "not paid");	
						
						statement02.executeUpdate();
											
						
						shoppingFrame.setVisible(false);
						GUI_checkout.checkoutFrame();
						GUI_checkoutFrame.checkoutFrame.setVisible(true);
					}
			
						
				}
			
				
				catch(SQLException a)
				{
					a.printStackTrace();
					// System.out.println("Not all movies slots are filled in");
				}
				
				catch(Exception a)
				{
					a.printStackTrace();
					System.out.println("Error");
				}
			}
			
			else if(radio[j].isSelected() && e.getSource() == time02[j])
			{
			
				try
				{
					connect = DriverManager.getConnection(host, username, password);
					PreparedStatement statement = connect.prepareStatement("Select * from movies where id = " + id[j]);
					ResultSet result = statement.executeQuery();
					
					
					while(result.next())
					{
						
						PreparedStatement statement02 = connect.prepareStatement("INSERT INTO transactions(id, username, password, movie, date, time, tickets, total, paymentStatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
						//ResultSet result02 = statement02.executeQuery();
						amount[j] = Integer.parseInt(quantity[j].getText());
						cost[j] = result.getDouble(7);
						total[j] = cost[j] * amount[j]; 
						
						statement02.setInt(1, k + 1);
						statement02.setString(2, GUI_loginFrame.loginInfo[0]);
						statement02.setString(3, GUI_loginFrame.loginInfo[1]);
						statement02.setString(4, result.getString(2));
						statement02.setString(5, result.getString(3));
						statement02.setString(6, result.getString(5));
						statement02.setInt(7, amount[j]);
						statement02.setDouble(8, total[j]);	
						statement02.setString(9, "not paid");	
						
						statement02.executeUpdate();
											
						
						shoppingFrame.setVisible(false);
						GUI_checkout.checkoutFrame();
						GUI_checkoutFrame.checkoutFrame.setVisible(true);
					}
			
						
				}
			
				
				catch(SQLException a)
				{
					a.printStackTrace();
					// System.out.println("Not all movies slots are filled in");
				}
				
				catch(Exception a)
				{
					a.printStackTrace();
					System.out.println("Error");
				}
			}
			
			else if(radio[j].isSelected() && e.getSource() == time03[j])
			{
			
				try
				{
					connect = DriverManager.getConnection(host, username, password);
					PreparedStatement statement = connect.prepareStatement("Select * from movies where id = " + id[j]);
					ResultSet result = statement.executeQuery();
					
					
					while(result.next())
					{
						
						PreparedStatement statement02 = connect.prepareStatement("INSERT INTO transactions(id, username, password, movie, date, time, tickets, total, paymentStatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
						//ResultSet result02 = statement02.executeQuery();
						amount[j] = Integer.parseInt(quantity[j].getText());
						cost[j] = result.getDouble(7);
						total[j] = cost[j] * amount[j]; 
						
						statement02.setInt(1, k + 1);
						statement02.setString(2, GUI_loginFrame.loginInfo[0]);
						statement02.setString(3, GUI_loginFrame.loginInfo[1]);
						statement02.setString(4, result.getString(2));
						statement02.setString(5, result.getString(3));
						statement02.setString(6, result.getString(6));
						statement02.setInt(7, amount[j]);
						statement02.setDouble(8, total[j]);	
						statement02.setString(9, "not paid");	
						
						statement02.executeUpdate();
											
						
						shoppingFrame.setVisible(false);
						GUI_checkout.checkoutFrame();
						GUI_checkoutFrame.checkoutFrame.setVisible(true);
					}
			
						
				}
			
				
				catch(SQLException a)
				{
					a.printStackTrace();
					// System.out.println("Not all movies slots are filled in");
				}
				
				catch(Exception a)
				{
					a.printStackTrace();
					System.out.println("Error");
				}
			}
			
		}
		
		
	}

}
