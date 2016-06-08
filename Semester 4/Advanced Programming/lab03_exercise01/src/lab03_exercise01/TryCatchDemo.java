package lab03_exercise01;

import java.io.BufferedReader;
import java.io.*;

public class TryCatchDemo
{
	public static void main(String[] args)
	{
	
		try
		{
			System.out.println("Enter text: ");
			InputStreamReader istream = new InputStreamReader(System.in);
			BufferedReader input = new BufferedReader(istream);
			String inputLine = input.readLine();
			System.out.println("Read: " + inputLine);
			Object s = null;
			s.toString();	
		}
		
		catch(IOException e)
		{
			System.out.println("The input went wrong");
			e.printStackTrace();
		}
			
		catch(NullPointerException e)
		{
			System.out.println("The input went fine");
			e.printStackTrace();
		}
			
		finally
		{
			System.out.println("Code finally reached");
		}
	
	}
	
}
