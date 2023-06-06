package com.example.brain_hack_v1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class QuestionSelect extends AppCompatActivity {

    Button Maths, GK, Science, Home;
    Animation ZoomInOut;
    MediaPlayer BackGroundSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_select);

        BackGroundSound = MediaPlayer.create(this, R.raw.bgm2);
        BackGroundSound.start();

        Maths = (Button)findViewById(R.id.btn_maths);
        Science = (Button)findViewById(R.id.btn_science);
        GK = (Button)findViewById(R.id.btn_gk);
        Home = (Button)findViewById(R.id.btn_home2);

        ////////////////////////////////////////////////////////////////////////////////////////////////

        ZoomInOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_and_out);

        // btn_maths ani
        Maths.startAnimation(ZoomInOut);

        // btn_science
        Science.startAnimation(ZoomInOut);

        // btn_science
        GK.startAnimation(ZoomInOut);

        ////////////////////////////////////////////////////////////////////////////////////////////////


        Maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(QuestionSelect.this, Maths.class));
                BackGroundSound.pause();
                finish();
            }
        });

        Science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(QuestionSelect.this, Science.class));
                BackGroundSound.pause();
                finish();
            }
        });

        GK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(QuestionSelect.this, GK.class));
                BackGroundSound.pause();
                finish();
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(QuestionSelect.this,MainActivity.class));
                BackGroundSound.pause();
                finish();
            }
        });

    }
}
