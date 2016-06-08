package lab03_exercise02;

import java.io.*;

public class CheckedVUnchecked
{
	public static void main(String[] args) throws IOException
	{
		unchecked();
		checked();
		/* 
		 Checked exceptions are verified by the compiler.
		 Therefore, the exception need to be declared
		 or handled. The compile error indicates that
		 we need to catch or throw the checked method.
		 */
	}
 
	public static void checked() throws IOException
	{

	}

	public static void unchecked() throws NullPointerException
	{

	}

}