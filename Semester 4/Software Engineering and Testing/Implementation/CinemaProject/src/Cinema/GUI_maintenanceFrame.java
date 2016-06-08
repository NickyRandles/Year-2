package Cinema;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.sql.*;

public class GUI_maintenanceFrame implements ActionListener{

	static JInternalFrame maintenanceFrame = new JInternalFrame();
	JPanel panel = new JPanel(), topPanel = new JPanel(), centerPanel = new JPanel(), bottomPanel = new JPanel(), centerBottomPanel, enterIdPanel, enterMoviePanel, removeMoviePanel, bottomTopPanel, enterNamePanel, bottomBottomPanel, removePanel, removeFieldPanel, centerTopPanel, addMoviePanel;
	JLabel currentMovies, removeMovieHeader, enterId, orLabel, enterMovie, viewUsers, removeUsers, removeId, addMovieHeader, empty ;
	JTextField enterIdField = new JTextField(), enterMovieField = new JTextField(), removeIdField = new JTextField();
	JTextArea moviesTextArea, usersTextArea;
	JButton removeMovieButton, addButton, removeUserButton;
	String movies, users;
	JLabel [] addLabel;
	JTextField [] addField;
	JScrollPane scrollPane, movieScrollPane, userScrollPane;
	Font headerFont = new Font("Ariel", Font.BOLD, 14);
	
	Connection connect;
	String host = "jdbc:mysql://localhost/cinema";
	String username = "root";
	String password = "";
	
	public void maintenanceFrame()
	{
		
		panel.setLayout(new BorderLayout());
		topPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new BorderLayout());
		bottomPanel.setLayout(new BorderLayout());
		
	
		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		scrollPane = new JScrollPane(panel);
		maintenanceFrame.add(scrollPane);
		
		viewCurrentMovies();
		addMovie();
		removeMovie();
		viewUsers();
		removeUsers();
		
		GUITemplate.header(maintenanceFrame);
		GUITemplate.footer(maintenanceFrame);
		GUI.desktop.add(maintenanceFrame);
		
