using UnityEngine;
using System.Collections;

public class Player : MonoBehaviour 
{
	private int score = 0;
	private void OnGUI()
	{
		string scoreMessage = "Score = " + score;
		GUILayout.Label(scoreMessage);
	}

	private void OnTriggerEnter2D(Collider2D c)
	{
		string tag = c.tag;

		if("Food" == tag)
		{
			score++;
		}
	}

}
