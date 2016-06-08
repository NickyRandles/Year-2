package Cinema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GUITemplate {
		
	static JPanel header, footer;
	static JLabel headerLeft, headerCenter, headerRight, footerTop, footerMiddle, footerBottom;
	
	public static void header(JInternalFrame a)
	{
		header = new JPanel();
		header.setBackground(Color.cyan);
		header.setLayout(new GridLayout(1, 3));
		header.setBorder(new LineBorder(Color.blue));
		
		ImageIcon leftImage = new ImageIcon("Images/cinema01.jpg");
		headerLeft = new JLabel(leftImage);
		headerCenter = new JLabel("Dublin Cinema");
		Font headerFont = new Font("Serif", Font.BOLD, 24);
		headerCenter.setFont(headerFont);
		ImageIcon rightImage = new ImageIcon("Images/cinema02.jpg");
		headerRight = new JLabel(rightImage);
		
		header.add(headerLeft);
		header.add(headerCenter);
		header.add(headerRight);
		
		a.add(header, BorderLayout.NORTH);
		
	}
	
	
	public static void footer(JInternalFrame b)
	{
		footer = new JPanel();
		footer.setLayout(new GridLayout(3, 1));
		footer.setBorder(new LineBorder(Color.blue));
		footer.setBackground(Color.cyan);
		footerTop = new JLabel("Dublin Cinema");
		footerTop.setHorizontalAlignment(SwingConstants.CENTER);
		footerMiddle = new JLabel("Blanchardstown Centre, Dublin 15");
		footerMiddle.setHorizontalAlignment(SwingConstants.CENTER);
		footerBottom = new JLabel("Phone: 01-8201234 email: questions@dublincinema.ie");
		footerBottom.setHorizontalAlignment(SwingConstants.CENTER);
		
		footer.add(footerTop);
		footer.add(footerMiddle);
		footer.add(footerBottom);
		
		b.add(footer, BorderLayout.SOUTH);
	}

}
