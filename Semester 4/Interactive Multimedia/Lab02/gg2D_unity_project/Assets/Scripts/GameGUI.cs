using UnityEngine;
using System.Collections;

public class GameGUI : MonoBehaviour {

	public Player player;

	private void OnGUI()
	{
		displayScore ();
		displayLives ();
	}

	private void displayScore()
	{
		int playerScore = player.GetScore();
		string scoreMessage = "Score = " + playerScore;
		GUILayout.Label (scoreMessage);
	}

	private void displayLives()
	{
		int playerLives = player.GetLives();
		string livesMessage = "Lives = " + playerLives;
		GUILayout.Label(livesMessage);

	}
	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}
}
