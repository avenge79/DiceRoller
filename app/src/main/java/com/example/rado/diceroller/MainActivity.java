package com.example.rado.diceroller;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int rolledTimes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod() {
        Button button = (Button) findViewById(R.id.rollButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTimeout();
            }
        });
    }

    private void setTimeout() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (rolledTimes < 15) {
                    // roll your dice
                    rollDice();
                    // set timeout again
                    setTimeout();
                } else {
                    rolledTimes = 0;
                }
            }
        }, 100);
    }


    private void rollDice() {

        rolledTimes++;

        Random rand = new Random();
        int rollResult = rand.nextInt(6) + 1;
        TextView diceResult = (TextView) findViewById(R.id.rollResult);
        diceResult.setText(Integer.toString(rollResult));
        ImageView img = (ImageView) findViewById(R.id.diceImage);

        switch (rollResult) {
            case 1:
                img.setImageResource(R.drawable.dice1);
                break;
            case 2:
                img.setImageResource(R.drawable.dice2);
                break;
            case 3:
                img.setImageResource(R.drawable.dice3);
                break;
            case 4:
                img.setImageResource(R.drawable.dice4);
                break;
            case 5:
                img.setImageResource(R.drawable.dice5);
                break;
            case 6:
                img.setImageResource(R.drawable.dice6);
                break;
        }

    }

}
