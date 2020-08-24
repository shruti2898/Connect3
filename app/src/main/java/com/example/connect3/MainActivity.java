package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    // 0= green 1= red
    int activePlayer=0;
    boolean gameisActive=true;
    // unplayed=2
    int[] gameState={2,2,2,2,2,2,2,2,2};

    int[][] wins={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        public void dropin(View view){

        ImageView counter = (ImageView) view;



        int tapcounter =Integer.parseInt(counter.getTag().toString());

        if(gameState[tapcounter]==2 && gameisActive) {

                     gameState[tapcounter] = activePlayer;

                     counter.setTranslationY(-1000f);

                     if (activePlayer == 0) {

                             counter.setImageResource(R.drawable.green);
                             activePlayer = 1;
                     }
                     else {
                         counter.setImageResource(R.drawable.red);
                         activePlayer = 0;
                     }

                     counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

                     for(int[] winspos :wins){
                         if(     gameState[winspos[0]] == gameState[winspos[1]]  &&
                                 gameState[winspos[1]] == gameState[winspos[2]]  &&
                                 gameState[winspos[0]]!=2 )
                           {   gameisActive=false;
                               String winner="Mario";
                               if(gameState[winspos[0]]==0){
                                   winner="Luigi";
                               }

                               TextView winnerMessage =(TextView) findViewById(R.id.winnerMessage);
                               winnerMessage.setText(winner+" has won!");
                               LinearLayout layout =(LinearLayout) findViewById(R.id.playAgainLayout);
                               layout.setVisibility(View.VISIBLE);
                           }
                         else{
                             boolean gameIsOver = true;
                             for(int counterState:gameState){
                                 if(counterState==2){
                                     gameIsOver=false;
                                 }
                             }
                             if(gameIsOver==true){
                                 TextView winnerMessage =(TextView) findViewById(R.id.winnerMessage);
                                 winnerMessage.setText("It's a draw!");
                                 LinearLayout layout =(LinearLayout) findViewById(R.id.playAgainLayout);
                                 layout.setVisibility(View.VISIBLE);
                             }
                         }


                     }
        }
    }

    public void playAgain(View view){
        gameisActive=true;
        LinearLayout layout =(LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

         activePlayer=0;

        // unplayed=2

        for(int i=0;i<8;i++){
            gameState[i]=2;
        }
        ImageView red1= (ImageView) findViewById(R.id.red1);  red1.setImageResource(0);
        ImageView red2= (ImageView) findViewById(R.id.red2);  red2.setImageResource(0);
        ImageView red3= (ImageView) findViewById(R.id.red3);  red3.setImageResource(0);
        ImageView red4= (ImageView) findViewById(R.id.red4);  red4.setImageResource(0);
        ImageView red5= (ImageView) findViewById(R.id.red5);  red5.setImageResource(0);
        ImageView red6= (ImageView) findViewById(R.id.red6);  red6.setImageResource(0);
        ImageView red7= (ImageView) findViewById(R.id.red7);  red7.setImageResource(0);
        ImageView red8= (ImageView) findViewById(R.id.red8);  red8.setImageResource(0);
        ImageView red9= (ImageView) findViewById(R.id.red9);  red9.setImageResource(0);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}