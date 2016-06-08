using UnityEngine;
using System.Collections;

public class Player : MonoBehaviour 
{
	private int score = 0;
	private int lives = 3;

	public AudioClip yumSound;
	public AudioClip dieSound;

	public int GetScore()
	{
		return score;
	}

	public int GetLives()
	{
		return lives;
	}

	private void Update()
	{
		if(lives < 0)
		{
			Application.LoadLevel("gameOver");
		}
	}


	private void OnTriggerEnter2D(Collider2D c)
	{
		string tag = c.tag;

		if("Food" == tag)
		{
			score++;
			audio.PlayOneShot(yumSound);
		}

		if("Spikes" == tag){
			lives--;
			audio.PlayOneShot(dieSound);
			MoveToStartPosition();
		}
	}
	
	private void MoveToStartPosition()
	{
		Vector3 startPosition = new Vector3 (0, 5, 0);
		transform.position = startPosition;
	
	}

}
