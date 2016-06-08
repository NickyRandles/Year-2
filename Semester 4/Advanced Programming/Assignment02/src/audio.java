import java.applet.Applet;
import java.applet.AudioClip;

public class audio {
	
	public AudioClip Clip;
	
	static audio english_sound1 = new audio ("/Sounds/english_sound1.wav");
	static audio english_sound2 = new audio ("/Sounds/english_sound2.wav");
	static audio english_sound3 = new audio ("/Sounds/english_sound3.wav");
	static audio english_sound4 = new audio ("/Sounds/english_sound4.wav");
	static audio english_sound5 = new audio ("/Sounds/english_sound5.wav");	
	
	static audio spanish_sound1 = new audio ("/Sounds/spanish_sound1.wav");
	static audio spanish_sound2 = new audio ("/Sounds/spanish_sound2.wav");
	static audio spanish_sound3 = new audio ("/Sounds/spanish_sound3.wav");
	static audio spanish_sound4 = new audio ("/Sounds/spanish_sound4.wav");
	static audio spanish_sound5 = new audio ("/Sounds/spanish_sound5.wav");
	
	static audio french_sound1 = new audio ("/Sounds/french_sound1.wav");
	static audio french_sound2 = new audio ("/Sounds/french_sound2.wav");
	static audio french_sound3 = new audio ("/Sounds/french_sound3.wav");
	static audio french_sound4 = new audio ("/Sounds/french_sound4.wav");
	static audio french_sound5 = new audio ("/Sounds/french_sound5.wav");
		
	public audio(String audio)
	{
		
		try
		{
			
			Clip = Applet.newAudioClip(audio.class.getResource(audio));
			
		}
		
		catch(Exception e)
		{
			e.getMessage();
		}
				
	}
	
	public void play()
	{
		                                                                                                                                            
		try
		{		
			new Thread()
			{
				public void run()
				{			
					Clip.play();
						
				}
					
			}.start();
				
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
			 
	}
	
	public void stop()
	{	
		Clip.stop();		
	}
}
