package lab07_exercise02;

public class TwoThreads
{
	public static void main (String[] args)
	{
		new SimpleThread("Jamaica").start();
		new SimpleThread("Fiji").start();
		new SimpleThread("Hawaii").start();
	}
}
