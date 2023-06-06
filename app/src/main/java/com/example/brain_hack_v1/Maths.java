package com.example.brain_hack_v1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Maths extends AppCompatActivity {

    private TextView Val1, Val2, Marks;
    private EditText Answer;
    private Button Check, Back;
    private ImageView Star, Correct_IV, Wrong_IV;


    private  MediaPlayer BackGroundSound;
    private int marks = 0;
    private Animation ZoomInOut, Rotate;

    Random random;
    int min,max,output;
    int min1,max1,output1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths);

        BackGroundSound = MediaPlayer.create(this, R.raw.bgm3);
        BackGroundSound.start();

        random =new Random();

        Val1 = (TextView)findViewById(R.id.Val1);
        Val2 = (TextView)findViewById(R.id.Val2);
        Marks = (TextView)findViewById(R.id.Marks);

        Answer = (EditText)findViewById(R.id.Ans);

        Check = (Button)findViewById(R.id.btn_Check);
        Back = (Button)findViewById(R.id.btn_Back);

        Star = (ImageView)findViewById(R.id.star);
        Correct_IV = (ImageView)findViewById(R.id.correct_IV);
        Wrong_IV = (ImageView)findViewById(R.id.wrong_IV);


        ////////////////////////////////////////////////////////////////////////////////////////////////

        ZoomInOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_and_out);

        // btn_play ani
        Check.startAnimation(ZoomInOut);

        // btn_exit ani
        Back.startAnimation(ZoomInOut);



        Marks.setText("0");

        String tempMax,tempMin;

        tempMax = "9";
        tempMin = "1";

        if (!tempMax.equals("")&& !tempMin.equals("")) {
            max = Integer.parseInt(tempMax);
            min = Integer.parseInt(tempMin);

            if (max > min) {
                output = random.nextInt((max - min) + 1) + min;
                Val1.setText(""+output);
            }

            max1 = Integer.parseInt(tempMax);
            min1 = Integer.parseInt(tempMin);

            if (max1 > min1) {
                output1 = random.nextInt((max - min) + 1) + min;
                Val2.setText(""+output1);
            }
        }


        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String valuex = Answer.getText().toString();

                if (TextUtils.isEmpty(valuex)){
                    Toast.makeText(Maths.this, "Please enter the answer", Toast.LENGTH_SHORT).show();
                }else {


                    if (marks == 10) {

                        Intent intent = new Intent(Maths.this, LastActivity.class);

                        //Sending Score to LastActivity
                        String MarkValue = Marks.getText().toString();
                        intent.putExtra("MARK", MarkValue);
                        BackGroundSound.pause();
                        startActivity(intent);

                    } else {


                        int va1 = Integer.parseInt((String) Val1.getText());
                        int va11 = Integer.parseInt((String) Val2.getText());
                        int tot = va1 + va11;


                        String value = Answer.getText().toString();
                        int A = Integer.parseInt(value);

                        if (A == tot) {
                            Correct_IV.setVisibility(View.VISIBLE);
                            Wrong_IV.setVisibility(View.INVISIBLE);

                            Answer.setText("");


                            if (marks == 0) {

                                marks++;
                                Marks.setText("" + marks);

                            } else {
                                marks++;

                                Marks.setText("" + marks);

                            }

                            String tempMax, tempMin;

                            tempMax = "9";
                            tempMin = "1";

                            if (!tempMax.equals("") && !tempMin.equals("")) {
                                max = Integer.parseInt(tempMax);
                                min = Integer.parseInt(tempMin);

                                if (max > min) {
                                    output = random.nextInt((max - min) + 1) + min;
                                    Val1.setText("" + output);
                                }

                                max1 = Integer.parseInt(tempMax);
                                min1 = Integer.parseInt(tempMin);

                                if (max1 > min1) {
                                    output1 = random.nextInt((max1 - min1) + 1) + min1;
                                    Val2.setText("" + output1);
                                }
                            }

                        } else {
                            Correct_IV.setVisibility(View.INVISIBLE);
                            Wrong_IV.setVisibility(View.VISIBLE);

                            Answer.setText("");


                            if (marks == 0) {
                            } else {
                                marks--;

                                Marks.setText("" + marks);

                            }


                            String tempMax, tempMin;

                            tempMax = "9";
                            tempMin = "1";

                            if (!tempMax.equals("") && !tempMin.equals("")) {
                                max = Integer.parseInt(tempMax);
                                min = Integer.parseInt(tempMin);

                                if (max > min) {
                                    output = random.nextInt((max - min) + 1) + min;
                                    Val1.setText("" + output);
                                }

                                max1 = Integer.parseInt(tempMax);
                                min1 = Integer.parseInt(tempMin);

                                if (max1 > min1) {
                                    output1 = random.nextInt((max1 - min1) + 1) + min1;
                                    Val2.setText("" + output1);
                                }
                            }
                        }
                    }
                }
            }
        });





        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Maths.this, QuestionSelect.class));
                BackGroundSound.pause();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed(){

        startActivity(new Intent(Maths.this,QuestionSelect.class));
        BackGroundSound.pause();
        finish();

    }


}



