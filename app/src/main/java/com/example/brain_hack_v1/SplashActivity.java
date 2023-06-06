package com.example.brain_hack_v1;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class SplashActivity extends AppCompatActivity {

    private ImageView LoadMain;

    private Animation Rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        LoadMain = (ImageView)findViewById(R.id.loadMain);

        // Animation ///////////////////////////////////////////////////////////////////////////////////

        Rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);


        // star ani
        LoadMain.startAnimation(Rotate);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        Thread time = new Thread(){
            public void run(){
                try {
                    sleep(5000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent  =  new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);

                    finish();
                }
            }
        };

        time.start();
    }


}
