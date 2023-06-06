package com.example.brain_hack_v1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class LastActivity extends AppCompatActivity {

    private TextView Marks;
    private Button Retry, Home, Levels, Retry1;
    private ImageView CupCake1, CupCake2, CupCake3, EmptyCupCake1, EmptyCupCake2,EmptyCupCake3;
    private Animation ZoomInOut;

    private MediaPlayer BackGroundSound;

    int int_Mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_activity);

        BackGroundSound = MediaPlayer.create(this, R.raw.bgm);
        BackGroundSound.start();

        Retry = (Button) findViewById(R.id.btn_retry);
        Retry1 = (Button) findViewById(R.id.btn_retry_1);
        Home = (Button) findViewById(R.id.btn_home);
        Levels = (Button) findViewById(R.id.btn_LevelSelect);
        Marks = (TextView) findViewById(R.id.Mark_TV);


        CupCake1 = (ImageView) findViewById(R.id.CupCake1);
        CupCake2 = (ImageView) findViewById(R.id.CupCake2);
        CupCake3 = (ImageView) findViewById(R.id.CupCake3);

        EmptyCupCake1 = (ImageView) findViewById(R.id.EmptyCupCake1);
        EmptyCupCake2 = (ImageView) findViewById(R.id.EmptyCupCake2);
        EmptyCupCake3 = (ImageView) findViewById(R.id.EmptyCupCake3);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        Marks.setText("" + getIntent().getStringExtra("MARK"));

        // CupCake_get ////////////////////////////////////////////////////////////////////////////////


        int int_Mark = Integer.parseInt((String) Marks.getText());

        if (int_Mark == 0) {

            Marks.setText("0");

            Retry.setVisibility(View.INVISIBLE);
            Home.setVisibility(View.INVISIBLE);
            Levels.setVisibility(View.INVISIBLE);
            Retry1.setVisibility(View.VISIBLE);
            EmptyCupCake1.setVisibility(View.VISIBLE);
            EmptyCupCake2.setVisibility(View.VISIBLE);
            EmptyCupCake3.setVisibility(View.VISIBLE);


        } else {
            if (int_Mark <= 3) {


                Retry1.setVisibility(View.INVISIBLE);
                CupCake1.setVisibility(View.VISIBLE);
                EmptyCupCake2.setVisibility(View.VISIBLE);
                EmptyCupCake3.setVisibility(View.VISIBLE);


            } else {
                if (int_Mark <= 6) {


                    CupCake1.setVisibility(View.VISIBLE);
                    CupCake2.setVisibility(View.VISIBLE);
                    EmptyCupCake3.setVisibility(View.VISIBLE);


                } else {
                    if (int_Mark <= 10) {


                        Retry1.setVisibility(View.INVISIBLE);
                        CupCake1.setVisibility(View.VISIBLE);
                        CupCake2.setVisibility(View.VISIBLE);
                        CupCake3.setVisibility(View.VISIBLE);

                    }
                }
            }
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                ZoomInOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_and_out);

                // btn_retry ani
                Retry.startAnimation(ZoomInOut);

                // btn_home ani
                Home.startAnimation(ZoomInOut);

                // btn_levels ani
                Levels.startAnimation(ZoomInOut);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                Retry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(LastActivity.this, Maths.class));
                        BackGroundSound.pause();
                        finish();
                    }
                });


                Home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(LastActivity.this, MainActivity.class));
                        BackGroundSound.pause();
                        finish();
                    }
                });


                Levels.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(LastActivity.this, QuestionSelect.class));
                        BackGroundSound.pause();
                        finish();
                    }
                });


            }
        }