# ioextendedmmust-roompersistence
app storing a list of friends that we meet on daily basis

This app demonstrates androin room database usage in 4 steps

1. Add Dependency to build.gradle

   implementation "android.arch.persistence.room:runtime:1.0.0"
   annotationProcessor "android.arch.persistence.room:compiler:1.0.0"
   
2. create the model class (Entity)

    package com.austinegwa64.newfriends.Database;

  import android.arch.persistence.room.ColumnInfo;
  import android.arch.persistence.room.Entity;
  import android.arch.persistence.room.PrimaryKey;

    /**
    * Created by gwaza on 6/23/2018.
    */

    @Entity
    public class Friend {


    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "image")
    private int image;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "contact")
    private String contact;

    @ColumnInfo(name = "placemet")
    private String placeMet;

    public Friend(int image, String name, String contact, String placeMet) {
        this.image = image;
        this.name = name;
        this.contact = contact;
        this.placeMet = placeMet;
    }

    public Friend(String name, String contact, String placeMet) {
        this.name = name;
        this.contact = contact;
        this.placeMet = placeMet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPlaceMet() {
        return placeMet;
    }

    public void setPlaceMet(String placeMet) {
        this.placeMet = placeMet;
    }
}

3. Create the dao class.

This is an inteface that has the methods to handle the database

    @Dao
    public interface DatabaseDao {

    @Query("SELECT * FROM myFriends")
    List<Friend> getAllFriends();

    @Insert
    void insertAll(Friend... friends);

}

4. Create the database class

    @Database(entities = {Friend.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DatabaseDao databaseDao();
}


5. interact with the database in main activity

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

        startSaveFriendActivity.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddFriend.class);
                startActivity(intent);

            }
        });


.. success .. 

