package com.example.rockpaperscissor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var playerChoiceTextView: TextView
    lateinit var computerChoiceTextView: TextView
    lateinit var resultTextView: TextView
    private lateinit var playerScoreTextView: TextView
    private lateinit var computerScoreTextView: TextView
    private var playerScore = 0
    private var computerScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerChoiceTextView = findViewById(R.id.playerChoiceTextView)
        computerChoiceTextView = findViewById(R.id.computerChoiceTextView)
        resultTextView = findViewById(R.id.resultTextView)
        playerScoreTextView = findViewById(R.id.playerScoreTextView)
        computerScoreTextView = findViewById(R.id.computerScoreTextView)


        findViewById<Button>(R.id.rockButton).setOnClickListener{ playGame("Rock") }
        findViewById<Button>(R.id.paperbutton).setOnClickListener{ playGame("Paper") }
        findViewById<Button>(R.id.scissorsButton).setOnClickListener{playGame("Scissors")}

    }
    private fun playGame(playerChoice: String) {
        val options = arrayOf("Rock", "Paper", "Scissors")
        val computerChoice = options[Random.nextInt(options.size)]

        playerChoiceTextView.text = "Your choice: $playerChoice"
        computerChoiceTextView.text = "Computer's choice :$computerChoice"

        val result = determineWinner(playerChoice, computerChoice)
        resultTextView.text = result

        updateScores()
    }

    private fun determineWinner(playerChoice: String, computerChoice: String): String {
        return when  {
            playerChoice == computerChoice -> "Its a tie"
            playerChoice =="Rock" && computerChoice == "Scissors" ||
                playerChoice =="Scissors" && computerChoice == "Paper" ||
                playerChoice == "Paper" && computerChoice == "Rock" -> {
                playerScore++
                "You Win!!"
            }
            else ->
            { computerScore++
                "Computer Wins :("}
        }
    }
    private fun updateScores() {
        playerScoreTextView.text = "Player: $playerScore"
        computerScoreTextView.text = "Computer: $computerScore"
    }


}