package com.example.tik_tak_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    int[][] winPos = {{0,1,2},{3,4,5},{6,7,8},
                      {0,3,6},{1,4,7},{2,5,8},
                      {0,4,8},{2,4,6}};
    int[] currentPos={2,2,2,2,2,2,2,2,2};
    int player = 1;
    int win =3;
    Animation alpha;
    LottieAnimationView ltv;

    public void gameReset(){
        alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
        for(int i =0;i< currentPos.length;i++){
            currentPos[i]=2;
        }
        player = 1;
        win =3;
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView1)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView2)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView3)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView4)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView5)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView6)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView7)).setClickable(true);
        ((ImageView)findViewById(R.id.imageView8)).setClickable(true);
        ((TextView)findViewById(R.id.status)).setText("X's Turn");
        ((TextView)findViewById(R.id.status)).startAnimation(alpha);

    }
    @SuppressLint("SetTextI18n")
    public void clicked(View view) {
        ltv = findViewById(R.id.win_lt);
        alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
        TextView txt = findViewById(R.id.status);
        ImageView imgv = (ImageView) view;
        int c = Integer.parseInt(imgv.getTag().toString());
        if (currentPos[c] == 2) {
            currentPos[c] = player;
            if (player == 1) {
                player = 0;
                imgv.setImageResource(R.drawable.x);
                imgv.startAnimation(alpha);
                txt.setText("O's Turn");
            } else {
                player = 1;
                imgv.setImageResource(R.drawable.o);
                imgv.startAnimation(alpha);
                txt.setText("X's Turn");
            }
        }
        int i;
        for (i = 0; i < winPos.length;i++){
            if(((currentPos[winPos[i][0]])==(currentPos[winPos[i][1]]))&&((currentPos[winPos[i][1]])==(currentPos[winPos[i][2]]))&&currentPos[winPos[i][0]]!=2){
                win = currentPos[winPos[i][0]];
                if(win==1){
                    txt.setText("X WON, touch to restart");
                    ltv.playAnimation();
                    ((ImageView)findViewById(R.id.imageView0)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView1)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView2)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView3)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView4)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView5)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView6)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView7)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView8)).setClickable(false);
                }
                else{
                    txt.setText("O WON, touch to restart");
                    ltv.playAnimation();
                    ((ImageView)findViewById(R.id.imageView0)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView1)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView2)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView3)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView4)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView5)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView6)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView7)).setClickable(false);
                    ((ImageView)findViewById(R.id.imageView8)).setClickable(false);
                }
            }

        }
        int count = 0;
        for(int t=0;t<currentPos.length;t++){
            if (currentPos[t]==2) {
                break;
            }
            count++;
        }
        if((count==9)&&win==3){
            txt.setText("DRAW , touch to restart");
        }
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameReset();
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}