		maintenanceFrame.setSize(484, 462);
		maintenanceFrame.setLocation(150, 0);
		maintenanceFrame.setVisible(false);
		
		
	}
	
	public void viewCurrentMovies()
	{
		currentMovies = new JLabel("View current movies");
		currentMovies.setFont(headerFont);
		currentMovies.setHorizontalAlignment(SwingConstants.CENTER);
		topPanel.add(currentMovies, BorderLayout.NORTH);
		moviesTextArea = new JTextArea(5, 20);
		moviesTextArea.setEditable(false);
		movieScrollPane = new JScrollPane();
		

		try
		{
			connect = DriverManager.getConnection(host, username, password);
			PreparedStatement statement;
			ResultSet result;
			
				statement = connect.prepareStatement("Select * from movies");
				result = statement.executeQuery();
			
			
		
				while(result.next())
				{
					movies = result.getString(1) + ".  " + result.getString(2) + "  " + result.getString(3) + "  " + result.getString(4) + "  " + result.getString(5) + "  " + result.getString(6);
					moviesTextArea.append(movies + "\n"); 
					movieScrollPane = new JScrollPane(moviesTextArea);
					topPanel.add(movieScrollPane, BorderLayout.SOUTH);
				}
				
			
			
		}
		
		catch(SQLException e)
		{
			// System.out.println("Not all users slots are filled in");
		}
		
		catch(Exception e)
		{
			System.out.println("Error");
		}
		
	}
	
	public void addMovie()
	{
		centerTopPanel = new JPanel();
		centerTopPanel.setLayout(new BorderLayout());
		centerTopPanel.setBorder(new LineBorder(Color.cyan, 10));
		addMoviePanel = new JPanel();
		addMoviePanel.setLayout(new GridLayout(8, 2));
		
		addMovieHeader = new JLabel("Add Movie");
		addMovieHeader.setFont(headerFont);
		addMovieHeader.setHorizontalAlignment(SwingConstants.CENTER);
		addLabel = new JLabel[7];
		addField = new JTextField[7];
		String [] addString = {"Id:", "Movie: ", "Date: ", "Time 1:", "Time 2:", "Time 3:", "Price:"};
		empty = new JLabel();
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		
		for(int i = 0; i < 7; i++)
		{
			addLabel[i] = new JLabel(addString[i]);
			addField[i] = new JTextField();
			addMoviePanel.add(addLabel[i]);
			addMoviePanel.add(addField[i]);
		}
		addMoviePanel.add(empty);
		addMoviePanel.add(addButton);
		centerTopPanel.add(addMovieHeader, BorderLayout.NORTH);
		centerTopPanel.add(addMoviePanel, BorderLayout.CENTER);
		centerPanel.add(centerTopPanel, BorderLayout.CENTER);
		
	}
	
	public void removeMovie()
	{
		centerBottomPanel = new JPanel();
		centerBottomPanel.setLayout(new BorderLayout());
		centerBottomPanel.setBorder(new LineBorder(Color.cyan, 10));
		enterIdPanel = new JPanel();
		enterIdPanel.setLayout(new GridLayout(1, 1));
		removeMoviePanel = new JPanel();
		removeMoviePanel.setLayout(new GridLayout(1, 1));
		
		removeMovieHeader = new JLabel("Remove Movie");
		removeMovieHeader.setFont(headerFont);
		removeMovieHeader.setHorizontalAlignment(SwingConstants.CENTER);
		centerBottomPanel.add(removeMovieHeader, BorderLayout.NORTH);
		
		enterId = new JLabel("Enter Id");
		enterIdPanel.add(enterId);
		enterIdPanel.add(enterIdField);
		centerBottomPanel.add(enterIdPanel, BorderLayout.CENTER);
		
		empty = new JLabel();
		removeMovieButton = new JButton("Remove");
		removeMovieButton.addActionListener(this);
		removeMoviePanel.add(empty);
		removeMoviePanel.add(removeMovieButton);
		centerBottomPanel.add(removeMoviePanel, BorderLayout.SOUTH);
		
		centerPanel.add(centerBottomPanel, BorderLayout.SOUTH);
		

	}
	
	public void viewUsers()
	{
		bottomTopPanel = new JPanel();
		bottomTopPanel.setLayout(new BorderLayout());
		enterNamePanel = new JPanel();
		enterNamePanel.setLayout(new GridLayout(1,2));
		
		viewUsers = new JLabel("View Users");
		viewUsers.setFont(headerFont);
		viewUsers.setHorizontalAlignment(SwingConstants.CENTER);
		bottomTopPanel.add(viewUsers, BorderLayout.NORTH);
		usersTextArea = new JTextArea(5, 20);
		usersTextArea.setEditable(false);
		userScrollPane = new JScrollPane();
		
		try
		{
			connect = DriverManager.getConnection(host, username, password);
			PreparedStatement statement;
			ResultSet result;
			
				statement = connect.prepareStatement("Select * from register");
				result = statement.executeQuery();
			
			
		
				while(result.next())
				{
					users = "Id: " + result.getString(1) + ", First name: " + result.getString(2) + ", Surname:  " + result.getString(3) + ", Username:  " + result.getString(4) + ", Password:  " + result.getString(5) + ", Email address:  " + result.getString(6) + ", Contact no:  " + result.getString(7) + ", Address:  " + result.getString(8) + ", Card no: " + result.getString(9);
					usersTextArea.append(users + "\n\n"); 
					userScrollPane = new JScrollPane(usersTextArea);
					bottomTopPanel.add(userScrollPane, BorderLayout.SOUTH);
				}
				
			
			
		}
		
		catch(SQLException e)
		{
			// System.out.println("Not all users slots are filled in");
		}
		
		catch(Exception e)
		{
			System.out.println("Error");
		}
		
		
		
		
		bottomPanel.add(bottomTopPanel, BorderLayout.NORTH);
		
	}
	
	public void removeUsers()
	{
		bottomBottomPanel = new JPanel();
		bottomBottomPanel.setLayout(new BorderLayout());
		bottomBottomPanel.setBorder(new LineBorder(Color.cyan, 10));
		removeFieldPanel = new JPanel();
		removeFieldPanel.setLayout(new GridLayout(1,1));
		removePanel = new JPanel();
		removePanel.setLayout(new GridLayout(1,1));
		
		removeUsers = new JLabel("Remove User");
		removeUsers.setFont(headerFont);
		removeUsers.setHorizontalAlignment(SwingConstants.CENTER);
		bottomBottomPanel.add(removeUsers, BorderLayout.NORTH);
		
		removeId = new JLabel("Enter Id");
		empty = new JLabel();
		removeFieldPanel.add(removeId);
		removeFieldPanel.add(removeIdField);
		bottomBottomPanel.add(removeFieldPanel, BorderLayout.CENTER);
		
		removeUserButton = new JButton("Remove");
		removeUserButton.addActionListener(this);
		removePanel.add(empty);
		removePanel.add(removeUserButton);
		bottomBottomPanel.add(removePanel, BorderLayout.SOUTH);
		
		
		bottomPanel.add(bottomBottomPanel, BorderLayout.SOUTH);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addButton)
		{
			try
			{
				
				connect = DriverManager.getConnection(host, username, password);
				PreparedStatement statement = (PreparedStatement) connect.prepareStatement("INSERT INTO movies(id, movie, date, time01, time02, time03, price) VALUES(?, ?, ?, ?, ?, ?, ?)");
				
				for(int i = 1; i <= 7; i++)
				{
					statement.setString(i, addField[i-1].getText());
					
				}
				statement.executeUpdate();
				
			}
			
			catch(SQLException a)
			{
				a.printStackTrace();
			}
			
			catch(Exception a)
			{
				a.printStackTrace();
			}
			

		}
		
		else if(e.getSource() == removeMovieButton)
		{
			try
			{
				connect = DriverManager.getConnection(host, username, password);
				int id = Integer.parseInt(enterIdField.getText());
				//String idRemove = "Delete from movies WHERE id = " + 6;
				String query = "delete from movies where id = ?";
				PreparedStatement statement = (PreparedStatement) connect.prepareStatement(query);
				statement.setInt(1, id);
				statement.execute();
				
				
			
			}
			
			catch(SQLException b)
			{
				b.printStackTrace();
				// System.out.println("Not all users slots are filled in");
			}
			
			catch(Exception b)
			{
				b.printStackTrace();
			}
		}
		
		
		else if(e.getSource() == removeUserButton)
		{
			try
			{
				connect = DriverManager.getConnection(host, username, password);
				int id = Integer.parseInt(removeIdField.getText());
				String query = "delete from register where id = ?";
				PreparedStatement statement = (PreparedStatement) connect.prepareStatement(query);
				statement.setInt(1, id);
				statement.execute();
				
			}
			
			catch(SQLException b)
			{
				b.printStackTrace();
				// System.out.println("Not all users slots are filled in");
			}
			
			catch(Exception b)
			{
				b.printStackTrace();
			}
		}
		
	}
	
	
}
