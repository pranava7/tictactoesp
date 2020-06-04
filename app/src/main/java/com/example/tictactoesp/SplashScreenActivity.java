package com.example.tictactoesp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=3000;
    //After completion of 2000 ms, the next activity will get started.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.

        setContentView(R.layout.splashscreen_layout);
        //this will bind your MainActivity.class file with activity_main.

        ImageView imageView= (ImageView) findViewById(R.id.imageView) ;


        AnimationSet s = new AnimationSet(false) ;

        Animation animation1= AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.rotate);
        Animation animation= AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.bounce);

        s.addAnimation(animation);
        s.addAnimation(animation1);

        // imageView.startAnimation(animation1);
        imageView.startAnimation(s);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreenActivity.this,
                        MainActivity.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
