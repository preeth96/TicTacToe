package com.example.tictactoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home extends AppCompatActivity {
//     0-> dog  ,     1->Cat  ,    2-> Empty
    int activePlayer=0;
    boolean gameIsAction =true;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPosition = { {0,1,2 },{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    // Views
    LinearLayout scoreLayout;
    TextView winner;
    Button playAgain;
    ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Intialising all views
        scoreLayout=findViewById(R.id.score_layout);
        winner=findViewById(R.id.winner);
        playAgain=findViewById(R.id.playAgain);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image4=findViewById(R.id.image4);
        image5=findViewById(R.id.image5);
        image6=findViewById(R.id.image6);
        image7=findViewById(R.id.image7);
        image8=findViewById(R.id.image8);
        image9=findViewById(R.id.image9);

    }

    public void onTap(View view){

        ImageView tappedView= (ImageView) view;
        tappedView.setTranslationY(-1000f);

        int tappedPosition = Integer.parseInt(tappedView.getTag().toString());

        if (gameIsAction && gameState [tappedPosition]==2)
        {
            gameState[tappedPosition]=activePlayer;

            if (activePlayer == 0)
            {
                tappedView.setImageResource(R.drawable.dog);

            activePlayer=1;
        }
        else
            {
                tappedView.setImageResource(R.drawable.cat);
                activePlayer=0;
            }
        tappedView.animate().translationYBy(1000f).rotation(360).setDuration(300);
        for(int[] winningPosition: winningPosition){

            if((gameState[winningPosition[0]]==gameState[winningPosition[1]])&&
            (gameState[winningPosition[1]]==gameState[winningPosition[2]])&&
                    (gameState[winningPosition[2]] !=  2))
            {
                gameIsAction = false;
                String winnerText ="Dog";
                if(activePlayer == 0 )
                {
                    winnerText = "Cat";
                }
                scoreLayout.setVisibility(View.VISIBLE);
                winner.setText("Winner is "+winnerText);
            }
            else{

                boolean gameOver = true;
                for(int state:gameState)
                {
                    if(state == 2)
                    {
                        gameOver = false;

                    }
                }
                if(gameOver)
                {
                    scoreLayout.setVisibility(view.VISIBLE);
                    winner.setText("It's a draw");
                }
            }


        }


        }

    }

    public void playAgain(View view)
    {
        activePlayer=0;
        gameIsAction=true;
        for(int i=0;i<9;i++)
        {
            gameState[i]=2;
        }


        scoreLayout.setVisibility(View.INVISIBLE);
         image1.setImageResource(0);
         image2.setImageResource(0);
         image3.setImageResource(0);
         image4.setImageResource(0);
         image5.setImageResource(0);
         image6.setImageResource(0);
         image7.setImageResource(0);
         image8.setImageResource(0);
         image9.setImageResource(0);
    }

}