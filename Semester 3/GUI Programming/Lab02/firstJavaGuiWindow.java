// Student name: Nicky Randles
// Student number: B00058026
// Lab: 2
// Task: 1
import javax.swing.*;

class firstJavaGuiWindow extends JFrame
{
	public firstJavaGuiWindow()
	{
		//setting title, size, location and resizability
		setTitle("First Java GUI Window");
		setSize(440, 380);
		setLocation(100, 300);
		setResizable(true);
	}

	public static void main(String[] args)
	{
		JFrame frame = new firstJavaGuiWindow();
		//setting visibility
		frame.setVisible(true);
	}

}