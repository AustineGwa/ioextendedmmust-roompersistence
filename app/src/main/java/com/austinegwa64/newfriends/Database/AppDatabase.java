package com.austinegwa64.newfriends.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by gwaza on 6/23/2018.
 */


@Database(entities = {Friend.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DatabaseDao databaseDao();
}
