package com.example.brain_hack_v1;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityAccount extends AppCompatActivity {

    private Button Delete_Account;

    private TextView Name;

    DatabaseHelper myDb;

    private MediaPlayer BackGroundSound;

    private int ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Delete_Account = (Button)findViewById(R.id.Deletet);
        Name = (TextView)findViewById(R.id.Id);

        myDb = new DatabaseHelper(this);

        Delete_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deletedRows = myDb.deleteData(String.valueOf(ID));
                if (deletedRows > 0){

                    startActivity(new Intent(ActivityAccount.this, MainActivity.class));
                    finish();
                    BackGroundSound.pause();
                }else{

                }

            }
        });



        Cursor res = myDb.getAllData();
        if (res.getCount() == 0){

            //show message
            //  showMessage("Error", "Nothing Found");
            // return;

        }
        StringBuffer buffer =  new StringBuffer();
        while (res.moveToNext()){
            //  buffer.append(res.getString(0)+"\n");
            buffer.append(res.getString(1));
            //  buffer.append("Score      :- "+ res.getString(2)+"\n");

            Name.setText(buffer);
            // BackGroundSound.pause();
        }

    }



    public void onBackPressed(){

        startActivity(new Intent(ActivityAccount.this,MainActivity.class));
        BackGroundSound.pause();
        finish();

    }


}
