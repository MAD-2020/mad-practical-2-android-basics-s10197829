package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button Button1_Button, Button2_Button, Button3_Button;
    TextView Score_View;
    int randomLocation;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Score_View = findViewById(R.id.score_view);
        Score_View.setText(String.valueOf(score));

        Button1_Button = findViewById(R.id.button1);
        Button2_Button = findViewById(R.id.button2);
        Button3_Button = findViewById(R.id.button3);

        setNewMole();

        Button1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfHit(0,randomLocation);
            }
        });
        Button2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfHit(1,randomLocation);
            }
        });
        Button3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfHit(2,randomLocation);
            }
        });
    }

    public void setNewMole() {
        Random ran = new Random();
        int numClicked;
        randomLocation = ran.nextInt(3);

        Button1_Button.setText("O");
        Button2_Button.setText("O");
        Button3_Button.setText("O");

        if (randomLocation == 0) {
            Button1_Button.setText("*");
        } else if (randomLocation == 1){
            Button2_Button.setText("*");
        } else {
            Button3_Button.setText("*");
        }


    }

    public void checkIfHit(int num1, int num2){
        String buttonPos;
        if(num1 == 0){
            buttonPos = "Left";
        } else if (num1 == 1) {
            buttonPos = "Middle";
        }
        else {
            buttonPos = "Right";
        }

        Log.v("Whack-A-Mole", buttonPos + " button clicked!");
        if (num1 == num2) {
            score ++;
            Log.v("Whack-A-Mole", "Hit, score added!");
        } else {
            score --;
            Log.v("Whack-A-Mole", "Missed, score deducted!");
        }


        Score_View.setText(String.valueOf(score));
        setNewMole();
    }
}
