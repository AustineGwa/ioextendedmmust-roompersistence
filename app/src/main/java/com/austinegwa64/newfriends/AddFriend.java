package com.austinegwa64.newfriends;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.austinegwa64.newfriends.Database.AppDatabase;
import com.austinegwa64.newfriends.Database.Friend;

public class AddFriend extends AppCompatActivity {

    Button button;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"production")
                .build();


        button = findViewById(R.id.addFriend);


        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"production")
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    final Friend  friend = new Friend("Austine", "0718728894", "googleIo");
                    //save the item before leaving the activity


                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            db.databaseDao().insertAll(friend);
                        }
                    });


                    Intent i = new Intent(AddFriend.this,MainActivity.class);
                    startActivity(i);

                    finish();
                }

        });
    }
}


