package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button buttonRock, buttonPaper, buttonScissors;
    TextView gameScore;
    ImageView playerImage, opponentImage;
    int numPlayerScore = 0;
    int numOpponentScore = 0;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRock = (Button) findViewById(R.id.buttonRock);
        buttonPaper = (Button) findViewById(R.id.buttonPaper);
        buttonScissors = (Button) findViewById(R.id.buttonScissors);
        gameScore = (TextView) findViewById(R.id.gameScore);
        playerImage = (ImageView) findViewById(R.id.playerImage);
        opponentImage = (ImageView) findViewById(R.id.opponentImage);

        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImage.setImageResource(R.drawable.rock);
                message = choice("rock");
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                gameScore.setText("Score: \nHuman: " + Integer.toString(numPlayerScore) + "\nOpponent: " + Integer.toString(numOpponentScore));
            }
        });

        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImage.setImageResource(R.drawable.paper);
                message = choice("paper");
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                gameScore.setText("Score: \nHuman: " + Integer.toString(numPlayerScore) + "\nOpponent: " + Integer.toString(numOpponentScore));
            }
        });

        buttonScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImage.setImageResource(R.drawable.scissors);
                message = choice("scissors");
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                gameScore.setText("Score: \nHuman: " + Integer.toString(numPlayerScore) + "\nOpponent: " + Integer.toString(numOpponentScore));
            }
        });
    }

    public String choice(String playerChoice) {
        String opponentChoice = "";
        String result = "";
        Random rand = new Random();
        Animation animBlink;
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        // 3 choices: 1) Rock 2) Paper 3) Scissors
        int opponentChoiceRand = rand.nextInt(3) + 1;

        switch(opponentChoiceRand) {
            case 1:
                opponentChoice = "rock";
                opponentImage.setImageResource(R.drawable.rock);
                break;
            case 2:
                opponentChoice = "paper";
                opponentImage.setImageResource(R.drawable.paper);
                break;
            case 3:
                opponentChoice = "scissors";
                opponentImage.setImageResource(R.drawable.scissors);
                break;
            default:
                break;
        }

        switch(playerChoice) {
            case "rock":
                if (opponentChoice.equals("rock")) {
                    result = "Draw";
                    playerImage.clearAnimation();
                    opponentImage.clearAnimation();
                }
                else if (opponentChoice.equals("paper")) {
                    result = "Opponent Wins";
                    numOpponentScore++;
                    opponentImage.startAnimation(animBlink);
                    playerImage.clearAnimation();
                }
                else if (opponentChoice.equals("scissors")) {
                    result = "Player Wins";
                    numPlayerScore++;
                    playerImage.startAnimation(animBlink);
                    opponentImage.clearAnimation();
                }
                else {
                    result = "ERROR";
                }
                break;
            case "paper":
                if (opponentChoice.equals("rock")) {
                    result = "Player Wins";
                    numPlayerScore++;
                    playerImage.startAnimation(animBlink);
                    opponentImage.clearAnimation();
                }
                else if (opponentChoice.equals("paper")) {
                    result = "Draw";
                    playerImage.clearAnimation();
                    opponentImage.clearAnimation();
                }
                else if (opponentChoice.equals("scissors")) {
                    result = "Opponent Wins";
                    numOpponentScore++;
                    opponentImage.startAnimation(animBlink);
                    playerImage.clearAnimation();
                }
                else {
                    result = "ERROR";
                }
                break;
            case "scissors":
                if (opponentChoice.equals("rock")) {
                    result = "Opponent Wins";
                    numOpponentScore++;
                    opponentImage.startAnimation(animBlink);
                    playerImage.clearAnimation();
                }
                else if (opponentChoice.equals("paper")) {
                    result = "Player Wins";
                    numPlayerScore++;
                    playerImage.startAnimation(animBlink);
                    opponentImage.clearAnimation();
                }
                else if (opponentChoice.equals("scissors")) {
                    result = "Draw";
                    playerImage.clearAnimation();
                    opponentImage.clearAnimation();
                }
                else {
                    result = "ERROR";
                }
                break;
            default:
                break;
        }
        return result;
    }
}