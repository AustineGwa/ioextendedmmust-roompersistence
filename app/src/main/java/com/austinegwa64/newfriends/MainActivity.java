package com.austinegwa64.newfriends;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.austinegwa64.newfriends.Database.AppDatabase;
import com.austinegwa64.newfriends.Database.Friend;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    List<Friend> friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //whenever the activity is started, it reads data from database and stores it into
        // local array list 'items'
        final AppDatabase database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"friends")
                .build();

       // get data in background thread
        Runnable r = new Runnable(){
            @Override
            public void run() {
                friends = database.databaseDao().getAllFriends();
                recyclerView  = findViewById(R.id.recyclerview_main);
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                adapter= new FriendsAdapter(getApplicationContext(), friends);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

            }
        };

        Thread newThread= new Thread(r);
        newThread.start();

    }
}
