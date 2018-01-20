package com.example.shank.game;

import  android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
     int a =0;

     int p[]={2,2,2,2,2,2,2,2,2};
     boolean gameactive =true;
    public void drawin(View view)

    {
        ImageView button = (ImageView) view;
        button.getTag().toString();
        int [][] winning ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        int x = Integer.parseInt(button.getTag().toString());
        if (p[x] == 2 && gameactive == true) {

             p[x]=a;
            if (a == 0) {
                button.setImageResource(R.drawable.red);
                a = 1;
            } else {
                button.setImageResource(R.drawable.black);

                a = 0;
            }

        }

        for(int[] winningp : winning) {
            if (p[winningp[0]] == p[winningp[1]]
                    && p[winningp[1]] == p[winningp[2]]
                    && p[winningp[0]] != 2) {
                String winner ="red";
                if(p[winningp[0]]==1){
                    winner ="black";
                }
                 gameactive =false;
                TextView textView=findViewById(R.id.msg);
                textView.setVisibility(View.VISIBLE);
                Button button1 =findViewById(R.id.play);
                button1.setVisibility(View.VISIBLE);
                textView.setText(winner+" has won");



            }
        }
        int check=0;
        for(int i=0;i<p.length;i++)
        {
            if(p[i]!=2)
            {
                check++;
            }
        }
        if(check== p.length)
        {
            TextView textView=findViewById(R.id.msg);
            textView.setVisibility(View.VISIBLE);
            textView.setText("draw");
            Button button1 =findViewById(R.id.play);
            button1.setVisibility(View.VISIBLE);
        }

      }
      public  void  playagain(View view)
      {
          gameactive =true;
          TextView textView=findViewById(R.id.msg);
          textView.setVisibility(View.INVISIBLE);
          Button button1 =findViewById(R.id.play);
          button1.setVisibility(View.INVISIBLE);
          int a =0;


          for(int i=0;i<9 ;i++)
          {
              p[i]=2;
          }

          GridLayout gridLayout =findViewById(R.id.gridlay);
          for(int i=0;i<gridLayout.getChildCount();i++)
          {
              ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
          }
      }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
