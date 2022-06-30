package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    boolean gameActive=true;
    int [] gamestate={2,2,2,2,2,2,2,2};
    int winPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void onTap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameReset(view);
        }
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
                String winnerstr;
                if(gamestate[winPosition[0]]==0)
                {
                    winnerstr="Player 1 has won";
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerstr);
                    gameActive=false;
                }
                else
                {
                    winnerstr="Player 2 has won";
                    TextView status = findViewById(R.id.status);
                    status.setText(winnerstr);
                }

            }

        }

        public void gameReset(View view)
        {
         gameActive=true;
         activePlayer=0;
         int gamestate [] ={2,2,2,2,2,2,2,2};
            ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);




        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}