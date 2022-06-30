package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    int [] gamestate={2,2,2,2,2,2,2,2};
    int winPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void onTap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(gamestate[tappedImage]==2)
        {
            gamestate[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.styx);
                activePlayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("2nd players turn - Tap to play");


            }
            else
            {
                img.setImageResource(R.drawable.circle);
                activePlayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("1st players turn - Tap to play");

            }
            img.animate().translationYBy(1000f).setDuration(300);

        }
        for(int [] winPosition: winPositions)
        {
            if(gamestate[winPosition[0]]==gamestate[winPosition[1]] &&
               gamestate[winPosition[1]]==gamestate[winPosition[2]] &&
                    gamestate[winPosition[0]] != 2 )
            {
                //somebody has won find who?
                
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}