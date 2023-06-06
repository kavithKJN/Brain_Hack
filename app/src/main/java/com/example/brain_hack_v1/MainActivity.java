package com.example.brain_hack_v1;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    private Button play, exit, add_admin, account;
    private Animation AnimBlink, ZoomInOut,Nothing;
    private MediaPlayer BackGroundSound;
    private EditText admin_name;

    private long PressBack;
    private Toast backToast;
    DatabaseHelper myDb;
    private int id = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        BackGroundSound = MediaPlayer.create(this, R.raw.bgm);
        BackGroundSound.start();

        play = (Button) findViewById(R.id.btn_play);
        exit = (Button) findViewById(R.id.btn_exit);
        add_admin = (Button)findViewById(R.id.new_admin);
        account = (Button)findViewById(R.id.Btn_account);

        admin_name = (EditText)findViewById(R.id.adminText);

        myDb = new DatabaseHelper(this);


        ////////////////////////////////////////////////////////////////////////////////////////////////

        ZoomInOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_and_out);

        //play.startAnimation(ZoomInOut);

        //exit.startAnimation(ZoomInOut);

        //add_admin.startAnimation(ZoomInOut);



        ////////////////////////////////////////////////////////////////////////////////////////////////

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, QuestionSelect.class));
                BackGroundSound.pause();
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackGroundSound.pause();
                finish();
            }
        });



        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, ActivityAccount.class));
                finish();
            }
        });


        Check();

        add_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = admin_name.getText().toString();

                if (TextUtils.isEmpty(name)){

                    Toast.makeText(MainActivity.this, "Type Your Name", Toast.LENGTH_SHORT).show();



                }else {

                    boolean isInserted = myDb.insertData(String.valueOf(id), admin_name.getText());
                    String.valueOf(id);

                    if (isInserted == true) {

                        play.setVisibility(View.VISIBLE);
                        play.setAnimation(ZoomInOut);
                        exit.setVisibility(View.VISIBLE);
                        exit.setAnimation(ZoomInOut);
                        account.setVisibility(View.VISIBLE);
                        account.setAnimation(ZoomInOut);


                        add_admin.setVisibility(View.INVISIBLE);

                        add_admin.setAnimation(Nothing);
                        admin_name.setVisibility(View.INVISIBLE);

                        // Toast.makeText(MainActivity.this, "Admin Created", Toast.LENGTH_SHORT).show();

                    } else {

                    }
                    // Toast.makeText(MainActivity.this, "Admin Not Created", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }



    protected void Check() {

        Cursor res = myDb.getAllData();

        if (res.getCount() == 0){
            add_admin.setVisibility(View.VISIBLE);
            add_admin.setAnimation(ZoomInOut);
            admin_name.setVisibility(View.VISIBLE);

            exit.setVisibility(View.INVISIBLE);
            play.setVisibility(View.INVISIBLE);
            account.setVisibility(View.INVISIBLE);

            exit.setAnimation(Nothing);
            play.setAnimation(Nothing);



        }else {

            play.setVisibility(View.VISIBLE);
            play.setAnimation(ZoomInOut);

            exit.setVisibility(View.VISIBLE);
            exit.setAnimation(ZoomInOut);

            account.setVisibility(View.VISIBLE);
            account.setAnimation(ZoomInOut);



            add_admin.setVisibility(View.INVISIBLE);

            add_admin.setAnimation(Nothing);
            admin_name.setVisibility(View.INVISIBLE);
        }

    }


    @Override
    public void onBackPressed() {

        if (PressBack + 0 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {

        }
        PressBack = System.currentTimeMillis();

    }
}
